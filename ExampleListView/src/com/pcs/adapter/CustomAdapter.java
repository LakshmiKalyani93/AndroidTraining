package com.pcs.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.pcs.examplelistview.R;
import com.pcs.helper.GetDetails;
import com.pcs.helper.UserDetails;

public class CustomAdapter extends BaseAdapter {
	
private LayoutInflater layoutInflator;
	private ArrayList< UserDetails> users;
	private Context mcontext;


	public CustomAdapter(Context context,
			ArrayList<UserDetails> userList) {

		mcontext=context;
		users =userList;
		LayoutInflater.from(mcontext);
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
		
		View itemView = layoutInflater.inflate(R.layout.innerlayout, null);
		
		ImageView imageView=(ImageView) itemView.findViewById(R.id.image);
		Button nameBtn=(Button) itemView.findViewById(R.id.name_btn);
		Button emailBtn=(Button) itemView.findViewById(R.id.email_btn);
		Button phoneBtn=(Button) itemView.findViewById(R.id.phn_btn);
		
		UserDetails user= getItem(position);
		
		imageView.setBackgroundResource(R.drawable.gad);
		nameBtn.setText(user.getCustomername());
		emailBtn.setText(user.getEmail());
		phoneBtn.setText(user.getCustomerid());
		
		
		
		return itemView;
	}


}
