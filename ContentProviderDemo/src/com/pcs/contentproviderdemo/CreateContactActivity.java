package com.pcs.contentproviderdemo;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pcs.contentproviderdemo.DBHelper.ContactContrast;

public class CreateContactActivity extends Activity implements OnClickListener{

	private EditText nameEdt;
	private EditText emailEdt;
	private EditText phoneTyepEdt;
	private EditText PhoneEdt;

	private Button showContacts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create);

		nameEdt=(EditText)findViewById(R.id.name_edt);
		emailEdt=(EditText)findViewById(R.id.email_edt);
		phoneTyepEdt=(EditText)findViewById(R.id.type_edt);
		PhoneEdt=(EditText)findViewById(R.id.number_edt);

		showContacts=(Button)findViewById(R.id.showContact_btn);
		showContacts.setOnClickListener(this);
	}

	public void onClickAddContact(View view){

		String name= nameEdt.getText().toString();
		String email=emailEdt.getText().toString();
		String phoneType=phoneTyepEdt.getText().toString();
		String phone=PhoneEdt.getText().toString();

		if(TextUtils.isEmpty(name)||TextUtils.isEmpty(email)||TextUtils.isEmpty(phoneType)||TextUtils.isEmpty(phone))
		{
			Toast.makeText(getBaseContext(), getResources().getString(R.string.null_msg), Toast.LENGTH_LONG)
			.show();

		}else
		{
			ContentValues values = new ContentValues();
			values.put(ContactContrast.CONTACT_NAME, name);
			values.put(ContactContrast.EMAIL, email);
			values.put(ContactContrast.PHONE_TYPE, phoneType);
			values.put(ContactContrast.PHONE_NUMBER, phone);
			@SuppressWarnings("unused")
			Uri uri = getContentResolver().insert(ContactsProvider.CONTENT_URI, values);
			nameEdt.setText(null);
			emailEdt.setText(null);
			phoneTyepEdt.setText(null);
			PhoneEdt.setText(null);
			Toast.makeText(getBaseContext(), getResources().getString(R.string.add_msg), Toast.LENGTH_LONG)
			.show();

		}
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent("com.pcs.retrievecontactsdemo.RetrieveContactsActivity.RETRIEVE");
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(intent);


	}

}
