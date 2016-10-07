package com.example.linuxguide;

import java.util.ArrayList;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CommandListOfflineFragment extends ListFragment {
	private CommandDataHandler mHandler;
	private ArrayList<Command> mCommands;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mHandler = new CommandDataHandler(getActivity());
		mHandler.open();
		mCommands = mHandler.getAllCommands();
		mHandler.close();
		CommandAdapter adapter = new CommandAdapter(mCommands, getActivity());
		setListAdapter(adapter);
		setHasOptionsMenu(true);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.command_list_offline_fragment, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.menu_item_new_command:
			final Dialog dialog = new Dialog(getActivity());
			dialog.setContentView(R.layout.menu_add_command_dialog);
			dialog.setTitle("Add New Command");
			final EditText textviewTitle=(EditText)dialog.findViewById(R.id.dialog_add_command_title);
			final EditText textviewSubtitle=(EditText) dialog.findViewById(R.id.dialog_add_command_subtitle);
			
			Button dialogButtonAdd = (Button) dialog
					.findViewById(R.id.dialog_add_command_button_add);
			Button dialogButtonCancel = (Button) dialog
					.findViewById(R.id.dialog_add_command_button_cancel);
			dialogButtonAdd.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String title=textviewTitle.getText().toString();
					String subtitle=textviewSubtitle.getText().toString();
					Command command=new Command();
					command.setTitle(title);
					command.setSubtitle(subtitle);
					mHandler.open();
					mHandler.insertCommand(command);
					mCommands = mHandler.getAllCommands();
					mHandler.close();
					CommandAdapter adapter = new CommandAdapter(mCommands, getActivity());
					setListAdapter(adapter);
					dialog.dismiss();
					Toast.makeText(getActivity(),"Add new command success", Toast.LENGTH_SHORT).show();
				}
			});
			dialogButtonCancel.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
			});
			dialog.show();
			return true;
		case android.R.id.home:
			if (NavUtils.getParentActivityName(getActivity()) != null) {
				NavUtils.navigateUpFromSameTask(getActivity());
			}
			return super.onOptionsItemSelected(item);

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.command_offline_list, null);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			if (NavUtils.getParentActivityName(getActivity()) != null) {
				getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
			}
		}
		return v;
	}

}
