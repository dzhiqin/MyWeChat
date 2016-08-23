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
				// TODO �Զ����ɵķ������
				
			}
			
		});
	}
}
