package com.trainerworkout.trainee;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.trainerworkout.trainee.adapter.WorkoutExerciseListAdapter;
import com.trainerworkout.trainee.database.DatabaseHelper;
import com.trainerworkout.trainee.helper.DownloadSetImageTask;
import com.trainerworkout.trainee.helper.SelectedWorkout;
import com.trainerworkout.trainee.helper.DownloadSetImageTask.ImageType;
import com.trainerworkout.trainee.model.rest.ExercisesModel;
import com.trainerworkout.trainee.model.rest.WorkoutModel;
import com.trainerworkout.trainee.model.rest.WorkoutsExercisesModel;

public class WorkoutActivity extends FragmentActivity {
	
	private WorkoutExerciseListAdapter adapter;
	private ListView workoutExercisesList;
	private List<ExercisesModel> exercises;

	public WorkoutActivity(){}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workout);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		// Retrieve user ID
		Integer SELECTED_WORKOUT_ID 	= -1;
		String  SELECTED_WORKOUT_NAME	= "";
		Bundle extras = getIntent().getExtras();
		if(extras != null) {
			SELECTED_WORKOUT_ID 	= extras.getInt("SELECTED_WORKOUT_ID");
			SELECTED_WORKOUT_NAME	= extras.getString("SELECTED_WORKOUT_NAME");
		}
		getActionBar().setTitle(SELECTED_WORKOUT_NAME);
		
		workoutExercisesList 	= (ListView)findViewById(R.id.workout_exercise_list);
		exercises 				= fetchOffLineWorkoutExercises(SELECTED_WORKOUT_ID);
		addWorkoutExercisesListToView(exercises);
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

	/**
     * WIll take the workout list as input and trigger the corresponding
     * action when clicked: show exercise activity.
     */
    private class WorkoutExerciseClickListener implements ListView.OnItemClickListener {
    	
    	private List<ExercisesModel> exercises;
    	
    	public WorkoutExerciseClickListener(List<ExercisesModel> exercises){
    		this.exercises = exercises;
    	}

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent workoutExerciseActivity = new Intent(getApplicationContext(), WorkoutExerciseActivity.class);
			workoutExerciseActivity.putExtra("SELECTED_WORKOUT_EXERCISE_ID", exercises.get(position).getId());
			startActivity(workoutExerciseActivity);
		}
    }
	
	private void addWorkoutExercisesListToView(List<ExercisesModel> exercises){
		adapter = new WorkoutExerciseListAdapter(getApplicationContext().getApplicationContext(), exercises);
		workoutExercisesList.setAdapter(adapter);
		workoutExercisesList.setOnItemClickListener(new WorkoutExerciseClickListener(exercises));
    }

	private List<ExercisesModel> fetchOffLineWorkoutExercises(int workoutID){
		List<WorkoutsExercisesModel> workoutExercises 	= new ArrayList<WorkoutsExercisesModel>();
		List<ExercisesModel> 		 exercises 			= new ArrayList<ExercisesModel>();

		DatabaseHelper helper = DatabaseHelper.getInstance(getApplicationContext());

		PreparedQuery<WorkoutsExercisesModel> preparedWorkoutsQuery = null;
		PreparedQuery<ExercisesModel> preparedExercisesQuery 		= null;
		try {
			QueryBuilder<WorkoutsExercisesModel, Integer> qb = helper.getWorkoutsExercisesDao().queryBuilder();
			Where where = qb.where();
			where.eq("workoutId", workoutID);
			preparedWorkoutsQuery = qb.prepare();
			
			workoutExercises = helper.getWorkoutsExercisesDao().query(preparedWorkoutsQuery);
			
			for(WorkoutsExercisesModel exercise: workoutExercises){
				QueryBuilder<ExercisesModel, Integer> qb2 = helper.getExercisesDao().queryBuilder();
				Where where2 = qb2.where();
				where2.eq("id", exercise.getExerciseId());
				preparedExercisesQuery = qb2.prepare();
				
				exercises.addAll(helper.getExercisesDao().query(preparedExercisesQuery));
			}
		}catch (Exception e){
			e.printStackTrace();
		}		

		return exercises;
	}

}