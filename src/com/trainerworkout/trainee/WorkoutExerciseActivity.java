package com.trainerworkout.trainee;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.trainerworkout.trainee.adapter.WorkoutExerciseListAdapter;
import com.trainerworkout.trainee.database.DatabaseHelper;
import com.trainerworkout.trainee.helper.DownloadSetImageTask;
import com.trainerworkout.trainee.helper.DownloadSetImageTask.ImageType;
import com.trainerworkout.trainee.model.rest.ExercisesModel;
import com.trainerworkout.trainee.model.rest.WorkoutsExercisesModel;

public class WorkoutExerciseActivity extends FragmentActivity {
	
	

	public WorkoutExerciseActivity(){}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workout_exercise);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		ImageView image_one = (ImageView)findViewById(R.id.workout_exercise_image_one);
		ImageView image_two = (ImageView)findViewById(R.id.workout_exercise_image_two);
		
		// Retrieve user ID
		Integer SELECTED_WORKOUT_EXERCISE_ID 	= -1;
		Bundle extras = getIntent().getExtras();
		if(extras != null) {
			SELECTED_WORKOUT_EXERCISE_ID = extras.getInt("SELECTED_WORKOUT_EXERCISE_ID");
		}
		
		ExercisesModel exercise = fetchExerciseFromId(SELECTED_WORKOUT_EXERCISE_ID);
		
		new DownloadSetImageTask(image_one, getApplicationContext(), false, ImageType.MISSING_GENERAL)
			.execute(exercise.getImage());
		new DownloadSetImageTask(image_two, getApplicationContext(), false, ImageType.MISSING_GENERAL)
		.execute(exercise.getImage2());
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case android.R.id.home:
	        onBackPressed();
	        return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}
	
	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		// TODO Auto-generated method stub
		super.onActivityResult(arg0, arg1, arg2);
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.FragmentActivity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onPostResume() {
		// TODO Auto-generated method stub
		super.onPostResume();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	private ExercisesModel fetchExerciseFromId(int id){
		DatabaseHelper helper = DatabaseHelper.getInstance(getApplicationContext());
		ExercisesModel exercise = null;

		try {			
			exercise = helper.getExercisesDao().queryForId(id);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return exercise;
	}
}