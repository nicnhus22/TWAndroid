package com.trainerworkout.trainee.model.drawer;

import android.widget.ImageView;

public class NavDrawerFirstItem {
     
    private String profileImage;
    private String firstName;
     
    public NavDrawerFirstItem(){}
 
    /**
     * 
     * @param profileImage
     * @param firstName
     */
    public NavDrawerFirstItem(String firstName, String profileImage){
        this.profileImage = profileImage;
        this.firstName = firstName;
    }

	/**
	 * @return the profileImage
	 */
	public String getProfileImage() {
		return profileImage;
	}

	/**
	 * @param profileImage the profileImage to set
	 */
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
     
    
}