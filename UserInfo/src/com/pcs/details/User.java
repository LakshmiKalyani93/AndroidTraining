package com.pcs.details;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
	
	private static String username;
	private static String password;
	private static String email;
	private static String phonenumber;
	private static String address;
	
	public User(Parcel source) {
		
		setUsername(source.readString());
		setPassword(source.readString());
		setEmail(source.readString());
		setPhonenumber(source.readString());
		setAddress(source.readString());
		
	}
	public User() {
		
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		User.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		User.password = password;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		User.email = email;
	}
	public static String getPhonenumber() {
		return phonenumber;
	}
	public static void setPhonenumber(String phonenumber) {
		User.phonenumber = phonenumber;
	}
	public static String getAddress() {
		return address;
	}
	public static void setAddress(String address) {
		User.address = address;
	}
	@Override
	public int describeContents() {
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeString(getUsername());
		dest.writeString(getPassword());
		dest.writeString(getEmail());
		dest.writeString(getPhonenumber());
		dest.writeString(getAddress());
			
	}
	
public static final Creator<User> CREATOR = new Creator<User>(){

	@Override
	public User createFromParcel(Parcel source) {
		return new User(source);
	}

	@Override
	public User[] newArray(int size) {
		return new User[size];
	}
		
};

public String toString() {
	
	return "Username :"+ getUsername()+"\nPassword"+ getPassword()+"\nEmail :"+getEmail()+
"\nPhone Number :"+getPhonenumber()+"\nAddress :"+getAddress();
	
};

}
