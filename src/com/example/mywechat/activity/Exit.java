package com.example.mywechat.activity;

import com.example.mywechat.R;
import com.example.mywechat.utils.ActivityCollector;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Exit extends BaseActivity{

	//private LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exit_dialog);
	/*	layout=(LinearLayout)findViewById(R.layout.exit_dialog);
		layout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "��ʾ����������ⲿ�رձ�����", Toast.LENGTH_SHORT).show();
				
			}
		});*/
	}

	/*@Override
	public boolean onTouchEvent(MotionEvent event){
		finish();
		return true;
	}
	public void exit_no(View v){
		finish();
	}
	public void exit_yes(View v){
		ActivityCollector.finishAll();
	}*/
}
