package com.pcs.implicitapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
			intent = new Intent("com.pcs.responseapplication.SHOW_SPORTS_IMAGE");
			break;
		case R.id.movies :
			intent = new Intent("com.pcs.responseapplication.SHOW_MOVIES_IMAGE");
			break;

		case R.id.study :
			intent = new Intent("com.pcs.responseapplication.SHOW_STUDY_IMAGE");
			break;

		case R.id.text :
			intent = new Intent("com.pcs.responseapplication.SHOW_TEXT");
			intent.setData(Uri.parse("hello"));
			break;

		default :
			break;

		}
		startActivity(intent);
	}

}
