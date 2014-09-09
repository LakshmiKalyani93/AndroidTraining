package com.pcs.userinfo;

import com.pcs.details.User;
import com.pcs.helper.Helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class UserDetailsActivity extends Activity{
	 private EditText userEdt;
	 private EditText pwdEdt;
	 private EditText emailEdt;
	 private EditText phnEdt;
	 private EditText addressEdt;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.info);
	
	Button getuserBtn = (Button)findViewById(R.id.user_btn);
	 userEdt =(EditText)findViewById(R.id.user_edt);
	 pwdEdt =(EditText)findViewById(R.id.pwd_edt);
	 emailEdt =(EditText)findViewById(R.id.email_edt);
	 phnEdt =(EditText)findViewById(R.id.phn_edt);
	 addressEdt =(EditText)findViewById(R.id.address_edt);
	
	getuserBtn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Intent intent = new Intent(UserDetailsActivity.this,DetailsDisplayActivity.class);
			User userobj = new User();
			
			userobj.setUsername(userEdt.getText().toString());
			userobj.setPassword(pwdEdt.getText().toString());
			userobj.setEmail(emailEdt.getText().toString());
			userobj.setPhonenumber(phnEdt.getText().toString());
			userobj.setAddress(addressEdt.getText().toString());
			
			
			intent.putExtra(Helper.DetailsExtras.USER_DETAILS, userobj);
			startActivity(intent);
			
		}
	});
	
	}
	

}
