package devesh.b.pharm.guide.mu;

/* B.Pharm Guide App is Written & Developed by Devesh Chaushari

*/

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class About extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
	//    getActionBar().hide();
		setContentView(R.layout.about);
		
		//		getActionBar().setDisplayShowHomeEnabled(false);
	//	getActionBar().setDisplayShowTitleEnabled(false);


	}
	public void update(View v){
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://play.google.com/store/apps/dev?id=6568269370408193556"));
		startActivity(intent);  // get more ephrine apps
		
		
	}
	public void getp(View v){
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("market://details?id=devesh.b.pharm.guide.premium"));
		startActivity(intent);


	}

	public void contact(View v){
		setContentView(R.layout.contact);
		WebView myWebView = (WebView) findViewById(R.id.webView4);
		myWebView.loadUrl("http://goo.gl/forms/CJvLGFXOEE");
		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		myWebView.setWebViewClient(new WebViewClient());
		myWebView.setWebViewClient(new MyWebViewClient());


	}
	private class MyWebViewClient extends WebViewClient {

		ProgressBar p = (ProgressBar) findViewById(R.id.progressBar8);

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {



			// Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs

			//     if (mInterstitialAd.isLoaded()) {
			//        mInterstitialAd.show();
			//     } else {
			//     }
			if (Uri.parse(url).getHost().equals("docs.google.com")) {
				// This is my web site, so do not override; let my WebView load the page
				// dialog = ProgressDialog.show(about.this, "",
				//         "Loading. Please wait...", true);
				p.setVisibility(View.VISIBLE);
				return false;
			}
			if (Uri.parse(url).getHost().equals("goo.gl")) {
				// This is my web site, so do not override; let my WebView load the page
				//  dialog = ProgressDialog.show(about.this, "",
				//         "Loading. Please wait...", true);
				p.setVisibility(View.VISIBLE);
				return false;
			}



			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
			startActivity(intent);
			return true;
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			//  dialog = ProgressDialog.show(about.this, "",
			//        "Loading. Please wait...", true);
			p.setVisibility(View.VISIBLE);
			super.onPageStarted(view, url, favicon);
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);
			p.setVisibility(View.GONE);
			//dialog.hide();
		}


	}





}
