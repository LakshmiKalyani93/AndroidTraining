package com.pcs.reponseapplication;


import com.pcs.constants.Helper;
import com.pcs.responseapplication.R;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.widget.TextView;
import android.widget.Toast;

public class ResponseActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.response);
		
		TextView textview=(TextView)findViewById(R.id.txt_view);
		
			Uri uri=getIntent().getData();
			if(uri != null)
			{
				String choice=getIntent().getAction();

				if(choice==Helper.DataExtras.SHOW_SPORTS){
					textview.setBackgroundResource(R.drawable.sports);
				}
				else  if(choice==Helper.DataExtras.SHOW_MOVIES){
					textview.setBackgroundResource(R.drawable.movies);
				}
				else  if(choice==Helper.DataExtras.SHOW_STUDY){
					textview.setBackgroundResource(R.drawable.study);
				}
				else  if(choice==Helper.DataExtras.SHOW_TEXT){
					textview.setText(R.string.text);
				}
			}else {
				Toast.makeText(ResponseActivity.this,getResources().getString(R.string.no_output), Toast.LENGTH_LONG).show();
			}
		}

	
}
