package com.trainerworkout.trainee.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.trainerworkout.trainee.R;
import com.trainerworkout.trainee.adapter.WorkoutExerciseListAdapter;
import com.trainerworkout.trainee.database.DatabaseHelper;
import com.trainerworkout.trainee.model.rest.ExercisesModel;
import com.trainerworkout.trainee.model.rest.WorkoutsExercisesModel;

public class WorkoutFragment extends Fragment {

	private WorkoutExerciseListAdapter adapter;
	private ListView workoutExercisesList;

	public WorkoutFragment(){}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_workout, container, false);

		Integer SELECTED_WORKOUT_ID = getArguments().getInt("SELECTED_WORKOUT_ID");

		workoutExercisesList = (ListView)rootView.findViewById(R.id.workout_exercise_list);

		List<ExercisesModel> exercises = fetchOffLineWorkoutExercises(SELECTED_WORKOUT_ID);
		addWorkoutExercisesListToView(exercises);

		return rootView;
	}

	private void addWorkoutExercisesListToView(List<ExercisesModel> exercises){
		adapter = new WorkoutExerciseListAdapter(getActivity().getApplicationContext(), exercises);
		workoutExercisesList.setAdapter(adapter);
		// workoutExercisesList.setOnItemClickListener(new WorkoutClickListener(workouts));
    }

	private List<ExercisesModel> fetchOffLineWorkoutExercises(int workoutID){
		List<WorkoutsExercisesModel> workoutExercises 	= new ArrayList<WorkoutsExercisesModel>();
		List<ExercisesModel> 		 exercises 			= new ArrayList<ExercisesModel>();

		DatabaseHelper helper = DatabaseHelper.getInstance(getActivity());

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