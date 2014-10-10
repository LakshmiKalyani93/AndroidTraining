package com.pcs.retrievecontactsdemo;




import Helper.Helper;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class RetrieveContactsActivity extends Activity implements OnClickListener{
	private ListView listView;
	private Button deleteContacts;
	ContentResolver resolver;
	Uri uri;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.retrieve);

		listView = (ListView)findViewById(R.id.listview);
		deleteContacts=(Button)findViewById(R.id.deleteContact_btn);
		deleteContacts.setOnClickListener(this);
		String action = getIntent().getAction();
		if(action.equals(Helper.KeyExtras.ACTION_NAME))
		{

			ContentResolver resolver=getContentResolver();
			Uri uri = Uri.parse("content://com.pcs.contentproviderdemo.ContactsProvider/contacts");

			Cursor cursor = resolver.query(uri, null, null,null,null);
			while(cursor.moveToNext())
			{
				@SuppressWarnings("deprecation")
				SimpleCursorAdapter adapter= new SimpleCursorAdapter(RetrieveContactsActivity.this, R.layout.custom, cursor, 
						new String[]{"ContactName","Email","PhoneType","PhoneNumber"},
						new int[]{R.id.name_txt,R.id.email_txt,R.id.phoneType_txt,R.id.phone_txt});
				listView.setAdapter(adapter);
			}
		}

	}
	@Override
	public void onClick(View v) {

		resolver = getContentResolver();
		uri = Uri.parse("content://com.pcs.contentproviderdemo.ContactsProvider/contacts");
		resolver.delete(uri, null, null);
		Toast.makeText(RetrieveContactsActivity.this, getResources().getString(R.string.delete_msg), Toast.LENGTH_LONG).show();

	}

}
