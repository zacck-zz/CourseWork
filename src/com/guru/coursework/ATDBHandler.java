package com.guru.coursework;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ToggleButton;

public class ATDBHandler extends SQLiteOpenHelper {
	private static String DBName = "courseDB";
	private static int DBVer = 1;

	// the Messages table name and fields
	private static final String TABLE_MESSAGES = "tbl_messages";

	// the table columns
	private static final String KEY_TIME = "time";
	private static final String KEY_MESSAGE = "message";
	private static final String KEY_TO = "to_id";
	private static final String KEY_FROM = "from_id";

	public ATDBHandler(Context ctx) {
		super(ctx, DBName, null, DBVer);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// lets write the string query that will make the table
		String CREATE_MESSAGES = "CREATE TABLE " + TABLE_MESSAGES + " ("
				+ KEY_FROM + " TEXT, " + KEY_MESSAGE + " TEXT, " + KEY_TIME
				+ " TEXT, " + KEY_TIME + " TEXT )";
		// we can execute the sql query we just wrote to actually create the
		// tables in the database
		db.execSQL(CREATE_MESSAGES);

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}

	// insert message
	public void addMessage(Message msg) {
		// initialize a database instance we can write into
		SQLiteDatabase db = this.getWritableDatabase();
		// content values for loading
		ContentValues MsgValues = new ContentValues();
		MsgValues.put(KEY_FROM, msg.getFrom());
		MsgValues.put(KEY_MESSAGE, msg.getMessaage());
		MsgValues.put(KEY_TIME, msg.getTime());
		MsgValues.put(KEY_TO, msg.getTO());

		// now lets insert this into the database
		db.insert(TABLE_MESSAGES, null, MsgValues);
		db.close();
	}

	public List<Message> getAllMessages() {
		// initialize a list of messages that we will return
		List<Message> allMsgs = new ArrayList<Message>();

		// the query to select all messages
		String selectMessages = "SELECT * FROM " + TABLE_MESSAGES;
		
		//lets Run the query 
		SQLiteDatabase db = this.getWritableDatabase();
		//get all messages in a cursor(collection of results )
		Cursor msgCursor = db.rawQuery(selectMessages, null);
		
		//lets loop through the cursor while adding to the list 
		if(msgCursor.moveToFirst())
		{
			do
			{
				Message msg = new Message();
				msg.setFrom(msgCursor.getString(msgCursor.getColumnIndex(KEY_FROM)));
				msg.setMsg(msgCursor.getString(msgCursor.getColumnIndex(KEY_MESSAGE)));
				msg.setTime(msgCursor.getString(msgCursor.getColumnIndex(KEY_TIME)));
				msg.setTo(msgCursor.getString(msgCursor.getColumnIndex(KEY_TO)));
				//add message to list 
				allMsgs.add(msg);
				
			}while(msgCursor.moveToNext());
		}
		
		return allMsgs;

	}

}
