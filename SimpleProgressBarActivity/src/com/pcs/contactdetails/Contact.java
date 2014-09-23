package com.pcs.contactdetails;


import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable{

	private String name;
	private String number;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public static Parcelable.Creator<Contact> getCreator() {
		return CREATOR;
	}

	public Contact(String personName, String phoneNumber){
		name =personName;
		number=phoneNumber;

	}

	public Contact(Parcel source) {
		name=source.readString();
		number=source.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {

		@Override
		public Contact createFromParcel(Parcel source) {
			return new Contact(source);
		}

		public Contact[] newArray(int size) {
			return new Contact[size];
		}
	};

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(name);
		dest.writeString(number);
	}
	
	public String toString() {
		
		return "Personname :"+ getName()+"\nPhoneNumber"+ getNumber();
		
	};

}
