package com.chapslife.philly.traffic.utils;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class AABDatabaseManager
{
	private SQLiteDatabase db; // a reference to the database manager class.
	private final String DB_NAME = "trafficDB2"; // the name of our database
	private final int DB_VERSION = 1; // the version of the database
 
	// the names for our database columns
	private final String TABLE_NAME = "favorites";
	private final String TABLE_ROW_ID = "id";
	private final String TABLE_ROW_ONE = "URL";
	private final String TABLE_ROW_TWO = "title";
	private final String TABLE_ROW_THREE = "delay";
	private final String TABLE_ROW_FOUR = "state";
	
	Context context;
	
	public AABDatabaseManager(Context context)
	{
		this.context = context;
 
		// create or open the database
		CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);
		this.db = helper.getWritableDatabase();
	}
	
	 //---closes the database---    
    public void close() 
    {
    	db.close();
    }
    
	public void addRow(String rowStringOne, String rowStringTwo, int rowStringThree, String rowStringFour)
	{
		// this is a key value pair holder used by android's SQLite functions
		ContentValues values = new ContentValues();
	 
		// this is how you add a value to a ContentValues object
		// we are passing in a key string and a value string each time
		values.put(TABLE_ROW_ONE, rowStringOne);
		values.put(TABLE_ROW_TWO, rowStringTwo);
		values.put(TABLE_ROW_THREE, rowStringThree);
		values.put(TABLE_ROW_FOUR, rowStringFour);
		
		// ask the database object to insert the new data 
		try
		{
			db.insert(TABLE_NAME, null, values);
		}
		catch(Exception e)
		{
			Log.e("DB ERROR", e.toString()); // prints the error message to the log
			e.printStackTrace(); // prints the stack trace to the log
		}
	}
	
	public void deleteRow(long rowID)
	{
		// ask the database manager to delete the row of given id
		try
		{
		    db.delete(TABLE_NAME, TABLE_ROW_ID + "=" + rowID, null);
	    }
		catch (Exception e)
		{
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
	}
	
	public void updateRow(long rowID, String rowStringOne, String rowStringTwo, int rowStringThree, String rowStringFour)
	{
		// this is a key value pair holder used by android's SQLite functions
		ContentValues values = new ContentValues();
		
		values.put(TABLE_ROW_ONE, rowStringOne);
		values.put(TABLE_ROW_TWO, rowStringTwo);
		values.put(TABLE_ROW_THREE, rowStringThree);
		values.put(TABLE_ROW_FOUR, rowStringFour);
		
		// ask the database object to update the database row of given rowID
		try {db.update(TABLE_NAME, values, TABLE_ROW_ID + "=" + rowID, null);}
		catch (Exception e)
		{
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		}
	}
	
	/**********************************************************************
	 * RETRIEVING ALL ROWS FROM THE DATABASE TABLE
	 * 
	 * This is an example of how to retrieve all data from a database
	 * table using this class.  You should edit this method to suit your
	 * needs.
	 * 
	 * the key is automatically assigned by the database
	 */
	public ArrayList<ArrayList<Object>> getAllRowsAsArrays()
	{
		// create an ArrayList that will hold all of the data collected from
		// the database.
		ArrayList<ArrayList<Object>> dataArrays =
			new ArrayList<ArrayList<Object>>();
	 
		// this is a database call that creates a "cursor" object.
		// the cursor object store the information collected from the
		// database and is used to iterate through the data.
		Cursor cursor;
	 
		try
		{
			// ask the database object to create the cursor.
			cursor = db.query(
					TABLE_NAME,
					new String[]{TABLE_ROW_ID, TABLE_ROW_ONE, TABLE_ROW_TWO, TABLE_ROW_THREE, TABLE_ROW_FOUR },
					null, null, null, null, null
			);
	 
			// move the cursor's pointer to position zero.
			cursor.moveToFirst();
	 
			// if there is data after the current cursor position, add it
			// to the ArrayList.
			if (!cursor.isAfterLast())
			{
				do
				{
					ArrayList<Object> dataList = new ArrayList<Object>();
	 
					dataList.add(cursor.getLong(0));
					dataList.add(cursor.getString(1));
					dataList.add(cursor.getString(2));
					dataList.add(cursor.getString(3));
					dataList.add(cursor.getString(4));
					
					dataArrays.add(dataList);
				}
				// move the cursor's pointer up one position.
				while (cursor.moveToNext());
			}
			// let java know that you are through with the cursor.
			cursor.close();
		}
		catch (SQLException e)
		{
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		}
		
		
		// return the ArrayList that holds the data collected from
		// the database.
		return dataArrays;
	}
	 
	 
	 
	 
	/**********************************************************************
	 * RETRIEVING A ROW FROM THE DATABASE TABLE
	 * 
	 * This is an example of how to retrieve a row from a database table
	 * using this class.  You should edit this method to suit your needs.
	 * 
	 * @param rowID the id of the row to retrieve
	 * @return an array containing the data from the row
	 */
	public ArrayList<Object> getRowAsArray(long rowID)
	{
		// create an array list to store data from the database row.
		// I would recommend creating a JavaBean compliant object 
		// to store this data instead.  That way you can ensure
		// data types are correct.
		ArrayList<Object> rowArray = new ArrayList<Object>();
		Cursor cursor;
	 
		try
		{
			// this is a database call that creates a "cursor" object.
			// the cursor object store the information collected from the
			// database and is used to iterate through the data.
			cursor = db.query
			(
					TABLE_NAME,
					new String[] { TABLE_ROW_ID, TABLE_ROW_ONE, TABLE_ROW_TWO, TABLE_ROW_THREE, TABLE_ROW_FOUR },
					TABLE_ROW_ID + "=" + rowID,
					null, null, null, null, null
			);
	 
			// move the pointer to position zero in the cursor.
			cursor.moveToFirst();
	 
			// if there is data available after the cursor's pointer, add
			// it to the ArrayList that will be returned by the method.
			if (!cursor.isAfterLast())
			{
				do
				{
					rowArray.add(cursor.getLong(0));
					rowArray.add(cursor.getString(1));
					rowArray.add(cursor.getString(2));
					rowArray.add(cursor.getInt(3));
					rowArray.add(cursor.getString(4));
				}
				while (cursor.moveToNext());
			}
	 
			// let java know that you are through with the cursor.
			cursor.close();
		}
		catch (SQLException e) 
		{
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
	 
		// return the ArrayList containing the given row from the database.
		return rowArray;
	}
    // TODO: write the constructor and methods for this class
 
	// the beginnings our SQLiteOpenHelper class
	private class CustomSQLiteOpenHelper extends SQLiteOpenHelper
	{

		public CustomSQLiteOpenHelper(Context context) {
			
			super(context, DB_NAME, null, DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			
			// the SQLite query string that will create our 4 column database table.
			String newTableQueryString = 	
				"create table " +
				TABLE_NAME +
				" (" +
				TABLE_ROW_ID + " integer primary key autoincrement not null," +
				TABLE_ROW_ONE + " text," +
				TABLE_ROW_TWO + " text," +
				TABLE_ROW_THREE + " integer," +
				TABLE_ROW_FOUR + " text" +
				");";
		 
			// execute the query string to the database.
			db.execSQL(newTableQueryString);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
	}
}