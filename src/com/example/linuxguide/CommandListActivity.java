package com.example.linuxguide;

import android.support.v4.app.Fragment;



public class CommandListActivity extends SingleFragmentActivity {
	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		return new CommandListFragment();
	}
}
