package com.example.mywechat.activity;

import com.example.mywechat.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Welcome extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.welcome);
	}
	public void welcome_login(View v){
		Intent intent=new Intent();
		intent.setClass(Welcome.this, Login.class);
		startActivity(intent);
		//this.finish();
	}
	public void welcome_register(View v){
		Intent intent=new Intent();
		intent.setClass(Welcome.this, MainWeChat.class);
		startActivity(intent);
		//this.finish();
	}
}
