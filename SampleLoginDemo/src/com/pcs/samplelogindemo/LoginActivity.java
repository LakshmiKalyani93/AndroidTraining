package com.pcs.samplelogindemo;

import com.pcs.helper.Helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener{
	private EditText emaiEdt;
	private EditText pwdEdt;

	private Button loginBtn;
	private String email;
	private String password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		emaiEdt=(EditText)findViewById(R.id.email_edt);
		pwdEdt=(EditText)findViewById(R.id.pwd_edt);

		loginBtn=(Button)findViewById(R.id.login_btn);

		loginBtn.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		email =emaiEdt.getText().toString();
		password=pwdEdt.getText().toString();

		if(TextUtils.isEmpty(email)||TextUtils.isEmpty(password))
		{
			Toast.makeText(getBaseContext(), getResources().getString(R.string.null_msg), Toast.LENGTH_LONG).show();
		}

		else if(email.equals(Helper.DataExtras.EMAIL_VALID) && password.equals(Helper.DataExtras.PASSWORD_VALID))
		{
			Intent intent = new Intent(getBaseContext(), WelcomeActivity.class);
			intent.putExtra(Helper.DataExtras.USER_NAME, email );
			startActivity(intent);
		}
		else
		{
			Toast.makeText(getBaseContext(), getResources().getString(R.string.match_msg), Toast.LENGTH_LONG).show();
		}

	}
}
