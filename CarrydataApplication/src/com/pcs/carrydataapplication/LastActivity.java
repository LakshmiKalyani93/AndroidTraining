package com.pcs.carrydataapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LastActivity extends Activity{
	
	private TextView final_name;
	private TextView final_stream;
	public static final int REQUE_B=104;
	private Button home_btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.last);
		
		final_name = (TextView)findViewById(R.id.final_msg);
		final_stream = (TextView)findViewById(R.id.final_message);
		home_btn=(Button)findViewById(R.id.home);
		
		String final_string=getIntent().getStringExtra(Constants.Login.STREAM);
		final_stream.setText(getResources().getString(R.string.sttxt)+" "+final_string);
		
		home_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				
			}
		});
	
		
	}
	
	
	

}
