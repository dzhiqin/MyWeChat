package com.example.mywechat.activity;

import com.example.mywechat.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class Login extends BaseActivity{

	/**
	 * 帐号编辑框
	 */
	private EditText mUser;
	/**
	 * 密码编辑框
	 */
	private EditText mPassword;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		mUser=(EditText)findViewById(R.id.login_user_edit);
		mPassword=(EditText)findViewById(R.id.login_passwd_edit);
	}
	public void login_mainwechat(View v){
		if("weixin".equals(mUser.getText().toString())&&"123".equals(mPassword.getText().toString())){
			Intent intent=new Intent(Login.this,LoadingActivity.class);
			startActivity(intent);
		}else if("".equals(mUser.getText().toString())||"".equals(mPassword.getText().toString())){
			new AlertDialog.Builder(Login.this)
			.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
			.setTitle("登录错误")
			.setMessage("微信帐号或者密码不能为空，\n请输入后再登录！")
			.create().show();
		}else{
			new AlertDialog.Builder(Login.this)
			.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
			.setTitle("登录失败")
			.setMessage("微信帐号或密码不正确，\n请检查后重新输入！")
			.create().show();
		}
	}
	/**
	 * 返回按钮，直接结束activity
	 * @param v
	 */
	public void login_back(View v){
		this.finish();
	}
	/**
	 * 忘记密码按钮，进入微信主页
	 */
	public void login_pw(View v){
		Uri uri=Uri.parse("http://weixin.qq.com");
		Intent intent=new Intent(Intent.ACTION_VIEW,uri);
		startActivity(intent);
	}
}
