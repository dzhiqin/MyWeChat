package com.example.mywechat.activity;

import com.example.mywechat.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class WhatsnewDoor extends BaseActivity{
	/**
	 * 左边动图
	 */
	private ImageView mLeft;
	/**
	 * 右边动图
	 */
	private ImageView mRight;
	/**
	 * 放大透明的文字
	 */
	private TextView mText;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.whats_door);
		mLeft=(ImageView)findViewById(R.id.imageLeft);
		mRight=(ImageView)findViewById(R.id.imageRight);
		mText=(TextView)findViewById(R.id.anim_text);
		
		//左移 800ms开始，持续1500
		AnimationSet animL=new AnimationSet(true);		
		TranslateAnimation mTranslateAnimationL=new TranslateAnimation(
				Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,-1.0f,
				Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f);
		mTranslateAnimationL.setDuration(1500);
		animL.setStartOffset(800);
		animL.addAnimation(mTranslateAnimationL);
		animL.setFillAfter(true);
		mLeft.startAnimation(animL);
		
		//右移 800ms开始，持续1500
		AnimationSet animR=new AnimationSet(true);		
		TranslateAnimation mTranslateAnimationR=new TranslateAnimation(
				Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,+1.0f,
				Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f);
		mTranslateAnimationR.setDuration(1500);
		animR.setStartOffset(800);
		animR.addAnimation(mTranslateAnimationR);
		animR.setFillAfter(true);
		mRight.startAnimation(animR);
		
		//放大 持续1000， 透明持续1500
		AnimationSet animS=new AnimationSet(true);
		ScaleAnimation mScaleAnimation=new ScaleAnimation(
				1f,3f,1f,3f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
		mScaleAnimation.setDuration(1000);
		AlphaAnimation mAlphaAnimation=new AlphaAnimation(1,0.00001f);
		mAlphaAnimation.setDuration(1500);
		animS.addAnimation(mAlphaAnimation);
		animS.addAnimation(mScaleAnimation);
		animS.setFillAfter(true);
		mText.startAnimation(animS);
		
		new Handler().postDelayed(new Runnable(){

			@Override
			public void run() {
				Intent intent=new Intent();
				intent.setClass(WhatsnewDoor.this,MainWeChat.class);
				startActivity(intent);
				WhatsnewDoor.this.finish();
			}
			
		},2300);
	}

}
