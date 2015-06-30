package com.trainerworkout.trainee.service;

import retrofit.Callback;
import retrofit.http.POST;
import retrofit.http.Query;

import com.trainerworkout.trainee.model.rest.LoginModel;

public interface TWService {

	@POST("/Users/Login")
	public void performLogin(@Query("email") String email,
							 @Query("password") String password, Callback<LoginModel> response);
	
}
