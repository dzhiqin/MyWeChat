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
	 * �ʺű༭��
	 */
	private EditText mUser;
	/**
	 * ����༭��
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
			.setTitle("��¼����")
			.setMessage("΢���ʺŻ������벻��Ϊ�գ�\n��������ٵ�¼��")
			.create().show();
		}else{
			new AlertDialog.Builder(Login.this)
			.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
			.setTitle("��¼ʧ��")
			.setMessage("΢���ʺŻ����벻��ȷ��\n������������룡")
			.create().show();
		}
	}
	/**
	 * ���ذ�ť��ֱ�ӽ���activity
	 * @param v
	 */
	public void login_back(View v){
		this.finish();
	}
	/**
	 * �������밴ť������΢����ҳ
	 */
	public void login_pw(View v){
		Uri uri=Uri.parse("http://weixin.qq.com");
		Intent intent=new Intent(Intent.ACTION_VIEW,uri);
		startActivity(intent);
	}
}
