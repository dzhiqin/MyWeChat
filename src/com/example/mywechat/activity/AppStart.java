package com.example.mywechat.activity;


import com.example.mywechat.R;
import com.example.mywechat.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
/**
 * 微信启动界面，展示welcome图片
 * @author dzhiqin
 *
 */
public class AppStart extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.appstart);
		/**
		 * 延时启动的线程 ，1s后启动,进入welcome界面选择登录或注册
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
