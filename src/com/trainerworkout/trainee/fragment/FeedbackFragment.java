package com.trainerworkout.trainee.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trainerworkout.trainee.R;
 
public class FeedbackFragment extends Fragment {
     
    public FeedbackFragment(){}
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_feedback, container, false);
          
        return rootView;
    }
}