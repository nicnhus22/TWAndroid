package com.trainerworkout.trainee.adapter;

import java.util.ArrayList;
import java.util.List;

import com.trainerworkout.trainee.R;
import com.trainerworkout.trainee.helper.DownloadSetImageTask;
import com.trainerworkout.trainee.model.drawer.NavDrawerFirstItem;
import com.trainerworkout.trainee.model.rest.WorkoutHolderModel;
import com.trainerworkout.trainee.model.rest.WorkoutModel;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class WorkoutListAdapter extends BaseAdapter {

	private Context context;
    private List<WorkoutModel> workoutItems;
	
    /**
     * @param context
     * @param workoutItems
     */
	public WorkoutListAdapter(Context context,
			List<WorkoutModel> workoutItems) {
		super();
		this.context = context;
		this.workoutItems = workoutItems;
	}

	@Override
	public int getCount() {
		return workoutItems.size();
	}

	@Override
	public Object getItem(int position) {
		return workoutItems.get(position);
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
            convertView = mInflater.inflate(R.layout.workout_item, null);
        }
          
        TextView txtTitle = (TextView) convertView.findViewById(R.id.workout_item_name);
        
        txtTitle.setText(workoutItems.get(position).getName());
		
		return convertView;
	}

}
