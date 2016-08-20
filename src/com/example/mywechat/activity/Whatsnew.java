package com.example.mywechat.activity;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.mywechat.R;

public class Whatsnew extends BaseActivity{

	private ViewPager mViewPager;
	private int currentIndex=0;
	private ImageView mPage1;
	private ImageView mPage2;
	private ImageView mPage3;
	private ImageView mPage4;
	private ImageView mPage5;
	private ImageView mPage6;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.whatsnew_viewpager);
		mViewPager=(ViewPager)findViewById(R.id.whatsnew_viewpager);
		//mViewPager设置页面切换监听
		mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
		mPage1=(ImageView)findViewById(R.id.page1);
		mPage2=(ImageView)findViewById(R.id.page2);
		mPage3=(ImageView)findViewById(R.id.page3);
		mPage4=(ImageView)findViewById(R.id.page4);
		mPage5=(ImageView)findViewById(R.id.page5);
		mPage6=(ImageView)findViewById(R.id.page6);
		//提取要分页显示的view
		LayoutInflater inflater=LayoutInflater.from(this);
		View view1=inflater.inflate(R.layout.whats1, null);
		View view2=inflater.inflate(R.layout.whats2, null);
		View view3=inflater.inflate(R.layout.whats3, null);
		View view4=inflater.inflate(R.layout.whats4, null);
		View view5=inflater.inflate(R.layout.whats5, null);
		View view6=inflater.inflate(R.layout.whats6, null);
		//将这些view装入数组中
		final ArrayList<View>views=new ArrayList<View>();
		views.add(view1);
		views.add(view2);
		views.add(view3);
		views.add(view4);
		views.add(view5);
		views.add(view6);
		//填充ViewPager的适配器PagerAdapter
		PagerAdapter adapter=new PagerAdapter(){

			@Override
			public int getCount() {
				// TODO 自动生成的方法存根
				return views.size();
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO 自动生成的方法存根
				return arg1==arg0;
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
		mViewPager.setAdapter(adapter);
	}

	public class MyOnPageChangeListener implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO 自动生成的方法存根
			
		}

		@SuppressLint("NewApi")
		@Override
		public void onPageSelected(int arg0) {
			switch(arg0){
			case 0:
				mPage1.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
				mPage2.setImageDrawable(getResources().getDrawable(R.drawable.page));
				break;
			case 1:
				mPage1.setImageDrawable(getResources().getDrawable(R.drawable.page));
				mPage2.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
				mPage3.setImageDrawable(getResources().getDrawable(R.drawable.page));
				break;
			case 2:
				mPage2.setImageDrawable(getResources().getDrawable(R.drawable.page));
				mPage3.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
				mPage4.setImageDrawable(getResources().getDrawable(R.drawable.page));
				break;
			case 3:
				mPage3.setImageDrawable(getResources().getDrawable(R.drawable.page));
				mPage4.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
				mPage5.setImageDrawable(getResources().getDrawable(R.drawable.page));
				break;
			case 4:
				mPage4.setImageDrawable(getResources().getDrawable(R.drawable.page));
				mPage5.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
				mPage6.setImageDrawable(getResources().getDrawable(R.drawable.page));
				break;
			case 5:
				mPage5.setImageDrawable(getResources().getDrawable(R.drawable.page));
				mPage6.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
				break;
			}
			currentIndex=arg0;
		}
		
	}
	public void startBtn(View v){
		Intent intent=new Intent();
		intent.setClass(Whatsnew.this,WhatsnewDoor.class);
		startActivity(intent);
		this.finish();
	}
}
