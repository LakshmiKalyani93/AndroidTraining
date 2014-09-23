package com.pcs.simpleprogressbaractivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SampleActivity extends Activity{

	private Button eventSetBtn;
	private Button menuStyleBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sample);

		eventSetBtn = (Button)findViewById(R.id.event_btn);
		menuStyleBtn = (Button)findViewById(R.id.menu_btn);

		eventSetBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent event_intent= new Intent(SampleActivity.this,EventActivity.class);
				startActivity(event_intent);

			}
		});

		menuStyleBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent menu_intent= new Intent(SampleActivity.this,MenuStyleActivity.class);
				startActivity(menu_intent);

			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.optionmenu, menu);//Menu Resource, Menu  
        return true;  
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
		case R.id.profile: Toast.makeText(this,getResources().getString(R.string.display_msg)+" "+getResources().getString(R.string.profile), Toast.LENGTH_LONG).show();
		
			break;
		case R.id.bluetooth:Toast.makeText(this,getResources().getString(R.string.display_msg)+" "+getResources().getString(R.string.bluetooth), Toast.LENGTH_LONG).show();
		
			break;
		case R.id.wifi:Toast.makeText(this,getResources().getString(R.string.display_msg)+" "+getResources().getString(R.string.wifi), Toast.LENGTH_LONG).show();
		
			break;
		case R.id.data_pack:Toast.makeText(this,getResources().getString(R.string.display_msg)+" "+getResources().getString(R.string.data_pack), Toast.LENGTH_LONG).show();
	
			break;
		case R.id.gps:Toast.makeText(this,getResources().getString(R.string.display_msg)+" "+getResources().getString(R.string.gps), Toast.LENGTH_LONG).show();
	
			break;
		case R.id.baterry:Toast.makeText(this,getResources().getString(R.string.display_msg)+" "+getResources().getString(R.string.baterry), Toast.LENGTH_LONG).show();
		
			break;
			default:
			break;
			
		}
		
		
		return super.onOptionsItemSelected(item);
	}

}
