package com.trainerworkout.trainee.model.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginModel {

	@SerializedName("status")
	@Expose
	private String status;
	
	/**
	 * 
	 * @param email
	 * @param password
	 * @param status
	 * @param firstName
	 * @param lastName
	 */
	public LoginModel(String email, String password, String status,
			String firstName, String lastName) {
		super();
		this.status = status;
	}

	/**
	 * @return the success
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param success the success to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
