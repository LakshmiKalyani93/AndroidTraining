package com.pcs.samplefragmentapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

public class MainFragmentActivity extends FragmentActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
	}
	
	public static class ActionFragmentActivity extends Fragment implements OnClickListener{

		private Button pcsBtn;
		private Button gitBtn;
		private Button sportsBtn;
		private Button androidBtn;

		@Override
		public View onCreateView(LayoutInflater inflater,
				ViewGroup container,  Bundle savedInstanceState) {

			View actionView = inflater.inflate(R.layout.action, container, false);

			pcsBtn=(Button)actionView.findViewById(R.id.pcs_btn);
			gitBtn=(Button)actionView.findViewById(R.id.git_btn);
			sportsBtn=(Button)actionView.findViewById(R.id.sports_btn);
			androidBtn=(Button)actionView.findViewById(R.id.android_btn);

			pcsBtn.setOnClickListener(this);
			gitBtn.setOnClickListener(this);
			androidBtn.setOnClickListener(this);
			sportsBtn.setOnClickListener(this);

			return actionView;

		}

		@Override
		public void onClick(View v) {
			DispalyFragmentActivity displayFragment = new DispalyFragmentActivity(v.getId());
			getFragmentManager().beginTransaction().add(R.id.display_fragment, displayFragment).commit();

		}

	}
	public static class MyBrowser extends WebViewClient{
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	}

	public static class DispalyFragmentActivity extends Fragment {

		private int id;

		private WebView pcs_webVw;
		private WebView git_webVw;
		private ImageView sports_imgVw;
		private ImageView android_imgVw;
		public DispalyFragmentActivity() {
		}
		public DispalyFragmentActivity(int id) {
			this.id=id;
		}

		@SuppressLint("SetJavaScriptEnabled")
		@Override
		public View onCreateView(LayoutInflater inflater,
				ViewGroup container,  Bundle savedInstanceState) {
			View displayView =inflater.inflate(R.layout.display,container, false);

			pcs_webVw=(WebView)displayView.findViewById(R.id.pcs_webVw);
			git_webVw=(WebView)displayView.findViewById(R.id.git_webVw);
			sports_imgVw=(ImageView)displayView.findViewById(R.id.sports_imgVw);
			android_imgVw=(ImageView)displayView.findViewById(R.id.android_imgVw);

			switch(id){	

			case R.id.pcs_btn:
				pcs_webVw.setVisibility(View.VISIBLE);
				git_webVw.setVisibility(View.GONE);
				android_imgVw.setVisibility(View.GONE);
				sports_imgVw.setVisibility(View.GONE);
				MyBrowser browse_pcs=new MyBrowser();
				pcs_webVw.setWebViewClient(browse_pcs);
				pcs_webVw.getSettings().setJavaScriptEnabled(true);
				pcs_webVw.loadUrl("http://paradigmcreatives.com");

				break;
			case R.id.git_btn:
				pcs_webVw.setVisibility(View.GONE);
				git_webVw.setVisibility(View.VISIBLE);
				android_imgVw.setVisibility(View.GONE);
				sports_imgVw.setVisibility(View.GONE);
				MyBrowser browse_git=new MyBrowser();
				git_webVw.setWebViewClient(browse_git);
				git_webVw.getSettings().setJavaScriptEnabled(true);
				git_webVw.loadUrl("http://github.com");
				break;
			case R.id.android_btn:
				pcs_webVw.setVisibility(View.GONE);
				git_webVw.setVisibility(View.GONE);
				android_imgVw.setVisibility(View.VISIBLE);
				sports_imgVw.setVisibility(View.GONE);
				android_imgVw.setBackgroundResource(R.drawable.versions);
				break;
			case R.id.sports_btn:
				pcs_webVw.setVisibility(View.GONE);
				git_webVw.setVisibility(View.GONE);
				android_imgVw.setVisibility(View.GONE);
				sports_imgVw.setBackgroundResource(R.drawable.sports_img);
				android_imgVw.setVisibility(View.GONE);
				break;
				default:
					break;
			}

			return displayView;

		}	
	}

}
