package com.pcs.sampleactionbardemo;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebFragment extends Fragment{
	private WebView webView;
	@SuppressLint("SetJavaScriptEnabled")
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//Inflating our own layout 
		View rootView = inflater.inflate(R.layout.web, container, false);
		//fetching webview of the layout web
		webView=(WebView)rootView.findViewById(R.id.web_Vw);
		//Getting an instance to the class Browser
		MyBrowser browse_pcs=new MyBrowser();
		webView.setWebViewClient(browse_pcs);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("http://paradigmcreatives.com");
		
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
