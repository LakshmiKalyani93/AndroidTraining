package com.pcs.sampleservicedemo;


import com.pcs.sampleservicedemo.MyService.MyBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ServiceDemoActivity extends Activity implements OnClickListener {

	private MyService mService=null;
	@SuppressWarnings("unused")
	private boolean isBound=false;

	private EditText showTimeEdt;
	private Button startBtn;
	private Button stopBtn;
	private Button showTimeBtn;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service);

		startBtn=(Button)findViewById(R.id.start_btn);
		stopBtn=(Button)findViewById(R.id.stop_btn);
		showTimeBtn=(Button)findViewById(R.id.show_btn);
		showTimeEdt=(EditText)findViewById(R.id.display_edt);


		startBtn.setOnClickListener(this);
		stopBtn.setOnClickListener(this);
		showTimeBtn.setOnClickListener(this);

		Intent intent = new Intent(ServiceDemoActivity.this,MyService.class);
		bindService(intent, connect, Context.BIND_AUTO_CREATE);

	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){

		case R.id.start_btn:
			startService(new Intent(getBaseContext(), MyService.class));

			break;
		case R.id.stop_btn:
			stopService(new Intent(getBaseContext(), MyService.class));
			break;
		case  R.id.show_btn: showTime();
			
			break;

		default:
			break;
		}

	}

	private ServiceConnection connect = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder binder) {
			MyBinder mBinder = (MyBinder) binder;
			mService=mBinder.getService();
			isBound=true;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			mService=null;
			isBound=false;

		}
	};

	public void showTime(){
		String currentTime = mService.getCurrentTime();
		showTimeEdt.setText(getResources().getString(R.string.korean)+currentTime);

	}
}
