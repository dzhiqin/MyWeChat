package com.example.mywechat.activity;


import com.example.mywechat.R;
import com.example.mywechat.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
/**
 * ΢���������棬չʾwelcomeͼƬ
 * @author dzhiqin
 *
 */
public class AppStart extends BaseActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.appstart);
		/**
		 * ��ʱ�������߳� ��1s������,����welcome����ѡ���¼��ע��
		 */
		new Handler().postDelayed(new Runnable(){

			@Override
			public void run() {
				Intent intent=new Intent(AppStart.this,Welcome.class);
				startActivity(intent);
				finish();
			}
			
		},1000);
	}
}
