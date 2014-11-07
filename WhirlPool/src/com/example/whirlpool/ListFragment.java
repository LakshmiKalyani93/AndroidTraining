package com.example.whirlpool;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.adapter.CustomAdapter;

public class ListFragment extends Fragment {
	private ListView listView;
	View view;
	//creating constructor...
	private Context mContext;
	public ListFragment(Context context) {
		mContext=context;
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//inflating the view...
		view = inflater.inflate(R.layout.fragment_shopper_list, null);		
		listView = (ListView)view.findViewById(R.id.listview);
		String[] fruits=getResources().getStringArray(R.array.shopper_item_list);
		CustomAdapter adapter = new CustomAdapter(getActivity(), fruits);
		//adding listview to the adapter...
		listView.setAdapter(adapter);
		return view;
	}	

}
