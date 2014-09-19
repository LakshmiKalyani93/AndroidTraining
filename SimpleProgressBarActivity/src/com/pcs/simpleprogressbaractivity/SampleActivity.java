package com.pcs.simpleprogressbaractivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SampleActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sample);
		
		Button eventSetBtn = (Button)findViewById(R.id.event_btn);
		
		eventSetBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent= new Intent(SampleActivity.this,EventActivity.class);
				startActivity(intent);
								
			}
		});

	}

}
