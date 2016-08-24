package com.example.mywechat.activity;

import com.example.mywechat.R;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ExitFromSettings extends BaseActivity{

	private LinearLayout exitLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exit_from_settings);
		exitLayout=(LinearLayout)findViewById(R.id.exit_dialog_layout);
		exitLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "��ʾ����������ⲿ���رմ���", Toast.LENGTH_SHORT).show();
				
			}
		});
	}
	/**
	 * �ڴ����ⲿ������رմ���
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event){
		finish();
		return true;
	}
	public void exitfromsettings(View v){
		this.finish();//�رնԻ�����
		MainWeChat.instance.finish();//�ر�mainwechat���activity
	}
	public void exitcancel(View v){
		this.finish();
	}
}
