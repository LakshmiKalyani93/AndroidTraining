package com.pcs.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.pcs.customtoastdemo.R;


public class CustomAdapter extends BaseAdapter {
	private  Context mContext ;
	private String[] userData;
	private LayoutInflater layoutInflater;
	ViewHolder holder = null;
	public CustomAdapter(Context context, String[] user_data) {
		mContext=context;
		userData=user_data;
		layoutInflater=LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		return userData.length;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		int pos= (Integer) getItem(position);

		if(convertView==null){
			convertView = layoutInflater.inflate(com.pcs.customtoastdemo.R.layout.inflate, null);
			holder = new ViewHolder();
			holder.userTxt=(TextView) convertView.findViewById(R.id.user);
			holder.notifyTxt=(TextView) convertView.findViewById(R.id.notify);

			convertView.setTag(holder);
		}
		else
			holder=(ViewHolder)convertView.getTag();

		holder.userTxt.setText(userData[pos]);
		final String[] list=mContext.getResources().getStringArray(R.array.noify_list);
		holder.notifyTxt.setText(list[position]);

		convertView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showCustomAlert();	

			}

			private void showCustomAlert( ){

				// Call toast.xml file for toast layout
				View toastRoot = layoutInflater.inflate(R.layout.inflate, null);
				toastRoot.setBackgroundColor(Color.LTGRAY); 
				Toast toast = new Toast(mContext);
				TextView user_toast_txtView=(TextView)toastRoot.findViewById(R.id.user);
				TextView notify_toast_txtView=(TextView)toastRoot.findViewById(R.id.notify);
				user_toast_txtView.setText(userData[position]);
				notify_toast_txtView.setText(list[position]);	
				// Set layout to toast
				toast.setView(toastRoot);
				toast.setGravity(Gravity.CENTER,
						40, 50);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.show();
			}
		});

		return convertView;
	}

	public class ViewHolder{	
		public	TextView userTxt;
		public	TextView notifyTxt;
	}
}

