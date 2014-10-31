package com.pcs.sampledemo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.pcs.adapter.CustomAdapter;

@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
public class MainActivity extends Activity {

	private static final String LIST_FRAGMENT_TAG = "list_fragment";
	static final String[] fruits = new String[] { "Apple", "Avocado", "Banana",
		"Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit",
		"Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple" };

	private ListView listView;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		listView=(ListView)findViewById(R.id.listview);
		CustomAdapter adapter=new CustomAdapter(this,fruits);

		listView.setAdapter(adapter);
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
		case R.id.share:item.setIcon(R.drawable.share_img);
		item.setTitle(getResources().getString(R.string.share));
			return true;

		case R.id.add_item:item.setIcon(R.drawable.add_img);
			return true;

		case R.id.other_options:item.setIcon(R.drawable.more_img);
			toggleList();
		return true;

		default: 
			return super.onOptionsItemSelected(item);

		}
	}



	private void toggleList() {


		Fragment fragment = getFragmentManager().findFragmentByTag(LIST_FRAGMENT_TAG);
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
							LIST_FRAGMENT_TAG
							).addToBackStack(null).commit();
		}
	}
}





