package com.pcs.contentproviderdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

	@SuppressLint("NewApi")
	public DBHelper(Context context) {
		super(context, ContactContrast.DATABASE_NAME, null, ContactContrast.VERSION, null);
	}
	public class ContactContrast{
		public static final int VERSION=1;
		public static final String _ID ="_id";
		public static final String DATABASE_NAME="ContactsDB";
		public static final String TABLE_NAME="Contacts";
		public static final String CONTACT_NAME="ContactName";
		public static final String EMAIL="Email";
		public static final String PHONE_TYPE="PhoneType";
		public static final String PHONE_NUMBER="PhoneNumber";
		public static final String CREATE_TABLE="create table "
				+TABLE_NAME
				+"(_id integer primary key autoincrement, "
				+CONTACT_NAME
				+" text, "
				+EMAIL
				+" text not null, "
				+PHONE_TYPE
				+" text, "
				+PHONE_NUMBER
				+" integer not null);";

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(ContactContrast.CREATE_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql="drop table if exists "+ContactContrast.TABLE_NAME;
		db.execSQL(sql);
		onCreate(db);

	}

}
