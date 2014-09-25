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


		msgTxt = (TextView)findViewById(R.id.data_txt);
		codeTxt = (TextView)findViewById(R.id.data2_txt);
		validTxt = (TextView)findViewById(R.id.data3_txt);

		downloadBtn = (Button)findViewById(R.id.json_btn);

		downloadBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

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


		protected void onPreExecute() {

			super.onPreExecute();

			dialog = new ProgressDialog(mContext);
			dialog.setTitle(R.string.msg);
			dialog.setProgress(10);
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.show();

		}

		@Override
		protected String doInBackground(Void... params) {

			String line = null;

			try {
				URL url = new URL("http://validate.jsontest.com/?json=%7B%22key%22:%22value%22%7D");
				URLConnection con = url.openConnection();
				con.connect();

				InputStream is = con.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);

				sb = new StringBuilder();

				while((line=br.readLine())!=null)
				{
					dialog.setProgress(60);
					sb.append(line);

				}

				Log.i(TAG, "Response ="+sb.toString());

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(sb!=null)
			{
				return sb.toString();
			}
			else
			{
				return null;
			}
		}


		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);

			dialog.setProgress(values[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);


			dialog.dismiss();

			if(result!=null)
			{
				try
				{



					JSONObject obj =new JSONObject(result) ;

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
				Toast.makeText(JsonActivity.this,getResources().getString(R.string.app_name), Toast.LENGTH_LONG).show();
			}
		}

	}
}
