package com.pcs.samplelogindemo;

import com.pcs.helper.Helper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends Activity {
	private TextView resultEdt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
setContentView(R.layout.welcome);

resultEdt=(TextView)findViewById(R.id.result_txt);
String result = getIntent().getStringExtra(Helper.DataExtras.USER_NAME);

resultEdt.setText(getResources().getString(R.string.username)+result);


	}

}
