package com.Pixogram.MediaUpload.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Pixogram.MediaUpload.DTO.MediaDetailsDTO;
import com.Pixogram.MediaUpload.DTO.RequestBody;
import com.Pixogram.MediaUpload.Exception.NoMediaFoundException;
import com.Pixogram.MediaUpload.converter.MediaDetailsConvertor;
import com.Pixogram.MediaUpload.model.MediaDetails;
import com.Pixogram.MediaUpload.service.FileHandler;
import com.Pixogram.MediaUpload.service.MediaUploadService;

@RestController
@CrossOrigin(origins = "*")
public class MediaUploadController {

	private static final Logger logger = LoggerFactory.getLogger(MediaUploadController.class);

	@Autowired
	private MediaUploadService service;

	/**
	 * Method to get Media Details on the basis of UserId
	 * 
	 * @throws NoMediaFoundException
	 * @throws IOException 
	 * 
	 */
	@RequestMapping("/Media/GetMedia/{userId}")
	public List<String> getMediaDetailsByUserId(@PathVariable String userId)
			throws NoMediaFoundException, IOException {
		logger.debug("Method -> getMediaDetailsByUserId || UserId : " + userId);
		List<MediaDetailsDTO> mediaDetailsDTO = new ArrayList<MediaDetailsDTO>();
		List<MediaDetails> mediaDetails = service.getMediaDetailsByUserId(Long.valueOf(userId));
		for (MediaDetails mediaDetailsTemp : mediaDetails) {
			MediaDetailsDTO MediaDetailsDTOTemp = MediaDetailsConvertor.convertMediaDetailsToMediaDetailsDTO(mediaDetailsTemp);
			mediaDetailsDTO.add(MediaDetailsDTOTemp);
		}
		List<String> list = new ArrayList<>();
		for(MediaDetailsDTO mediaDetailsDTO1 :mediaDetailsDTO){
			File file = new File(mediaDetailsDTO1.getMediaUrl());
			FileInputStream f= new FileInputStream(file);
			byte[] bytes=new byte[(int)file.length()];
			f.read(bytes);
			String encodeBase64 = Base64.getEncoder().encodeToString(bytes);
			list.add("date:image/"+"jpg"+";base64,"+encodeBase64);
			
		}
		return list;
	}

	

	/**
	 * Method to Add Media Details
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/Media/UploadMedia/{userId}")
	public long addMediaDetails(@ModelAttribute RequestBody requestBody ,@PathVariable String userId) throws IOException {
		logger.debug("Method -> addMediaDetails");
		 MediaDetailsDTO[] mediaDetailsDTOList= requestBody.getMediaDetailsDto();
		int nextMediaNo = service.countNoOfMediaByUserId(Long.valueOf(userId));
		for (MediaDetailsDTO mediaDetailsDTO : mediaDetailsDTOList) {
			MediaDetails mediaDetails = MediaDetailsConvertor.convertMediaDetailsDTOToMediaDetails(mediaDetailsDTO);
			mediaDetails.setMediaUrl(FileHandler.saveFile(mediaDetailsDTO.getMedia(),userId, String.valueOf(nextMediaNo+1)));
			mediaDetails.setUserId(Long.valueOf(userId));
			Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
			mediaDetails.setUploadedDate(timeStamp);
			mediaDetails.setMediaType(mediaDetailsDTO.getMedia().getOriginalFilename().split("\\.")[1]);
			nextMediaNo++;
			return service.addUserOrUpdate(mediaDetails);
		}
		return 0;
	}

	

}
