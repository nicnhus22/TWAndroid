package com.trainerworkout.trainee.model.rest;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkoutHolderModel {

	private WorkoutModel workout;
	private List<String> images;
	private transient  List<WorkoutsExercisesModel> exercises;
	
	public WorkoutHolderModel(WorkoutModel workout, List<String> images,
			List<WorkoutsExercisesModel> exercises) {
		super();
		this.workout = workout;
		this.images = images;
		this.exercises = exercises;
	}

	/**
	 * @return the workout
	 */
	public WorkoutModel getWorkout() {
		return workout;
	}
	

	/**
	 * @param workout the workout to set
	 */
	public void setWorkout(WorkoutModel workout) {
		this.workout = workout;
	}


	/**
	 * @return the images
	 */
	public List<String> getImages() {
		return images;
	}



	/**
	 * @param images the images to set
	 */
	public void setImages(List<String> images) {
		this.images = images;
	}



	/**
	 * @return the exercises
	 */
	public List<WorkoutsExercisesModel> getExercises() {
		return exercises;
	}



	/**
	 * @param exercises the exercises to set
	 */
	public void setExercises(List<WorkoutsExercisesModel> exercises) {
		this.exercises = exercises;
	}

	
	
	
	
}
