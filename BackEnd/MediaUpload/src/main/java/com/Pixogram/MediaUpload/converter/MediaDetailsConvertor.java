package com.Pixogram.MediaUpload.converter;

import com.Pixogram.MediaUpload.DTO.MediaDetailsDTO;
import com.Pixogram.MediaUpload.model.MediaDetails;

public final class MediaDetailsConvertor {

	public static MediaDetailsDTO convertMediaDetailsToMediaDetailsDTO(MediaDetails mediaDetails) {

		MediaDetailsDTO mediaDetailsDTO = new MediaDetailsDTO( mediaDetails.getTitle(), mediaDetails.getDescription(), mediaDetails.getTags(), null,mediaDetails.getMediaUrl(),mediaDetails.getMediaType());
		
		return mediaDetailsDTO;
	}

	public static MediaDetails convertMediaDetailsDTOToMediaDetails(MediaDetailsDTO mediaDetailsDTO) {
		MediaDetails mediaDetails = new MediaDetails(0,0, mediaDetailsDTO.getTitle(), mediaDetailsDTO.getDescription(), mediaDetailsDTO.getTags(), null,mediaDetailsDTO.getMediaUrl(),String.valueOf(mediaDetailsDTO.getMediaType()));
		return mediaDetails;
	}

}
