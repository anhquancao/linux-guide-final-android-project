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
import android.widget.TextView;

public class InstallGuideFragment extends Fragment {
	private Button ubuntu1304;
	private Button ubuntu1310;
	private Button debian;
	private Button debiantest;
	private Button archlinux;
	private Button kalilinux;
	private Button fedora;
	private Button suse;

	private TextView mVersion;
	private TextView mCPU;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.install_title);
		setHasOptionsMenu(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			if (NavUtils.getParentActivityName(getActivity()) != null) {
				NavUtils.navigateUpFromSameTask(getActivity());
			}
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
	@TargetApi(11)
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.install_guide_menu, null);
		ubuntu1304 = (Button) v.findViewById(R.id.button_ubuntu_13_04);
		ubuntu1310 = (Button) v.findViewById(R.id.button_ubuntu_13_10);
		debian = (Button) v.findViewById(R.id.button_Debian);
		debiantest = (Button) v.findViewById(R.id.button_Debian_testing);
		archlinux = (Button) v.findViewById(R.id.button_Archlinux);
		kalilinux = (Button) v.findViewById(R.id.button_KaliLinux);
		fedora = (Button) v.findViewById(R.id.button_Fedora19);
		suse = (Button) v.findViewById(R.id.button_openSUSE123);
		String version = Build.VERSION.RELEASE;
		String arch = System.getProperty("os.arch");
		mVersion = (TextView) v.findViewById(R.id.version);
		mCPU = (TextView) v.findViewById(R.id.cpu_type);
		mCPU.setText(arch);
		mVersion.setText(version);
		
		if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB)
		{
			if (NavUtils.getParentActivityName(getActivity())!=null){
				getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
			}
		}
		
		ubuntu1304.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						LinuxPagerActivity.class);
				intent.putExtra(InstallGuideItemFragment.EXTRA_GUIDE_ID, 0);
				startActivity(intent);
			}
		});
		ubuntu1310.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						LinuxPagerActivity.class);
				intent.putExtra(InstallGuideItemFragment.EXTRA_GUIDE_ID, 1);
				startActivity(intent);
			}
		});
		debian.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						LinuxPagerActivity.class);
				intent.putExtra(InstallGuideItemFragment.EXTRA_GUIDE_ID, 2);
				startActivity(intent);
			}
		});
		debiantest.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						LinuxPagerActivity.class);
				intent.putExtra(InstallGuideItemFragment.EXTRA_GUIDE_ID, 3);
				startActivity(intent);
			}
		});
		archlinux.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						LinuxPagerActivity.class);
				intent.putExtra(InstallGuideItemFragment.EXTRA_GUIDE_ID, 4);
				startActivity(intent);
			}
		});
		kalilinux.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						LinuxPagerActivity.class);
				intent.putExtra(InstallGuideItemFragment.EXTRA_GUIDE_ID, 5);
				startActivity(intent);
			}
		});
		fedora.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						LinuxPagerActivity.class);
				intent.putExtra(InstallGuideItemFragment.EXTRA_GUIDE_ID, 6);
				startActivity(intent);
			}
		});
		suse.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						LinuxPagerActivity.class);
				intent.putExtra(InstallGuideItemFragment.EXTRA_GUIDE_ID, 7);
				startActivity(intent);
			}
		});
		return v;
	}

}
