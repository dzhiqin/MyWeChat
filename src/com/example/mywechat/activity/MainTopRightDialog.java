package com.example.mywechat.activity;

import com.example.mywechat.R;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainTopRightDialog extends BaseActivity{

	private LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_top_right_dialog);
		layout=(LinearLayout)findViewById(R.id.main_dialog_layout);
		layout.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "提示，点击窗口外部关闭窗口",Toast.LENGTH_SHORT).show();
				
			}
			
		});
	}
	/**
	 * 随便点击窗口外部，结束activity
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event){
		finish();
		return true;
	}
}
