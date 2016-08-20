package com.example.mywechat.utils;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
/**
 * ActivityCollector 类用于管理所有的活动
 * @author dzhiqin
 *
 */
public class ActivityCollector {

	public static List<Activity> activities=new ArrayList<Activity>();
	public static void addActivity(Activity activity){
		activities.add(activity);
	}
	public static void removeActivity(Activity activity){
		activities.remove(activity);
	}
	/**
	 * 关闭所有活动
	 */
	public static void finishAll(){
		for(Activity activity:activities){
			if(!activity.isFinishing()){
				activity.finish();
			}
		}
	}
	public ActivityCollector() {
		// TODO 自动生成的构造函数存根
	}

}
