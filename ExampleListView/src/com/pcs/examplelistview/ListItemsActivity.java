package com.pcs.examplelistview;

import java.util.ArrayList;

import com.example.examplelistview.R;
import com.pcs.adapter.CustomAdapter;
import com.pcs.helper.UserDetails;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;


public class ListItemsActivity extends ListActivity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.items);
		
		ListView listView = (ListView)findViewById(R.id.items_list);
		
		ArrayList<UserDetails> userList = new ArrayList<UserDetails>();
		CustomAdapter adapter = new CustomAdapter(ListItemsActivity.this, userList);
		
		listView.setAdapter(adapter);
		
		UserDetails userobj = new UserDetails();
		userobj.setCustomername("kalyani");
		userobj.setCustomerid("pcs232");
		userobj.setAccountnumber("12345");
		userobj.setEmail("kalyani@pcs.com");
		
		
		
		
		
		
	}

}
