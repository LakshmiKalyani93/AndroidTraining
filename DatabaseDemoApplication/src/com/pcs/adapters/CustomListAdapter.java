package com.pcs.adapters;

import com.pcs.model.PersonDetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class CustomListAdapter extends ArrayAdapter<PersonDetails>{
	
	private LayoutInflater layoutInflater;
	private Context mContext;
	private int mResource;

	public CustomListAdapter(Context context, int resource) {
		super(context, resource);
		
		mContext=context;
		mResource = resource;
		layoutInflater = LayoutInflater.from(context);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return super.getView(position, convertView, parent);
	}

}
