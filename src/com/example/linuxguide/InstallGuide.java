package com.example.linuxguide;

import java.util.ArrayList;

public class InstallGuide {
	private long mId;
	private String mTitle;

	public InstallGuide(long id, String title) {
		mId=id;
		mTitle=title;
	}

	public long getId() {
		return mId;
	}

	public void setId(long id) {
		this.mId = id;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		this.mTitle = title;
	}
	public static ArrayList<InstallGuide> getGuides(){
		ArrayList<InstallGuide> guides=new ArrayList<InstallGuide>();
		guides.add(new InstallGuide(0, "Ubuntu 13.04"));
		guides.add(new InstallGuide(1, "Ubuntu 13.10"));
		guides.add(new InstallGuide(2, "Debian"));
		guides.add(new InstallGuide(3, "Debian Testing"));
		guides.add(new InstallGuide(4, "ArchLinux"));
		guides.add(new InstallGuide(5, "KaliLinux"));
		guides.add(new InstallGuide(6, "Fedora 19"));
		guides.add(new InstallGuide(7, "openSUSE 12.3"));
		return guides;
	}
}
