package com.pcs.logindemo;


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

		if(!(username.equals("") || password.equals(""))) {
			Toast.makeText(this, "Logged in successfully", Toast.LENGTH_LONG).show();
		}
		else {
			Toast.makeText(this, "Failed to login", Toast.LENGTH_LONG).show();

		}		
	}



}
