package com.trainerworkout.trainee.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.trainerworkout.trainee.R;
import com.trainerworkout.trainee.database.DatabaseHelper;
import com.trainerworkout.trainee.helper.CurrentUser;
import com.trainerworkout.trainee.helper.DownloadSetImageTask;
import com.trainerworkout.trainee.helper.DownloadSetImageTask.ImageType;
import com.trainerworkout.trainee.model.rest.UserModel;
import com.trainerworkout.trainee.notification.ToastNotification;
import com.trainerworkout.trainee.view.RoundedImage;
 
public class ProfileFragment extends Fragment {

	// Class Variables
    private static final String TAG = ProfileFragment.class.getSimpleName();
    
    // Photo management
    final int REQ_CODE_PICK_IMAGE= 1;
    
    // VIew Components
    ImageView profile_edit_image;
    EditText  profile_edit_first_name;
    EditText  profile_edit_last_name;
    EditText  profile_edit_email;
    EditText  profile_edit_password;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        
        // Fetch logged user
        UserModel DBUser = CurrentUser.fetch(getActivity());
        
        profile_edit_image 		= (ImageView)rootView.findViewById(R.id.profile_edit_image);
        profile_edit_first_name = (EditText)rootView.findViewById(R.id.profile_edit_first_name);
        profile_edit_last_name 	= (EditText)rootView.findViewById(R.id.profile_edit_last_name);
        profile_edit_email 		= (EditText)rootView.findViewById(R.id.profile_edit_email);
        profile_edit_password 	= (EditText)rootView.findViewById(R.id.profile_edit_password);
        
        // Set user fields
        new DownloadSetImageTask(profile_edit_image, getActivity(), true, ImageType.MISSING_GENERAL)
        	.execute(DBUser.getImage());
        profile_edit_first_name.setText(DBUser.getFirstName());
        profile_edit_last_name.setText(DBUser.getLastName());
        profile_edit_email.setText(DBUser.getEmail());
        
        profile_edit_image.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view) {
				new ToastNotification.Builder(getActivity())
					.withNotification("Will change image")
					.show();
				Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
				photoPickerIntent.setType("image/*");
				startActivityForResult(photoPickerIntent, REQ_CODE_PICK_IMAGE);    
			}
        });
        
        return rootView;
    }

	@Override
	public void onResume() {
		super.onResume();
	}

	/**
	 * On result, transform the selected image into a Bitmap
	 * and set the image in the view
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, 
		       Intent imageReturnedIntent) {
		    super.onActivityResult(requestCode, resultCode, imageReturnedIntent); 

		    switch(requestCode) { 
		    case REQ_CODE_PICK_IMAGE:
		        if(resultCode == Activity.RESULT_OK){  
		            Uri selectedImage = imageReturnedIntent.getData();
		            String[] filePathColumn = {MediaStore.Images.Media.DATA};

		            Cursor cursor = getActivity().getContentResolver().query(
		                               selectedImage, filePathColumn, null, null, null);
		            cursor.moveToFirst();

		            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
		            String filePath = cursor.getString(columnIndex);
		            cursor.close();

		            Bitmap bitmap = BitmapFactory.decodeFile(filePath);
		            
		            int width = bitmap.getWidth();
		            int height = bitmap.getHeight();
		            Bitmap cropImg = null;
		            int scale = (width > height ? height : width);
		            cropImg = Bitmap.createBitmap(bitmap, 0, 0, scale, scale);
		            
		            RoundedImage profile_image = new RoundedImage(cropImg);
		            profile_edit_image.setImageDrawable(profile_image);
		        }
		    }
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


	
}