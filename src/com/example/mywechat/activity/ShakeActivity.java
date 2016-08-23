package com.example.mywechat.activity;

import android.os.Bundle;
import android.os.Vibrator;
import android.widget.RelativeLayout;

import com.example.mywechat.R;
import com.example.mywechat.listener.ShakeListener;
import com.example.mywechat.listener.ShakeListener.OnShakeListener;

public class ShakeActivity extends BaseActivity{

	ShakeListener mShakeListener=null;
	/**
	 * 震动器，手机震动使用
	 */
	Vibrator mVibrator;
	private RelativeLayout mImgUp;
	private RelativeLayout mImgDown;
	private RelativeLayout mTitle;
	@Override 
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shake_activity);
		mVibrator=(Vibrator)getApplication().getSystemService(VIBRATOR_SERVICE);
		mImgUp=(RelativeLayout)findViewById(R.id.shakeImgUp);
		mImgDown=(RelativeLayout)findViewById(R.id.shakeImgDown);
		mTitle=(RelativeLayout)findViewById(R.id.shake_title_bar);
	
		//设置晃动监听
		mShakeListener=new ShakeListener(this);
		mShakeListener.setOnShakeListener(new OnShakeListener(){
	
			@Override
			public void onShake() {
				// TODO 自动生成的方法存根
				
			}
			
		});
	}
}
