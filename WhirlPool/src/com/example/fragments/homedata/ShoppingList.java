package com.example.fragments.homedata;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.whirlpool.R;
import com.example.whirlpool.ShoppersListActivity;

public class ShoppingList extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View shop_view=inflater.inflate(R.layout.shopping_list_fragment,container,false);

		shop_view.setOnClickListener(new  OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(getActivity(),ShoppersListActivity.class);
				startActivity(intent);
			}
		});

		return shop_view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}
	
	
	
	
	

}
