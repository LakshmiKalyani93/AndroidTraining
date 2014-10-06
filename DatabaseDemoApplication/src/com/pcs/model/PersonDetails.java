package com.pcs.model;

import android.content.Context;


public class PersonDetails  {
	
	private String UserName ;
	private String Email;
	private String Password;
	
	public PersonDetails(Context context) {
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
