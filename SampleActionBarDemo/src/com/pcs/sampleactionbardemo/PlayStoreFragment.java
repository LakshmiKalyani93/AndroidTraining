package com.pcs.sampleactionbardemo;

import com.pcs.sampleactionbardemo.WebFragment.MyBrowser;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PlayStoreFragment extends Fragment{
	private WebView webView;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//Inflating our own layout
		View rootView = inflater.inflate(R.layout.playstore, container, false);
		webView=(WebView)rootView.findViewById(R.id.web_View);
		//Getting an instance to the class Browser
		MyBrowser browse_googleplay=new MyBrowser();
		webView.setWebViewClient(browse_googleplay);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("http://play.google.com/store");
		
		return rootView;

	}
	public static class MyBrowser extends WebViewClient{
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	}

}
