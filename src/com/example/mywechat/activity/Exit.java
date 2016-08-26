package com.example.mywechat.activity;

import com.example.mywechat.R;
import com.example.mywechat.utils.ActivityCollector;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Exit extends BaseActivity {

	private LinearLayout mlayout;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exit_dialog);
		mlayout=(LinearLayout)findViewById(R.id.exit_layout_id);			
		mlayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "提示：点击窗口外部关闭本窗口", Toast.LENGTH_SHORT).show();				
			}
		});
	}

	/**
	 * mlayout的click事件被他本身获取了，用于显示提示信息，所以当点击mlayout之外的部分，进入此函数
	 * 实现点击窗口外部关闭本窗口的功能
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event){
		/*switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			Log.v("test", "action_down");
			break;
		case MotionEvent.ACTION_UP:
			Log.v("test", "action_up");
			break;
		}*/
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
