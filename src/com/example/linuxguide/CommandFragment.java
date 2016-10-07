package com.example.linuxguide;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class CommandFragment extends ListFragment {
	private CommandKind mCommandKind;
	private Command mCommands;
	private String mURL;

	private ArrayList<Command> mCommandlist;

	public static final String EXTRA_COMMAND_ID = "com.example.linuxguide.command_id";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		int Id = getArguments().getInt(EXTRA_COMMAND_ID);
		mCommandKind = CommandKind.get(Id);
		mURL=mCommandKind.getLink();
		mConnectInternet.start();
		
		setHasOptionsMenu(true);

	}

	Thread mConnectInternet = new Thread(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			HttpURLConnection urlConnection = null;
			 
			try {
				URL url = new URL(mURL);
				urlConnection = (HttpURLConnection) url.openConnection();
				InputStream in = new BufferedInputStream(
						urlConnection.getInputStream());
				readStream(in);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (urlConnection != null) {
					urlConnection.disconnect();
					
				}
			}

		}
	});

	private void readStream(InputStream in){
		try{
			final BufferedReader rd= new BufferedReader(new InputStreamReader(in));
			String line;
			final StringBuffer response=new StringBuffer();
			while ((line=rd.readLine())!=null){
				response.append(line);
				response.append('\r');
				
			}
			rd.close();
			
			//goi luong chinh ra de set du lieu tren UI 
			getActivity().runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					ArrayList<Command> listCommand=docDuLieuJSON(response.toString());
					CommandAdapter adapter=new CommandAdapter(listCommand, getActivity());
					setListAdapter(adapter);
				}
			});
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	private ArrayList<Command> docDuLieuJSON(String jsonStr){
		ArrayList<Command> listCommand=new ArrayList<Command>();
		try {
			JSONObject parentJSON=new JSONObject(jsonStr);
			JSONArray listChild=parentJSON.getJSONArray("Android");
			for (int i=0;i<listChild.length();i++){
				Command command=new Command();
				command.setId(Integer.parseInt(listChild.getJSONObject(i).get("id").toString()));
				command.setTitle(listChild.getJSONObject(i).get("title").toString());
				command.setSubtitle(listChild.getJSONObject(i).get("subtitle").toString());
				listCommand.add(command);
			}
		}catch (JSONException e){
			e.printStackTrace();
		}
		return listCommand;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			if (NavUtils.getParentActivityName(getActivity()) != null) {
				NavUtils.navigateUpFromSameTask(getActivity());
			}
		}
		return super.onOptionsItemSelected(item);
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.command_list_fragment, null);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			if (NavUtils.getParentActivityName(getActivity()) != null) {
				getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
			}
		}
		return v;
	}

	public static CommandFragment newInstance(int commandKindid) {
		Bundle args = new Bundle();
		args.putInt(EXTRA_COMMAND_ID, commandKindid);
		CommandFragment fragment = new CommandFragment();
		fragment.setArguments(args);
		return fragment;
	}

}
