package com.pcs.simpleprogressbaractivity;

import com.pcs.constants.Constants;
import com.pcs.contactdetails.Contact;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MenuStyleActivity extends Activity{

	private Button addContactsBtn;
	private EditText nameEdt;
	private EditText phnEdt;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		addContactsBtn = (Button)findViewById(R.id.add_btn);

		nameEdt = (EditText)findViewById(R.id.name_edt);
		phnEdt = (EditText)findViewById(R.id.phn_edt);

		registerForContextMenu(addContactsBtn);

	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);

		getMenuInflater().inflate(R.menu.menustyle, menu);

	}
	
	

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		String call = phnEdt.getText().toString();	

		switch(item.getItemId())
		{

		case R.id.item_call: 
			Intent intent = new Intent(Intent.ACTION_CALL);
			
			intent.setData(Uri.parse("tel:"+call ));
			startActivity(intent);

			break;
		case R.id.item_sms:
			Intent sms_intent=new Intent();
			sms_intent.setAction(android.content.Intent.ACTION_VIEW);
			sms_intent.setData(Uri.parse("smsto:"+call));
			startActivity(sms_intent);
			break;
		case R.id.item_update:
			break;
		case R.id.item_existing:
			Toast.makeText(this, getResources().getString(R.string.existing_msg)+"\n"+nameEdt.getText().toString()+"\n"+call, Toast.LENGTH_LONG).show();
			finish();
			break;
		case R.id.item_new:

			Contact contact = new Contact(nameEdt.getText().toString(),phnEdt.getText().toString());
			Intent intent_new_contact = new Intent(getBaseContext(),ContactsDisplayActivity.class);
			intent_new_contact.putExtra(Constants.ContactExtras.CONTACT, contact);
			startActivity(intent_new_contact);
			break;
		default:
			break;


		}

		return super.onContextItemSelected(item);
	}

}
