package com.example.mywechat.model;

public class ChatMsgEntity {
	/**
	 * 聊天人名字
	 */
	private String name;
	/**
	 * 聊天日期
	 */
	private String date;
	/**
	 * 聊天内容
	 */
	private String content;
	private boolean isComeMsg=true;
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getDate(){
		return date;
	}
	public void setDate(String date){
		this.date=date;
	}
	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content=content;
	}
	public boolean getMsgType(){
		return isComeMsg;
	}
	public void setMsgType(boolean isComeMsg){
		this.isComeMsg=isComeMsg;
	}
	public ChatMsgEntity() {
		// TODO 自动生成的构造函数存根
	}
	public ChatMsgEntity(String name,String date,String text,boolean isComeMsg){
		this.name=name;
		this.date=date;
		this.content=text;
		this.isComeMsg=isComeMsg;
	}
}
