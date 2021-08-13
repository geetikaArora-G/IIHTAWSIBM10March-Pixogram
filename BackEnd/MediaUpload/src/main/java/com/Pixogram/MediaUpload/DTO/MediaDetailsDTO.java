package com.Pixogram.MediaUpload.DTO;

import org.springframework.web.multipart.MultipartFile;



public class MediaDetailsDTO{

	private String title;
	private String description;
	private String tags;
	private MultipartFile media;
	private String mediaUrl;
	private String mediaType;
	
	public MediaDetailsDTO() {
		super();
	}
	public MediaDetailsDTO( String title, String description, String tags,
			MultipartFile media ,String mediaUrl, String mediaType) {
		super();
		this.title = title;
		this.description = description;
		this.tags = tags;
		this.media = media;
		this.mediaUrl = mediaUrl;
		this.mediaType = mediaType;
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
	
	public MultipartFile getMedia() {
		return media;
	}
	public void setMedia(MultipartFile media) {
		this.media = media;
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
