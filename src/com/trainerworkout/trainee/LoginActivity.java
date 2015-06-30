
package com.trainerworkout.trainee;

import java.util.Arrays;
import java.util.List;

import org.apache.http.impl.client.DefaultHttpClient;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.trainerworkout.trainee.gson.DeserializeUser;
import com.trainerworkout.trainee.helper.HttpClientSingleton;
import com.trainerworkout.trainee.model.rest.LoginModel;
import com.trainerworkout.trainee.model.rest.UserModel;
import com.trainerworkout.trainee.notification.ToastNotification;
import com.trainerworkout.trainee.resource.query.URLQueries;
import com.trainerworkout.trainee.service.TWService;

public class LoginActivity extends Activity {

	private static final String TAG = LoginActivity.class.getSimpleName();
	
	private final List<String> permissions;
	
	private final String LOGIN_SUCCESS = "ok";

	public LoginActivity() {
		permissions = Arrays.asList();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// Hide Action Bar
		hideActionBar();
		// Set view
		setContentView(R.layout.activity_login);
		// Create Http Client singleton
		createOkHttpClient();
		final OkClient client = HttpClientSingleton.getInstance();
				
		Button login_button = (Button)findViewById(R.id.button1);
		login_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	startLogoFadeInOut();
            	            	
            	TextView email 	  = (TextView)findViewById(R.id.login_password);
            	TextView password = (TextView)findViewById(R.id.login_email);
            	
            	RestAdapter restAdapter = new RestAdapter.Builder()
	    			.setLogLevel(RestAdapter.LogLevel.FULL)
	    			.setEndpoint(URLQueries.SERVER_ZONE)
	    			.setClient(client)
	    			.build(); 

	    		TWService service = restAdapter.create(TWService.class);
	    		service.performLogin(password.getText().toString(),email.getText().toString(), new Callback<LoginModel>() {
	    			@Override
	    			public void success(LoginModel model, Response response) {
	    				final boolean success = (model.getStatus().equals(LOGIN_SUCCESS) ? true : false);
	    				if(success)
	    					startMainActivity(response);
	    				else
	    					showLoginError();
	    				stopLogoFadeInOut();
	    				
	    			}
	    			@Override
	    			public void failure(RetrofitError error) {
	    				stopLogoFadeInOut();
	    			}
	    		});
            }
        });
	}



	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
	
	/**
	 * Start MainActivity on login successful
	 */
	private void startMainActivity(Response response){
		// Build user model
		Gson gson = 
			    new GsonBuilder()
			        .registerTypeAdapter(UserModel.class, new DeserializeUser())
			        .create();
		
		String json = new String(((TypedByteArray) response.getBody()).getBytes());
		UserModel user = gson.fromJson(json, UserModel.class);
		
		new ToastNotification.Builder(this.getApplicationContext())
			.withNotification(ToastNotification.SUCCESS_LOGIN.concat(user.getFirstName()))
			.show();
		
		Intent mainActivity = new Intent(this, MainActivity.class);
		mainActivity.putExtra("user_firstName", user.getFirstName());
		mainActivity.putExtra("user_profileImage", user.getImage());
		startActivity(mainActivity);
	}
	
	/**
	 * Error message upon login
	 */
	private void showLoginError(){
		new ToastNotification.Builder(this.getApplicationContext())
			.withNotification(ToastNotification.FAILURE_LOGIN)
			.show();
	}
	
	/**
	 *  Hides the action bar on login page
	 */
	private void hideActionBar(){
		View decorView = getWindow().getDecorView();
		// Hide the status bar.
		int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(uiOptions);
		// Remember that you should never show the action bar if the
		// status bar is hidden, so hide that too if necessary.
		ActionBar actionBar = getActionBar();
		actionBar.hide();
	}

	private void startLogoFadeInOut(){
		Animation fadeIn = new AlphaAnimation(0, 1);
		fadeIn.setInterpolator(new DecelerateInterpolator());
		fadeIn.setDuration(500);

		Animation fadeOut = new AlphaAnimation(1, 0);
		fadeOut.setInterpolator(new AccelerateInterpolator());
		fadeOut.setStartOffset(500);
		fadeOut.setDuration(500);

		AnimationSet animation = new AnimationSet(false);
		animation.addAnimation(fadeIn);
		animation.addAnimation(fadeOut);
		
		ImageView logo = (ImageView)findViewById(R.id.first_drawer_image);
		
		logo.setAnimation(animation);
	}
	
	private void stopLogoFadeInOut(){
		ImageView logo = (ImageView)findViewById(R.id.first_drawer_image);
		logo.setAnimation(null);
	}
	
	private void createOkHttpClient(){
		new HttpClientSingleton();
	}
}
