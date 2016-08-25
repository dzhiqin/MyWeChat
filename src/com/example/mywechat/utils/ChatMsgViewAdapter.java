package com.example.mywechat.utils;

import java.util.List;

import com.example.mywechat.R;
import com.example.mywechat.model.ChatMsgEntity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ChatMsgViewAdapter extends BaseAdapter{

	/**
	 * 创建一个接口
	 * 
	 */
	public static interface MsgType{
		int COME_MSG=0;
		int TO_MSG=1;
	}
	private static final String TAG=ChatMsgViewAdapter.class.getSimpleName();
	private List<ChatMsgEntity> messages;
	private Context context;
	private LayoutInflater mInflater;
	public ChatMsgViewAdapter(Context context,List<ChatMsgEntity> messages) {
		this.context=context;
		this.messages=messages;
		mInflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return messages.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO 自动生成的方法存根
		return messages.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO 自动生成的方法存根
		return position;
	}
	/**
	 * 重点理解
	 */
	@Override
	public int getItemViewType(int position){
		ChatMsgEntity entity=messages.get(position);
		if(entity.getMsgType()){
			return MsgType.COME_MSG;
		}else{
			return MsgType.TO_MSG;
		}
	}
	@Override
	public int getViewTypeCount(){
		return 2;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ChatMsgEntity entity=messages.get(position);
		boolean isComeMsg=entity.getMsgType();
		ViewHolder viewHolder=null;
		if(convertView==null){
			if(isComeMsg){
				convertView=mInflater.inflate(R.layout.chatting_item_left,null);
			}else{
				convertView=mInflater.inflate(R.layout.chatting_item_right, null);
			}
			viewHolder=new ViewHolder();
			viewHolder.tvSendTime=(TextView)convertView.findViewById(R.id.tv_sendtime);
			viewHolder.tvContent=(TextView)convertView.findViewById(R.id.tv_chatcontent);
			viewHolder.tvUserName=(TextView)convertView.findViewById(R.id.tv_username);
			viewHolder.isComeMsg=isComeMsg;
			convertView.setTag(viewHolder);
		}else{
			viewHolder=(ViewHolder)convertView.getTag();
		}
		viewHolder.tvContent.setText(entity.getContent());
		viewHolder.tvSendTime.setText(entity.getDate());
		viewHolder.tvUserName.setText(entity.getName());
		return convertView;
	}
	static class ViewHolder{
		public TextView tvSendTime;
		public TextView tvUserName;
		public TextView tvContent;
		public boolean isComeMsg;
	}
}
