package com.pcs.databasedemoapplication;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.pcs.adapters.CustomListAdapter;
import com.pcs.databasedemoapplication.DBHelper.PersonDetailsContrast;
import com.pcs.model.PersonDetails;

public class DataDisplayActivity extends Activity{

	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datadisplay);

		listView = (ListView)findViewById(R.id.listview);
		
		
		ArrayList<PersonDetails> personList = new ArrayList<PersonDetails>();
		DBHelper db=new DBHelper(DataDisplayActivity.this);
		SQLiteDatabase sqlitedb=db.getReadableDatabase();
		Cursor mCursor =sqlitedb.rawQuery("select * from  "+PersonDetailsContrast.TABLE_NAME, null);
		CustomListAdapter adapter = new CustomListAdapter(DataDisplayActivity.this, personList);
		
		if(mCursor.moveToFirst())
		{
			do{
				PersonDetails person = new PersonDetails(getBaseContext());
				person.setUserName(mCursor.getString((mCursor.getColumnIndex(PersonDetailsContrast.PERSON_NAME))));
				person.setEmail(mCursor.getString((mCursor.getColumnIndex(PersonDetailsContrast.PERSON_EMAIL))));
				person.setPassword(mCursor.getString((mCursor.getColumnIndex(PersonDetailsContrast.PERSON_PASSWORD))));
				personList.add(person);
					
			}while(mCursor.moveToNext());	
		}
		listView.setAdapter(adapter);	
	}
		
}
