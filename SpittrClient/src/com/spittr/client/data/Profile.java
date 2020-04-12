package com.spittr.client.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class Profile {
	
	private String name;
	
	public Profile() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
