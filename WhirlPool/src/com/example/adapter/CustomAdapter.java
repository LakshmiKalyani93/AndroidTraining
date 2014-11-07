package com.example.adapter;

import com.example.whirlpool.R;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.ColorRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Adapter to handle list data
 * custom adapter which extends BaseAdapter
 * @author Kalyani pcs-232
 *
 */
public class CustomAdapter extends BaseAdapter {
	private  Context mContext ;
	private String[] shopperItemList;
	private LayoutInflater layoutInflater;
	ViewHolder holder = null;
	//created a constructor...
	public CustomAdapter(Context context, String[] data) {
		mContext=context;
		shopperItemList=data;
		layoutInflater=LayoutInflater.from(mContext);
	}
	//Returns the length of the data
	@Override
	public int getCount() {
		return shopperItemList.length;
	}
	//Returns the position of the item
	@Override
	public Object getItem(int position) {
		return position;
	}
	//Retrieves the id of the item 
	@Override
	public long getItemId(int position) {
		return position;
	}
	//In this we inflate the our own custom view and performs the actions basing on the sub views presented....
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		int pos= (Integer) getItem(position);

		if(convertView==null){
			convertView = layoutInflater.inflate(R.layout.inflate, null);
			holder = new ViewHolder();
			holder.checkBox=(CheckBox) convertView.findViewById(R.id.checkbox);
			holder.checkBox.setTag(holder);
			holder.TxtView=(TextView) convertView.findViewById(R.id.text_view);
			convertView.setTag(holder);
		}
		else
			holder=(ViewHolder)convertView.getTag();
		//Disables the listener action on every 4th item
		if(pos%5==0)
		{
			holder.checkBox.setVisibility(View.GONE);
			convertView.setEnabled(false);
			convertView.setClickable(false);
			convertView.setFocusable(false);
			holder.TxtView.setTextColor(mContext.getResources().getColor(R.color.orange));
			holder.TxtView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
			convertView.setBackgroundColor(Color.WHITE);
			holder.TxtView.setText(shopperItemList[pos]);
			convertView.setOnClickListener(null);
		}
		else{
			holder.checkBox.setVisibility(View.VISIBLE);
			convertView.setEnabled(true);
			convertView.setClickable(true);
			convertView.setFocusable(true);
			holder.TxtView.setText(shopperItemList[pos]);
			convertView.setBackgroundColor(mContext.getResources().getColor(R.color.gray_in));
			holder.TxtView.setTextColor(Color.BLACK);
			holder.TxtView.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL);
			convertView.setFocusable(true);
			convertView.setClickable(true);	  
			convertView.setOnClickListener(new OnClickListener() {
				//on listview item click
				@Override
				public void onClick(View v) {
					Toast.makeText(mContext, mContext.getResources().getString(R.string.app_name), Toast.LENGTH_LONG).show();			
				}
			});
		}
		return convertView;
	}
	//creating view holder...
	public class ViewHolder{
		public	CheckBox checkBox;	
		public	TextView TxtView;
	}
}

