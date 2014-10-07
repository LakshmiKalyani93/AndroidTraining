package com.pcs.parcelabledemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.pcs.employdetails.Employ;
import com.pcs.helper.Helper;


public class EmployeeDetails extends Activity {

	private Button submitBtn;
	private EditText nameEdt;
	private EditText idEdt;
	private EditText designEdt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.employ);

		submitBtn = (Button)findViewById(R.id.submit);

		nameEdt =(EditText)findViewById(R.id.name_edt);
		idEdt=(EditText)findViewById(R.id.id_edt);
		designEdt=(EditText)findViewById(R.id.design_edt);


		submitBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(EmployeeDetails.this,DisplayActivity.class);
				Employ employ = new Employ();
				employ.setEmployName(nameEdt.getText().toString());
				employ.setEmployID(idEdt.getText().toString());
				employ.setDesignation(designEdt.getText().toString());
				intent.putExtra(Helper.DetailsExtras.Employ_DETAILS, employ);
				startActivity(intent);
			}
		});

	}


}
