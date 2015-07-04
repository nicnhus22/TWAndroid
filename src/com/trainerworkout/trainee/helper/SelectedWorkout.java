package com.trainerworkout.trainee.helper;

import com.trainerworkout.trainee.model.rest.WorkoutModel;

public class SelectedWorkout {

	private static WorkoutModel selectedWorkout;
	
	/**
	 * @return
	 */
	public static WorkoutModel getSelectedWorkout(){
		return SelectedWorkout.selectedWorkout;
	}
	
	/**
	 * @param selectedWorkout
	 */
	public static void setSelectedWorkout(WorkoutModel selectedWorkout){
		SelectedWorkout.selectedWorkout = selectedWorkout;
	}
}
