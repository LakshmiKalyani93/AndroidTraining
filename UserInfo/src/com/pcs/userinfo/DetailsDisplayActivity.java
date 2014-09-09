package com.pcs.userinfo;

import com.pcs.details.User;
import com.pcs.helper.Helper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsDisplayActivity extends Activity{
	
	private TextView displayEdt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		
		displayEdt = (TextView)findViewById(R.id.user_txt);
		 
		User user = getIntent().getParcelableExtra(Helper.DetailsExtras.USER_DETAILS);
		if(user!=null)
			
		{
			displayEdt.setText(user.toString());
		}
		
	}

}
