package com.pcs.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pcs.examplelistview.R;
import com.pcs.helper.UserDetails;

public class CustomAdapter extends BaseAdapter {
	
private LayoutInflater layoutInflator;
	private ArrayList< UserDetails> users;
	private Context mcontext;


	public CustomAdapter(Context context,
			ArrayList<UserDetails> userList) {

		mcontext=context;
		users =userList;
		layoutInflator = LayoutInflater.from(mcontext);
	}

	@Override
	public int getCount() {
		return users.size();
	}

	@Override
	public UserDetails getItem(int position) {
		return users.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder = null;
		
		UserDetails user= (UserDetails)getItem(position);
		
		if(convertView==null){
		
		convertView = layoutInflator.inflate(R.layout.innerlayout, null);
		
		holder = new ViewHolder();
		holder.imageView=(ImageView) convertView.findViewById(R.id.image);
		holder.nameTxt=(TextView) convertView.findViewById(R.id.name_txt);
		 holder.emailTxt=(TextView) convertView.findViewById(R.id.email_txt);
		 holder.phoneTxt=(TextView) convertView.findViewById(R.id.phn_txt);
		 convertView.setTag(holder);
		
		}
		else
		{
			holder=(ViewHolder)convertView.getTag();
		}
	
		
		holder.imageView.setBackgroundResource(R.drawable.gad);
		holder.nameTxt.setText(user.getCustomername());
		holder.emailTxt.setText(user.getEmail());
		holder.phoneTxt.setText(user.getCustomerid());
		
		return convertView;
	}
	
public class ViewHolder{
	

	public	ImageView imageView;	
	public	TextView nameTxt;
	public TextView emailTxt;
	public TextView phoneTxt;
}

}
