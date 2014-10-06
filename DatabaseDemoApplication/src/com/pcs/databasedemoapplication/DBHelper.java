package com.pcs.databasedemoapplication;

import com.pcs.model.PersonDetails;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	private SQLiteDatabase sqlitedb;
	public DBHelper(Context context) {
		super(context, PersonDetailsContrast.DATABASE_NAME, null,
				PersonDetailsContrast.VERSION);
	}

	public static class PersonDetailsContrast {
		public static final int VERSION = 4;
		public static final String DATABASE_NAME = "Persons";
		public static final String TABLE_NAME = "Persons_Table";
		public static final String PERSON_ID = "_id";
		public static final String PERSON_NAME = "PersonName";
		public static final String PERSON_EMAIL = "PersonEmail";
		public static final String PERSON_PASSWORD = "PersonPassword";
		public static final String PERSON_DETAILS_CREATE_TABLE = "create table "
				+ TABLE_NAME
				+ "("
				+ PERSON_ID
				+ " integer,"
				+ PERSON_NAME
				+ "  text not null,"
				+ PERSON_EMAIL
				+ "  text not null,"
				+ PERSON_PASSWORD + " text not null)";

	}

	public void onCreate(SQLiteDatabase db) {
		db.execSQL(PersonDetailsContrast.PERSON_DETAILS_CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		String drop = "drop table if exists  " + PersonDetailsContrast.TABLE_NAME;
		db.execSQL(drop);
		onCreate(db);	
	}

	public long addPerson(PersonDetails person) {
		sqlitedb = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(PersonDetailsContrast.PERSON_NAME, person.getUserName());
		values.put(PersonDetailsContrast.PERSON_EMAIL, person.getEmail());
		values.put(PersonDetailsContrast.PERSON_PASSWORD, person.getPassword());
		long result= sqlitedb.insert(PersonDetailsContrast.TABLE_NAME, null, values);
		sqlitedb.close();
		return result;
	}

}
