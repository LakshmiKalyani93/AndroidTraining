package com.pcs.simpleprogressbaractivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MenuStyleActivity extends Activity{
	
	private Button addContactsBtn;
	private EditText nameEdt;
	private EditText phnEdt;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		addContactsBtn = (Button)findViewById(R.id.add_btn);
		
		nameEdt = (EditText)findViewById(R.id.name_edt);
		phnEdt = (EditText)findViewById(R.id.phn_edt);
		
		registerForContextMenu(addContactsBtn);
	
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		
		 getMenuInflater().inflate(R.menu.menustyle, menu);
		
		
	}

}
