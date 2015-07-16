package com.trainerworkout.trainee.database;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.trainerworkout.trainee.R;
import com.trainerworkout.trainee.model.rest.ExercisesModel;
import com.trainerworkout.trainee.model.rest.UserModel;
import com.trainerworkout.trainee.model.rest.WorkoutModel;
import com.trainerworkout.trainee.model.rest.WorkoutsExercisesModel;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	// Log tag
	private final String LOG_NAME = getClass().getName();
	
	private Context context;
	
	// Database constants
	private static final String 	DATABASE_NAME = "Trainer.db";
	private static final Integer 	DATABASE_VERSION = 1;
	private static DatabaseHelper instance;
	
	// Tables
	private Dao<WorkoutModel, Integer> 	workoutDao  = null;
	private Dao<UserModel, Integer> 	userDao 	= null;
	private Dao<WorkoutsExercisesModel, Integer> workoutsExercisesDao 	= null;
	private Dao<ExercisesModel, Integer> exercisesDao = null;
	
	// Exceptions
	private RuntimeExceptionDao<WorkoutModel, Integer> 	 workoutRuntimeDao 	= null;
	private RuntimeExceptionDao<UserModel, Integer> 	 userRuntimeDao 		= null;
	private RuntimeExceptionDao<WorkoutsExercisesModel, Integer> workoutsExercisesRuntimeDao = null;
	private RuntimeExceptionDao<ExercisesModel, Integer> exercisesRuntimeDao = null; 


	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
		this.context = context;
	}

	/**
	 * @param c
	 * @return
	 */
	public static DatabaseHelper getInstance(Context c) {
		if ( DatabaseHelper.instance == null ) {
			DatabaseHelper.instance = new DatabaseHelper(c);
		}
		return DatabaseHelper.instance;
	}
	
	/**
	 * Runtime exception for UserModel table.
	 * @return
	 */
	public RuntimeExceptionDao<UserModel,Integer> getUserRuntimeDao() {
		if (userRuntimeDao == null) {
			userRuntimeDao = getRuntimeExceptionDao(UserModel.class);
		}
		return userRuntimeDao;
	}
	
	/**
	 * Runtime exception for WorkoutModel table.
	 * @return
	 * @throws java.sql.SQLException 
	 */
	public RuntimeExceptionDao<WorkoutModel,Integer> getWorkoutRuntimeDao() {
		if (workoutRuntimeDao == null) {
			workoutRuntimeDao = getRuntimeExceptionDao(WorkoutModel.class);
		}
		return workoutRuntimeDao;
	}
	
	/**
	 * Get UserDao instance
	 * @return
	 * @throws SQLException
	 */
	public Dao<UserModel, Integer> getUserDao() throws SQLException {
		if (userDao == null) {
			userDao = getDao(UserModel.class);
		}
		return userDao;
	}

	/**
	 * Get Workout instance
	 * @return
	 * @throws java.sql.SQLException 
	 */
	public Dao<WorkoutModel, Integer> getWorkoutDao() throws SQLException {
		if (workoutDao == null) {
			workoutDao = getDao(WorkoutModel.class);
		}
		return workoutDao;
	}
	
	/**
	 * Get WorkoutsExercises instance
	 * @return
	 * @throws SQLException
	 */
	public Dao<WorkoutsExercisesModel, Integer> getWorkoutsExercisesDao() throws SQLException {
		if (workoutsExercisesDao == null) {
			workoutsExercisesDao = getDao(WorkoutsExercisesModel.class);
		}
		return workoutsExercisesDao;
	}
	
	public Dao<ExercisesModel, Integer> getExercisesDao() throws SQLException {
		if (exercisesDao == null) {
			exercisesDao = getDao(ExercisesModel.class);
		}
		return exercisesDao;
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onCreate");
			TableUtils.createTable(connectionSource, UserModel.class);
			TableUtils.createTable(connectionSource, WorkoutModel.class);
			TableUtils.createTable(connectionSource, WorkoutsExercisesModel.class);
			TableUtils.createTable(connectionSource, ExercisesModel.class);
		} catch (SQLException e) {
			Log.e(LOG_NAME, "Could not create new tables", e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersion,
			int newVersion) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onUpgrade");
			TableUtils.dropTable(connectionSource, UserModel.class, true);
			TableUtils.dropTable(connectionSource, WorkoutModel.class, true);
			TableUtils.dropTable(connectionSource, WorkoutsExercisesModel.class, true);
			TableUtils.dropTable(connectionSource, ExercisesModel.class, true);
			onCreate(sqLiteDatabase, connectionSource);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		super.close();
		userRuntimeDao 		 = null;
		workoutRuntimeDao 	 = null;
		workoutsExercisesRuntimeDao = null;
		exercisesRuntimeDao  = null;
	}

}

