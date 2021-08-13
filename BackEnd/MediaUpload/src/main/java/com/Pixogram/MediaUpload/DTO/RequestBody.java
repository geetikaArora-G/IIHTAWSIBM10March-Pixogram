package com.Pixogram.MediaUpload.DTO;

public class RequestBody {
	
	MediaDetailsDTO[] mediaDetailsDto;
	
	

	public RequestBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public RequestBody(MediaDetailsDTO[] mediaDetailsDto) {
		super();
		this.mediaDetailsDto = mediaDetailsDto;
	}


	public MediaDetailsDTO[] getMediaDetailsDto() {
		return mediaDetailsDto;
	}

	public void setMediaDetailsDto(MediaDetailsDTO[] mediaDetailsDto) {
		this.mediaDetailsDto = mediaDetailsDto;
	}

	
}
