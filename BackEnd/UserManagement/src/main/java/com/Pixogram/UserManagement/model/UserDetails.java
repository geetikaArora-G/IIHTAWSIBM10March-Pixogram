package com.Pixogram.UserManagement.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class UserDetails {

	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private Date dob;
	private String password;
	private String confirmPassword;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	private String locationOfProfilePicture;

	public UserDetails() {
	
	}

	public UserDetails(long id, String firstName, String lastName, String userName, String email, Date dob,
			String password, String confirmPassword, Timestamp createdDate, Timestamp updatedDate,
			String locationOfProfilePicture) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.dob = dob;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.locationOfProfilePicture = locationOfProfilePicture;
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

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getLocationOfProfilePicture() {
		return locationOfProfilePicture;
	}

	public void setLocationOfProfilePicture(String locationOfProfilePicture) {
		this.locationOfProfilePicture = locationOfProfilePicture;
	}

	

	
}
