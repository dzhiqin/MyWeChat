package com.example.mywechat.utils;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
/**
 * ActivityCollector �����ڹ������еĻ
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
	 * �ر����л
	 */
	public static void finishAll(){
		for(Activity activity:activities){
			if(!activity.isFinishing()){
				activity.finish();
			}
		}
	}
	public ActivityCollector() {
		// TODO �Զ����ɵĹ��캯�����
	}

}
