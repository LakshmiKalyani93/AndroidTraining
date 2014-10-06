package com.pcs.adapters;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pcs.databasedemoapplication.R;

import com.pcs.model.PersonDetails;

public class CustomListAdapter extends BaseAdapter {
	
	private LayoutInflater layoutInflater;
	private Context mContext;
	private ArrayList< PersonDetails> mpersons;
	
	
	public CustomListAdapter(Context context,
			ArrayList<PersonDetails> personList) {
		mpersons =personList;
		mContext=context;
		layoutInflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		return mpersons.size();
	}

	@Override
	public PersonDetails getItem(int position) {
		return mpersons.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;

		PersonDetails person= (PersonDetails)getItem(position);

		if(convertView==null){

			convertView = layoutInflater.inflate(R.layout.custom, null);

			holder = new ViewHolder();
			holder.imageView=(ImageView) convertView.findViewById(R.id.img_view);
			holder.nameTxt=(TextView) convertView.findViewById(R.id.user_txt);
			holder.emailTxt=(TextView) convertView.findViewById(R.id.email_txt);
			holder.pwdTxt=(TextView) convertView.findViewById(R.id.pwd_txt);
			convertView.setTag(holder);
		}
		else
		{
			holder=(ViewHolder)convertView.getTag();
		}
		holder.imageView.setBackgroundResource(R.drawable.personimg);
		holder.nameTxt.setText(person.getUserName());
		holder.emailTxt.setText(person.getEmail());
		holder.pwdTxt.setText(person.getPassword());

		return convertView;

	}

	public class ViewHolder
	{
		public ImageView imageView;
		public TextView nameTxt;
		public TextView emailTxt;
		public TextView pwdTxt;
	}

}
