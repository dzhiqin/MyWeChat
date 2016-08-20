package com.example.mywechat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.mywechat.R;
/**
 * ֻ������ʾ��¼bar
 * @author Administrator
 *
 */
public class LoadingActivity extends BaseActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading);
		
		new Handler().postDelayed(new Runnable(){

			@Override
			public void run() {
				Intent intent=new Intent();
				intent.setClass(LoadingActivity.this, Whatsnew.class);
				startActivity(intent);
				LoadingActivity.this.finish();
				Toast.makeText(getApplicationContext(), "��¼�ɹ�", Toast.LENGTH_SHORT).show();
			}},200);
	}

}
