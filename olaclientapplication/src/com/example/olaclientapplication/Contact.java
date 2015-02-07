package com.example.olaclientapplication;

import android.net.Uri;

public class Contact {

	public Contact(String name){
		CONTACT_NAME = name;
	}
	public boolean isSelected;
	public long CONTACT_ID;
	public String CONTACT_NUMBER;
	public String CONTACT_LOOKUP_KEY;
	public String CONTACT_NAME;
	public Uri CONTACT_URI;
	public String OBJECT_ID;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return CONTACT_NAME;
	}
}
