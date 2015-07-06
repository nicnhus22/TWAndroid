package com.trainerworkout.trainee.model.rest;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "UserModel")
public class UserModel {
	
	@DatabaseField(canBeNull = false, id = true)
	int id;
	@DatabaseField(canBeNull = true, defaultValue = "0")
	int admin;
	@DatabaseField(canBeNull = true, defaultValue = "0")
	int appInstalled;
	@DatabaseField(canBeNull = true, defaultValue = "0")
	int demoApp;
	@DatabaseField(canBeNull = true)
    String firstName;
	@DatabaseField(canBeNull = true)
    String lastName;
	@DatabaseField(canBeNull = true)
    String email;
	@DatabaseField(canBeNull = true)
    String phone;
	@DatabaseField(canBeNull = true)
    String address;
	@DatabaseField(canBeNull = true)
    String street;
	@DatabaseField(canBeNull = true)
    String suite;
	@DatabaseField(canBeNull = true)
    String city;
	@DatabaseField(canBeNull = true)
    String province;
	@DatabaseField(canBeNull = true)
    String country;
	@DatabaseField(canBeNull = true)
    String userType;
	@DatabaseField(canBeNull = true)
    String fbUsername;
	@DatabaseField(canBeNull = true)
    String created_at;
	@DatabaseField(canBeNull = true)
	String deleted_at;
	@DatabaseField(canBeNull = true)
	String updated_at;
	@DatabaseField(canBeNull = true, defaultValue = "America/New_York")
	String timezone;
	@DatabaseField(canBeNull = true)
	String thumb;
	@DatabaseField(canBeNull = true)
	String image;
	@DatabaseField(canBeNull = true)
	String birthday;
	@DatabaseField(canBeNull = true)
	String biography;
	@DatabaseField(canBeNull = true)
	String certifications;
	@DatabaseField(canBeNull = true)
	String specialities;
	@DatabaseField(canBeNull = true)
	String past_experience;
	@DatabaseField(canBeNull = true)
	String word;
	@DatabaseField(canBeNull = true)
    String videoLink;
	@DatabaseField(canBeNull = true)
    String videoKey;
	@DatabaseField(canBeNull = true)
    String demoWeb;
	@DatabaseField(canBeNull = true)
    String stripeCheckoutToken;
	@DatabaseField(canBeNull = true)
    String typeOfCreditCard;
	@DatabaseField(canBeNull = true)
    String fourLastDigits;
	@DatabaseField(canBeNull = true)
    String gender;
	@DatabaseField(canBeNull = true)
    String lastLoginApp;
	@DatabaseField(canBeNull = true)
    String lastLogin;
    
    /**
     * 
     * @param id
     * @param admin
     * @param appInstalled
     * @param demoApp
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @param address
     * @param street
     * @param suite
     * @param city
     * @param province
     * @param country
     * @param userType
     * @param fbUsername
     * @param created_at
     * @param deleted_at
     * @param updated_at
     * @param timezone
     * @param thumb
     * @param image
     * @param birthday
     * @param biography
     * @param certifications
     * @param specialities
     * @param past_experience
     * @param word
     * @param videoLink
     * @param videoKey
     * @param demoWeb
     * @param stripeCheckoutToken
     * @param typeOfCreditCard
     * @param fourLastDigits
     * @param gender
     * @param lastLoginApp
     * @param lastLogin
     * @param weight
     * @param objectives
     */
	public UserModel(int id, int admin, int appInstalled, int demoApp,
			String firstName, String lastName, String email, String phone,
			String address, String street, String suite, String city,
			String province, String country, String userType,
			String fbUsername, String created_at, String deleted_at,
			String updated_at, String timezone, String thumb, String image,
			String birthday, String biography, String certifications,
			String specialities, String past_experience, String word,
			String videoLink, String videoKey, String demoWeb,
			String stripeCheckoutToken, String typeOfCreditCard,
			String fourLastDigits, String gender, String lastLoginApp,
			String lastLogin, String weight[], String objectives[]) {
		super();
		this.id = id;
		this.admin = admin;
		this.appInstalled = appInstalled;
		this.demoApp = demoApp;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.province = province;
		this.country = country;
		this.userType = userType;
		this.fbUsername = fbUsername;
		this.created_at = created_at;
		this.deleted_at = deleted_at;
		this.updated_at = updated_at;
		this.timezone = timezone;
		this.thumb = thumb;
		this.image = image;
		this.birthday = birthday;
		this.biography = biography;
		this.certifications = certifications;
		this.specialities = specialities;
		this.past_experience = past_experience;
		this.word = word;
		this.videoLink = videoLink;
		this.videoKey = videoKey;
		this.demoWeb = demoWeb;
		this.stripeCheckoutToken = stripeCheckoutToken;
		this.typeOfCreditCard = typeOfCreditCard;
		this.fourLastDigits = fourLastDigits;
		this.gender = gender;
		this.lastLoginApp = lastLoginApp;
		this.lastLogin = lastLogin;
	}

	public UserModel() {
		// ORM Lite requires it
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the admin
	 */
	public int getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(int admin) {
		this.admin = admin;
	}

	/**
	 * @return the appInstalled
	 */
	public int getAppInstalled() {
		return appInstalled;
	}

	/**
	 * @param appInstalled the appInstalled to set
	 */
	public void setAppInstalled(int appInstalled) {
		this.appInstalled = appInstalled;
	}

	/**
	 * @return the demoApp
	 */
	public int getDemoApp() {
		return demoApp;
	}

	/**
	 * @param demoApp the demoApp to set
	 */
	public void setDemoApp(int demoApp) {
		this.demoApp = demoApp;
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

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the suite
	 */
	public String getSuite() {
		return suite;
	}

	/**
	 * @param suite the suite to set
	 */
	public void setSuite(String suite) {
		this.suite = suite;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the fbUsername
	 */
	public String getFbUsername() {
		return fbUsername;
	}

	/**
	 * @param fbUsername the fbUsername to set
	 */
	public void setFbUsername(String fbUsername) {
		this.fbUsername = fbUsername;
	}

	/**
	 * @return the created_at
	 */
	public String getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	/**
	 * @return the deleted_at
	 */
	public String getDeleted_at() {
		return deleted_at;
	}

	/**
	 * @param deleted_at the deleted_at to set
	 */
	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}

	/**
	 * @return the updated_at
	 */
	public String getUpdated_at() {
		return updated_at;
	}

	/**
	 * @param updated_at the updated_at to set
	 */
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	/**
	 * @return the timezone
	 */
	public String getTimezone() {
		return timezone;
	}

	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	/**
	 * @return the thumb
	 */
	public String getThumb() {
		return thumb;
	}

	/**
	 * @param thumb the thumb to set
	 */
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the biography
	 */
	public String getBiography() {
		return biography;
	}

	/**
	 * @param biography the biography to set
	 */
	public void setBiography(String biography) {
		this.biography = biography;
	}

	/**
	 * @return the certifications
	 */
	public String getCertifications() {
		return certifications;
	}

	/**
	 * @param certifications the certifications to set
	 */
	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}

	/**
	 * @return the specialities
	 */
	public String getSpecialities() {
		return specialities;
	}

	/**
	 * @param specialities the specialities to set
	 */
	public void setSpecialities(String specialities) {
		this.specialities = specialities;
	}

	/**
	 * @return the past_experience
	 */
	public String getPast_experience() {
		return past_experience;
	}

	/**
	 * @param past_experience the past_experience to set
	 */
	public void setPast_experience(String past_experience) {
		this.past_experience = past_experience;
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @return the videoLink
	 */
	public String getVideoLink() {
		return videoLink;
	}

	/**
	 * @param videoLink the videoLink to set
	 */
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	/**
	 * @return the videoKey
	 */
	public String getVideoKey() {
		return videoKey;
	}

	/**
	 * @param videoKey the videoKey to set
	 */
	public void setVideoKey(String videoKey) {
		this.videoKey = videoKey;
	}

	/**
	 * @return the demoWeb
	 */
	public String getDemoWeb() {
		return demoWeb;
	}

	/**
	 * @param demoWeb the demoWeb to set
	 */
	public void setDemoWeb(String demoWeb) {
		this.demoWeb = demoWeb;
	}

	/**
	 * @return the stripeCheckoutToken
	 */
	public String getStripeCheckoutToken() {
		return stripeCheckoutToken;
	}

	/**
	 * @param stripeCheckoutToken the stripeCheckoutToken to set
	 */
	public void setStripeCheckoutToken(String stripeCheckoutToken) {
		this.stripeCheckoutToken = stripeCheckoutToken;
	}

	/**
	 * @return the typeOfCreditCard
	 */
	public String getTypeOfCreditCard() {
		return typeOfCreditCard;
	}

	/**
	 * @param typeOfCreditCard the typeOfCreditCard to set
	 */
	public void setTypeOfCreditCard(String typeOfCreditCard) {
		this.typeOfCreditCard = typeOfCreditCard;
	}

	/**
	 * @return the fourLastDigits
	 */
	public String getFourLastDigits() {
		return fourLastDigits;
	}

	/**
	 * @param fourLastDigits the fourLastDigits to set
	 */
	public void setFourLastDigits(String fourLastDigits) {
		this.fourLastDigits = fourLastDigits;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the lastLoginApp
	 */
	public String getLastLoginApp() {
		return lastLoginApp;
	}

	/**
	 * @param lastLoginApp the lastLoginApp to set
	 */
	public void setLastLoginApp(String lastLoginApp) {
		this.lastLoginApp = lastLoginApp;
	}

	/**
	 * @return the lastLogin
	 */
	public String getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}    
    
}
