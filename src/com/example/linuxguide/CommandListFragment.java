package com.example.linuxguide;

import java.util.ArrayList;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CommandListFragment extends ListFragment {
	private ArrayList<CommandKind> mKinds;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.command_title);
		mKinds = CommandKind.getKinds();
		CommandKindAdapter adapter=new CommandKindAdapter(mKinds);
		setListAdapter(adapter);
		setHasOptionsMenu(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()){
		case android.R.id.home:
			if (NavUtils.getParentActivityName(getActivity())!=null){
				NavUtils.navigateUpFromSameTask(getActivity());
			}
		}
		return super.onOptionsItemSelected(item);
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB) @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB)
		{
			if (NavUtils.getParentActivityName(getActivity())!=null){
				getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
			}
		}
		View v = inflater.inflate(R.layout.command_list_fragment, null);
		return v;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		CommandKind ck=((CommandKindAdapter)getListAdapter()).getItem(position);
		
		Intent intent=new Intent(getActivity(), CommandPagerActivity.class);
		intent.putExtra(CommandFragment.EXTRA_COMMAND_ID, ck.getId());
		startActivity(intent);
	}
	
	private class CommandKindAdapter extends ArrayAdapter<CommandKind> {
		public CommandKindAdapter(ArrayList<CommandKind> kinds) {
			super(getActivity(), 0, kinds);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(
						R.layout.list_item_command, null);
			}
			CommandKind c = getItem(position);
			TextView title = (TextView) convertView
					.findViewById(R.id.command_item_textview);
			ImageView image = (ImageView) convertView
					.findViewById(R.id.command_item_image);
			title.setText(c.getKind());
			image.setImageResource(c.getImage());
			
			return convertView;
		}
	}
}
