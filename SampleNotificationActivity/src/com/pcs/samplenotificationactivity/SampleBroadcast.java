package com.pcs.samplenotificationactivity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.support.v4.app.NotificationCompat;

import android.widget.Toast;

public class SampleBroadcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		if (intent != null) {

			if (intent.getAction().equals("com.pcs.SEND_BROADCAST_MSG"))

			{

				Toast.makeText(
						context,
						context.getResources()
								.getString(R.string.broadcast_msg),
						Toast.LENGTH_LONG).show();
			} else if (intent.getAction().equals("com.pcs.SEND_NOTIFICATION"))
			{

				NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
						context);
				mBuilder.setSmallIcon(R.drawable.notify)
						.setContentTitle(
								context.getResources()
										.getString(R.string.title))
						.setContentText(
								context.getResources().getString(R.string.msg));

				Intent notify_intent = new Intent();

				notify_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
						| Intent.FLAG_ACTIVITY_CLEAR_TASK);

				NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

				String[] events = new String[6];
				// Sets a title for the Inbox style big view
				inboxStyle.setBigContentTitle("Messageses:");
				int len = events.length;
				// Moves events into the big view
				for (int i = 0; i < len; i++) 
				{

					inboxStyle.addLine(context.getResources().getString(R.string.msg));
				}
				// Moves the big view style object into the notification object.
				mBuilder.setStyle(inboxStyle);

				PendingIntent pending_intent = PendingIntent.getBroadcast(
						context, 0, notify_intent,
						PendingIntent.FLAG_UPDATE_CURRENT);

				mBuilder.setAutoCancel(true);
				mBuilder.setContentIntent(pending_intent);

				NotificationManager mNotificationManager = (NotificationManager) context
						.getSystemService(Context.NOTIFICATION_SERVICE);

				mNotificationManager.notify(0, mBuilder.build());

				mNotificationManager.notify(0, mBuilder.build());
			}
			else
			{
				return;
			}
		}
		else 
		{
			Toast.makeText(context,
					context.getResources().getString(R.string.intent_null),
					Toast.LENGTH_LONG).show();
		}

	}

}
