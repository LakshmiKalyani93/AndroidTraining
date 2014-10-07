package com.pcs.samplebroadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SampleBroadcastActivity extends Activity implements OnClickListener{
	private Button sendBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.broad);
		
		sendBtn = (Button)findViewById(R.id.send_btn);
		sendBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		intent.setAction("com.pcs.SEND_BROADCAST");
		sendBroadcast(intent);
		
	}

}
