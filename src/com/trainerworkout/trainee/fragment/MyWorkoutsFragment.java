package com.trainerworkout.trainee.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trainerworkout.trainee.R;
 
public class MyWorkoutsFragment extends Fragment {
     
    public MyWorkoutsFragment(){}
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_my_workouts, container, false);
          
        return rootView;
    }
}