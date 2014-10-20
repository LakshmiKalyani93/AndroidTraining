package com.pcs.sampleactionbardemo;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class MainActivity extends Activity{
	
	ActionBar.Tab galleryTab,moviesTab,webTab,playStoreTab;
	
	Fragment gal_frag = new GalleryFragment();
	Fragment mov_frag = new MoviesFragment();
	Fragment web_frag = new WebFragment();
	Fragment play_frag = new PlayStoreFragment();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ActionBar actionBar= getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		galleryTab=actionBar.newTab().setIcon(R.drawable.gallery).setTabListener(new MyTabListener(gal_frag));;
		moviesTab=actionBar.newTab().setIcon(R.drawable.movie_icon).setTabListener(new MyTabListener(mov_frag));;
		webTab=actionBar.newTab().setIcon(R.drawable.web).setTabListener(new MyTabListener(web_frag));
		playStoreTab=actionBar.newTab().setIcon(R.drawable.play).setTabListener(new MyTabListener(play_frag));

		actionBar.addTab(galleryTab);
		actionBar.addTab(moviesTab);
		actionBar.addTab(webTab);
		actionBar.addTab(playStoreTab);

	}
}
