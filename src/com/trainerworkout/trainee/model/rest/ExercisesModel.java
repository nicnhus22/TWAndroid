package com.trainerworkout.trainee.model.rest;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ExercisesModel")
public class ExercisesModel {
	
	@DatabaseField(canBeNull = false, id = true)
	int id;
	@DatabaseField(canBeNull = true)
	int bodygroupId;
	@DatabaseField(canBeNull = true)
	int userId;
	@DatabaseField(canBeNull = true)
	String name;
	@DatabaseField(canBeNull = true)
	String description;
	@DatabaseField(canBeNull = true)
	String image;
	@DatabaseField(canBeNull = true)
	String image2;
	@DatabaseField(canBeNull = true)
	String thumb;
	@DatabaseField(canBeNull = true)
	String thumb2;
	@DatabaseField(canBeNull = true)
	String video;
	@DatabaseField(canBeNull = true)
	String youtube;
	@DatabaseField(canBeNull = true)
	String type;
	@DatabaseField(canBeNull = true)
	String equipment;
	@DatabaseField(canBeNull = true)
	String deleted_at;
	@DatabaseField(canBeNull = true)
	String created_at;
	@DatabaseField(canBeNull = true)
	String updated_at;
	@DatabaseField(canBeNull = true)
	int authorId;
	@DatabaseField(canBeNull = true)
	int bodyGroupSec;
	@DatabaseField(canBeNull = false, defaultValue="0")
	int views;
	@DatabaseField(canBeNull = false, defaultValue="0")
	int used;
	@DatabaseField(canBeNull = true)
	String nameEngine;
	
	
	public ExercisesModel(){}
	
	/**
	 * @param id
	 * @param bodygroupId
	 * @param userId
	 * @param name
	 * @param description
	 * @param image
	 * @param image2
	 * @param thumb
	 * @param thumb2
	 * @param video
	 * @param youtube
	 * @param type
	 * @param equipment
	 * @param deleted_at
	 * @param created_at
	 * @param updated_at
	 * @param authorId
	 * @param bodyGroupSec
	 * @param views
	 * @param used
	 * @param nameEngine
	 */
	public ExercisesModel(int id, int bodygroupId, int userId, String name,
			String description, String image, String image2, String thumb,
			String thumb2, String video, String youtube, String type,
			String equipment, String deleted_at, String created_at,
			String updated_at, int authorId, int bodyGroupSec, int views,
			int used, String nameEngine) {
		super();
		this.id = id;
		this.bodygroupId = bodygroupId;
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.image = image;
		this.image2 = image2;
		this.thumb = thumb;
		this.thumb2 = thumb2;
		this.video = video;
		this.youtube = youtube;
		this.type = type;
		this.equipment = equipment;
		this.deleted_at = deleted_at;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.authorId = authorId;
		this.bodyGroupSec = bodyGroupSec;
		this.views = views;
		this.used = used;
		this.nameEngine = nameEngine;
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
	 * @return the bodygroupId
	 */
	public int getBodygroupId() {
		return bodygroupId;
	}
	/**
	 * @param bodygroupId the bodygroupId to set
	 */
	public void setBodygroupId(int bodygroupId) {
		this.bodygroupId = bodygroupId;
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
	 * @return the image2
	 */
	public String getImage2() {
		return image2;
	}
	/**
	 * @param image2 the image2 to set
	 */
	public void setImage2(String image2) {
		this.image2 = image2;
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
	 * @return the thumb2
	 */
	public String getThumb2() {
		return thumb2;
	}
	/**
	 * @param thumb2 the thumb2 to set
	 */
	public void setThumb2(String thumb2) {
		this.thumb2 = thumb2;
	}
	/**
	 * @return the video
	 */
	public String getVideo() {
		return video;
	}
	/**
	 * @param video the video to set
	 */
	public void setVideo(String video) {
		this.video = video;
	}
	/**
	 * @return the youtube
	 */
	public String getYoutube() {
		return youtube;
	}
	/**
	 * @param youtube the youtube to set
	 */
	public void setYoutube(String youtube) {
		this.youtube = youtube;
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
	 * @return the equipment
	 */
	public String getEquipment() {
		return equipment;
	}
	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipment(String equipment) {
		this.equipment = equipment;
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
	 * @return the bodyGroupSec
	 */
	public int getBodyGroupSec() {
		return bodyGroupSec;
	}
	/**
	 * @param bodyGroupSec the bodyGroupSec to set
	 */
	public void setBodyGroupSec(int bodyGroupSec) {
		this.bodyGroupSec = bodyGroupSec;
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
	 * @return the used
	 */
	public int getUsed() {
		return used;
	}
	/**
	 * @param used the used to set
	 */
	public void setUsed(int used) {
		this.used = used;
	}
	/**
	 * @return the nameEngine
	 */
	public String getNameEngine() {
		return nameEngine;
	}
	/**
	 * @param nameEngine the nameEngine to set
	 */
	public void setNameEngine(String nameEngine) {
		this.nameEngine = nameEngine;
	}
 
	
	
}
