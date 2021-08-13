package com.Pixogram.UserManagement.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Pixogram.UserManagement.model.UserDetails;


public interface UserRepository extends CrudRepository<UserDetails, String> {
	
	  List<UserDetails> findByUserNameAndPassword(String userName, String password);
	  
	  List<UserDetails> findByUserName(String userName);
	  
	  List<UserDetails> findById(Long id);


}
