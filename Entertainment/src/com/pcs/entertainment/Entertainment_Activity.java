package com.pcs.entertainment;




import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.entertainment.R;

public class Entertainment_Activity extends Activity implements OnClickListener {
	
	private Button rogerBtn;
	private Button saniaBtn;
	private Button sachinBtn;
	private Button ronaldoBtn;
	private Button anandBtn;
	private Button ranaBtn;
	private Button anuskaBtn;
	private Button prabasBtn;
	private Button rajBtn;
	private View layout_up;
	private View layout_down;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enter);

		rogerBtn=(Button)findViewById(R.id.roger_btn);
		saniaBtn=(Button)findViewById(R.id.sania_btn);
		sachinBtn=(Button)findViewById(R.id.sachin_btn);
		anandBtn=(Button)findViewById(R.id.anand_btn);
		ronaldoBtn=(Button)findViewById(R.id.ronaldo_btn);
		ranaBtn=(Button)findViewById(R.id.rana_btn);
		anuskaBtn=(Button)findViewById(R.id.anuska_btn);
		prabasBtn=(Button)findViewById(R.id.prabhas_btn);
		rajBtn=(Button)findViewById(R.id.raj_btn);
		
		layout_up =(View)findViewById(R.id.sports);
		layout_down =(View)findViewById(R.id.movies);
	
		
		rogerBtn.setOnClickListener(this);
		saniaBtn.setOnClickListener(this);
		sachinBtn.setOnClickListener(this);
		anandBtn.setOnClickListener(this);
		ronaldoBtn.setOnClickListener(this);
		ranaBtn.setOnClickListener(this);
		anuskaBtn.setOnClickListener(this);
		prabasBtn.setOnClickListener(this);
		anuskaBtn.setOnClickListener(this);

		rajBtn.setOnClickListener(this);



	}
	public void onClick(View v) {
		

		switch(v.getId()){
		case R.id.roger_btn:
			layout_up .setBackgroundResource(R.drawable.roger);
			break;

		case R.id.sania_btn :

			layout_up .setBackgroundResource(R.drawable.sania);
			break;

		case R.id.sachin_btn:
			layout_up.setBackgroundResource(R.drawable.sachin);

			break;

		case R.id.anand_btn:
			layout_up.setBackgroundResource(R.drawable.vishwa);

			break;
		case R.id.ronaldo_btn:
			layout_up .setBackgroundResource(R.drawable.ronaldo);

			break;
		case R.id.rana_btn:
			layout_down .setBackgroundResource(R.drawable.rana);

			break;
		case R.id.raj_btn:
			layout_down .setBackgroundResource(R.drawable.rajmouli);

			break;
		case R.id.anuska_btn:
			layout_down .setBackgroundResource(R.drawable.anuska);

			break;
			
		case R.id.prabhas_btn:
			layout_down.setBackgroundResource(R.drawable.prabhas);

			break;
				
			
		default:
			break;

		}
	}
	
}

