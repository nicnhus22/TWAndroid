package com.trainerworkout.trainee.helper;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.trainerworkout.trainee.R;
import com.trainerworkout.trainee.view.RoundedImage;

public class DownloadSetImageTask extends AsyncTask<String, Void, Bitmap> {
	
	private final String SERVER_ROOT = "http://staging.trainerworkout.com/";
	
	ImageView bmImage;
	Context context;
	boolean rounded;

	public DownloadSetImageTask(ImageView bmImage, Context context, boolean rounded) {
		this.bmImage = bmImage;
		this.context = context;
		this.rounded = rounded;
	}

	protected Bitmap doInBackground(String... urls) {
		String urldisplay = urls[0];
		Bitmap mIcon11 = null;
		try {
			InputStream in = new java.net.URL(SERVER_ROOT.concat(urldisplay)).openStream();
			mIcon11 = BitmapFactory.decodeStream(in);
		} catch (Exception e) {
			Log.e("Error", e.getMessage());
			e.printStackTrace();
			mIcon11 = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_profile);
		}
		return mIcon11;
	}

	protected void onPostExecute(Bitmap result) {
		if(this.rounded){
			RoundedImage roundedImage = new RoundedImage(result);
			bmImage.setImageDrawable(roundedImage);
		} else {
			bmImage.setImageBitmap(result);
		}
	}
	
}