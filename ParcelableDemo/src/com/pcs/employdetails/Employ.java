package com.pcs.employdetails;


import android.os.Parcel;

import android.os.Parcelable;

public class Employ implements Parcelable{
	public String employName;
	public String employID;
	public String designation;

	

	public Employ() {

	}


	public String getEmployName() {
		return employName;
	}
	public void setEmployName(String employName) {
		this.employName = employName;
	}
	public String getEmployID() {
		return employID;
	}
	public void setEmployID(String employID) {
		this.employID = employID;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public int describeContents() {
		return 0;
	}
	
	public Employ(Parcel source) {

		setEmployName(source.readString());
		setEmployID(source.readString());
		setDesignation(source.readString());
	}

	
	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeString(getEmployName());
		dest.writeString(getEmployID());
		dest.writeString(getDesignation());

	}

	

	public static final Creator<Employ> CREATOR = new Creator<Employ>(){

		
		@Override
		public Employ createFromParcel(Parcel source) {
			return new Employ(source);
		}
		
		@Override
		public Employ[] newArray(int size) {
			return new Employ[size];
		}

	};

	
	public String toString() {

		return "Username :"+ getEmployName()+"\nEmploy ID :"+ getEmployID()+"\nDesignation :"+getDesignation();

	};

}
