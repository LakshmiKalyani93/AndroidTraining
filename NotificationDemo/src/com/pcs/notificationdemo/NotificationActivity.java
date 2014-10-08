package com.pcs.notificationdemo;


import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;


public class NotificationActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this);
		mBuilder.setSmallIcon(R.drawable.ic_launcher)
		.setContentTitle(
				getResources()
				.getString(R.string.title))
				.setContentText(
						getResources().getString(R.string.msg));

		Intent notify_intent = new Intent();

		notify_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
				| Intent.FLAG_ACTIVITY_CLEAR_TASK);

		NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

		String[] events = new String[6];
		
		inboxStyle.setBigContentTitle("Messageses:");
		int len = events.length;
		for (int i = 0; i < len; i++) 
		{
			inboxStyle.addLine(getResources().getString(R.string.msg));
		}
		mBuilder.setStyle(inboxStyle);


		PendingIntent pending_intent = PendingIntent.getBroadcast(
				this, 0, notify_intent,
				PendingIntent.FLAG_UPDATE_CURRENT);

		mBuilder.setAutoCancel(true);
		mBuilder.setContentIntent(pending_intent);

		NotificationManager mNotificationManager = (NotificationManager) this
				.getSystemService(Context.NOTIFICATION_SERVICE);

		mNotificationManager.notify(0, mBuilder.build());

	}
 
 
}
