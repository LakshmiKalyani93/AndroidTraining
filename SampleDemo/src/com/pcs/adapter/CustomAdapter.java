package com.pcs.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.pcs.sampledemo.R;

public class CustomAdapter extends BaseAdapter {
	private  Context mContext ;
	private String[] fruitsData;
	private LayoutInflater layoutInflater;

	ViewHolder holder = null;
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
		if(pos%4==0)
		{
			holder.checkBox.setVisibility(View.GONE);
			convertView.setEnabled(false);
			convertView.setClickable(false);
			convertView.setFocusable(false);
			convertView.setBackgroundColor(Color.CYAN);
			holder.TxtView.setText(fruitsData[pos]);
			convertView.setOnClickListener(null);
		}
		else{
			holder.checkBox.setVisibility(View.VISIBLE);
			convertView.setEnabled(true);
			convertView.setClickable(true);
			convertView.setFocusable(true);
			holder.TxtView.setText(fruitsData[pos]);
			convertView.setBackgroundColor(Color.WHITE);
			convertView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(mContext,mContext.getResources().getString(R.string.item_select_msg), Toast.LENGTH_LONG).show();
				}
			});
		}
		return convertView;
	}

	public class ViewHolder{
		public	CheckBox checkBox;	
		public	TextView TxtView;
	}
}

