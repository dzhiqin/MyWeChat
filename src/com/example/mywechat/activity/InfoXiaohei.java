package com.example.mywechat.activity;

import com.example.mywechat.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InfoXiaohei extends BaseActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_xiaohei);
	}

	//返回按钮,结束本activity
	public void btn_back(View v){
		this.finish();
	}
	//发消息按钮，也是结束本activity
	public void btn_sendmsg(View v){
		this.finish();
	}
	//头像按钮，弹出大头像
	public void head_xiaohei(View v){
		Intent intent=new Intent(InfoXiaohei.this,BigImage.class);
		startActivity(intent);
	}
}
