package com.pcs.samplelogindemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class SampleLoginActivity extends Activity implements OnClickListener{
	private Button loginBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		loginBtn =(Button)findViewById(R.id.login);
		loginBtn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		
		Intent intent = new Intent(SampleLoginActivity.this, FetchActivity.class);
		startActivity(intent);
		
	}

}
