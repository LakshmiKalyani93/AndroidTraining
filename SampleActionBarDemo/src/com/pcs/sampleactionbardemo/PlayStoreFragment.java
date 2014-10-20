package com.pcs.sampleactionbardemo;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlayStoreFragment extends Fragment{
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//Inflating our own layout
		View rootView = inflater.inflate(R.layout.playstore, container, false);
		return rootView;

	}

}
