package com.pcs.databasedemoapplication;

import com.pcs.model.PersonDetails;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
	private Button allUserBtn;




	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.database);

		userEdt = (EditText)findViewById(R.id.user_edt);
		emailEdt = (EditText)findViewById(R.id.email_edt);
		pwdEdt = (EditText)findViewById(R.id.pwd_edt);


		loginBtn =(Button)findViewById(R.id.login_btn);
		newUserBtn =(Button)findViewById(R.id.newUser_btn);
		allUserBtn =(Button)findViewById(R.id.allusers_btn);
		loginBtn.setOnClickListener(this);
		newUserBtn.setOnClickListener(this);
		allUserBtn.setOnClickListener(this);


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
			else{
			DBHelper dbhelper = new DBHelper(DatabaseActivity.this);
			PersonDetails person = new PersonDetails(DatabaseActivity.this);
			person.setUserName(UserName_val);
			person.setEmail(Email_val);
			person.setPassword(Password_val);
			long result= dbhelper.addPerson(person);

			if(result!=-1)
			{
				Toast.makeText(DatabaseActivity.this, getResources().getString(R.string.row_insert_msg), Toast.LENGTH_LONG).show();
			}
			userEdt.setText(" ");
			emailEdt.setText(" ");
			pwdEdt.setText(" ");
			}

			break;


		case R.id.newUser_btn: 
			Toast.makeText(DatabaseActivity.this, getResources().getString(R.string.register), Toast.LENGTH_LONG).show();
			break;

		case R.id.allusers_btn:
			Intent intent = new Intent(DatabaseActivity.this,DataDisplayActivity.class);
			startActivity(intent);

			break;

		default:
			break;

		}

	}
}
