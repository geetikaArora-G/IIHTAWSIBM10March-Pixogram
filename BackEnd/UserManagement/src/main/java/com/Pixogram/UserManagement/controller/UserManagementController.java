package com.Pixogram.UserManagement.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.Pixogram.UserManagement.DTO.UserDetailsDTO;
import com.Pixogram.UserManagement.Exception.UserNotFoundException;
import com.Pixogram.UserManagement.client.AuthServiceProxy;
import com.Pixogram.UserManagement.converter.UserDetailsConvertor;
import com.Pixogram.UserManagement.model.JwtRequest;
import com.Pixogram.UserManagement.model.UserDetails;
import com.Pixogram.UserManagement.service.FileHandler;
import com.Pixogram.UserManagement.service.UserManagementService;

@RestController
@EnableEurekaClient
public class UserManagementController {

	private static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);

	@Autowired
	private UserManagementService service;
	
	@Autowired
	AuthServiceProxy authService;

	/**
	 * Method to get User Details on the basis of Username & password
	 * 
	 * @throws UserNotFoundException
	 * 
	 */
	@RequestMapping("/Users/{userName}/{password}")
	public ResponseEntity getUserDetailsForLogin(@PathVariable String userName, @PathVariable String password)
			throws UserNotFoundException {
		logger.debug("Method -> getUserDetailsForLogin || UserName : " + userName + "|| Password : " + password);
		UserDetailsDTO userDetailsDTO= UserDetailsConvertor.convertUserDetailsToUSerDetailsDTO(service.getUser(userName, password));
		JwtRequest jwtRequest = new JwtRequest();
		jwtRequest.setUserName(userName);
		String authorization = authService.authenticate(jwtRequest);
		 HttpHeaders headers = new HttpHeaders();
		    headers.set("Authorization", authorization);
		return ResponseEntity.ok().headers(headers).body(userDetailsDTO);
	}

	/**
	 * Method to get User Details on the basis of Username to check if its
	 * unique or not
	 * 
	 * @throws UserNotFoundException
	 * 
	 */
	@RequestMapping("/Users/{userName}")
	public UserDetailsDTO checkIfUserExists(@PathVariable String userName)
			throws UserNotFoundException {
		logger.debug("Method -> getUserDetailsForCheckingUserName || UserName : " + userName);
		return UserDetailsConvertor.convertUserDetailsToUSerDetailsDTO(service.getUser(userName));
	}

	/**
	 * Method to Add User Details
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST, value = "Users")
	public long addUserDetails(@ModelAttribute UserDetailsDTO userDetailsDTO) throws IOException {
		logger.debug("Method -> addUserDetails || UserName : " + userDetailsDTO.getUserName());
		UserDetails user = UserDetailsConvertor.convertUserDetailsDTOToUSerDetails(userDetailsDTO);
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		user.setCreatedDate(timeStamp);
		if (userDetailsDTO.getProfilePicture() != null) {
			user.setLocationOfProfilePicture(FileHandler.saveFile(userDetailsDTO.getProfilePicture(),userDetailsDTO.getUserName()));
		}
		return service.addUserOrUpdate(user);
	}

	/**
	 * Method to Update User Details -
	 * @throws UserNotFoundException 
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST, value = "Users/{id}")
	public long updateUserDetails(@ModelAttribute UserDetailsDTO userDetailsDTO, @PathVariable String id) throws UserNotFoundException {
		logger.debug("Method -> updateUserDetails || UserName : " + userDetailsDTO.getUserName());
		UserDetails user = service.getUserById(id);
		user.setUserName(userDetailsDTO.getUserName());
		user.setPassword(userDetailsDTO.getPassword());
		user.setConfirmPassword(userDetailsDTO.getConfirmPassword());
		user.setEmail(userDetailsDTO.getEmail());
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		user.setUpdatedDate(timeStamp);
		user.setId(Long.valueOf(id));
		return service.addUserOrUpdate(user);
	}
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "Authorization"));
        configuration.setExposedHeaders(Arrays.asList("Authorization"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
