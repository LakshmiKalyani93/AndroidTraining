package com.pcs.samplenotificationactivity;

import com.pcs.constants.Helper;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class LocalBroadcastActivity extends Activity
{

	BroadcastReceiver broadcastReceiver ;
	private Button localBroadcast_Btn;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.local);

		//fetching Button localBroadcast_Btn of the layout local
		localBroadcast_Btn = (Button)findViewById(R.id.local_broadcast_btn);

		//setting a OnClickListener to the localBroadcast_Btn
		localBroadcast_Btn.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				//creating my own method...
				sendMessage();

			}

		});
		//setting a BroadcastReceiver object inorder to broadcast the response
		broadcastReceiver = new BroadcastReceiver() 
		{
			@Override
			public void onReceive(Context context, Intent intent) 
			{
				//checking the intent if any null value is present
				if(intent!=null)
				{	
					String receive_message = intent.getStringExtra(Helper.BroadcastExtras.LOCAL_BROADCAST);
					Toast.makeText(
							context,
							receive_message,
							Toast.LENGTH_LONG).show();

				}
				else
				{
					Toast.makeText(
							context,
							getResources().getString(R.string.no_local_intent),
							Toast.LENGTH_LONG).show();
				}
			}
		};

		//registering the broadcast receiver
		LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,
				new IntentFilter("send_local_broadcast"));
	}


	private void sendMessage()
	{
		//creating an intent to set up an action 
		Intent intent = new Intent("send_local_broadcast");

		// You can also include some extra data.
		intent.putExtra(Helper.BroadcastExtras.LOCAL_BROADCAST, getResources()
				.getString(R.string.local_broadcast_msg));
		//braodcasting the message through intent
		LocalBroadcastManager.getInstance(getBaseContext()).sendBroadcast(intent);

	}

	@Override
	protected void onPause()
	{
		super.onPause();
		//unregistering the broadcst receiver
		LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
	}
}
