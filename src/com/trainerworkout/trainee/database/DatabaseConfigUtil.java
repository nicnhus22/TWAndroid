package com.trainerworkout.trainee.database;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import com.trainerworkout.trainee.model.rest.ExercisesModel;
import com.trainerworkout.trainee.model.rest.UserModel;
import com.trainerworkout.trainee.model.rest.WorkoutModel;
import com.trainerworkout.trainee.model.rest.WorkoutsExercisesModel;

import java.io.IOException;
import java.sql.SQLException;


/**
 * DatabaseConfigUtl writes a configuration file to avoid using annotation processing in runtime which is very slow
 * under Android. This gains a noticeable performance improvement.
 * 
 * The configuration file is written to /res/raw/ by default. More info at: http://ormlite.com/docs/table-config
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {

	private static final Class<?>[] classes = new Class[] {
			UserModel.class, WorkoutModel.class, WorkoutsExercisesModel.class, ExercisesModel.class
	};
	public static void main(String[] args) throws SQLException, IOException {
		writeConfigFile("ormlite_config.txt",classes);
	}
}
