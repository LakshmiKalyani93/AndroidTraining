package com.pcs.adapters;

import java.util.Random;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pcs.lazyloaderdemo.ImageLoader;
import com.pcs.lazyloaderdemo.MainActivity;
import com.pcs.lazyloaderdemo.R;

public class ImageLoaderAdapter extends BaseAdapter implements OnClickListener{
	private Context mContext;
	private String[] urlData;
	private static LayoutInflater layoutInflater=null;
	public ImageLoader imageLoader; 
	public ImageLoaderAdapter(Context context, String[] mUrls) {
		mContext=context;
		urlData=mUrls;
		layoutInflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		imageLoader=new ImageLoader(mContext.getApplicationContext());
	}

	@Override
	public int getCount() {

		return urlData.length;
	}

	@Override
	public Object getItem(int position) {

		return position;
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	public class ViewHolder{
		public ImageView web_img,like_img;
		public TextView user_txt,notify_txt;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView==null)
		{
			convertView=layoutInflater.inflate(R.layout.inflate, null);
			holder=new ViewHolder();
			holder.user_txt=(TextView)convertView.findViewById(R.id.user);
			holder.notify_txt=(TextView)convertView.findViewById(R.id.notify);
			holder.web_img=(ImageView)convertView.findViewById(R.id.web_img_vw);
			holder.like_img=(ImageView)convertView.findViewById(R.id.like_img_vw);
			convertView.setTag(holder);
		}
		else
		{
			holder=(ViewHolder)convertView.getTag();
		}
		Random random = new Random();
		int max=50, min =10;
		holder.user_txt.setText("User ID :"+random.nextInt(max - min + 1));
		holder.notify_txt.setText("Notifications:"+random.nextInt(max - min + 1));
		if(random.nextInt()%2==0)
			holder.like_img.setBackgroundResource(R.drawable.like2);
		else
			holder.like_img.setBackgroundResource(R.drawable.dislike);
		ImageView image=holder.web_img;
		imageLoader.DisplayImage(urlData[position], image);

		/******** Set Item Click Listener for LayoutInflater for each row ***********/
		convertView.setOnClickListener(new OnItemClickListener(position));

		return convertView;	
	}

	@Override
	public void onClick(View v) {

	}
	private class OnItemClickListener  implements OnClickListener{          
		private int mPosition;

		OnItemClickListener(int position){
			mPosition = position;
		}

		@Override
		public void onClick(View arg0) {
			MainActivity setClick = (MainActivity)mContext;
			setClick.onItemClick(mPosition);
		}              
	}   


}
