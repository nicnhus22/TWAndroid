package com.trainerworkout.trainee.helper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.opengl.Visibility;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.trainerworkout.trainee.R;

public class Animations {

	/**
	 * Logo fade in out
	 * @param logo
	 */
	public static void startLogoFadeInOut(ImageView logo){
		Animation fadeIn = new AlphaAnimation(0, 1);
		fadeIn.setInterpolator(new DecelerateInterpolator());
		fadeIn.setDuration(500);

		Animation fadeOut = new AlphaAnimation(1, 0);
		fadeOut.setInterpolator(new AccelerateInterpolator());
		fadeOut.setStartOffset(500);
		fadeOut.setDuration(500);

		AnimationSet animation = new AnimationSet(false);
		animation.addAnimation(fadeIn);
		animation.addAnimation(fadeOut);
		
		logo.setAnimation(animation);
	}
	public static void stopLogoFadeInOut(ImageView logo){
		logo.setAnimation(null);
	}
	
	/**
	 * List view fade in
	 */
	public static void fadeView(final View view){
		// Prepare the View for the animation
		view.setVisibility(View.VISIBLE);
		view.setAlpha(0.0f);
		view.animate().alpha(1.0f);
	}
	
	
	/**
	 *  Hide view
	 */
	public static void hideView(View view){
		view.setVisibility(View.GONE);
	}
}
