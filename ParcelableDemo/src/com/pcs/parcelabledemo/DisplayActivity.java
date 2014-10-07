package com.pcs.parcelabledemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.pcs.employdetails.Employ;
import com.pcs.helper.Helper;

public class DisplayActivity extends Activity{
	
	private TextView employInfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		employInfo = (TextView)findViewById(R.id.employ_txt);
		 
		Employ employ = getIntent().getParcelableExtra(Helper.DetailsExtras.Employ_DETAILS);
		if(employ!=null)
			
		{
			employInfo.setText(employ.toString());
		}
		
	}
	

}
