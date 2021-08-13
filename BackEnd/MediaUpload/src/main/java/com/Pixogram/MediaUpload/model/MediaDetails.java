package com.Pixogram.MediaUpload.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class MediaDetails {

	@Id
	@GeneratedValue
	private long mediaId;
	private long userId;
	private String title;
	private String description;
	private String tags;
	private Timestamp uploadedDate;
	private String mediaUrl;
	private String mediaType;
	
	public MediaDetails() {
		super();
	}
	public MediaDetails(long mediaId, long userId, String title, String description, String tags,
			Timestamp uploadedDate, String mediaUrl, String mediaType) {
		super();
		this.mediaId = mediaId;
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.tags = tags;
		this.uploadedDate = uploadedDate;
		this.mediaUrl = mediaUrl;
		this.mediaType = mediaType;

	}
	public long getMediaId() {
		return mediaId;
	}
	public void setMediaId(long mediaId) {
		this.mediaId = mediaId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Timestamp getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(Timestamp uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	public String getMediaUrl() {
		return mediaUrl;
	}
	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	
}
