package com.example.linuxguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class linuxMenuFragment extends Fragment {
	
	private Button mButtonCommand;
	private Button mButtonInstallGuide;
	private Button mButtonTips;
	private Button mButtonFAQ;
	private Button mButtonNews;
	private Button mButtonAbout;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.linux_title);
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v=inflater.inflate(R.layout.menu_layout, null);
		mButtonCommand=(Button) v.findViewById(R.id.button_linux_command);
		mButtonAbout=(Button) v.findViewById(R.id.button_app_about);
		mButtonFAQ=(Button) v.findViewById(R.id.button_linux_FAQ);
		mButtonNews=(Button) v.findViewById(R.id.button_linux_news);
		mButtonTips=(Button) v.findViewById(R.id.button_linux_tips);
		mButtonInstallGuide=(Button) v.findViewById(R.id.button_linux_install_guide);
		mButtonInstallGuide.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getActivity(), InstallGuideActivity.class);
				startActivity(i);
			}
		});
		mButtonCommand.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getActivity(),CommandMenuActivity.class);
				startActivity(i);
			}
		});
		return v;
	}
}
