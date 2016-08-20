package com.example.mywechat.activity;

import com.example.mywechat.utils.ActivityCollector;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		ActivityCollector.addActivity(this);
	}

	@Override
	protected void onDestroy(){
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}
}
