package com.trainerworkout.trainee.model.rest;

import com.google.gson.annotations.Expose;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "WorkoutsExercisesModel")
public class WorkoutsExercisesModel {

	@Expose
	private ExercisesModel exercises;
	
	@DatabaseField(canBeNull = false, id = true)
	int id;
	@DatabaseField(canBeNull = true)
	int workoutId;
	@DatabaseField(canBeNull = true)
	int exerciseId;
	@DatabaseField(canBeNull = true)
	int sets;
	@DatabaseField(canBeNull = true)
	int order;
	@DatabaseField(canBeNull = true)
	String notes;
	@DatabaseField(canBeNull = true)
	String created_at;
	@DatabaseField(canBeNull = true)
	String deleted_at;
	@DatabaseField(canBeNull = true)
	String updated_at;
	@DatabaseField(canBeNull = true)
	int equipmentId;
	@DatabaseField(canBeNull = true)
	int groupId;
	@DatabaseField(canBeNull = true)
	String metric;
	
	public WorkoutsExercisesModel(){}
	
	/**
	 * @param id
	 * @param workoutId
	 * @param exerciseId
	 * @param sets
	 * @param order
	 * @param notes
	 * @param created_at
	 * @param deleted_at
	 * @param updated_at
	 * @param equipmentId
	 * @param groupId
	 * @param metric
	 */
	public WorkoutsExercisesModel(int id, int workoutId, int exerciseId,
			int sets, int order, String notes, String created_at,
			String deleted_at, String updated_at, int equipmentId, int groupId,
			String metric) {
		super();
		this.id = id;
		this.workoutId = workoutId;
		this.exerciseId = exerciseId;
		this.sets = sets;
		this.order = order;
		this.notes = notes;
		this.created_at = created_at;
		this.deleted_at = deleted_at;
		this.updated_at = updated_at;
		this.equipmentId = equipmentId;
		this.groupId = groupId;
		this.metric = metric;
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
	 * @return the workoutId
	 */
	public int getWorkoutId() {
		return workoutId;
	}
	/**
	 * @param workoutId the workoutId to set
	 */
	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}
	/**
	 * @return the exerciseId
	 */
	public int getExerciseId() {
		return exerciseId;
	}
	/**
	 * @param exerciseId the exerciseId to set
	 */
	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}
	/**
	 * @return the sets
	 */
	public int getSets() {
		return sets;
	}
	/**
	 * @param sets the sets to set
	 */
	public void setSets(int sets) {
		this.sets = sets;
	}
	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
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
	 * @return the equipmentId
	 */
	public int getEquipmentId() {
		return equipmentId;
	}
	/**
	 * @param equipmentId the equipmentId to set
	 */
	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}
	/**
	 * @return the groupId
	 */
	public int getGroupId() {
		return groupId;
	}
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	/**
	 * @return the metric
	 */
	public String getMetric() {
		return metric;
	}
	/**
	 * @param metric the metric to set
	 */
	public void setMetric(String metric) {
		this.metric = metric;
	}

	/**
	 * @return the exercise
	 */
	public ExercisesModel getExercise() {
		return exercises;
	}

	/**
	 * @param exercise the exercise to set
	 */
	public void setExercise(ExercisesModel exercise) {
		this.exercises = exercise;
	}
	
	
}
