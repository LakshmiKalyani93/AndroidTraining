package com.pcs.sampleanimationsdemo;


import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.pcs.sampleanimationdemo.R;

@SuppressLint("NewApi")
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MoveActivity extends Activity implements AnimationListener ,OnClickListener {
	//Defining different views
	private Button startBtn;
	private Button bounceBtn;
	private Button flipBtn;
	private ImageView imgView;
	//creating instances for the animation...
	private Animation move_animation,bounce_animation;

	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.move_view);

		// load the animation
		move_animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
		bounce_animation=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);

		// set animation listener
		move_animation.setAnimationListener(this);
		bounce_animation.setAnimationListener(this);
		//fetching the views of the layout move_view and setting the on click listeners to them..
		imgView=(ImageView)findViewById(R.id.imgview);
		startBtn = (Button) findViewById(R.id.start);
		startBtn.setOnClickListener(this);

		bounceBtn=(Button)findViewById(R.id.bounce);
		bounceBtn.setOnClickListener(this);

		flipBtn=(Button)findViewById(R.id.flip);
		flipBtn.setOnClickListener(this);

	}
	//on click actions are performed here....
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.start:
			imgView.startAnimation(move_animation);
			break;
		case R.id.flip:
			//creating an instance animation for the object animator
			ObjectAnimator animation = ObjectAnimator.ofFloat(v, "rotationY", 0.0f, 360f);
			//setting the duration specifying how long the animation exists
			animation.setDuration(3600);
			animation.setRepeatCount(ObjectAnimator.RESTART);
			animation.setInterpolator(new AccelerateDecelerateInterpolator());
			animation.setTarget(imgView);
			//starting the animation...
			animation.start();
			break;
		case R.id.bounce:
			imgView.startAnimation(bounce_animation);
			break;
		}
	}
	
	/*specifies the action what if the animation starts
	 * we can write our own custom action depending on the animation state
	 * */
	
	@Override
	public void onAnimationEnd(Animation anim) {
		// when animation ends
		if ((anim == move_animation)||(anim == bounce_animation)) {
			Toast.makeText(getApplicationContext(), getResources().getString(R.string.anim_stop),
					Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onAnimationRepeat(Animation anim) {
		// if the animation repeats
		if ((anim == move_animation)||(anim == bounce_animation)) {
			Toast.makeText(getApplicationContext(), getResources().getString(R.string.anim_repeat),
					Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onAnimationStart(Animation anim) {
		// when the animation is started
		if ((anim == move_animation)||(anim == bounce_animation)) {
			Toast.makeText(getApplicationContext(),getResources().getString(R.string.anim_start),
					Toast.LENGTH_SHORT).show();
		}
	}
}
