package com.example.linuxguide;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CommandAdapter extends ArrayAdapter<Command> {
	private Context mContext;

	public CommandAdapter(ArrayList<Command> commands, Context c) {
		super(c, 0, commands);
		mContext = c;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = ((Activity) mContext).getLayoutInflater().inflate(
					R.layout.command_item, null);
		}
		Command c=getItem(position);
		
		TextView title=(TextView) convertView.findViewById(R.id.command_item_title);
		TextView subtitle=(TextView) convertView.findViewById(R.id.command_item_subtitle);
		title.setText(c.getTitle());
		subtitle.setText(c.getSubtitle());
		return convertView;
	}
}
