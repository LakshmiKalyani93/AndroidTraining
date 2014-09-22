package com.pcs.simpleprogressbaractivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SampleActivity extends Activity{

	private Button eventSetBtn;
	private Button menuStyleBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sample);

		eventSetBtn = (Button)findViewById(R.id.event_btn);
		menuStyleBtn = (Button)findViewById(R.id.menu_btn);

		eventSetBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent event_intent= new Intent(SampleActivity.this,EventActivity.class);
				startActivity(event_intent);

			}
		});

		menuStyleBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent menu_intent= new Intent(SampleActivity.this,MenuStyleActivity.class);
				startActivity(menu_intent);

			}
		});

	}

}
