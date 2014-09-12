package com.pcs.responseapplication;


import com.pcs.constants.Helper;
import com.pcs.responseapplication.R;

import android.app.Activity;
import android.os.Bundle;

import android.widget.TextView;

public class ResponseActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.response);

		TextView textview=(TextView)findViewById(R.id.txt_view);



		String choice=getIntent().getAction();



		if(choice.equals(Helper.DataExtras.SHOW_SPORTS)){
			textview.setBackgroundResource(R.drawable.sports);
		}
		else  if(choice.equals(Helper.DataExtras.SHOW_MOVIES)){
			textview.setBackgroundResource(R.drawable.movies);
		}
		else  if(choice.equals(Helper.DataExtras.SHOW_STUDY)){
			textview.setBackgroundResource(R.drawable.study);
		}
		else  if(choice.equals(Helper.DataExtras.SHOW_TEXT)){
			textview.setText(getResources().getString(R.string.text));
		}
	}	



}
