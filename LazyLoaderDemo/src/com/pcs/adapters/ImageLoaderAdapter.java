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
//Adapter class extends with BaseAdapter and implements with OnClickListener 
public class ImageLoaderAdapter extends BaseAdapter implements OnClickListener{
	private int max=50,min=10,user_id,notify_number;
	private Context mContext;
	private String[] urlData;
	private static LayoutInflater layoutInflater=null;
	public ImageLoader imageLoader; 
	//creating a constructor
	public ImageLoaderAdapter(Context context, String[] mUrls) {
		mContext=context;
		urlData=mUrls;
		layoutInflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// Create ImageLoader object to download and show image in list
		// Call ImageLoader constructor to initialize FileCache
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
			//Inflate inflate.xml file for each row 
			convertView=layoutInflater.inflate(R.layout.inflate, null);
			//	View Holder Object to contain inflate.xml file elements
			holder=new ViewHolder();
			holder.user_txt=(TextView)convertView.findViewById(R.id.user);
			holder.notify_txt=(TextView)convertView.findViewById(R.id.notify);
			holder.web_img=(ImageView)convertView.findViewById(R.id.web_img_vw);
			holder.like_img=(ImageView)convertView.findViewById(R.id.like_img_vw);
			// Set holder with LayoutInflater
			convertView.setTag(holder);
		}
		else
		{
			holder=(ViewHolder)convertView.getTag();
		}
		//generating a random number
		Random random = new Random();
		user_id=random.nextInt(max - min + 1);
		notify_number=user_id+min;
		holder.user_txt.setText("User ID :"+user_id);
		holder.notify_txt.setText("Notifications:"+notify_number);
		//depending on the nature of the generated number it displays the images
		if(random.nextInt()%2==0)
			holder.like_img.setBackgroundResource(R.drawable.like2);
		else
			holder.like_img.setBackgroundResource(R.drawable.dislike);
		//creating an instance to the ImageView
		ImageView image=holder.web_img;

		//DisplayImage function from ImageLoader Class
		imageLoader.DisplayImage(urlData[position], image);

		/******** Set Item Click Listener for LayoutInflater for each row ***********/
		convertView.setOnClickListener(new OnItemClickListener(position,user_id));

		return convertView;	
	}

	@Override
	public void onClick(View v) {

	}
	private class OnItemClickListener implements OnClickListener{          
		private int mPosition;
		private int mID;

		OnItemClickListener(int position,int id){
			mPosition = position;
			mID=id;
		}
		//upon on click of an item in the listview... 
		@Override
		public void onClick(View arg0) {
			MainActivity setClick = (MainActivity)mContext;
			setClick.onItemClick(mPosition,mID);
		}              
	}   
}
