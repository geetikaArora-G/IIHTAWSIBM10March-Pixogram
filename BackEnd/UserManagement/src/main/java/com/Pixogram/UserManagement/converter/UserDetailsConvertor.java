package com.Pixogram.UserManagement.converter;

import com.Pixogram.UserManagement.DTO.UserDetailsDTO;
import com.Pixogram.UserManagement.model.UserDetails;

public final class UserDetailsConvertor {

	public static UserDetailsDTO convertUserDetailsToUSerDetailsDTO(UserDetails userDetails) {

		UserDetailsDTO userDetailsDTO = new UserDetailsDTO(userDetails.getId(), userDetails.getFirstName(),
				userDetails.getLastName(), userDetails.getUserName(), userDetails.getEmail(), userDetails.getDob(),
				userDetails.getPassword(), userDetails.getConfirmPassword(),null);
		
		return userDetailsDTO;
	}

	public static UserDetails convertUserDetailsDTOToUSerDetails(UserDetailsDTO userDetailsDTO) {
		UserDetails userDetails = new UserDetails(userDetailsDTO.getId(), userDetailsDTO.getFirstName(),
				userDetailsDTO.getLastName(), userDetailsDTO.getUserName(), userDetailsDTO.getEmail(),
				userDetailsDTO.getDob(), userDetailsDTO.getPassword(), userDetailsDTO.getConfirmPassword(), null, null,
				null);
		return userDetails;
	}

}
