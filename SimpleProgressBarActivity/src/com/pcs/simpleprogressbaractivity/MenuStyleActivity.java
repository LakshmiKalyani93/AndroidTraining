package com.pcs.simpleprogressbaractivity;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MenuStyleActivity extends Activity{

	private Button addContactsBtn;
	private EditText nameEdt;
	private EditText phnEdt;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		//getting a reference to button addContactsBtn of the layout menu
		addContactsBtn = (Button)findViewById(R.id.add_btn);

		// Getting a reference to EditText of the layout menu
		nameEdt = (EditText)findViewById(R.id.name_edt);
		phnEdt = (EditText)findViewById(R.id.phn_edt);
		//registering the addContactBtn to the ContextMenu
		registerForContextMenu(addContactsBtn);

	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menustyle, menu);

	}



	@Override
	public boolean onContextItemSelected(MenuItem item) {
		String call = phnEdt.getText().toString();	
		String person = nameEdt.getText().toString();	
		
		//validating the fields for the null values if any are present

		if(TextUtils.isEmpty(person)||TextUtils.isEmpty(call))
		{
			Toast.makeText(this, getResources().getString(R.string.null_msg), Toast.LENGTH_LONG).show();
		}
		
		//retrieves the id's for each item based on selection and performs the relavant action

		switch(item.getItemId())
		{

		case R.id.item_call: 
			Intent intent = new Intent(Intent.ACTION_CALL);

			intent.setData(Uri.parse("tel:"+call ));
			startActivity(intent);

			break;
		case R.id.item_sms:
			Intent sms_intent=new Intent();
			sms_intent.setAction(android.content.Intent.ACTION_VIEW);
			sms_intent.setData(Uri.parse("smsto:"+call));
			startActivity(sms_intent);
			break;
		case R.id.item_update:
			break;
		case R.id.item_existing:
			Toast.makeText(this, getResources().getString(R.string.existing_msg)+"\n"+person+"\n"+call, Toast.LENGTH_LONG).show();
			finish();
			break;
		case R.id.item_new:
			Toast.makeText(this, getResources().getString(R.string.new_msg)+"\n"+person+"\n"+call, Toast.LENGTH_LONG).show();
			finish();

			break;
		default:
			break;


		}

		return super.onContextItemSelected(item);
	}

}
