package com.trainerworkout.trainee.helper;

import java.io.InputStream;
import java.lang.ref.WeakReference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.trainerworkout.trainee.R;
import com.trainerworkout.trainee.view.RoundedImage;

public class DownloadSetImageTask extends AsyncTask<String, Void, Bitmap> {
	
	private final String SERVER_ROOT = "http://staging.trainerworkout.com/";
	
	private final WeakReference<ImageView> bmImage;

	Context context;
	boolean rounded;
	ImageType type;
	
	public static enum ImageType {
		MISSING_PROFILE,
		MISSING_GENERAL
	}

	public DownloadSetImageTask(ImageView bmImage, Context context, boolean rounded, ImageType type) {
		this.bmImage = new WeakReference<ImageView>(bmImage);
		this.context = context;
		this.rounded = rounded;
		this.type = type;
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
			if(this.type == ImageType.MISSING_PROFILE)
				mIcon11 = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_profile);
			else if(this.type == ImageType.MISSING_GENERAL)
				mIcon11 = BitmapFactory.decodeResource(context.getResources(), R.drawable.tw);
		}
		return mIcon11;
	}

	protected void onPostExecute(Bitmap result) {
		try {
			if(this.rounded){
				RoundedImage roundedImage = new RoundedImage(result);
				ImageView image = bmImage.get();
				image.setImageDrawable(roundedImage);
			} else {
				ImageView image = bmImage.get();
				image.setImageBitmap(result);
			}
		}catch(Exception e){
			// Do nothing
		}
	}
}