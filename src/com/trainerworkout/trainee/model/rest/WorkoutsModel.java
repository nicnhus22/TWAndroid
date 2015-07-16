package com.trainerworkout.trainee.model.rest;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkoutsModel {

	@SerializedName("status")
	@Expose
	private String status;
	@SerializedName("total")
	@Expose
	private String total;

	public WorkoutsModel(){	}
	
	/**
	 * @param workouts
	 * @param status
	 * @param total
	 */
	public WorkoutsModel(List<WorkoutModel> workouts, String status,
			String total) {
		super();
		this.status = status;
		this.total = total;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	
	
}
