package com.pcs.sampledemo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.pcs.adapter.CustomAdapter;

@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
public class MainActivity extends Activity{

	static final String[] fruits = new String[] { "Apple", "Avocado", "Banana",
		"Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit",
		"Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple","Cherry","Date","Papaya","Peach","Pine Apple","Mulberry","Plum" };

	private ListView listView;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.main);
		listView=(ListView)findViewById(R.id.listview);
		CustomAdapter adapter=new CustomAdapter(this,fruits);
		View header = (View)getLayoutInflater().inflate(R.layout.list_view_item, null);
		listView.addHeaderView(header);
		listView.setAdapter(adapter);

		ActionBar actionBar = getActionBar();  

		LayoutInflater mInflater = LayoutInflater.from(this);
		View mCustomView = mInflater.inflate(R.layout.actionbar_top, null);
		ImageButton imageButton = (ImageButton) mCustomView
				.findViewById(R.id.slide_drawer_btn);
		imageButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), getResources().getString(R.string.app_name), Toast.LENGTH_LONG).show();			
			}
		});

		actionBar.setCustomView(mCustomView);
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_SHOW_CUSTOM);
		actionBar.setDisplayShowCustomEnabled(true);	
		actionBar.setDisplayShowTitleEnabled(false);
	

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	@SuppressLint("NewApi")
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		item.setEnabled(true);
		int v=item.getItemId();
		switch (v) {
		case R.id.share:
			Toast.makeText(getApplicationContext(), getResources().getString(R.string.share), Toast.LENGTH_LONG).show();
			return true;
		case R.id.add_item:
			Toast.makeText(getApplicationContext(), getResources().getString(R.string.add_item), Toast.LENGTH_LONG).show();
			return true;
		case R.id.other_options:
			item.setIcon(R.drawable.more_img);
			toggleList();
			return true;
		default: 
			return super.onOptionsItemSelected(item);
		}
	}

	private void toggleList() {
		Fragment fragment = getFragmentManager().findFragmentByTag(com.pcs.helper.Constants.KeyExtras.LIST_FRAGMENT_TAG);
		if (fragment != null) {
			getFragmentManager().popBackStack();
		} else {
			getFragmentManager().beginTransaction()
			.setCustomAnimations(R.anim.slideup,
					R.anim.slidedown,
					R.anim.slideup,
					R.anim.slidedown)
					.add(R.id.list_fragment_container, SlidingListFragment
							.instantiate(this, SlidingListFragment.class.getName()),
							com.pcs.helper.Constants.KeyExtras.LIST_FRAGMENT_TAG
							).addToBackStack(null).commit();
		}
	}

}






