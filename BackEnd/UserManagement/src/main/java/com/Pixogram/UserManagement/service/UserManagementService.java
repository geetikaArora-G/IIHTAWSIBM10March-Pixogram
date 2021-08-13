package com.Pixogram.UserManagement.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Pixogram.UserManagement.Exception.UserNotFoundException;
import com.Pixogram.UserManagement.model.UserDetails;
import com.Pixogram.UserManagement.repo.UserRepository;

@Service
public class UserManagementService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserManagementService.class);


	@Autowired
	UserRepository repo;

	public UserDetails getUser(String userName, String password) throws UserNotFoundException {

		List<UserDetails> list = repo.findByUserNameAndPassword(userName, password);
		if (null != list) {
			return list.get(0);
		} else {
			logger.error("User Not Found Having UserName : " + userName);
			throw new UserNotFoundException("User Not Found Having UserName : " + userName);
		}

	}

	public long addUserOrUpdate(UserDetails user) {
		repo.save(user);
		return user.getId();
	}

	public UserDetails getUser(String userName) throws UserNotFoundException {

		List<UserDetails> list = repo.findByUserName(userName);
		if (null != list) {
			return list.get(0);
		} else {
			logger.error("User Not Found Having UserName : " + userName);
			throw new UserNotFoundException("User Not Found Having UserName : " + userName);
		}
	}

	public UserDetails getUserById(String id) throws UserNotFoundException {

		List<UserDetails> list = repo.findById(Long.valueOf(id));
		if (null != list) {
			return list.get(0);
		} else {
			logger.error("User Not Found Having Id : " + id);
			throw new UserNotFoundException("User Not Found Having Id : " + id);
		}
	}
}
