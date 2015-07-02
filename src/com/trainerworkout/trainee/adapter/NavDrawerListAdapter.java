package com.trainerworkout.trainee.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.trainerworkout.trainee.R;
import com.trainerworkout.trainee.helper.DownloadSetImageTask;
import com.trainerworkout.trainee.helper.DownloadSetImageTask.ImageType;
import com.trainerworkout.trainee.model.drawer.NavDrawerFirstItem;
import com.trainerworkout.trainee.model.drawer.NavDrawerItem;
 
public class NavDrawerListAdapter extends BaseAdapter {
     
    private Context context;
    private ArrayList<Object> navDrawerItems;
     
    public NavDrawerListAdapter(Context context, ArrayList<Object> navDrawerItems){
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }
 
    @Override
    public int getCount() {
        return navDrawerItems.size();
    }
 
    @Override
    public Object getItem(int position) {       
        return navDrawerItems.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
	        
    	if(navDrawerItems.get(position).getClass() == NavDrawerFirstItem.class){
    		if (convertView == null) {
	            LayoutInflater mInflater = (LayoutInflater)
	                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
	            convertView = mInflater.inflate(R.layout.drawer_first_item, null);
	        }
	          
	        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.first_drawer_image);
	        TextView txtTitle = (TextView) convertView.findViewById(R.id.first_drawer_first_name);
	          
	          
	        new DownloadSetImageTask(imgIcon, this.context, true, ImageType.MISSING_PROFILE)
            	.execute(((NavDrawerFirstItem)navDrawerItems.get(position)).getProfileImage());
	        
	        txtTitle.setText(((NavDrawerFirstItem)navDrawerItems.get(position)).getFirstName());
    	}else{
    		if (convertView == null) {
	            LayoutInflater mInflater = (LayoutInflater)
	                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
	            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
	        }
	          
	        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
	        TextView txtTitle = (TextView) convertView.findViewById(R.id.drawer_title);
	          
	        imgIcon.setImageResource(((NavDrawerItem)navDrawerItems.get(position)).getIcon());        
	        txtTitle.setText(((NavDrawerItem)navDrawerItems.get(position)).getTitle());
	         
    	}
    		
        return convertView;
    }
 
}