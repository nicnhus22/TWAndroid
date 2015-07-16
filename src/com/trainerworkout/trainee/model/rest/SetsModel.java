package com.trainerworkout.trainee.model.rest;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "SetsModel")
public class SetsModel {

	@DatabaseField(canBeNull = false, id = true)
	int id;
	@DatabaseField(canBeNull = true)
	int exerciseId;
	@DatabaseField(canBeNull = true)
	int workoutsExercisesId;
	@DatabaseField(canBeNull = true)
	int number;
	@DatabaseField(canBeNull = true)
	int reps;
	@DatabaseField(canBeNull = true)
	float weight;
	@DatabaseField(canBeNull = true)
	int rest;
	@DatabaseField(canBeNull = true)
	String tempo;
	@DatabaseField(canBeNull = true)
	String type;
	@DatabaseField(canBeNull = true)
	float distance;
	@DatabaseField(canBeNull = true)
	String speed;
	@DatabaseField(canBeNull = true)
	int time;
	@DatabaseField(canBeNull = true)
	String notes;
	@DatabaseField(canBeNull = true)
	int workoutId;
	@DatabaseField(canBeNull = true)
	int completed;
	@DatabaseField(canBeNull = true)
	int last;
	@DatabaseField(canBeNull = true)
	String created_at;
	@DatabaseField(canBeNull = true)
	String updated_at;
	@DatabaseField(canBeNull = true)
	String deleted_at;
	@DatabaseField(canBeNull = true)
	float weightKG;
	@DatabaseField(canBeNull = true)
	int bpm;
	@DatabaseField(canBeNull = true)
	int equipmentId;
	@DatabaseField(canBeNull = true)
	String metric;
	
	public SetsModel(){}
	
	/**
	 * @param id
	 * @param exerciseId
	 * @param workoutsExercisesId
	 * @param number
	 * @param reps
	 * @param weight
	 * @param rest
	 * @param tempo
	 * @param type
	 * @param distance
	 * @param speed
	 * @param time
	 * @param notes
	 * @param workoutId
	 * @param completed
	 * @param last
	 * @param created_at
	 * @param updated_at
	 * @param deleted_at
	 * @param weightKG
	 * @param bpm
	 * @param equipmentId
	 * @param metric
	 */
	public SetsModel(int id, int exerciseId, int workoutsExercisesId,
			int number, int reps, float weight, int rest, String tempo,
			String type, float distance, String speed, int time, String notes,
			int workoutId, int completed, int last, String created_at,
			String updated_at, String deleted_at, float weightKG, int bpm,
			int equipmentId, String metric) {
		super();
		this.id = id;
		this.exerciseId = exerciseId;
		this.workoutsExercisesId = workoutsExercisesId;
		this.number = number;
		this.reps = reps;
		this.weight = weight;
		this.rest = rest;
		this.tempo = tempo;
		this.type = type;
		this.distance = distance;
		this.speed = speed;
		this.time = time;
		this.notes = notes;
		this.workoutId = workoutId;
		this.completed = completed;
		this.last = last;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.weightKG = weightKG;
		this.bpm = bpm;
		this.equipmentId = equipmentId;
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
	 * @return the workoutsExercisesId
	 */
	public int getWorkoutsExercisesId() {
		return workoutsExercisesId;
	}
	/**
	 * @param workoutsExercisesId the workoutsExercisesId to set
	 */
	public void setWorkoutsExercisesId(int workoutsExercisesId) {
		this.workoutsExercisesId = workoutsExercisesId;
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @return the reps
	 */
	public int getReps() {
		return reps;
	}
	/**
	 * @param reps the reps to set
	 */
	public void setReps(int reps) {
		this.reps = reps;
	}
	/**
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}
	/**
	 * @return the rest
	 */
	public int getRest() {
		return rest;
	}
	/**
	 * @param rest the rest to set
	 */
	public void setRest(int rest) {
		this.rest = rest;
	}
	/**
	 * @return the tempo
	 */
	public String getTempo() {
		return tempo;
	}
	/**
	 * @param tempo the tempo to set
	 */
	public void setTempo(String tempo) {
		this.tempo = tempo;
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
	 * @return the distance
	 */
	public float getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(float distance) {
		this.distance = distance;
	}
	/**
	 * @return the speed
	 */
	public String getSpeed() {
		return speed;
	}
	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
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
	 * @return the completed
	 */
	public int getCompleted() {
		return completed;
	}
	/**
	 * @param completed the completed to set
	 */
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	/**
	 * @return the last
	 */
	public int getLast() {
		return last;
	}
	/**
	 * @param last the last to set
	 */
	public void setLast(int last) {
		this.last = last;
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
	 * @return the weightKG
	 */
	public float getWeightKG() {
		return weightKG;
	}
	/**
	 * @param weightKG the weightKG to set
	 */
	public void setWeightKG(float weightKG) {
		this.weightKG = weightKG;
	}
	/**
	 * @return the bpm
	 */
	public int getBpm() {
		return bpm;
	}
	/**
	 * @param bpm the bpm to set
	 */
	public void setBpm(int bpm) {
		this.bpm = bpm;
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
	
	
	
}
