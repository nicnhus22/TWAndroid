
package com.trainerworkout.trainee;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import android.accounts.Account;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.trainerworkout.trainee.database.DatabaseHelper;
import com.trainerworkout.trainee.gson.DeserializeUser;
import com.trainerworkout.trainee.helper.CurrentUser;
import com.trainerworkout.trainee.helper.HttpClientSingleton;
import com.trainerworkout.trainee.helper.Security;
import com.trainerworkout.trainee.model.rest.LoginModel;
import com.trainerworkout.trainee.model.rest.UserModel;
import com.trainerworkout.trainee.model.rest.WorkoutModel;
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
		final OkClient client = createOkHttpClient();
				
		Button login_button = (Button)findViewById(R.id.button1);
		login_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	            	
            	final TextView email 	  	= (TextView)findViewById(R.id.login_email);
            	final TextView password 	= (TextView)findViewById(R.id.login_password);
            	
            	RestAdapter restAdapter = new RestAdapter.Builder()
	    			.setLogLevel(RestAdapter.LogLevel.FULL)
	    			.setEndpoint(URLQueries.SERVER_ZONE)
	    			.setClient(client)
	    			.build(); 

	    		TWService service = restAdapter.create(TWService.class);
	    		service.performLogin(email.getText().toString(), password.getText().toString(), new Callback<LoginModel>() {
	    			@Override
	    			public void success(LoginModel model, Response response) {
	    				final boolean success = (model.getStatus().equals(LOGIN_SUCCESS) ? true : false);
	    				if(success)
	    					startMainActivity(response, password.getText().toString());
	    				else
	    					showLoginError();
	    			}
	    			@Override
	    			public void failure(RetrofitError error) {
	    				startMainActivityOffLine(email.getText().toString(), password.getText().toString());
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
	private void startMainActivity(Response response, String password){
		// Build user model
		Gson gson = new GsonBuilder()
					        .registerTypeAdapter(UserModel.class, new DeserializeUser())
					        .create();
		String json = new String(((TypedByteArray) response.getBody()).getBytes());
		UserModel user = gson.fromJson(json, UserModel.class);
		
		// Create DB user
		UserModel DBUser = null;
		try {
			user.setPassword(password);
			DBUser = createAndReturnUserIfNotExist(user);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		Intent mainActivity = new Intent(this, MainActivity.class);
		mainActivity.putExtra("user_id", DBUser.getId());
		startActivity(mainActivity);
	}
	
	/**
	 * Start Main Activity Off Line
	 */
	private void startMainActivityOffLine(String email, String password){
		DatabaseHelper helper = DatabaseHelper.getInstance(getApplicationContext());
		
		PreparedQuery<UserModel> preparedQuery = null;
		UserModel DBUser = null;
		try {
			QueryBuilder<UserModel, Integer> qb = helper.getUserDao().queryBuilder();
			Where where = qb.where();
			where.eq("email", email);
			where.and();
			where.eq("password", password);
			preparedQuery = qb.prepare();
			DBUser = helper.getUserDao().queryForFirst(preparedQuery);
			
			if(null != DBUser){
				Intent mainActivity = new Intent(this, MainActivity.class);
				mainActivity.putExtra("user_id", DBUser.getId());
				startActivity(mainActivity);
			} else {
				new ToastNotification.Builder(this.getApplicationContext())
					.withNotification("Please check your internet connection.")
					.show();
			}
		}catch (Exception e){
			e.printStackTrace();
		}		
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
	
	/**
	 * @return OkClient object to perform Rest calls
	 */
	private OkClient createOkHttpClient(){
		new HttpClientSingleton();
		return HttpClientSingleton.getInstance();
	}
	
	/**
	 * 
	 * @param user
	 * @return UserModel object: last logged user
	 * @throws Exception
	 */
	private UserModel createAndReturnUserIfNotExist(UserModel user) throws Exception{
		// Get DB instance
		DatabaseHelper helper = DatabaseHelper.getInstance(getApplicationContext());
		// Insert and return user from DB
		UserModel DBUser = helper.getUserDao().createIfNotExists(user);
		
		return DBUser;
	}
}
