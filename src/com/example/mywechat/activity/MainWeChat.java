package com.example.mywechat.activity;

import java.util.ArrayList;

import com.example.mywechat.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class MainWeChat extends BaseActivity{

	public static MainWeChat instance=null;
	private ViewPager mTabPager;
	/**
	 * 滑动块图片
	 */
	private ImageView mTabImg;
	/**
	 * 页卡图标
	 */
	private ImageView mTab0,mTab1,mTab2,mTab3;
	/**
	 * 滑块偏移量
	 */
	private int zero=0;
	private int one,two,three;;

	/**
	 * 当前页卡编号
	 */
	private int currentIndex=0;
	private LayoutInflater inflater;
	/**
	 * 要显示的页卡视图
	 */
	private View view0;
	private View view1;
	private View view2;
	private View view3;
	private boolean menu_display=false;
	private PopupWindow menuWindow;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_wechat);
		instance=this;//
		mTabPager=(ViewPager)findViewById(R.id.tabpager);
		mTabPager.setOnPageChangeListener(new MyOnPageChangeListener());
		
		//实例化页卡图标
		mTab0=(ImageView)findViewById(R.id.img_weixin);
		mTab1=(ImageView)findViewById(R.id.img_address);
		mTab2=(ImageView)findViewById(R.id.img_friends);
		mTab3=(ImageView)findViewById(R.id.img_settings);
		mTabImg=(ImageView)findViewById(R.id.imag_tab_now);
		//设置页卡图标监听
		mTab0.setOnClickListener(new MyOnClickListener(0));
		mTab1.setOnClickListener(new MyOnClickListener(1));
		mTab2.setOnClickListener(new MyOnClickListener(2));
		mTab3.setOnClickListener(new MyOnClickListener(3));
		
		//获取当前屏幕分辨率
		Display currentDisplay=getWindowManager().getDefaultDisplay();
		int displayWidth=currentDisplay.getWidth();
		one=displayWidth/4;
		two=one*2;
		three=one*3;
		
		//提取要显示的视图布局
		inflater=LayoutInflater.from(this);
		view0=inflater.inflate(R.layout.main_tab_wechat, null);
		view1=inflater.inflate(R.layout.main_tab_address, null);
		view2=inflater.inflate(R.layout.main_tab_friends, null);
		view3=inflater.inflate(R.layout.main_tab_settings, null);
		//把view装入list数组
		final ArrayList<View> views=new ArrayList<View>();
		views.add(view0);
		views.add(view1);
		views.add(view2);
		views.add(view3);
		//填充viewpager的适配器
		PagerAdapter mPagerAdapter=new PagerAdapter(){

			@Override
			public int getCount() {
				// TODO 自动生成的方法存根
				return views.size();
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO 自动生成的方法存根
				return arg0==arg1;
			}
			@Override
			public void destroyItem(View container,int position,Object object){
				((ViewPager)container).removeView(views.get(position));
			}
			@Override
			public Object instantiateItem(View container,int position){
				((ViewPager)container).addView(views.get(position));
				return views.get(position);
			}
		};
		mTabPager.setAdapter(mPagerAdapter);
	}
	/**
	 * 页卡图标监听，用于监听哪个页卡被选择了，然后设置页卡的当前次序
	 * @author Administrator
	 *
	 */
	public class MyOnClickListener implements OnClickListener{
		private int index=0;
		public MyOnClickListener(int index){
			this.index=index;
		}
		@Override
		public void onClick(View v) {
			// 设置页卡当期次序
			mTabPager.setCurrentItem(index);
		}
		
	}
	/**
	 * 页卡切换监听
	 * @author Administrator
	 *
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void onPageSelected(int arg0) {
			Animation anim=null;
			switch(arg0){
			case 0:
				mTab0.setImageDrawable(getResources().getDrawable(R.drawable.tab_weixin_pressed));
				if(currentIndex==1){
					anim=new TranslateAnimation(one,0,0,0);
					mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_address_normal));
				}else if(currentIndex==2){
					anim=new TranslateAnimation(two,0,0,0);
					mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_find_frd_normal));
				}else if(currentIndex==3){
					anim =new TranslateAnimation(three,0,0,0);
					mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_settings_normal));
				}
				break;
			case 1:
				mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_address_pressed));
				//Log.v("test","case 1");
				if(currentIndex==0){
					anim =new TranslateAnimation(zero,one,0,0);
					mTab0.setImageDrawable(getResources().getDrawable(R.drawable.tab_weixin_normal));
				}else if(currentIndex==2){
					anim =new TranslateAnimation(two,one,0,0);
					mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_find_frd_normal));
				}else if(currentIndex==3){
					anim=new TranslateAnimation(three,one,0,0);
					mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_settings_normal));
				}
				break;
			case 2:
				mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_find_frd_pressed));
				if(currentIndex==0){
					anim=new TranslateAnimation(zero,two,0,0);
					mTab0.setImageDrawable(getResources().getDrawable(R.drawable.tab_weixin_normal));
				}else if(currentIndex==1){
					anim=new TranslateAnimation(one,two,0,0);
					mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_address_normal));
				}else if(currentIndex==3){
					anim=new TranslateAnimation(three,two,0,0);
					mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_settings_normal));
				}
				break;
			case 3:
				mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_settings_pressed));
				if(currentIndex==0){
					anim=new TranslateAnimation(zero,three,0,0);
					mTab0.setImageDrawable(getResources().getDrawable(R.drawable.tab_weixin_normal));
				}else if(currentIndex==1){
					anim=new TranslateAnimation(one,three,0,0);
					mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_address_normal));
				}else if(currentIndex==2){
					anim=new TranslateAnimation(two,three,0,0);
					mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_find_frd_normal));
				}
				break;
			}
			currentIndex=arg0;
			anim.setFillAfter(true);
			anim.setDuration(150);
			mTabImg.startAnimation(anim);
		}
		
	}
	/**
	 * 按键监听
	 */
	public boolean onKeyDown(int keyCode,KeyEvent event){
		if(keyCode==KeyEvent.KEYCODE_BACK&&event.getRepeatCount()==0){
			//获取back键
			if(menu_display){
			//	menuWindow.dismiss();
				menu_display=false;
				return true;
			}else{
				Intent intent=new Intent(MainWeChat.this,Exit.class);
				startActivity(intent);
				return true;
			}
		}
		return false;
	}
	/**
	 *微信界面顶部右侧按键 
	 */
	public void btnmainright(View v){
		Intent intent=new Intent(MainWeChat.this,MainTopRightDialog.class);
		startActivity(intent);
	}
	/**
	 * 与小黑的对话界面
	 */
	public void startchat(View v){
		Intent intent=new Intent(MainWeChat.this,ChatActivity.class);
		startActivity(intent);
	}
	/**
	 * 伪 退出“对话框”其实是一个activity
	 */
	public void exit_settings(View v){
		Intent intent=new Intent(MainWeChat.this,ExitFromSettings.class);
		startActivity(intent);
	}
	/**
	 * 进入手机 “摇一摇”
	 */
	public void btn_shake(View v){
		Intent intent=new Intent(MainWeChat.this,ShakeActivity.class);
		startActivity(intent);
	}
}
