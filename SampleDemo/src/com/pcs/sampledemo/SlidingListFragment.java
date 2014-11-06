package com.pcs.sampledemo;

import android.annotation.SuppressLint;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/*Creating a fragment that animates from bottom to top
 * Using an adapter that set the items in the listview
 * @Author Kalyani pcs -232*/
public class SlidingListFragment extends ListFragment{

	private int count =15;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.layout, container, false);
	}
	@SuppressLint("NewApi")
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		setListAdapter(new MyListAdapter());
	}
	
	//creating MyListadapter that extends BaseAdapter....
	private class MyListAdapter extends BaseAdapter {
		@Override
		public int getCount() {
			return count;
		}
		@Override
		public Object getItem(int position) {
			return position;
		}
		@Override
		public long getItemId(int position) {
			return position;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView result = (TextView) convertView;
			if (result == null) {
				result = (TextView) LayoutInflater.from(parent.getContext())
						.inflate(R.layout.list_view_item, parent, false);
			}
			result.setText(getResources().getString(R.string.action_show_list) +" #"+ position);
			return result;
		}
	}

}
