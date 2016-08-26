package com.example.mywechat.activity;

import com.example.mywechat.R;

import android.os.Bundle;
import android.view.MotionEvent;

public class BigImage extends BaseActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.big_image);
	}
	@Override
	public boolean onTouchEvent(MotionEvent event){
		finish();
		return true;
	}
}
