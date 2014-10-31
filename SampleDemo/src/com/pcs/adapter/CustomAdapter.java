package com.pcs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.pcs.sampledemo.R;

public class CustomAdapter extends BaseAdapter {
	private  Context mContext ;
	private String[] fruitsData;
	private LayoutInflater layoutInflater;
	public CustomAdapter(Context context, String[] data) {
		mContext=context;
		fruitsData=data;
		layoutInflater=LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		return fruitsData.length;
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

		ViewHolder holder = null;

		int pos= (Integer) getItem(position);

		if(convertView==null){

			convertView = layoutInflater.inflate(R.layout.inflate, null);

			holder = new ViewHolder();
			holder.checkBox=(CheckBox) convertView.findViewById(R.id.checkbox);
			holder.TxtView=(TextView) convertView.findViewById(R.id.text_view);

			convertView.setTag(holder);

		}
		else
			holder=(ViewHolder)convertView.getTag();
		
		holder.TxtView.setText(fruitsData[pos]);
		return convertView;
	}

	public class ViewHolder{
		public	CheckBox checkBox;	
		public	TextView TxtView;
	}
}
