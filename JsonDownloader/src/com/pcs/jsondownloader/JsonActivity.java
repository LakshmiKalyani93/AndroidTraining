package com.pcs.jsondownloader;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class JsonActivity extends Activity{

	private static final String TAG="response_msg";
	private static final int DOWNLOAD = 1;


	private Button downloadBtn;

	private TextView msgTxt;
	private TextView codeTxt;
	private TextView validTxt;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.json);

//fetching reference for TextViews of the layout json
		msgTxt = (TextView)findViewById(R.id.data_txt);
		codeTxt = (TextView)findViewById(R.id.data2_txt);
		validTxt = (TextView)findViewById(R.id.data3_txt);
		
//fetching reference Button of the layout json
		downloadBtn = (Button)findViewById(R.id.json_btn);

		//setting a listener to the button downloadBtn
		downloadBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				//call to a inner class JsonDownloader
				new JsonDownloader(JsonActivity.this).execute();

			}
		});

	}

	public class JsonDownloader extends AsyncTask<Void, Integer, String>
	{
		private StringBuilder sb=null;
		private Context mContext;
		private ProgressDialog dialog;

		public JsonDownloader(Context context){
			mContext = context;
		}

//creating a progress dialog in onPreExecute()
		protected void onPreExecute() {

			super.onPreExecute();

			dialog = new ProgressDialog(mContext);
			dialog.setTitle(R.string.msg);
			dialog.setProgress(10);
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.show();

		}

		
		//In this method we are trying to grab a Json object 
		@Override
		protected String doInBackground(Void... params) {

			String line = null;
			URL url=null;
			try {
				
				//specifying the URL where json object is present
				 url = new URL("http://validate.jsontest.com/?json=%7B%22key%22:%22value%22%7D");
				
				 //opening the connection for the URL as mentioned above
				 URLConnection con = url.openConnection();
				 //connecting to the URL
				con.connect();

				//Here,we are using Input Stream ,InputStreamReader,BufferedReader to store the input coming from the result
				InputStream is = con.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);

				sb = new StringBuilder();
//reading line by line and checking for the null values as well
				while((line=br.readLine())!=null)
				{
					//updating the progress
					dialog.setProgress(60);
					sb.append(line);

				}
				//printing the response in the LOG
				Log.i(TAG, "Response ="+sb.toString());

			}
			//Handling the exceptions
			catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
//checking out whether the response is null if so returning null so that application shouldn't crash
			if(sb!=null)
			{
				return sb.toString();
			}
			else
			{
				return null;
			}
		}

//setting the progress
		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);

			dialog.setProgress(values[0]);
		}

		
		
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);


			dialog.dismiss();
// Handling the exception if the response is null and parsing the text from that json object
			if(result!=null)
			{
				try
				{

					//creating th ejson object

					JSONObject obj =new JSONObject(result) ;

					//checking for json keys and displaying the values if any 
					if (obj.has("object_or_array"))
					{

						String message = obj.getString("object_or_array");
						msgTxt.setText("Message: "+message);

					}
					if(obj.has("parse_time_nanoseconds")){
						String code = obj.getString("parse_time_nanoseconds");
						codeTxt.setText("Code: "+code);
					}
					if(obj.has("validate")){
						String validate = obj.getString("validate");
						validTxt.setText("Validate: "+validate);
					}

				}
				catch (JSONException e) {
					e.printStackTrace();
				}

			}
			else
			{
				//if the response is null then we are showing the Toast msg
				Toast.makeText(JsonActivity.this,getResources().getString(R.string.app_name), Toast.LENGTH_LONG).show();
			}
		}

	}
}
