package com.trainerworkout.trainee.fragment;

import java.lang.reflect.Type;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.trainerworkout.trainee.R;
import com.trainerworkout.trainee.adapter.WorkoutListAdapter;
import com.trainerworkout.trainee.gson.DeserializeWorkoutHolder;
import com.trainerworkout.trainee.helper.Animations;
import com.trainerworkout.trainee.helper.HttpClientSingleton;
import com.trainerworkout.trainee.model.rest.WorkoutHolderModel;
import com.trainerworkout.trainee.model.rest.WorkoutsModel;
import com.trainerworkout.trainee.resource.query.URLQueries;
import com.trainerworkout.trainee.service.TWService;
 
public class MyWorkoutsFragment extends Fragment {
     
	private WorkoutListAdapter adapter;
	private ListView workoutList;
	
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
		service.fetchWorkouts(219, new Callback<WorkoutsModel>() {
			@Override
			public void success(WorkoutsModel model, Response response) {
				if(model.getStatus().equals("ok")){					
					List<WorkoutHolderModel> workoutModels = deserializeWorkoutHolder(response);
					
					workoutList = (ListView)getActivity().findViewById(R.id.workout_name_list);
					
					adapter = new WorkoutListAdapter(getActivity().getApplicationContext(), workoutModels);
					workoutList.setAdapter(adapter);
					
					Animations.stopLogoFadeInOut(loader_logo);
					Animations.hideView(loader_logo);
					Animations.slideView(workoutList);
				}
			}
			@Override
			public void failure(RetrofitError error) {
				System.out.println(error);
			}
		});
//        
        return rootView;
    }
    
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
}