package com.example.linuxguide;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;


public class CommandPagerActivity extends FragmentActivity {
	private ViewPager mViewPager;
	private ArrayList<CommandKind> mCommandKinds;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mViewPager = new ViewPager(this);
		mViewPager.setId(R.id.viewPager_command);
		setContentView(mViewPager);
		mCommandKinds=CommandKind.getKinds();
		FragmentManager fm=getSupportFragmentManager();
		
		mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mCommandKinds.size();
			}
			
			@Override
			public Fragment getItem(int pos) {
				// TODO Auto-generated method stub
				CommandKind commandkind=mCommandKinds.get(pos);
				return CommandFragment.newInstance(commandkind.getId());
			}
		});
		int commandid=getIntent().getIntExtra(CommandFragment.EXTRA_COMMAND_ID, 0);
		
		for (int i=0;i < mCommandKinds.size();i++){
			if (mCommandKinds.get(i).getId()==commandid){
				mViewPager.setCurrentItem(i);
				setTitle(mCommandKinds.get(i).getKind());
				break;
			}
		}
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int pos) {
				// TODO Auto-generated method stub
				CommandKind ck=mCommandKinds.get(pos);
				if (ck.getKind()!=null){
					setTitle(ck.getKind());
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
