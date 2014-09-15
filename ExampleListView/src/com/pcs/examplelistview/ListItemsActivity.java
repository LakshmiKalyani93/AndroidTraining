package com.pcs.examplelistview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.pcs.adapter.CustomAdapter;
import com.pcs.helper.UserDetails;


public class ListItemsActivity extends Activity{
	UserDetails userobj;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.items);
		
		ListView listView = (ListView)findViewById(R.id.items_list);
		
		ArrayList<UserDetails> userList = new ArrayList<UserDetails>();
		CustomAdapter adapter = new CustomAdapter(ListItemsActivity.this, userList);
		
		
		userobj = new UserDetails();

		userobj.setCustomername("kalyani");
		userobj.setCustomerid("pcs232");
		userobj.setAccountnumber("12345");
		userobj.setEmail("kalyani@pcs.com");
		userList.add(userobj);

		userobj = new UserDetails();
		userobj.setCustomername("anitha");
		userobj.setCustomerid("pcs233");
		userobj.setAccountnumber("24536");
		userobj.setEmail("anitha@pcs.com");
		userList.add(userobj);

		userobj = new UserDetails();
		userobj.setCustomername("harish");
		userobj.setCustomerid("pcs234");
		userobj.setAccountnumber("126845");
		userobj.setEmail("harish@pcs.com");
		userList.add(userobj);

		userobj = new UserDetails();
		userobj.setCustomername("dharma");
		userobj.setCustomerid("pcs235");
		userobj.setAccountnumber("1245345");
		userobj.setEmail("dharma@pcs.com");
		userList.add(userobj);
		
		userobj = new UserDetails();
		userobj.setCustomername("sailika");
		userobj.setCustomerid("pcs236");
		userobj.setAccountnumber("124523345");
		userobj.setEmail("sailika@pcs.com");
		userList.add(userobj);
		
		userobj = new UserDetails();
		userobj.setCustomername("avinash");
		userobj.setCustomerid("pcs237");
		userobj.setAccountnumber("12455345345");
		userobj.setEmail("avinash@pcs.com");
		userList.add(userobj);
	
		listView.setAdapter(adapter);
		
	}

}
