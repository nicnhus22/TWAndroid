package com.trainerworkout.trainee.notification;

import com.trainerworkout.trainee.MainActivity;

import android.content.Context;
import android.widget.Toast;

public class ToastNotification {

	private String message;
	
	public static final String SUCCESS_LOGIN = "Welcome ";
	public static final String FAILURE_LOGIN = "Login failed";
	
	public ToastNotification(Builder builder) {
		this.message = builder.message;
	}
	
	public static class Builder {
		
		private String message;
		private Context context;
		
		public Builder(Context context){
			this.context = context;
		}
		
		public Builder withNotification(String message){
			this.message = message;
			return this;
		}
		
		public ToastNotification show(){
			CharSequence text = this.message;
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			
			return new ToastNotification(this);
		}
	}
	
}
