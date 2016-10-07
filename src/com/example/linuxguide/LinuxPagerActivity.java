package com.example.linuxguide;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class LinuxPagerActivity extends FragmentActivity{
	private ViewPager mViewPager;
	private ArrayList<InstallGuide> mGuides;
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		mViewPager=new ViewPager(this);
		mViewPager.setId(R.id.viewPager);
		setContentView(mViewPager);
		mGuides=InstallGuide.getGuides();
		
		FragmentManager fm=getSupportFragmentManager();
		mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mGuides.size();
			}
			
			@Override
			public Fragment getItem(int pos) {
				// TODO Auto-generated method stub
				InstallGuide guide=mGuides.get(pos);
				return InstallGuideItemFragment.newInstance(guide.getTitle());
			}
		});
		
		int id=getIntent().getIntExtra(InstallGuideItemFragment.EXTRA_GUIDE_ID, 0);
		setTitle(mGuides.get(id).getTitle());
		for (int i=0;i< mGuides.size();i++){
			if (mGuides.get(i).getId()==id){
				mViewPager.setCurrentItem(i);
				break;
			}
		}
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int pos) {
				// TODO Auto-generated method stub
				InstallGuide guide=mGuides.get(pos);
				if (guide.getTitle()!=null){
					setTitle(guide.getTitle());
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
