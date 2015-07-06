package com.trainerworkout.trainee.model.rest;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "WorkoutModel")
public class WorkoutModel {
	
	@DatabaseField(canBeNull = false, id = true)
	private int id;
	@DatabaseField(canBeNull = true)
	private String name;
	@DatabaseField(canBeNull = true)
    private int categoryId;
	@DatabaseField(canBeNull = false, defaultValue = "0")
    private int  shares;
	@DatabaseField(canBeNull = true)
    private int views;
	@DatabaseField(canBeNull = true)
    private String objectives;
	@DatabaseField(canBeNull = true)
    private String description;
	@DatabaseField(canBeNull = true)
    private String type;
	@DatabaseField(canBeNull = true)
    private int userId;
	@DatabaseField(canBeNull = false, defaultValue = "0")
    private int authorId;
	@DatabaseField(canBeNull = true)
    private int timesPerformed;
	@DatabaseField(canBeNull = true)
    private int parentWorkout;
	@DatabaseField(canBeNull = true)
    private String availability;
	@DatabaseField(canBeNull = true)
    private String updated_at;
	@DatabaseField(canBeNull = true)
    private String created_at;
	@DatabaseField(canBeNull = true)
    private String deleted_at;
	@DatabaseField(canBeNull = false, defaultValue = "0")
    private float timesPerWeek;
	@DatabaseField(canBeNull = false, defaultValue = "0")
    private float averageCompleted;
	@DatabaseField(canBeNull = false, defaultValue = "0")
    private int sale;
	@DatabaseField(canBeNull = false, defaultValue = "0")
    private float price;
	@DatabaseField(canBeNull = true)
    private String category;
	@DatabaseField(canBeNull = true)
    private String lastRevized;
	@DatabaseField(canBeNull = false, defaultValue = "0")
    private int timesPerformedRevized;
    
    
    /**
     * @param id
     * @param name
     * @param categoryId
     * @param shares
     * @param views
     * @param objectives
     * @param description
     * @param type
     * @param userId
     * @param authorId
     * @param timesPerformed
     * @param parentWorkout
     * @param availability
     * @param updated_at
     * @param created_at
     * @param deleted_at
     * @param timesPerWeek
     * @param averageCompleted
     * @param sale
     * @param price
     * @param category
     * @param lastRevized
     * @param timesPerformedRevized
     */
	public WorkoutModel(int id, String name, int categoryId, int shares,
			int views, String objectives, String description, String type,
			int userId, int authorId, int timesPerformed, int parentWorkout,
			String availability, String updated_at, String created_at,
			String deleted_at, float timesPerWeek, float averageCompleted,
			int sale, float price, String category, String lastRevized,
			int timesPerformedRevized) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.shares = shares;
		this.views = views;
		this.objectives = objectives;
		this.description = description;
		this.type = type;
		this.userId = userId;
		this.authorId = authorId;
		this.timesPerformed = timesPerformed;
		this.parentWorkout = parentWorkout;
		this.availability = availability;
		this.updated_at = updated_at;
		this.created_at = created_at;
		this.deleted_at = deleted_at;
		this.timesPerWeek = timesPerWeek;
		this.averageCompleted = averageCompleted;
		this.sale = sale;
		this.price = price;
		this.category = category;
		this.lastRevized = lastRevized;
		this.timesPerformedRevized = timesPerformedRevized;
	}
	
	public WorkoutModel(){
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the shares
	 */
	public int getShares() {
		return shares;
	}
	/**
	 * @param shares the shares to set
	 */
	public void setShares(int shares) {
		this.shares = shares;
	}
	/**
	 * @return the views
	 */
	public int getViews() {
		return views;
	}
	/**
	 * @param views the views to set
	 */
	public void setViews(int views) {
		this.views = views;
	}
	/**
	 * @return the objectives
	 */
	public String getObjectives() {
		return objectives;
	}
	/**
	 * @param objectives the objectives to set
	 */
	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the authorId
	 */
	public int getAuthorId() {
		return authorId;
	}
	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	/**
	 * @return the timesPerformed
	 */
	public int getTimesPerformed() {
		return timesPerformed;
	}
	/**
	 * @param timesPerformed the timesPerformed to set
	 */
	public void setTimesPerformed(int timesPerformed) {
		this.timesPerformed = timesPerformed;
	}
	/**
	 * @return the parentWorkout
	 */
	public int getParentWorkout() {
		return parentWorkout;
	}
	/**
	 * @param parentWorkout the parentWorkout to set
	 */
	public void setParentWorkout(int parentWorkout) {
		this.parentWorkout = parentWorkout;
	}
	/**
	 * @return the availability
	 */
	public String getAvailability() {
		return availability;
	}
	/**
	 * @param availability the availability to set
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
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
	 * @return the timesPerWeek
	 */
	public float getTimesPerWeek() {
		return timesPerWeek;
	}
	/**
	 * @param timesPerWeek the timesPerWeek to set
	 */
	public void setTimesPerWeek(float timesPerWeek) {
		this.timesPerWeek = timesPerWeek;
	}
	/**
	 * @return the averageCompleted
	 */
	public float getAverageCompleted() {
		return averageCompleted;
	}
	/**
	 * @param averageCompleted the averageCompleted to set
	 */
	public void setAverageCompleted(float averageCompleted) {
		this.averageCompleted = averageCompleted;
	}
	/**
	 * @return the sale
	 */
	public int getSale() {
		return sale;
	}
	/**
	 * @param sale the sale to set
	 */
	public void setSale(int sale) {
		this.sale = sale;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the lastRevized
	 */
	public String getLastRevized() {
		return lastRevized;
	}
	/**
	 * @param lastRevized the lastRevized to set
	 */
	public void setLastRevized(String lastRevized) {
		this.lastRevized = lastRevized;
	}
	/**
	 * @return the timesPerformedRevized
	 */
	public int getTimesPerformedRevized() {
		return timesPerformedRevized;
	}
	/**
	 * @param timesPerformedRevized the timesPerformedRevized to set
	 */
	public void setTimesPerformedRevized(int timesPerformedRevized) {
		this.timesPerformedRevized = timesPerformedRevized;
	}
	
    
	
}
