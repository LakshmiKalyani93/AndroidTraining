package com.pcs.sampledemo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pcs.adapter.CustomAdapter;

public class ListFragment extends Fragment {
	private ListView listView;
	View view;
	//creating constructor...
	private Context context;
	public ListFragment(MainActivity mainActivity) {
		context=mainActivity;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//inflating the view...
		view = inflater.inflate(R.layout.fragment_list, null);		
		listView = (ListView)view.findViewById(R.id.listview);
		String[] fruits=getResources().getStringArray(R.array.friuts_list);
		CustomAdapter adapter = new CustomAdapter(getActivity(), fruits);
		//setting a header to the listview on inflating the custom view...
		View header = (View) ((Activity) context).getLayoutInflater().inflate(
				R.layout.list_view_item, null);
		listView.addHeaderView(header);
		//adding listview to the adapter...
		listView.setAdapter(adapter);
		return view;
	}	

}
