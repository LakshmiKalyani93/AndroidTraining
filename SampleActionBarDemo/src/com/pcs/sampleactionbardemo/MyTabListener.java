package com.pcs.sampleactionbardemo;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;

public class MyTabListener implements ActionBar.TabListener{

	private Fragment fragment;
	// The constructor.
	public MyTabListener(Fragment fragment) {
		this.fragment=fragment;

	}
	// When a tab is tapped, the FragmentTransaction replaces
	// the content of our main layout with the specified fragment;
	// that's why we declared an id for the main layout.
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		ft.replace(R.id.main, fragment);

	}

	// When a tab is unselected, we have to hide it from the user's view. 
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {

		ft.remove(fragment);
	}
	//on reselection tab will be displayed according to its defined view
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}

}