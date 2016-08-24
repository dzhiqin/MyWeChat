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
	 * �������ֻ���ʹ��
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
	
		//���ûζ�����
		mShakeListener=new ShakeListener(this);
		mShakeListener.setOnShakeListener(new OnShakeListener(){
	
			@Override
			public void onShake() {
				//��ʼҡһҡ����
				startAnim();
				mShakeListener.stop();
				startVibrato();//��ʼ��
				new Handler().postDelayed(new Runnable(){

					@Override
					public void run() {
						Toast.makeText(getApplicationContext(),"��Ǹ����ʱû���ҵ�\n��ͬһʱ��ҡ��"
								+ "�ֻ����ˡ�\n�����԰�", Toast.LENGTH_SHORT).show();
						mVibrator.cancel();
						mShakeListener.start();
					}},2000);
			}
			
		});
	}
	public void startAnim(){
		AnimationSet animUp=new AnimationSet(true);
		//ͼƬ�������ƶ�50%Ȼ���������ƶ�50%
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
		
		//ͼƬ�������ƶ�50%Ȼ���������ƶ�50%
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
	 * �����ֻ���
	 */
	public void startVibrato(){
		//��һ�����������ǽ������飬 �ڶ����������ظ�������-1Ϊ���ظ���
		mVibrator.vibrate(new long[]{500,200,500,200},-1);
	}
	/**
	 * ���ذ�������
	 */
	public void shake_activity_back(View v){
		this.finish();
	}
	/**
	 * ����������������
	 */
	public void linshi(View v){
		startAnim();
	}
	/**
	 * ��д���ٺ���
	 */
	@Override
	protected void onDestroy(){
		super.onDestroy();
		if(mShakeListener!=null){
			mShakeListener.stop();
		}
	}
}
