package com.example.mywechat.activity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.mywechat.R;
import com.example.mywechat.model.ChatMsgEntity;
import com.example.mywechat.utils.ChatMsgViewAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ChatActivity extends BaseActivity implements OnClickListener{

	/**
	 * ������Ϣ��ť
	 */
	private Button mBtnSend;
	/**
	 * �������ذ�ť
	 */
	private Button mBtnBack;
	/**
	 * ������Ϣ��
	 */
	private EditText mContent;
	/**
	 * ��ʾ����listview
	 */
	private ListView mListView;
	/**
	 * ������
	 */
	private ChatMsgViewAdapter mAdapter;
	/**
	 * ��ʾ������
	 */
	private List<ChatMsgEntity> mDataArray=new ArrayList<ChatMsgEntity> ();
	private String[]mMsgArray = new String[]{"�д�", "�У���", "��Ҳ��", "���ϰ�", 
			"�򰡣���Ŵ�", "�㲻������ͷ�ǣ���",
			"������", "....",};

	private String[]dateArray = new String[]{"2012-09-01 18:00", "2012-09-01 18:10", 
			"2012-09-01 18:11", "2012-09-01 18:20", 
			"2012-09-01 18:30", "2012-09-01 18:35", 
			"2012-09-01 18:40", "2012-09-01 18:50"}; 
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat_xiaolei);
		//����activityʱ���Զ����������
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN); 
		initView();
		initData();
	}
	/**
	 * ʵ�����ؼ������ü�����
	 */
	private void initView(){
		mListView=(ListView)findViewById(R.id.listview);
		mBtnSend=(Button)findViewById(R.id.btn_send);
		mBtnBack=(Button)findViewById(R.id.btn_back);
		mBtnSend.setOnClickListener(this);
		mBtnBack.setOnClickListener(this);
		mContent=(EditText)findViewById(R.id.et_sendmessage);
	}
	/**
	 * ��ʼ�������������
	 */
	private void initData(){
		for(int i=0;i<mMsgArray.length;i++){
			ChatMsgEntity entity=new ChatMsgEntity();//����һ��ʵ��
			entity.setDate(dateArray[i]);//����ʱ��
			if(i%2==0){//������ż��
				entity.setName("С��");//��������
				entity.setMsgType(true);//isComeMsg=true 				
			}else{
				entity.setName("����");
				entity.setMsgType(false);
			}
			entity.setContent(mMsgArray[i]);
			mDataArray.add(entity);
		}
		mAdapter=new ChatMsgViewAdapter(this,mDataArray);
		mListView.setAdapter(mAdapter);
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.btn_back:
			finish();
			break;
		case R.id.btn_send:
			sendMessage();
			break;
		}		
	}
	/**
	 * ������Ϣ
	 */
	private void sendMessage(){
		String contentString=mContent.getText().toString();//�õ�edittext��Ҫ���͵�����
		if(contentString.length()>0){
			ChatMsgEntity newEntity=new ChatMsgEntity();
			newEntity.setDate(getDate());//����ʱ��
			newEntity.setContent(contentString);
			newEntity.setName("����");
			newEntity.setMsgType(false);
			//���µ�ChatMsgEntityʵ����ӵ�mDataArray������
			mDataArray.add(newEntity);//
			mAdapter.notifyDataSetChanged();//ˢ����������mListView
			mContent.setText("");//����ѷ�������
			mListView.setSelection(mListView.getCount()-1);//��ѡ�е���Ŀ�赽listviewĩβ
		}
	}
	/**
	 * ���ʱ��ĺ���
	 */
	private String getDate(){
		Calendar c=Calendar.getInstance();//
		String year=String.valueOf(c.get(Calendar.YEAR));
		String month=String.valueOf(c.get(Calendar.MONTH)+1);//ע�� �·�Ҫ��1
		String day=String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		String hour=String.valueOf(c.get(Calendar.HOUR_OF_DAY));//�õ���24Сʱ�Ƶ�ʱ��
		String minute=String.valueOf(c.get(Calendar.MINUTE));
		
		StringBuffer theDate=new StringBuffer();
		theDate.append(year+"-"+month+"-"+day+" "+hour+":"+minute);
		return theDate.toString();
	}
	public void head_xiaohei(View v){
		Intent intent=new Intent(ChatActivity.this,InfoXiaohei.class);
			startActivity(intent);
		
	}
}
