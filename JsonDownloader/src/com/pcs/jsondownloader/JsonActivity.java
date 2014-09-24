package com.pcs.jsondownloader;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class JsonActivity extends Activity{
	
	
	private static final int DOWNLOAD = 1;
 
	
	private Button downloadBtn;
	
	private TextView VehicleTxt;
	private TextView ColorTxt;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.json);
		
		
		VehicleTxt = (TextView)findViewById(R.id.data_txt);
		ColorTxt = (TextView)findViewById(R.id.data2_txt);
		
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
				URL url = new URL("http://docs.blackberry.com/sampledata.json");
				URLConnection con = url.openConnection();
				con.connect();
				
				InputStream is = new InputStream() {
					
					@Override
					public int read() throws IOException {
						return 0;
					}
				};
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				 sb = new StringBuilder();
				 
				while((line=br.readLine())!=null)
				{
					dialog.setProgress(60);
					sb.append(line);
					
				}
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return sb.toString();
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
		
			
			try
			{
			JSONObject obj= new JSONObject();
			
			
			if (obj.has("vehicleType"))
			{
				
					String vehilcleType = obj.getString("vehicleType");
					VehicleTxt.setText("VehicleType: "+vehilcleType);
				
			}
			if(obj.has("vehicleColor")){
				String VehicleColor = obj.getString("vehicleColor");
				ColorTxt.setText("vehicleColor: "+VehicleColor);
			}
			}
			 catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	}

}
