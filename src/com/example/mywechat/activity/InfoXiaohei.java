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

	//���ذ�ť,������activity
	public void btn_back(View v){
		this.finish();
	}
	//����Ϣ��ť��Ҳ�ǽ�����activity
	public void btn_sendmsg(View v){
		this.finish();
	}
	//ͷ��ť��������ͷ��
	public void head_xiaohei(View v){
		Intent intent=new Intent(InfoXiaohei.this,BigImage.class);
		startActivity(intent);
	}
}
