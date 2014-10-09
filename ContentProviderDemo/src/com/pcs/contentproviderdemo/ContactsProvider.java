package com.pcs.contentproviderdemo;

import java.util.HashMap;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import com.pcs.contentproviderdemo.DBHelper.ContactContrast;
import com.pcs.helper.Helper;

public class ContactsProvider extends ContentProvider {

	SQLiteDatabase sqliteDb;

	public static final Uri CONTENT_URI =Uri.parse(Helper.KeyExtras.URL);
	public static final int  uriCode =1;
	static final UriMatcher uriMatcher ;
	private static HashMap<String,String> HASH_VALUE;

	static{
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(Helper.KeyExtras.PROVIDER_NAME, "contacts", uriCode);
		uriMatcher.addURI(Helper.KeyExtras.PROVIDER_NAME, "contacts/#",uriCode);
	}


	@SuppressWarnings("unused")
	@Override
	public boolean onCreate() {
		Context context=getContext();
		DBHelper dbHelper = new DBHelper(context);
		sqliteDb = dbHelper.getWritableDatabase();
		if(dbHelper!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder queryBulder = new SQLiteQueryBuilder();
		queryBulder.setTables(ContactContrast.TABLE_NAME);
		switch(uriMatcher.match(uri)){
		case uriCode:
			queryBulder.setProjectionMap(HASH_VALUE);
			break;
		default:
			throw new IllegalAccessError("Unknown URI : "+uri);

		}
		if(sortOrder==null || sortOrder=="")
		{
			sortOrder=ContactContrast._ID;
		}
		Cursor cursor = queryBulder.query(sqliteDb, projection, selection, selectionArgs, null,null, sortOrder);
		cursor.setNotificationUri(getContext().getContentResolver(), uri);
		return cursor;
	}

	@Override
	public String getType(Uri uri) {
		switch (uriMatcher.match(uri)) {
		  case uriCode:
		   return "vnd.android.cursor.dir/contacts";

		  default:
		   throw new IllegalArgumentException("Unsupported URI: " + uri);
		  }
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {

		long rowID = sqliteDb.insert(ContactContrast.TABLE_NAME, null, values);
		if (rowID > 0) {
			Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
			getContext().getContentResolver().notifyChange(_uri, null);
			return _uri;
		}
		throw new SQLException("Failed to add a record into : " + uri);
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int count = 0;
		  switch (uriMatcher.match(uri)) {
		  case uriCode:
		   count = sqliteDb.delete(ContactContrast.TABLE_NAME, selection, selectionArgs);
		   break;
		  default:
		   throw new IllegalArgumentException("Unknown URI " + uri);
		  }
		  getContext().getContentResolver().notifyChange(uri, null);
		  return count;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int count = 0;
		switch (uriMatcher.match(uri)) {
		case uriCode:
			count = sqliteDb.update(ContactContrast.TABLE_NAME, values, selection, selectionArgs);
			break;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return count;
	}

}
