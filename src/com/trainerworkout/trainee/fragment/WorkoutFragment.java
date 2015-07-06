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
	private WorkoutModel selectedWorkout;
	
    public WorkoutFragment(){}
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_workout, container, false);
        
        selectedWorkout = SelectedWorkout.getSelectedWorkout();
        
        TextView label = (TextView)rootView.findViewById(R.id.workout_name);
        label.setText(selectedWorkout.getName());

		return rootView;
    }
    
    
}