package com.Pixogram.MediaUpload.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Pixogram.MediaUpload.model.MediaDetails;




public interface MediaRepository extends CrudRepository<MediaDetails, String> {
	
	  List<MediaDetails> findByUserId(Long id);


}
