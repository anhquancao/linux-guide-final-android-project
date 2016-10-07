package com.example.linuxguide;

import java.util.ArrayList;

public class Command {
	private String mTitle;
	private String mSubtitle;
	private int mId;
	private CommandDataHandler mHandler;

	public Command(String title,String subtitle,int id){
		mId=id;
		mTitle=title;
		mSubtitle=subtitle;
	}

	public Command() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		mTitle = title;
	}

	public String getSubtitle() {
		return mSubtitle;
	}

	public void setSubtitle(String subtitle) {
		mSubtitle = subtitle;
	}

	public int getId() {
		return mId;
	}

	public void setId(int id) {
		mId = id;
	}

	public static ArrayList<Command> getCommands() {
		ArrayList<Command> commands = new ArrayList<Command>();
		Command command1=new Command("Hello world","Hello world",0);
		Command command2=new Command("Hello world","Hello world",1);
		Command command3=new Command("Hello world","Hello world",2);
		Command command4=new Command("Hello world","Hello world",3);
		commands.add(command1);
		commands.add(command2);
		commands.add(command3);
		commands.add(command4);
		return commands;
	}
	

}
