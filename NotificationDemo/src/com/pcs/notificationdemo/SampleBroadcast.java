package com.pcs.notificationdemo;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SampleBroadcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		Intent intent_new = new Intent(context, NotificationActivity.class);
		context.startActivity(intent_new);

	}
}


