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
import com.trainerworkout.trainee.R;
import com.trainerworkout.trainee.adapter.WorkoutListAdapter;
import com.trainerworkout.trainee.database.DatabaseHelper;
import com.trainerworkout.trainee.gson.DeserializeWorkoutHolder;
import com.trainerworkout.trainee.helper.Animations;
import com.trainerworkout.trainee.helper.BackHandledFragment;
import com.trainerworkout.trainee.helper.HttpClientSingleton;
import com.trainerworkout.trainee.helper.LoggedUser;
import com.trainerworkout.trainee.helper.SelectedWorkout;
import com.trainerworkout.trainee.model.rest.WorkoutHolderModel;
import com.trainerworkout.trainee.model.rest.WorkoutModel;
import com.trainerworkout.trainee.model.rest.WorkoutsModel;
import com.trainerworkout.trainee.notification.ToastNotification;
import com.trainerworkout.trainee.resource.query.URLQueries;
import com.trainerworkout.trainee.service.TWService;
 
public class MyWorkoutsFragment extends BackHandledFragment {
     
	private WorkoutListAdapter adapter;
	private ListView workoutList;
	private WorkoutModel workoutModel;
	
    public MyWorkoutsFragment(){}
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_my_workouts, container, false);
        
        final ImageView loader_logo = (ImageView)rootView.findViewById(R.id.workout_list_loader);
        Animations.startLogoFadeInOut(loader_logo);
        
        RestAdapter restAdapter = new RestAdapter.Builder()
        	.setClient(HttpClientSingleton.getInstance())
			.setLogLevel(RestAdapter.LogLevel.FULL)
			.setEndpoint(URLQueries.SERVER_ZONE)
			.build(); 

        TWService service = restAdapter.create(TWService.class);
		service.fetchWorkouts(LoggedUser.getUser().getId(), new Callback<WorkoutsModel>() {
			@Override
			public void success(WorkoutsModel model, Response response) {
				if(model.getStatus().equals("ok")){					
					List<WorkoutHolderModel> workoutModels 	= deserializeWorkoutHolder(response);
					
					List<WorkoutModel> workouts = new ArrayList<WorkoutModel>();
					try {
						workouts = createAndReturnWorkoutsIfNotExist(workoutModels);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					workoutList = (ListView)getActivity().findViewById(R.id.workout_name_list);
					
					adapter = new WorkoutListAdapter(getActivity().getApplicationContext(), workouts);
					workoutList.setAdapter(adapter);
					workoutList.setOnItemClickListener(new WorkoutClickListener(workoutModels));
					
					Animations.stopLogoFadeInOut(loader_logo);
					Animations.hideView(loader_logo);
					Animations.fadeView(workoutList);
				}
			}
			@Override
			public void failure(RetrofitError error) {
				System.out.println(error);
			}
		});

		return rootView;
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
    	
    	private List<WorkoutHolderModel> workoutModels;
    	
    	public WorkoutClickListener(List<WorkoutHolderModel> workoutModels){
    		this.workoutModels = workoutModels;
    	}

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			
			SelectedWorkout.setSelectedWorkout(workoutModels.get(position).getWorkout());
			
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, new WorkoutFragment()).addToBackStack("[BACK:MyWorkoutsFragment]").commit();
		}
    }

	@Override
	public String getTagText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onBackPressed() {
		// TODO Auto-generated method stub
		return true;
	}
    
    	
	private List<WorkoutModel> createAndReturnWorkoutsIfNotExist(List<WorkoutHolderModel> workoutHolders) throws SQLException{
		
		DatabaseHelper helper = DatabaseHelper.getInstance(getActivity());
		
		for(WorkoutHolderModel holder: workoutHolders){
			try {
				helper.getWorkoutDao().createIfNotExists(holder.getWorkout());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return helper.getWorkoutDao().queryForAll();
	}

	
	
}