package com.example.whirlpool;

import android.annotation.SuppressLint;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/*Creating a fragment that animates from bottom to top
 * Using an adapter which sets the items in the listview
 * SlidingFragment extends the ListFragment
 * @Author Kalyani pcs -232*/
public class SlidingListFragment extends ListFragment{

	
	
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
		

		public MyListAdapter() {
				
		}
		@Override
		public int getCount() {
			return 4;
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
			int pos=(Integer)getItem(position);
			TextView result = (TextView) convertView;
			if (result == null) {
				result = (TextView) LayoutInflater.from(parent.getContext())
						.inflate(R.layout.list_view_item, parent, false);
			}
			String[] data=getResources().getStringArray(R.array.show_list);
			result.setText(data[position]);
			return result;
		}
	}

}
