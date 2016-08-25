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
	 * 发送信息按钮
	 */
	private Button mBtnSend;
	/**
	 * 顶部返回按钮
	 */
	private Button mBtnBack;
	/**
	 * 发送信息框
	 */
	private EditText mContent;
	/**
	 * 显示内容listview
	 */
	private ListView mListView;
	/**
	 * 适配器
	 */
	private ChatMsgViewAdapter mAdapter;
	/**
	 * 显示的内容
	 */
	private List<ChatMsgEntity> mDataArray=new ArrayList<ChatMsgEntity> ();
	private String[]mMsgArray = new String[]{"有大", "有！？", "我也有", "那上吧", 
			"打啊！你放大啊", "你不？留人头那！。",
			"不解释", "....",};

	private String[]dateArray = new String[]{"2012-09-01 18:00", "2012-09-01 18:10", 
			"2012-09-01 18:11", "2012-09-01 18:20", 
			"2012-09-01 18:30", "2012-09-01 18:35", 
			"2012-09-01 18:40", "2012-09-01 18:50"}; 
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat_xiaolei);
		//启动activity时不自动弹出软键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN); 
		initView();
		initData();
	}
	/**
	 * 实例化控件，设置监听器
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
	 * 初始化并填充适配器
	 */
	private void initData(){
		for(int i=0;i<mMsgArray.length;i++){
			ChatMsgEntity entity=new ChatMsgEntity();//定义一个实例
			entity.setDate(dateArray[i]);//设置时间
			if(i%2==0){//区分奇偶数
				entity.setName("小黑");//设置姓名
				entity.setMsgType(true);//isComeMsg=true 				
			}else{
				entity.setName("人马");
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
	 * 发送信息
	 */
	private void sendMessage(){
		String contentString=mContent.getText().toString();//得到edittext内要发送的内容
		if(contentString.length()>0){
			ChatMsgEntity newEntity=new ChatMsgEntity();
			newEntity.setDate(getDate());//设置时间
			newEntity.setContent(contentString);
			newEntity.setName("人马");
			newEntity.setMsgType(false);
			//把新的ChatMsgEntity实例添加到mDataArray数组中
			mDataArray.add(newEntity);//
			mAdapter.notifyDataSetChanged();//刷新适配器，mListView
			mContent.setText("");//清空已发送内容
			mListView.setSelection(mListView.getCount()-1);//把选中的项目设到listview末尾
		}
	}
	/**
	 * 获得时间的函数
	 */
	private String getDate(){
		Calendar c=Calendar.getInstance();//
		String year=String.valueOf(c.get(Calendar.YEAR));
		String month=String.valueOf(c.get(Calendar.MONTH)+1);//注意 月份要加1
		String day=String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		String hour=String.valueOf(c.get(Calendar.HOUR_OF_DAY));//用的是24小时制的时间
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
