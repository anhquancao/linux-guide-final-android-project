package com.example.linuxguide;

import java.util.ArrayList;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
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

public class InstallGuideItemFragment extends Fragment {
	public static final String EXTRA_GUIDE_ID = "com.example.linuxguide.guide_id";
	private TextView mPara2;
	private String mTitle;
	private Button mImageFile;
	private Button mVNC;
	private Button mTerminal;
	private String mURL_large;
	private String mURL_small;
	private String mURL_core;
	private ArrayList<InstallGuide> guides;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mTitle = getArguments().getString(EXTRA_GUIDE_ID);
		setHasOptionsMenu(true);
		guides = InstallGuide.getGuides();
		if (mTitle.equals(guides.get(0).getTitle())) {
			mURL_large = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Large/ubuntu-13.04.LARGE.ext2.v2.zip/download";
			mURL_small = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Small/ubuntu-13.04.SMALL.ext2.v2.zip/download";
			mURL_core = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Core/ubuntu-13.04.CORE.ext2.v2.zip/download";

		} else if (mTitle.equals(guides.get(1).getTitle())) {
			mURL_large = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.10/Large/ubuntu-13.10.LARGE.ext2.v1.zip/download";
			mURL_small = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.10/Small/ubuntu-13.10.SMALL.ext2.v1.zip/download";
			mURL_core = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.10/Core/ubuntu-13.10.CORE.ext2.v1.zip/download";

		} else if (mTitle.equals(guides.get(2).getTitle())) {
			mURL_large = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Large/ubuntu-13.04.LARGE.ext2.v2.zip/download";
			mURL_small = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Small/ubuntu-13.04.SMALL.ext2.v2.zip/download";
			mURL_core = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Core/ubuntu-13.04.CORE.ext2.v2.zip/download";

		} else if (mTitle.equals(guides.get(3).getTitle())) {
			mURL_large = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Large/ubuntu-13.04.LARGE.ext2.v2.zip/download";
			mURL_small = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Small/ubuntu-13.04.SMALL.ext2.v2.zip/download";
			mURL_core = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Core/ubuntu-13.04.CORE.ext2.v2.zip/download";

		} else if (mTitle.equals(guides.get(4).getTitle())) {
			mURL_large = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Large/ubuntu-13.04.LARGE.ext2.v2.zip/download";
			mURL_small = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Small/ubuntu-13.04.SMALL.ext2.v2.zip/download";
			mURL_core = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Core/ubuntu-13.04.CORE.ext2.v2.zip/download";

		}
		if (mTitle.equals(guides.get(5).getTitle())) {
			mURL_large = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Large/ubuntu-13.04.LARGE.ext2.v2.zip/download";
			mURL_small = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Small/ubuntu-13.04.SMALL.ext2.v2.zip/download";
			mURL_core = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Core/ubuntu-13.04.CORE.ext2.v2.zip/download";

		}
		if (mTitle.equals(guides.get(6).getTitle())) {
			mURL_large = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Large/ubuntu-13.04.LARGE.ext2.v2.zip/download";
			mURL_small = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Small/ubuntu-13.04.SMALL.ext2.v2.zip/download";
			mURL_core = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Core/ubuntu-13.04.CORE.ext2.v2.zip/download";

		} else {
			mURL_large = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Large/ubuntu-13.04.LARGE.ext2.v2.zip/download";
			mURL_small = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Small/ubuntu-13.04.SMALL.ext2.v2.zip/download";
			mURL_core = "http://sourceforge.net/projects/linuxonandroid/files/Ubuntu/13.04/Core/ubuntu-13.04.CORE.ext2.v2.zip/download";

		}

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
		View v = inflater.inflate(R.layout.install_guide_fragment, container,
				false);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			if (NavUtils.getParentActivityName(getActivity()) != null) {
				getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
			}
		}

		mImageFile = (Button) v.findViewById(R.id.imageFile);
		mVNC = (Button) v.findViewById(R.id.vnc);
		mTerminal = (Button) v.findViewById(R.id.terminal);

		mPara2 = (TextView) v.findViewById(R.id.para2);

		mPara2.setText("Step1: You MUST have Root and a kernel that supports loop devices.\n"
				+ "Enable debugging mode\n"
				+ "Downloading the "
				+ mTitle
				+ " image file"
				+ "\nDownload and install terminal app and vncviewer app"
				+ "\nExtraxt the zip folder into folder called "
				+ mTitle
				+ " on the root of sdcard"
				+ "\n\nNow you are ready to boot "
				+ mTitle
				+ " do this by either using the Launch menu item or place the boot widget on screen"
				+ "\nAfter a minute or two you should get this message: root@localhost:/#"
				+ "\n\nThe terminal now act like a "
				+ mTitle
				+ " command line,to connect to the GUI, run VNC viewer app"
				+ "\nSet the IP address to localhost and port number 5900 and enter the password "
				+ mTitle
				+ " , then press connect"
				+ "\n\nNOTE: when you are finished in "
				+ mTitle
				+ " you must type exit in the commad line.");

		mImageFile.setText("Download " + mTitle + " image file");
		mVNC.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri
						.parse("http://market.android.com/details?id=android.androidVNC"));
				startActivity(intent);
			}
		});

		mTerminal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri
						.parse("http://market.android.com/details?id=jackpal.androidterm"));
				startActivity(intent);

			}
		});
		mImageFile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Dialog dialog = new Dialog(getActivity());
				dialog.setContentView(R.layout.install_guide_custom_dialog);
				dialog.setTitle("Download");
				Button dialogButtonLarge = (Button) dialog
						.findViewById(R.id.btn_large);
				Button dialogButtonSmall = (Button) dialog
						.findViewById(R.id.btn_small);
				Button dialogButtonCore = (Button) dialog
						.findViewById(R.id.btn_core);

				dialogButtonLarge.setText("Large "+mTitle+" Image File");
				dialogButtonSmall.setText("Small "+mTitle+" Image File");
				dialogButtonCore.setText("Core "+mTitle+" Image File");
				
				dialogButtonLarge.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub

						Intent intent = new Intent(Intent.ACTION_VIEW);
						intent.setData(Uri
								.parse(mURL_large));
						startActivity(intent);
					}
				});
				dialogButtonSmall.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(Intent.ACTION_VIEW);
						intent.setData(Uri
								.parse(mURL_small));
						startActivity(intent);
					}
				});
				dialogButtonCore.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(Intent.ACTION_VIEW);
						intent.setData(Uri
								.parse(mURL_core));
						startActivity(intent);
					}
				});
				dialog.show();
			}
		});

		return v;

	}

	public static InstallGuideItemFragment newInstance(String guideTitle) {
		Bundle args = new Bundle();
		args.putString(EXTRA_GUIDE_ID, guideTitle);

		InstallGuideItemFragment fragment = new InstallGuideItemFragment();
		fragment.setArguments(args);
		return fragment;
	}
}
