package com.pcs.logindemo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener{
	private EditText userEdt;
	private EditText pwdEdt;
	private Button loginBtn;
	private Button cancelBtn;


	@Override
	protected void onCreate(Bundle savedInstanceState) {						
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		userEdt = (EditText)findViewById(R.id.user_edt);
		pwdEdt = (EditText)findViewById(R.id.pwd_edt);

		loginBtn=(Button)findViewById(R.id.login_btn);
		cancelBtn=(Button)findViewById(R.id.cancel_btn);
		
		loginBtn.setOnClickListener(this);
		cancelBtn.setOnClickListener(this);

	}


	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.login_btn:
			break;
		case R.id.cancel_btn:
			break;
		
		}
		
	}
}



