package com.pcs.implicitapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ImplicitActivity extends Activity implements OnClickListener{

	private  Button sportsBtn;
	private  Button moviesBtn;
	private  Button studyBtn;
	private  Button textBtn;
	

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.implicit);

		sportsBtn=(Button)findViewById(R.id.sports);
		moviesBtn=(Button)findViewById(R.id.movies);
		studyBtn=(Button)findViewById(R.id.study);
		textBtn=(Button)findViewById(R.id.text);
		

		sportsBtn.setOnClickListener(this);
		studyBtn.setOnClickListener(this);
		moviesBtn.setOnClickListener(this);
		textBtn.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {

		Intent intent = new Intent();
		switch(v.getId())
		{
		case R.id.sports :
			intent = new Intent("com.pcs.responseapplication.ResponseActivity.SHOW_SPORTS_IMAGE");
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			startActivity(intent);
			break;
		case R.id.movies :
			intent = new Intent("com.pcs.responseapplication.ResponseActivity.SHOW_MOVIES_IMAGE");
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			startActivity(intent);
			break;

		case R.id.study :
			intent = new Intent("com.pcs.responseapplication.ResponseActivity.SHOW_STUDY_IMAGE");
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			startActivity(intent);
			break;

		

		case R.id.text :
			intent = new Intent("com.pcs.responseapplication.ResponseActivity.SHOW_TEXT");
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			startActivity(intent);
			break;

		default :
			break;

		}

	}

}
