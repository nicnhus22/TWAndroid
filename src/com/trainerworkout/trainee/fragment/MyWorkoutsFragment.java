package com.trainerworkout.trainee.fragment;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.trainerworkout.trainee.MainActivity;
import com.trainerworkout.trainee.R;
import com.trainerworkout.trainee.WorkoutActivity;
import com.trainerworkout.trainee.adapter.WorkoutListAdapter;
import com.trainerworkout.trainee.database.DatabaseHelper;
import com.trainerworkout.trainee.gson.DeserializeWorkoutHolder;
import com.trainerworkout.trainee.helper.Animations;
import com.trainerworkout.trainee.helper.BackHandledFragment;
import com.trainerworkout.trainee.helper.CurrentUser;
import com.trainerworkout.trainee.helper.DownloadSetImageTask;
import com.trainerworkout.trainee.helper.HttpClientSingleton;
import com.trainerworkout.trainee.helper.SelectedWorkout;
import com.trainerworkout.trainee.helper.DownloadSetImageTask.ImageType;
import com.trainerworkout.trainee.model.rest.UserModel;
import com.trainerworkout.trainee.model.rest.WorkoutHolderModel;
import com.trainerworkout.trainee.model.rest.WorkoutModel;
import com.trainerworkout.trainee.model.rest.WorkoutsExercisesModel;
import com.trainerworkout.trainee.model.rest.WorkoutsModel;
import com.trainerworkout.trainee.notification.ToastNotification;
import com.trainerworkout.trainee.resource.query.URLQueries;
import com.trainerworkout.trainee.service.TWService;
 
public class MyWorkoutsFragment extends Fragment {
     
	private WorkoutListAdapter adapter;
	private ListView workoutList;
	private WorkoutModel workoutModel;
	
	// Loader logo
	ImageView loader_logo = null;
	// Logged user
	UserModel DBUser = null;
	
    public MyWorkoutsFragment(){}
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_my_workouts, container, false);
        
        // Get logged user
        DBUser = CurrentUser.fetch(getActivity());
        
        loader_logo = (ImageView)rootView.findViewById(R.id.workout_list_loader);
        Animations.startLogoFadeInOut(loader_logo);
        
        RestAdapter restAdapter = new RestAdapter.Builder()
        	.setClient(HttpClientSingleton.getInstance())
			.setLogLevel(RestAdapter.LogLevel.FULL)
			.setEndpoint(URLQueries.SERVER_ZONE)
			.build(); 

        TWService service = restAdapter.create(TWService.class);
		service.fetchWorkouts(DBUser.getId(), new Callback<WorkoutsModel>() {
			@Override
			public void success(WorkoutsModel model, Response response) {
				if(model.getStatus().equals("ok")){					
					List<WorkoutHolderModel> workoutModels 	= deserializeWorkoutHolder(response);
					List<WorkoutModel> workouts = new ArrayList<WorkoutModel>();
					try {
						workouts = createAndReturnWorkoutsIfNotExist(workoutModels, DBUser.getId());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					addWorkoutListToView(workouts);
				}
			}
			@Override
			public void failure(RetrofitError error) {
				List<WorkoutModel> workouts = fetchOffLineWorkouts();
				addWorkoutListToView(workouts);
			}
		});

		return rootView;
    }
    
    private void addWorkoutListToView(List<WorkoutModel> workouts){
    	workoutList = (ListView)getActivity().findViewById(R.id.workout_name_list);
		
		adapter = new WorkoutListAdapter(getActivity().getApplicationContext(), workouts);
		workoutList.setAdapter(adapter);
		workoutList.setOnItemClickListener(new WorkoutClickListener(workouts));
		
		Animations.stopLogoFadeInOut(loader_logo);
		Animations.hideView(loader_logo);
		Animations.fadeView(workoutList);
    }
    
    
    /**
     * @param response
     * @return
     */
    private List<WorkoutHolderModel> deserializeWorkoutHolder(Response response){
    	// Build workout holder model
    	Type listType = new TypeToken<List<WorkoutHolderModel>>(){}.getType();
		Gson gson = new GsonBuilder()
			        .registerTypeAdapter(listType, new DeserializeWorkoutHolder())
			        .create();
		
		String json = new String(((TypedByteArray) response.getBody()).getBytes()); 
		List<WorkoutHolderModel> workoutHolder = null;
		try {
			workoutHolder = gson.fromJson(json, listType);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return workoutHolder;
    }
    
    /**
     * WIll take the workout list as input and trigger the corresponding
     * action when clicked: show workout fragment.
     */
    private class WorkoutClickListener implements ListView.OnItemClickListener {
    	
    	private List<WorkoutModel> workouts;
    	
    	public WorkoutClickListener(List<WorkoutModel> workouts){
    		this.workouts = workouts;
    	}

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			
			SelectedWorkout.setSelectedWorkout(workouts.get(position));
			
			Intent workoutActivity = new Intent(getActivity(), WorkoutActivity.class);
			workoutActivity.putExtra("SELECTED_WORKOUT_ID", workouts.get(position).getId());
			workoutActivity.putExtra("SELECTED_WORKOUT_NAME", workouts.get(position).getName());
			startActivity(workoutActivity);
		}
    }
    
    /**
     * This takes a list of WorkoutHolderModels and create a tuple for each
     * workout in the Workout table.
     * 
     * @param workoutHolders
     * @return List<WorkoutModel> list of workouts
     * @throws SQLException
     */
	private List<WorkoutModel> createAndReturnWorkoutsIfNotExist(List<WorkoutHolderModel> workoutHolders, int userID) throws SQLException{
		
		DatabaseHelper helper = DatabaseHelper.getInstance(getActivity());
		
		for(WorkoutHolderModel holder: workoutHolders){
			try {
				helper.getWorkoutDao().createIfNotExists(holder.getWorkout());
				
				for(WorkoutsExercisesModel exercise: holder.getExercises()){
					helper.getWorkoutsExercisesDao().createIfNotExists(exercise);
					helper.getExercisesDao().createIfNotExists(exercise.getExercise());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		PreparedQuery<WorkoutModel> preparedQuery = null;
		try {
			QueryBuilder<WorkoutModel, Integer> qb = helper.getWorkoutDao().queryBuilder();
			Where where = qb.where();
			where.eq("userId", userID);
			preparedQuery = qb.prepare();
		}catch (Exception e){
			e.printStackTrace();
		}		
		
		return helper.getWorkoutDao().query(preparedQuery);
	}

	/**
	 * The list will be the last list fetched when Internet worked.
	 * 
	 * @return List<WorkoutModel> list of WorkoutModels for the off line mode.
	 */
	private List<WorkoutModel> fetchOffLineWorkouts(){
		
		DatabaseHelper helper = DatabaseHelper.getInstance(getActivity());
		
		PreparedQuery<WorkoutModel> preparedQuery = null;
		try {
			QueryBuilder<WorkoutModel, Integer> qb = helper.getWorkoutDao().queryBuilder();
			Where where = qb.where();
			where.eq("userId", DBUser.getId());
			preparedQuery = qb.prepare();
		}catch (Exception e){
			e.printStackTrace();
		}		
		
		List<WorkoutModel> workouts = null;
		try {
			workouts = helper.getWorkoutDao().query(preparedQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workouts;
	}
	
}