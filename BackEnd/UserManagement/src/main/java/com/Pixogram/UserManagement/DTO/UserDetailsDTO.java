package com.Pixogram.UserManagement.DTO;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class UserDetailsDTO {

	private long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private Date dob;
	private String password;
	private String confirmPassword;
	private MultipartFile profilePicture;

	public UserDetailsDTO() {

	}

	public UserDetailsDTO(long id, String firstName, String lastName, String userName, String email, Date dob,
			String password, String confirmPassword,
			MultipartFile profilePicture) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.dob = dob;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.profilePicture = profilePicture;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public MultipartFile getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(MultipartFile profilePicture) {
		this.profilePicture = profilePicture;
	}

	

}
