package com.pcs.logindemo;


import com.pcs.constants.Constants;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class LoginActivity extends Activity implements OnClickListener{
	private EditText userEdt;
	private EditText pwdEdt;
	private Button login_Btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		userEdt =(EditText)findViewById(R.id.user_edt);
		pwdEdt=(EditText)findViewById(R.id.pwd_edt);
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

		if(username.equals(Constants.KeyExtras.USERNAME) && password.equals(Constants.KeyExtras.PASSWORD)) {
			Toast.makeText(this, getResources().getString(R.string.sucess), Toast.LENGTH_LONG).show();
		}
		else if(username.equals(Constants.KeyExtras.USERNAME) && password.equals("")) {
			Toast.makeText(this, getResources().getString(R.string.pwd_null), Toast.LENGTH_LONG).show();

		}
		else if(username.equals("") && password.equals(Constants.KeyExtras.PASSWORD))
		{
			Toast.makeText(this, getResources().getString(R.string.user_null), Toast.LENGTH_LONG).show();
		}
		else if(username.equals(Constants.KeyExtras.USER_INVALID) && password.equals(Constants.KeyExtras.PASSWORD)){
			Toast.makeText(this, getResources().getString(R.string.invalid_user), Toast.LENGTH_LONG).show();
		}
		else if(username.equals(Constants.KeyExtras.USERNAME) && password.equals(Constants.KeyExtras.PWD_INVALID)){
			Toast.makeText(this,getResources().getString(R.string.invalid_pwd), Toast.LENGTH_LONG).show();
		}
		else
		{
			Toast.makeText(this, "Both fields null, Failed to login", Toast.LENGTH_LONG).show();
		}
	}



}
