package com.Pixogram.MediaUpload.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Pixogram.MediaUpload.Exception.NoMediaFoundException;
import com.Pixogram.MediaUpload.model.MediaDetails;
import com.Pixogram.MediaUpload.repo.MediaRepository;

@Service
public class MediaUploadService {
	
	private static final Logger logger = LoggerFactory.getLogger(MediaUploadService.class);


	@Autowired
	MediaRepository repo;

	public long addUserOrUpdate(MediaDetails mediaDetails) {
		repo.save(mediaDetails);
		return mediaDetails.getMediaId();
	}
	public int countNoOfMediaByUserId(Long userId) {
		List<MediaDetails> list = repo.findByUserId(userId);
		if (null == list) {	
		     return 0;
		}
		return list.size();
	}
	public List<MediaDetails> getMediaDetailsByUserId(Long userId) throws NoMediaFoundException {

		List<MediaDetails> list = repo.findByUserId(userId);
		if (null == list) {	
			logger.error("No Media Found User Having UserId : " + userId);
			throw new NoMediaFoundException("No Media Found User Having UserId : " + userId);
		}
		return list;
	}

	
}
