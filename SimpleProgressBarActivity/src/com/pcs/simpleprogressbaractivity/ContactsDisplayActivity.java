package com.pcs.simpleprogressbaractivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.pcs.adapters.CustomAdapter;
import com.pcs.constants.Constants;
import com.pcs.contactdetails.Contact;

public class ContactsDisplayActivity extends Activity{
	
	ListView contactList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		
		
		 Contact contact = getIntent().getParcelableExtra(Constants.ContactExtras.CONTACT);
		 contactList=(ListView)findViewById(R.id.contacts_list);
		 
		 if(contact!=null){
			 contactList.setTag(contact);
		 }
		
		 ArrayAdapter<Contact> Contacts_List = new ArrayAdapter<Contact>();
		 CustomAdapter adapter = new CustomAdapter(ContactsDisplayActivity.this,contact_List);

		 contactList .setAdapter(adapter);
	
	
	}
}
