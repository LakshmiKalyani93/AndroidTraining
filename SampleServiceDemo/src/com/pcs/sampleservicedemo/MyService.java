package com.pcs.sampleservicedemo;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

	public final IBinder mbinder = new MyBinder();

	@Override
	public void onCreate() {
		super.onCreate();

		Toast.makeText(MyService.this,getResources().getString(R.string.create_msg), Toast.LENGTH_LONG).show();
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		Toast.makeText(MyService.this,getResources().getString(R.string.start_msg), Toast.LENGTH_LONG).show();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(MyService.this,getResources().getString(R.string.stop_msg), Toast.LENGTH_LONG).show();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return mbinder;
	}

	public String getCurrentTime(){
		SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy", Locale.KOREAN);
		Date date = new Date();
		return (dateformat.format(date));
	}

	public class MyBinder extends Binder{
		MyService getService(){
			return MyService.this;
		}

	}


}
