package com.example.mywechat.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
				//开始摇一摇动画
				startAnim();
				mShakeListener.stop();
				startVibrato();//开始震动
				new Handler().postDelayed(new Runnable(){

					@Override
					public void run() {
						Toast.makeText(getApplicationContext(),"抱歉，暂时没有找到\n在同一时刻摇晃"
								+ "手机的人。\n再试试吧", Toast.LENGTH_SHORT).show();
						mVibrator.cancel();
						mShakeListener.start();
					}},2000);
			}
			
		});
	}
	public void startAnim(){
		AnimationSet animUp=new AnimationSet(true);
		//图片先向上移动50%然后再向下移动50%
		TranslateAnimation anim0=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,
				Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,-0.5f);
		anim0.setDuration(1000);
		TranslateAnimation anim1=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,
				Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,+0.5f);
		anim1.setDuration(1000);
		anim1.setStartOffset(1000);
		animUp.addAnimation(anim0);
		animUp.addAnimation(anim1);
		mImgUp.startAnimation(animUp);
		
		//图片先向下移动50%然后再向上移动50%
		AnimationSet animDown=new AnimationSet(true);
		TranslateAnimation anim2=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,
				Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,+0.5f);
		anim2.setDuration(1000);
		TranslateAnimation anim3=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,
				Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,-0.5f);
		anim3.setDuration(1000);
		anim3.setStartOffset(1000);
		animDown.addAnimation(anim2);
		animDown.addAnimation(anim3);
		mImgDown.startAnimation(animDown);
		}
	/**
	 * 定义手机震动
	 */
	public void startVibrato(){
		//第一个｛｝里面是节奏数组， 第二个参数是重复次数，-1为不重复，
		mVibrator.vibrate(new long[]{500,200,500,200},-1);
	}
	/**
	 * 返回按键处理
	 */
	public void shake_activity_back(View v){
		this.finish();
	}
	/**
	 * 按标题栏启动动画
	 */
	public void linshi(View v){
		startAnim();
	}
	/**
	 * 复写销毁函数
	 */
	@Override
	protected void onDestroy(){
		super.onDestroy();
		if(mShakeListener!=null){
			mShakeListener.stop();
		}
	}
}
