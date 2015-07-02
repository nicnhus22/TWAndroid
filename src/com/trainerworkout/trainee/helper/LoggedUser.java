package com.trainerworkout.trainee.helper;

import com.trainerworkout.trainee.model.rest.UserModel;

public class LoggedUser {

	private static UserModel user;

	/**
	 * @return the user
	 */
	public static UserModel getUser() {
		return LoggedUser.user;
	}

	/**
	 * @param user the user to set
	 */
	public static void setUser(UserModel user) {
		LoggedUser.user = user;
	}
	
	
}
