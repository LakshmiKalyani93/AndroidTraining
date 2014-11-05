package com.pcs.customtoastdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.pcs.adapter.CustomAdapter;

public class MainActivity extends Activity{
	static final String[] user_data = new String[] { "Avinash Chowdary", "Anitha Gorli", "Harish Sharma",
		"Sailika Ethalapaka", "Dharma Sai", "Lakshmi Kalyani", "Keerthi Sami Reddy", "Anusha malineni",
		"Naveen Santhosh", "Sri Ram Kiran", "Sri Ramana", "Kanteswari", "Sunanada Padala","Priyanka","Pavitra Gurram","Pavani Gayatri","Mohana Allam","Vasu Dev Rao","Hari Krishna","Vamsi" };

	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		listView=(ListView)findViewById(R.id.listview);

		CustomAdapter adapter=new CustomAdapter(this, user_data);

		listView.setAdapter(adapter);

	}

}
