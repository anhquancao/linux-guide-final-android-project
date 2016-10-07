package com.example.linuxguide;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CommandDatabaseHelper extends SQLiteOpenHelper {
	public static final String DB_NAME="db_command.sqlite";
	public static final int VERSION=1;
	
	public static final String TABLE_COMMAND="command";
	public static final String COLUMN_COMMAND_ID="id";
	public static final String COLUMN_COMMAND_TITLE="title";
	public static final String COLUMN_STUDENT_SUBTITLE="subtitle";
	
	private static final String TABLE_CREATE = "CREATE TABLE " + TABLE_COMMAND
			+ " (" + COLUMN_COMMAND_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT , "
			+ COLUMN_COMMAND_TITLE + " TEXT NOT NULL , " + COLUMN_STUDENT_SUBTITLE
			+ " TEXT NOT NULL )";
	public CommandDatabaseHelper(Context context){
		super (context,DB_NAME,null,VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		try {
			db.execSQL(TABLE_CREATE);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
