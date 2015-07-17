package com.trainerworkout.trainee.adapter;

import java.util.ArrayList;
import java.util.List;

import com.trainerworkout.trainee.R;
import com.trainerworkout.trainee.helper.DownloadSetImageTask;
import com.trainerworkout.trainee.helper.DownloadSetImageTask.ImageType;
import com.trainerworkout.trainee.model.drawer.NavDrawerFirstItem;
import com.trainerworkout.trainee.model.rest.ExercisesModel;
import com.trainerworkout.trainee.model.rest.WorkoutHolderModel;
import com.trainerworkout.trainee.model.rest.WorkoutModel;
import com.trainerworkout.trainee.model.rest.WorkoutsExercisesModel;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class WorkoutExerciseListAdapter extends BaseAdapter {

	private Context context;
    private List<ExercisesModel> exercisesItems;
    private List<ImageView> exerciseImages;
	
    /**
     * @param context
     * @param workoutItems
     */
	public WorkoutExerciseListAdapter(Context context,
			List<ExercisesModel> exercisesItem) {
		super();
		this.context = context;
		this.exercisesItems = exercisesItem;
	}

	@Override
	public int getCount() {
		return exercisesItems.size();
	}

	@Override
	public Object getItem(int position) {
		return exercisesItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.exercise_item, null);
        }
          
        TextView 	txtTitle 	= (TextView) convertView.findViewById(R.id.workout_exercise_name);
        ImageView 	exImage 	= (ImageView)convertView.findViewById(R.id.workout_exercise_image); 
        
        
        // Set Exercise Name
        txtTitle.setText(exercisesItems.get(position).getName());
        // Set Exercise Image
//        new DownloadSetImageTask(exImage, context, false, ImageType.MISSING_GENERAL)
//    		.execute(exercisesItems.get(position).getImage());
		
		return convertView;
	}

	public List<ImageView> getExerciseImages(){
		return exerciseImages;
	}
}
