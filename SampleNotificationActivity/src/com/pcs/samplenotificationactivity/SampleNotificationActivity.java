package com.pcs.samplenotificationactivity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SampleNotificationActivity extends Activity{

	
	private Button broadcsastBtn;
	private Button notificationBtn;
	private Button localBroadcastBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification);

		broadcsastBtn = (Button)findViewById(R.id.broadcast_btn);
		notificationBtn = (Button)findViewById(R.id.notify_btn);
		localBroadcastBtn = (Button)findViewById(R.id.local_btn);

		broadcsastBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setAction("com.pcs.SEND_BROADCAST_MSG");
				sendBroadcast(intent);


			}
		});

		localBroadcastBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(SampleNotificationActivity.this,LocalBroadcastActivity.class);
				startActivity(intent);


			}
		});

		notificationBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Intent notify_intent = new Intent();
				notify_intent.setAction("com.pcs.SEND_NOTIFICATION");
				sendBroadcast(notify_intent);

			
			}
		});

	}

	
	}
