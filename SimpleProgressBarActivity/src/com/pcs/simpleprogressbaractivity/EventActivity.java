package com.pcs.simpleprogressbaractivity;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class EventActivity extends Activity{

	private EditText eventEdt;
	private EditText streamEdt;

	private Button dateBtn;
	private Button timeBtn;
	private Button setBtn;
	private Button cancelBtn;

	private TextView resultDate;
	private TextView resultTime;
	private TextView resultEvent;


	private int year;
	private int month;
	private int day;

	private int hour;
	private int minute;

	private ProgressDialog progress;
	private Handler updateHandler;



	private DatePickerDialog.OnDateSetListener datePickerListener ;
	private DatePickerDialog datepicker;

	private TimePickerDialog.OnTimeSetListener timePickerListener;
	private TimePickerDialog timepicker;

	Calendar calender = Calendar.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.event);

		updateHandler = new Handler();

		// Getting a reference to EditText of the layout event
		eventEdt = (EditText)findViewById(R.id.event_edt);
		streamEdt=(EditText)findViewById(R.id.stream_edt);

		// Getting a reference to Button of the layout event
		dateBtn = (Button)findViewById(R.id.date_btn);
		timeBtn=(Button)findViewById(R.id.time_btn);
		setBtn=(Button)findViewById(R.id.set_btn);
		cancelBtn=(Button)findViewById(R.id.cancel_btn);

		// Getting a reference to TextView of the layout event
		resultDate=(TextView)findViewById(R.id.result_date);
		resultTime=(TextView)findViewById(R.id.result_time);
		resultEvent=(TextView)findViewById(R.id.result_event);

		//creating an onClickListener to the button dateBtn
		dateBtn.setOnClickListener(new android.view.View.OnClickListener() {

			@Override
			public void onClick(View v) {

				year = calender.get(Calendar.YEAR);
				month = calender.get(Calendar.MONTH);
				day = calender.get(Calendar.DAY_OF_MONTH);

				//setting a datepicker dialog in the EventActivity 

				datepicker = new DatePickerDialog(EventActivity.this, datePickerListener, year, month, day);

				//enabling the datapicker dialog
				datepicker.show();

			}

		});

		datePickerListener 
		= new DatePickerDialog.OnDateSetListener() {

			public void onDateSet(DatePicker view, int selectedYear,
					int selectedMonth, int selectedDay) {
				year = selectedYear;
				month = selectedMonth;
				day = selectedDay;

				// set selected date into textview

				resultDate.setText(new StringBuilder().append(month + 1)
						.append("-").append(day).append("-").append(year)
						.append(" "));

			}

		};



		timeBtn.setOnClickListener(new android.view.View.OnClickListener() {

			@Override
			public void onClick(View v) {

				hour = calender.get(Calendar.HOUR);
				minute = calender.get(Calendar.MINUTE);
				//setting time picker dialog in the EventActivity 
				timepicker = new TimePickerDialog(EventActivity.this, timePickerListener, hour, minute, true);
				//enabling the timepicker widget
				timepicker.show();


			}
		});


		timePickerListener = new TimePickerDialog.OnTimeSetListener() {

			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour) {

				hour = hourOfDay;
				minute = minuteOfHour;

				//setting the result time to the textview

				resultTime.setText(new StringBuilder().append(hour)
						.append(":").append(minute)
						.append(" "));


			}
		};


		//creating an onClickListener to the button setBtn

		setBtn.setOnClickListener(new android.view.View.OnClickListener() {

			@Override
			public void onClick(View v) {

				String eventName = eventEdt.getText().toString();
				String streamName = streamEdt.getText().toString();
				//validating the fileds for null values if any resent
				if(TextUtils.isEmpty( eventName)||TextUtils.isEmpty(streamName))
				{
					Toast.makeText(EventActivity.this,getResources().getString(R.string.null_msg), Toast.LENGTH_LONG).show();
					finish();
				}
				//setting the result time value to the textview
				resultEvent.setText(getResources().getString(R.string.value)+""+eventName+"\n"+streamName);



				//creating a progress dialog 

				progress = new ProgressDialog(EventActivity.this);

				progress.setTitle("Setting Up Event");
				progress.setMessage("Event Setting is in progress ...");
				progress.setProgressStyle(progress.STYLE_HORIZONTAL);
				progress.setProgress(0);
				progress.setMax(20);
				progress.show();

				//updating the progress dialog

				new Thread(new Runnable() {


					@Override
					public void run() {


						try {

							// Here you should write your time consuming task...
							while (	progress.getProgress() <= progress.getMax()) {

								Thread.sleep(2000);

								updateHandler.post(new Runnable() {

									public void run() {

										progress.incrementProgressBy(2);

									}



								});

								if (progress.getProgress() == progress.getMax()) {

									progress.dismiss();


								}
							}
						} catch (Exception e) {
						}
					}

				}).start();  

			}

		});

		//creating an onClickListener to the button cancelBtn
		cancelBtn.setOnClickListener(new android.view.View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(EventActivity.this, getResources().getString(R.string.cancel_msg), Toast.LENGTH_LONG).show();
				finish();
			}
		});
	}

}
