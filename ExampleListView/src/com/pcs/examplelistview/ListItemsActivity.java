package com.pcs.examplelistview;

import java.util.ArrayList;


import com.pcs.adapter.CustomAdapter;
import com.pcs.helper.UserDetails;

import android.app.Activity;

import android.os.Bundle;
import android.widget.ListView;


public class ListItemsActivity extends Activity{
	UserDetails userobj;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.items);
		
		ListView listView = (ListView)findViewById(R.id.items_list);
		
		ArrayList<UserDetails> userList = new ArrayList<UserDetails>();
		CustomAdapter adapter = new CustomAdapter(ListItemsActivity.this, userList);
		
		
	
		
		
		listView.setAdapter(adapter);
		
	}

}
