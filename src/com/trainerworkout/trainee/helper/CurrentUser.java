package com.trainerworkout.trainee.helper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.trainerworkout.trainee.database.DatabaseHelper;
import com.trainerworkout.trainee.model.rest.UserModel;

public class CurrentUser {

	public static UserModel fetch(Context context){
		// Get current user
        DatabaseHelper helper = DatabaseHelper.getInstance(context);
		
		UserModel DBUser = null;
		SharedPreferences sp = context.getSharedPreferences("USER_PREFERENCES", Activity.MODE_PRIVATE);
		int userID = sp.getInt("CURRENT_USER_ID", 0);
		try {
			DBUser = helper.getUserDao().queryForId(userID);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return DBUser;
	}
	
}
