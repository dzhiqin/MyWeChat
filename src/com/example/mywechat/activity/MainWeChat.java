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
	 * ������ͼƬ
	 */
	private ImageView mTabImg;
	/**
	 * ҳ��ͼ��
	 */
	private ImageView mTab0,mTab1,mTab2,mTab3;
	/**
	 * ����ƫ����
	 */
	private int zero=0;
	private int one,two,three;;

	/**
	 * ��ǰҳ�����
	 */
	private int currentIndex=0;
	private LayoutInflater inflater;
	/**
	 * Ҫ��ʾ��ҳ����ͼ
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
		
		//ʵ����ҳ��ͼ��
		mTab0=(ImageView)findViewById(R.id.img_weixin);
		mTab1=(ImageView)findViewById(R.id.img_address);
		mTab2=(ImageView)findViewById(R.id.img_friends);
		mTab3=(ImageView)findViewById(R.id.img_settings);
		mTabImg=(ImageView)findViewById(R.id.imag_tab_now);
		//����ҳ��ͼ�����
		mTab0.setOnClickListener(new MyOnClickListener(0));
		mTab1.setOnClickListener(new MyOnClickListener(1));
		mTab2.setOnClickListener(new MyOnClickListener(2));
		mTab3.setOnClickListener(new MyOnClickListener(3));
		
		//��ȡ��ǰ��Ļ�ֱ���
		Display currentDisplay=getWindowManager().getDefaultDisplay();
		int displayWidth=currentDisplay.getWidth();
		one=displayWidth/4;
		two=one*2;
		three=one*3;
		
		//��ȡҪ��ʾ����ͼ����
		inflater=LayoutInflater.from(this);
		view0=inflater.inflate(R.layout.main_tab_wechat, null);
		view1=inflater.inflate(R.layout.main_tab_address, null);
		view2=inflater.inflate(R.layout.main_tab_friends, null);
		view3=inflater.inflate(R.layout.main_tab_settings, null);
		//��viewװ��list����
		final ArrayList<View> views=new ArrayList<View>();
		views.add(view0);
		views.add(view1);
		views.add(view2);
		views.add(view3);
		//���viewpager��������
		PagerAdapter mPagerAdapter=new PagerAdapter(){

			@Override
			public int getCount() {
				// TODO �Զ����ɵķ������
				return views.size();
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO �Զ����ɵķ������
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
	 * ҳ��ͼ����������ڼ����ĸ�ҳ����ѡ���ˣ�Ȼ������ҳ���ĵ�ǰ����
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
			// ����ҳ�����ڴ���
			mTabPager.setCurrentItem(index);
		}
		
	}
	/**
	 * ҳ���л�����
	 * @author Administrator
	 *
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO �Զ����ɵķ������
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO �Զ����ɵķ������
			
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
				Log.v("test","case 1");
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
	 * ��������
	 */
	public boolean onKeyDown(int keyCode,KeyEvent event){
		if(keyCode==KeyEvent.KEYCODE_BACK&&event.getRepeatCount()==0){
			//��ȡback��
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
	 *΢�Ž��涥���Ҳఴ�� 
	 */
	public void btnmainright(View v){
		Intent intent=new Intent(MainWeChat.this,MainTopRightDialog.class);
		startActivity(intent);
	}
	/**
	 * ��С�ڵĶԻ�����
	 */
	public void startchat(View v){
		Intent intent=new Intent(MainWeChat.this,ChatActivity.class);
		startActivity(intent);
	}
	/**
	 * α �˳����Ի�����ʵ��һ��activity
	 */
	public void exit_settings(View v){
		Intent intent=new Intent(MainWeChat.this,ExitFromSettings.class);
		startActivity(intent);
	}
	/**
	 * �����ֻ� ��ҡһҡ��
	 */
	public void btn_shake(View v){
		Intent intent=new Intent(MainWeChat.this,ShakeActivity.class);
		startActivity(intent);
	}
}
