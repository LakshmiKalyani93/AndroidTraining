package com.pcs.lazyloaderdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.pcs.adapters.ImageLoaderAdapter;

/*creating an application that downloads and loads the images from the web
 * @author:Kalyani*/
public class MainActivity extends Activity implements OnClickListener{
	private Button refreshBtn;
	private ListView listView;
	ImageLoaderAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.main);
		super.onCreate(savedInstanceState);
		//fetching listview of the layout main
		listView=(ListView)findViewById(R.id.listview);
		// Create custom adapter for listview
		adapter=new ImageLoaderAdapter(MainActivity.this,mStringUrls);
		//Set adapter to listview
		listView.setAdapter(adapter);
		//fetching button view of the layout main
		refreshBtn=(Button)findViewById(R.id.button);
		//settings on click listener
		refreshBtn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		//Refresh cache directory downloaded images
		adapter.imageLoader.clearCache();
		//Notifying on each interval when data set is changed
		adapter.notifyDataSetChanged();		
	}
	// Image urls used in ImageLoaderAdapter.java file
	private String[] mStringUrls={

			"http://www.clipartpal.com/_thumbs/pd/education/large_open_book.png",
			"http://www.clipartbest.com/cliparts/7Ta/Rrn/7TaRrnqTA.png",
			"http://eastbrookfieldpubliclibrary.files.wordpress.com/2011/06/clip-art-book.jpg",
			"http://www.clker.com/cliparts/1/a/2/e/1197085885105139227CrazyTerabyte_Book.svg.med.png",
			"http://www.clipartpal.com/_thumbs/pd/education/green_book_T.png",
			"http://www.clipartbest.com/cliparts/aTq/zEj/aTqzEjXTM.png",
			"http://www.saskatoonlibrary.ca/sites/default/files/Image/Kids/books-clipart.gif",
			"http://images.clipartpanda.com/stack-of-paper-clipart-book_stack_pc_md_wm.jpg",
			"timvandevall.com/wp-content/uploads/2014/01/Closed-Book-Clip-Art-Black-and-White.jpg",
			"http://images.clipartpanda.com/clipart-book-4cbK4Eecg.gif",
			"http://images.clipartlogo.com/files/ss/original/113/113539192/illustration-of-an-apple.jpg",
			"http://www.mikesilverman.com/redletterday/wp-content/uploads/2012/12/stack_of_books.jpg",
			"http://images.clipartpanda.com/bookstore-clipart-book-clipart.jpg",
			"http://sr.photos3.fotosearch.com/bthumb/CSP/CSP990/k11126519.jpg",
			"http://100things.com.au/wp-content/uploads/2014/05/novels.gif",
			"http://stockfresh.com/files/f/filata/m/26/1158015_stock-photo-apple-and-books.jpg"
	};
	//Toasting out the Image URL with User ID
	public void onItemClick(int mPosition,int id) {
		String temp=mStringUrls[mPosition];
		Toast.makeText(MainActivity.this,
				"UserID :"+id+"\nImage URL:\t"+temp ,
				Toast.LENGTH_LONG).show();

	}
}
