package com.pcs.databasedemoapplication;

import com.pcs.model.PersonDetails;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatabaseActivity extends Activity implements OnClickListener{

	private EditText userEdt;
	private EditText emailEdt;
	private EditText pwdEdt;

	private Button loginBtn;
	private Button newUserBtn;
	
	
	private DBHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.database);
		
		userEdt = (EditText)findViewById(R.id.user_edt);
		emailEdt = (EditText)findViewById(R.id.email_edt);
		pwdEdt = (EditText)findViewById(R.id.pwd_edt);
		
		
		loginBtn =(Button)findViewById(R.id.login_btn);
		newUserBtn =(Button)findViewById(R.id.newUser_btn);

		loginBtn.setOnClickListener(this);
		newUserBtn.setOnClickListener(this);


	}

	@Override
	public void onClick(View v) {

		switch(v.getId())
		{
		case R.id.login_btn :
		
			String UserName_val = userEdt.getText().toString();
			String Email_val = emailEdt.getText().toString();
			String Password_val = pwdEdt.getText().toString();
			
			if(TextUtils.isEmpty(UserName_val)||TextUtils.isEmpty(Password_val)||TextUtils.isEmpty(Email_val))
			{
				Toast.makeText(getBaseContext(), this.getResources().getString(R.string.null_msg), Toast.LENGTH_LONG).show();
			}
		 DBHelper dbhelper = new DBHelper(DatabaseActivity.this);
		 PersonDetails person = new PersonDetails();
		 dbhelper.addPerson(person);
	
			break;


		case R.id.newUser_btn: 

			break;
			
		default:
			break;
		}

	}

	



}
