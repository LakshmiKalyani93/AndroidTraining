package com.example.whirlpool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.adapter.ExpandableListAdapter;
public class ShoppersListActivity extends Activity{

	private DrawerLayout mDrawerLayout;
	private ExpandableListView expandableListView;
	private HashMap<String, List<String>> children;
	private ExpandableListAdapter expandableListAdapter;
	private List<String> parents;
	
	/*Creating an application that shows the slide drawer implementation from right to left 
	 * and displays a listview in the background
	 * allows a bottom to top animation for a fragment layout that shows listview 
	 * @Author kalyani pcs-232*/

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shopper_list);
		
		//loading the fragment....
		Fragment fragment = new ListFragment(ShoppersListActivity.this);
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction()
		.replace(R.id.content_frame, fragment).commit();

		ActionBar actionBar = getActionBar();  
		LayoutInflater mInflater = LayoutInflater.from(this);
		//inflating the view...
		View mCustomView = mInflater.inflate(R.layout.actionbar_top, null);
		ImageButton imageButton = (ImageButton) mCustomView
				.findViewById(R.id.slide_drawer_btn);
		imageButton.setOnClickListener(slideMenuOnclickListener);
		actionBar.setCustomView(mCustomView);
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_SHOW_CUSTOM);
		actionBar.setDisplayShowCustomEnabled(true);	
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setIcon(R.drawable.arrow);	
		actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.light_gray));
		//Calling own method to initiate drawer 
		setUpDrawer();	
	};
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
			Toast.makeText(this, getResources().getString(R.string.share), Toast.LENGTH_LONG).show();
			return true;
		case R.id.add_item:
			Toast.makeText(this, getResources().getString(R.string.add_item), Toast.LENGTH_LONG).show();
			return true;
		case R.id.other_options:
			item.setIcon(R.drawable.more_img);
			toggleList();
			return true;
		default: 
			return super.onOptionsItemSelected(item);
		}
	}

	public void toggleList() {
		//loading the fragment...
		Fragment fragment = getFragmentManager().findFragmentByTag(com.example.contants.Constants.KeyExtras.LIST_FRAGMENT_TAG);
		if (fragment != null) {
			getFragmentManager().popBackStack();
		} else {
			getFragmentManager().beginTransaction()
			.setCustomAnimations(R.anim.slideup,
					R.anim.slidedown,
					R.anim.slideup,
					R.anim.slidedown)
					.add(R.id.list_fragment_container,SlidingListFragment
							.instantiate(ShoppersListActivity.this, SlidingListFragment.class.getName()),
							com.example.contants.Constants.KeyExtras.LIST_FRAGMENT_TAG
							).addToBackStack(null).commit();
		}
	}

	//Initializing, setting attributes, adding adapters are done in this method
	private void setUpDrawer() {

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		//Adding Listener to drawer
		mDrawerLayout.setDrawerListener(mDrawerListener);

		expandableListView = (ExpandableListView) findViewById(R.id.expandable_right_drawer);

		//Adding data
		prepareListData();

		//Adding Adapter
		expandableListAdapter = new ExpandableListAdapter(this, parents,
				children);

		//Setting adapter to list
		expandableListView.setAdapter(expandableListAdapter);

		mDrawerLayout.closeDrawer(expandableListView);

		//Adding listener to each child in the list
		expandableListView.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				switch (groupPosition) {
				case 0:
					switch (childPosition) {
					case 0:
						break;
					case 1:
						break;
					case 2:
						break;
					default:
						break;
					}
					break;

				case 1:
					switch (childPosition) {
					case 0:
						break;
					case 1:
						break;
					case 2:
					default:
						break;
					}
					break;

				case 2:
					switch (childPosition) {
					case 0:

						break;
					case 1:
						break;
					case 2:
						break;
					default:
						break;
					}
					break;

				default:
					break;
				}

				mDrawerLayout.closeDrawer(expandableListView);
				return false;
			}
		});
	}

	//Opening Drawer on clicking home button
	View.OnClickListener slideMenuOnclickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (mDrawerLayout.isDrawerOpen(expandableListView)) {
				mDrawerLayout.closeDrawer(expandableListView);
			} else {
				mDrawerLayout.openDrawer(expandableListView);
			}
		}
	};

	//Own implemented Drawer listener
	private DrawerListener mDrawerListener = new DrawerListener() {

		@Override
		public void onDrawerStateChanged(int status) {

		}
		@Override
		public void onDrawerSlide(View view, float slideArg) {

		}
		@Override
		public void onDrawerOpened(View view) {
		}
		@Override
		public void onDrawerClosed(View view) {
		}
	};
	//Adding Dummy data
	private void prepareListData() {
		parents = new ArrayList<String>();
		children = new HashMap<String, List<String>>();

		// Adding Parent data
		parents.add(getResources().getString(R.string.github));
		parents.add(getResources().getString(R.string.pcs));
		parents.add(getResources().getString(R.string.app_store));
		parents.add(getResources().getString(R.string.mobogenie));

		// Adding github child data
		List<String> github = new ArrayList<String>();
		github.add(getResources().getString(R.string.repository));
		github.add(getResources().getString(R.string.git_url));
		github.add(getResources().getString(R.string.git_commit));
		github.add(getResources().getString(R.string.git_status));

		// Adding pcs child data
		List<String> pcs = new ArrayList<String>();
		pcs.add(getResources().getString(R.string.software_dev));
		pcs.add(getResources().getString(R.string.hr_manage));
		pcs.add(getResources().getString(R.string.bpo_section));
		pcs.add(getResources().getString(R.string.hardware_dev));

		// Adding appStore child data
		List<String> app_store = new ArrayList<String>();
		app_store.add(getResources().getString(R.string.applications));
		app_store.add(getResources().getString(R.string.games));
		app_store.add(getResources().getString(R.string.media));
		app_store.add(getResources().getString(R.string.books));

		// Adding mobogenie child data
		List<String> mobogenie = new ArrayList<String>();
		mobogenie.add(getResources().getString(R.string.mobo_app));
		mobogenie.add(getResources().getString(R.string.ebooks));
		mobogenie.add(getResources().getString(R.string.videos));
		mobogenie.add(getResources().getString(R.string.music));

		//Adding each child to parents
		children.put(parents.get(0), github);
		children.put(parents.get(1), pcs);
		children.put(parents.get(2), app_store);
		children.put(parents.get(3), mobogenie);
	}

}
