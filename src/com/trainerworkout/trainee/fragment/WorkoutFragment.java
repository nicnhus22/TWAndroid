package com.trainerworkout.trainee.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.trainerworkout.trainee.R;
import com.trainerworkout.trainee.adapter.WorkoutListAdapter;
import com.trainerworkout.trainee.helper.SelectedWorkout;
import com.trainerworkout.trainee.model.rest.WorkoutModel;
 
public class WorkoutFragment extends Fragment {
     
	private WorkoutListAdapter adapter;
	private ListView workoutList;
	
    public WorkoutFragment(){}
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_workout, container, false);
                
        Integer SELECTED_WORKOUT_ID = getArguments().getInt("SELECTED_WORKOUT_ID");
        
        TextView label = (TextView)rootView.findViewById(R.id.workout_name);
        label.setText(SELECTED_WORKOUT_ID.toString());

		return rootView;
    }
    
    
}