package com.pcs.carrydataapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class YourActivity  extends Activity implements OnClickListener{
	private Button yes_btn;
	private Button no_btn;
	private EditText stream_yr;
	public static final int REQUE_B=103;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.your);



		yes_btn=(Button)findViewById(R.id.y_bt1);
		no_btn=(Button)findViewById(R.id.y_bt2);
		stream_yr=(EditText)findViewById(R.id.st_edt);

		yes_btn.setOnClickListener(this);
		no_btn.setOnClickListener(this);



		String stream_yr_string = getIntent().getStringExtra(Constants.Login.STREAM);
		stream_yr.setText(stream_yr_string);


		
	}
			@Override
			public void onClick(View v) {


				switch (v.getId()) {
				case R.id.y_bt1: 
				Intent intent = new Intent(YourActivity.this, LastActivity.class);
				intent.putExtra(Constants.Login.STREAM,stream_yr.getText().toString());
				startActivity(intent);

				break;

				case R.id.y_bt2: 
					Intent intent2=new Intent();
					intent2.putExtra(Constants.Login.STREAM, stream_yr.getText().toString());
				    setResult(Activity.RESULT_OK, intent2);
					finish();
					break;

				default:
					break;
				}


			}
		
	}






