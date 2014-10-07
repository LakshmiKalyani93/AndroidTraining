package com.pcs.samplelogindemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FetchActivity extends Activity{

	private static final String TAG="response_msg";

	private Button detailBtn;
	private TextView weatherTxt;
	private TextView cityTxt;
	private TextView tempTxt;
	private TextView minTempTxt;
	private TextView maxTempTxt;
	private TextView humidityTxt;
	private EditText cityEdt;

	private StringBuilder stringBuilder;
	private Context mContext;
	
	private String city ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.fetch);

		weatherTxt= (TextView)findViewById(R.id.weather_txt);
		cityTxt= (TextView)findViewById(R.id.city_txt);
		humidityTxt= (TextView)findViewById(R.id.Humidity_txt);
		tempTxt= (TextView)findViewById(R.id.temp_txt);
		minTempTxt= (TextView)findViewById(R.id.min_temp_txt);
		maxTempTxt= (TextView)findViewById(R.id.max_temp_txt);
		cityEdt=(EditText)findViewById(R.id.city_edt);

		detailBtn = (Button)findViewById(R.id.details_btn);
		detailBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new SendRequestActivty(FetchActivity.this).execute();				
			}
		});

	}


	private  class SendRequestActivty extends AsyncTask<String, Integer, String>
	{
		public SendRequestActivty(Context context) {
			mContext = context;

		}


		@Override
		protected void onPreExecute() {

			Toast.makeText(mContext, getResources().getString(R.string.send_request), Toast.LENGTH_LONG).show(); 
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... args)
		{
			URL url;
			city = cityEdt.getText().toString();
			try {
				url = new URL( "http://api.openweathermap.org/data/2.5/weather?q=city&mode=json");
				URLConnection con = url.openConnection();
				con.connect();
				InputStream is = con.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader reader = new BufferedReader(isr);
				stringBuilder = new StringBuilder();
				String value = null;
				while((value=reader.readLine())!=null)
				{
					stringBuilder.append(value);
				}
				Log.i(TAG, "Response = "+stringBuilder.toString());

			} 
			catch (MalformedURLException e1) {
				e1.printStackTrace();
			}catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(stringBuilder!=null)
			{
				return stringBuilder.toString();
			}
			else
			{
				return null;
			}	

		}

		@Override
		protected void onProgressUpdate(Integer... values) {

			super.onProgressUpdate(values[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			String val = null;

			
			if(result!=null)
			{
			try {
				JSONObject jsonObj = new JSONObject(result);
				
				if(jsonObj.has("main"))
				{
					JSONObject jsonObj_inner =jsonObj.getJSONObject("main");

					if(jsonObj_inner.has("temp"))
					{
						val = jsonObj_inner.getString("temp");
						tempTxt.setText(getResources().getString(R.string.temp)+"\t"+ val);
					}
					if(jsonObj_inner.has("humidity"))
					{
						val = jsonObj_inner.getString("temp");
						humidityTxt.setText(getResources().getString(R.string.humidity)+"\t"+ val);
					}
					if(jsonObj_inner.has("temp_min"))
					{
						val = jsonObj_inner.getString("temp");
						minTempTxt.setText(getResources().getString(R.string.temp_min)+"\t"+ val);
					}
					if(jsonObj_inner.has("temp_max"))
					{
						val = jsonObj_inner.getString("temp");
						maxTempTxt.setText(getResources().getString(R.string.temp_max)+"\t"+ val);
					}

				}
				if(jsonObj.has("name")){
					val = jsonObj.getString("name");
					cityTxt.setText(getResources().getString(R.string.city)+"\t\t\t\t\t\t\t\t:\t"+city);
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}
			}else{
				Toast.makeText(mContext, getResources().getString(R.string.no_response), Toast.LENGTH_LONG).show(); 
			}
		}	
	}
	
}