package com.spittr;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.web.multipart.MultipartFile;

public class Spitter {

	private Long id;
	
	
	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	private String password;
	
	private MultipartFile profilePicture;

//	public Spitter(String firstName, String lastName, String userName, String password) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.userName = userName;
//		this.password = password;
//	}
//
//	public Spitter(Long id, String firstName, String lastName, String userName, String password) {
//		this.id = id;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.userName = userName;
//		this.password = password;
//	}
//	
//	public Spitter() {
//		// TODO Auto-generated constructor stub
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	@NotNull(message = "First Name cannot be null")
	@Size(min = 5, max = 30, message =  "first name must between 5 and 20 characters")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@NotNull(message = "Last Name cannot be null")
	@Size(min = 5, max = 30, message =  "last name must between 5 and 20 characters")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	@NotNull(message = "Username cannot be null")
	@Size(min = 5, max = 15, message =  "username must between 5 and 20 characters")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	@NotNull(message = "password Name cannot be null")
	@Size(min = 5, max = 25 , message =  "password must between 5 and 20 characters")
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public MultipartFile getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(MultipartFile profilePicture) {
		this.profilePicture = profilePicture;
	}

	@Override
	public String toString() {
		return String.format("[id =%s, firstname = %s, lastname=%s, username = %s, password = %s]", this.getId(),this.getFirstName(), this.getLastName(), this.getUserName(), this.getPassword());
	}
	
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "id");
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id");
	}

}
