package com.pcs.logindemo;


import java.util.regex.Pattern;

import com.pcs.constants.Constants;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class LoginActivity extends Activity implements OnClickListener{
	private EditText userEdt;
	private EditText pwdEdt,emailEdt,phnEdt;
	private Button login_Btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		userEdt =(EditText)findViewById(R.id.user_edt);
		pwdEdt=(EditText)findViewById(R.id.pwd_edt);
		emailEdt=(EditText)findViewById(R.id.email_edt);
		phnEdt=(EditText)findViewById(R.id.phn_edt);
		login_Btn=(Button)findViewById(R.id.login_btn);

		login_Btn.setOnClickListener(this);	

	}
	@Override
	public void onClick(View v) {
		login();
	}
	private void login() {

		String username=userEdt.getText().toString();
		String password=pwdEdt.getText().toString();
		String email=emailEdt.getText().toString();
		String phn=phnEdt.getText().toString();
		String phonePattern="[0-9]{10}";
		boolean isEmail= android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
		Pattern isPhonePattern= Pattern.compile(phonePattern);
		boolean isPhone=isPhonePattern.matcher(phn).matches();
		Log.d("LoginActivity","isEmail " + isEmail);
		Log.d("LoginActivity","isPhone " + isPhone);		
		
		if(username.equals(Constants.KeyExtras.USERNAME) && password.equals(Constants.KeyExtras.PASSWORD)&&isEmail&&isPhone) {
			Toast.makeText(this, getResources().getString(R.string.sucess), Toast.LENGTH_LONG).show();
		}
		else if(username.equals("") || password.equals("")||email.equals("")||phn.equals("")){
			Toast.makeText(this,getResources().getString(R.string.failure) , Toast.LENGTH_LONG).show();
		}
		else if(username.equals(Constants.KeyExtras.USER_INVALID) && password.equals(Constants.KeyExtras.PASSWORD)&&isEmail&&isPhone){
			Toast.makeText(this, getResources().getString(R.string.invalid_user), Toast.LENGTH_LONG).show();
		}
		else if(username.equals(Constants.KeyExtras.USERNAME) && password.equals(Constants.KeyExtras.PWD_INVALID)&&isEmail&&isPhone){
			Toast.makeText(this,getResources().getString(R.string.invalid_pwd), Toast.LENGTH_LONG).show();
		}
		else if(username.equals(Constants.KeyExtras.USERNAME) && password.equals(Constants.KeyExtras.PASSWORD)&&!isEmail&&isPhone){
			Toast.makeText(this,getResources().getString(R.string.invalid_email), Toast.LENGTH_LONG).show();
		}
		else if(username.equals(Constants.KeyExtras.USERNAME) && password.equals(Constants.KeyExtras.PASSWORD)&&isEmail&&!isPhone){
			Toast.makeText(this,getResources().getString(R.string.invalid_phn), Toast.LENGTH_LONG).show();
		}
		
	}

}
