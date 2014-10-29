package com.pcs.samplespriteanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	//Defining the views ...
	private Button startBtn;
	private Button stopBtn;
	//Defining the instance for the SpriteAction ...
	private SpriteAction spriteAction;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//fetching the views of the layout main...
		startBtn=(Button)findViewById(R.id.start);
		stopBtn=(Button)findViewById(R.id.stop);
		spriteAction=(SpriteAction)findViewById(R.id.spriteAction);
		//setting the listeners to the views... 
		startBtn.setOnClickListener(this);
		stopBtn.setOnClickListener(this);

	}
	//on click of any of the defined view and its respected operation call...
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.start:spriteAction.startAnimation();
		break;
		case R.id.stop:spriteAction.stopAnimation();
		break;
		default:
			break;
		}		
	}

}
