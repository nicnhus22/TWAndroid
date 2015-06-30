package com.trainerworkout.trainee.model.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkoutModel {

	@SerializedName("name")
	@Expose
	private String name;

	/**
	 * @param name
	 */
	public WorkoutModel(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
