package com.trainerworkout.trainee.service;

import retrofit.Callback;
import retrofit.http.POST;
import retrofit.http.Query;

import com.trainerworkout.trainee.model.rest.LoginModel;
import com.trainerworkout.trainee.model.rest.WorkoutsModel;

public interface TWService {

	@POST("/Users/Login")
	public void performLogin(@Query("email") String email,
							 @Query("password") String password, Callback<LoginModel> response);

	@POST("/Workouts")
	public void fetchWorkouts(@Query("userId") int id,
							  Callback<WorkoutsModel> response);
	
}
