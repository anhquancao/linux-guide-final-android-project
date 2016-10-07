package com.example.linuxguide;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CommandDataHandler {
	private SQLiteDatabase database;
	private CommandDatabaseHelper dbHelper;
	private String[] allColumns = { CommandDatabaseHelper.COLUMN_COMMAND_ID,
			CommandDatabaseHelper.COLUMN_COMMAND_TITLE,
			CommandDatabaseHelper.COLUMN_STUDENT_SUBTITLE };

	public CommandDataHandler(Context c) {
		dbHelper = new CommandDatabaseHelper(c);
	}

	public void open() {
		database = dbHelper.getWritableDatabase();

	}
	public void close(){
		dbHelper.close();
	}

	public long insertCommand(Command command) {
		ContentValues values = new ContentValues();
		values.put(CommandDatabaseHelper.COLUMN_COMMAND_TITLE,
				command.getTitle());
		values.put(CommandDatabaseHelper.COLUMN_STUDENT_SUBTITLE,
				command.getSubtitle());
		long insertId = database.insert(CommandDatabaseHelper.TABLE_COMMAND,
				null, values);
		return insertId;
	}

	public void updateCommand(Command command) {
		ContentValues values = new ContentValues();
		values.put(CommandDatabaseHelper.COLUMN_COMMAND_TITLE,
				command.getTitle());
		values.put(CommandDatabaseHelper.COLUMN_STUDENT_SUBTITLE,
				command.getSubtitle());

		String whereClause = CommandDatabaseHelper.COLUMN_COMMAND_ID + " = ? ";
		String[] whereArgs = new String[] { String.valueOf(command.getId()) };
		database.update(CommandDatabaseHelper.TABLE_COMMAND, values,
				whereClause, whereArgs);

	}

	public void deleteCommand(Command command) {
		long id = command.getId();
		database.delete(CommandDatabaseHelper.TABLE_COMMAND,
				CommandDatabaseHelper.COLUMN_COMMAND_ID + " = " + id, null);
	}

	public ArrayList<Command> getAllCommands() {
		ArrayList<Command> commands = new ArrayList<Command>();

		Cursor cursor = database.query(CommandDatabaseHelper.TABLE_COMMAND,
				allColumns, null, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Command command = cursorToCommand(cursor);
			commands.add(command);
			cursor.moveToNext();
		}
		cursor.close();
		return commands;
	}

	private Command cursorToCommand(Cursor cursor) {
		// TODO Auto-generated method stub
		Command command = new Command();
		command.setId(cursor.getInt(cursor
				.getColumnIndex(CommandDatabaseHelper.COLUMN_COMMAND_ID)));
		command.setTitle(cursor.getString(cursor
				.getColumnIndex(CommandDatabaseHelper.COLUMN_COMMAND_TITLE)));
		command.setSubtitle(cursor.getString(cursor
				.getColumnIndex(CommandDatabaseHelper.COLUMN_STUDENT_SUBTITLE)));
		return command;
	}
}
