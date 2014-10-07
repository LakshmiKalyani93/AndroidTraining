package com.pcs.samplebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Broadcast extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		
		if(intent!=null)
		{
			Toast.makeText(context, context.getResources().getString(R.string.broadcast_msg), Toast.LENGTH_LONG).show();
		}
		
	}

}
