package com.example.linuxguide;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class CommandMenuFragment extends Fragment {
	private Button mButtonCommandDaily;
	private Button mButtonCommandProvided;
	private Button mButtonCommandSaved;
	private Button mButtonCommandComplete;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId())
		{
			case android.R.id.home:
				if (NavUtils.getParentActivityName(getActivity())!=null){
					NavUtils.navigateUpFromSameTask(getActivity());
				}
		}
		return super.onOptionsItemSelected(item);
	}
	@TargetApi(Build.VERSION_CODES.HONEYCOMB) @Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View v=inflater.inflate(R.layout.command_menu_fragment, null);
		mButtonCommandDaily=(Button)v.findViewById(R.id.command_daily);
		mButtonCommandProvided=(Button)v.findViewById(R.id.command_provided);
		mButtonCommandSaved=(Button)v.findViewById(R.id.command_your);
		mButtonCommandComplete=(Button) v.findViewById(R.id.commands_more);
		if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB){
			if (NavUtils.getParentActivityName(getActivity())!=null){
				getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
			}
		}
		
		
		mButtonCommandDaily.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getActivity(),CommandListActivity.class );
				startActivity(i);
			}
		});
		mButtonCommandProvided.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getActivity(),CommandListOfflineActivity.class );
				startActivity(i);
			}
		});
		
		return v;
	}

}
