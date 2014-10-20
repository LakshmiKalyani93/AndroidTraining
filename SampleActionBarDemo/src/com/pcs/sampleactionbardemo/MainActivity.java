package com.pcs.sampleactionbardemo;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class MainActivity extends Activity{
	// Declaring our tabs and the corresponding fragments.
	ActionBar.Tab galleryTab,moviesTab,webTab,playStoreTab;

	Fragment gal_frag = new GalleryFragment();
	Fragment mov_frag = new MoviesFragment();
	Fragment web_frag = new WebFragment();
	Fragment play_frag = new PlayStoreFragment();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// Asking for the default ActionBar element that our platform supports.
		ActionBar actionBar= getActionBar();
		// Screen handling while hiding ActionBar icon.
		actionBar.setDisplayShowHomeEnabled(true);
		// Screen handling while hiding ActionBar title.
		actionBar.setDisplayShowTitleEnabled(true);
		// Creating ActionBar tabs.
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Setting custom tab icons and tab listeners
		galleryTab=actionBar.newTab().setIcon(R.drawable.gallery).setTabListener(new MyTabListener(gal_frag));;
		moviesTab=actionBar.newTab().setIcon(R.drawable.movie_icon).setTabListener(new MyTabListener(mov_frag));;
		webTab=actionBar.newTab().setIcon(R.drawable.web).setTabListener(new MyTabListener(web_frag));
		playStoreTab=actionBar.newTab().setIcon(R.drawable.play).setTabListener(new MyTabListener(play_frag));
		// Adding tabs to the ActionBar.
		actionBar.addTab(galleryTab);
		actionBar.addTab(moviesTab);
		actionBar.addTab(webTab);
		actionBar.addTab(playStoreTab);


	}
}
