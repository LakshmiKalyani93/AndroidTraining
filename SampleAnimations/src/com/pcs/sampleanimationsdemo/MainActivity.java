package com.pcs.sampleanimationsdemo;


import com.pcs.sampleanimationdemo.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/*Creating an application that implements few animations 
 *like flip ,fade,rotate,bounce and zoom controls
 *that shows basic behaviour how an animation works 
 *@Author : kalyani */

public class MainActivity extends Activity implements OnClickListener{
	//Defining views..
	private Button fadeBtn;
	private Button zoomBtn;
	private Button navigateBtn;
	private Button rotateBtn;
	private TextView textView;
	private ImageView imgView;
	//this method is called upon start of an activity
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//fetching the views of the layout activity_main and setting the respective listeners to them 
		textView = (TextView) findViewById(R.id.text);
		imgView = (ImageView) findViewById(R.id.image);

		fadeBtn = (Button) findViewById(R.id.fade);
		fadeBtn.setOnClickListener(this);

		zoomBtn = (Button) findViewById(R.id.zoom);
		zoomBtn.setOnClickListener(this);

		navigateBtn = (Button) findViewById(R.id.move);
		navigateBtn.setOnClickListener(this);

		rotateBtn = (Button) findViewById(R.id.rotate);
		rotateBtn.setOnClickListener(this);
	}
	//on click actions are implemented here for different views..
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.fade:fadeAnimation(v);
		break;
		case R.id.zoom:zoomAnimation(v);
		break;
		case R.id.move:moveAnimation(v);
		break;
		case R.id.rotate:rotateAnimation(v);
		break;
		default:
			break;
		}
	}
	//starting a fade in and out animation...
	private void fadeAnimation(View view) {
		Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
		fadeBtn.startAnimation(animation);
	}
	//starting a zoom in and out animation...
	private void zoomAnimation(View view) {
		Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
		textView.startAnimation(animation);
	}
	//starting a rotate animation....
	private void rotateAnimation(View view) {
		Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
		imgView.startAnimation(animation);
	}
	//starting a move animation...
	private void moveAnimation(View view) {
		try{

			//sending an intent to the MoveActivity.class...
			Intent intent = new Intent(this, MoveActivity.class);
			startActivity(intent);
		}catch(Exception e) {
			//Handling the intent if any exception arises..
			Toast.makeText(getApplicationContext(), getResources().getString(R.string.error_navigate_msg), 
					Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
	}




}
