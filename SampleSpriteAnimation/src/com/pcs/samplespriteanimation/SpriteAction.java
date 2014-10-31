package com.pcs.samplespriteanimation;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class SpriteAction extends View{


	private Context mContext;
	private boolean begin;
	private int frameWidth;
	private int frameHeight;
	public MoveThread moveThread;
	private Bitmap bmp;

	private List<SpriteAction> sprites = new ArrayList<SpriteAction>();
	//creating a constructor...

	public SpriteAction(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext=context;
		createSprites();
		
	}

	public SpriteAction(Context context, Bitmap bmp) {
		super(context);
		this.bmp=bmp;
		mContext=context;
		init();
	}

	private void init() {
		frameWidth=(bmp.getWidth())/5;
		frameHeight=(bmp.getHeight())/3;
		dest.left=dest.top=0;
		dest.right=frameWidth;
		dest.bottom=frameHeight;
	}

	Rect src=new Rect();
	Rect dest=new Rect();
	//init method...

	//starting the animation....
	public void startAnimation() {
		
		begin=true;
		dest.left=0;
		dest.top=0;
		//creating and intializing the thread instance...
		moveThread=new MoveThread();
		moveThread.start();
	}
	//stopping an animation...
	public void stopAnimation() {
		begin=false;
		try {
			moveThread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//onDraw method to draw the canvas ...
	@SuppressLint("WrongCall")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		for (SpriteAction sprite : sprites) {
			sprite.onDraw(canvas);

		}
	}

	private void createSprites() {

		sprites.add(createSprite(R.drawable.spritebird));
		sprites.add(createSprite(R.drawable.sprite_bird));
	}
	
	
	private SpriteAction createSprite(int resouce) {
		Bitmap bmp = BitmapFactory.decodeResource(getResources(), resouce);
		return new SpriteAction(getContext(), bmp);
	}
	//Handling the thread with our own customisation of the sprint image translation...
	public class MoveThread extends Thread{

		public int screenWidth,screenHeight;
		//speed of the animation
		int speed=5;
		@Override
		public void run() {
			screenWidth = getWidth();
			screenHeight = getHeight();
			while(begin) {
				for(int rows=0;rows<3;rows++) {
					for(int columns=0;columns<5;columns++) {
						//animation will start at the first Frame in the SpriteSheet
						src.left = columns*frameWidth;
						src.top = rows*frameHeight;
						src.right = src.left+frameWidth;
						src.bottom = src.top+frameHeight;
						dest.left++;
						dest.top++;
						dest.right = dest.left+frameWidth;
						dest.bottom = dest.top+frameHeight;
						postInvalidate();
						//Handling the exception....
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}



