package com.pcs.carrydataapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyActivity extends Activity implements OnClickListener {
	private Button ok_btn;
	private EditText name_et;
	private EditText stream_et;
	public static final int REQUE_A=101;
	public static final int REQUE_B=103;
	public static final int REQUE_C=105;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.my);


		ok_btn=(Button)findViewById(R.id.my_bt);
		name_et=(EditText)findViewById(R.id.name_edt);
		stream_et=(EditText)findViewById(R.id.stream_edt);




		ok_btn.setOnClickListener(this);	
	}
	@Override
	public void onClick(View v) {



		Intent intent=new Intent(MyActivity.this,YourActivity.class);
		intent.putExtra(Constants.Login.STREAM,stream_et.getText().toString());
		startActivityForResult(intent, REQUE_B);




	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);

		if(requestCode == REQUE_B){
			if(data!=null){
		   String streamc=data.getStringExtra(Constants.Login.STREAM);	
			Toast.makeText(MyActivity.this,(getResources().getString(R.string.message)+" "+streamc+" "+getResources().getString(R.string.data1)),Toast.LENGTH_LONG).show();
		}
		}


	}
}




