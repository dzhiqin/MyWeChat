package com.example.mywechat.activity;

import com.example.mywechat.R;
import com.example.mywechat.utils.ActivityCollector;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Exit extends BaseActivity{

	private LinearLayout mlayout;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exit_dialog);
		mlayout=(LinearLayout)findViewById(R.id.exit_layout_id);		
		mlayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "��ʾ����������ⲿ�رձ�����", Toast.LENGTH_SHORT).show();
				
			}
		});
	}

	/**
	 * mlayout��click�¼����������ȡ�ˣ�������ʾ��ʾ��Ϣ�����Ե����mlayout֮��Ĳ��֣�click�¼�����κ���
	 * ʵ�ֵ�������ⲿ�رձ����ڵĹ���
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event){
		finish();
		return true;
	}
	public void exit_no(View v){
		finish();
	}
	public void exit_yes(View v){
		ActivityCollector.finishAll();
	}
}
