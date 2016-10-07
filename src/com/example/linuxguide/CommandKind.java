package com.example.linuxguide;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class CommandKind {
	private int mId;
	private String mKind;
	private int mImage;
	private static ArrayList<CommandKind> kinds;
	private String mLink;

	public CommandKind(int id, String kind,int image,String link) {
		mId = id;
		mKind = kind;
		mImage=image;
		mLink=link;
	}

	

	
	public String getLink() {
		return mLink;
	}




	public void setLink(String link) {
		mLink = link;
	}




	public static void setKinds(ArrayList<CommandKind> kinds) {
		CommandKind.kinds = kinds;
	}




	public int getImage() {
		return mImage;
	}




	public void setImage(int image) {
		mImage = image;
	}




	public int getId() {
		return mId;
	}

	public void setId(int id) {
		mId = id;
	}

	public String getKind() {
		return mKind;
	}

	public void setKind(String kind) {
		mKind = kind;
	}

	public static ArrayList<CommandKind> getKinds() {
		
		CommandKind kind1 = new CommandKind(0, "File Commands",R.drawable.command_file,"http://kaelcao.besaba.com/file_command.php");
		
		CommandKind kind2 = new CommandKind(1, "Compression",R.drawable.command_compression,"http://kaelcao.besaba.com/compression.php");
		CommandKind kind3 = new CommandKind(2, "File Permissions",R.drawable.command_permission,"http://kaelcao.besaba.com/file_permissions.php");
		CommandKind kind4 = new CommandKind(3, "Searching",R.drawable.command_search,"http://kaelcao.besaba.com/searching.php");
		CommandKind kind5 = new CommandKind(4, "FTP",R.drawable.command_ftp,"http://kaelcao.besaba.com/ftp.php");
		CommandKind kind6 = new CommandKind(5, "Installation",R.drawable.command_install,"http://kaelcao.besaba.com/installatino.php");
		CommandKind kind7 = new CommandKind(6, "Network",R.drawable.command_network,"http://kaelcao.besaba.com/Network.php");
		CommandKind kind8 = new CommandKind(7, "Secure Shell SSH",R.drawable.command_ssh,"http://kaelcao.besaba.com/SSH.php");
		CommandKind kind9 = new CommandKind(8, "System Commands",R.drawable.command_system,"http://kaelcao.besaba.com/system.php");
		CommandKind kind10 = new CommandKind(9, "Text Editor",R.drawable.command_text,"http://kaelcao.besaba.com/text.php");
		kinds=new ArrayList<CommandKind>();
		kinds.add(kind1);
		kinds.add(kind2);
		kinds.add(kind3);
		kinds.add(kind4);
		kinds.add(kind5);
		kinds.add(kind6);
		kinds.add(kind7);
		kinds.add(kind8);
		kinds.add(kind9);
		kinds.add(kind10);
		return kinds;
	}
	public static CommandKind get(int id){
		for (CommandKind c : kinds ){
			if (c.getId()==id)
				return c;
		}
		return null;
	}
	

}
