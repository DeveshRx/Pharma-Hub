package devesh.b.pharm.guide.mu;

/* B.Pharm Guide App is Written & Developed by Devesh Chaushari

 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class Scheme extends Activity {
	public String pg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		getActionBar().hide();

		setContentView(R.layout.scheme);

		getActionBar().setDisplayShowHomeEnabled(false);
		getActionBar().setDisplayShowTitleEnabled(false);


		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);

		pg = "sem3";
		WebView myWebView = (WebView) findViewById(R.id.webView);
		myWebView.loadUrl("https://sites.google.com/site/bpharmapp/home/scheme");
		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebViewClient(new MyWebViewClient());
		

	        

	}

	private class MyWebViewClient extends WebViewClient {

		ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar3);

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon ) {
			// TODO Auto-generated method stub
			progress.setVisibility(View.VISIBLE);


		}

		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			//super.onPageFinished(view, url);
			progress.setVisibility(View.INVISIBLE);

		}


	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(this, home.class);
			startActivity(intent);
			finish();

		}
		// your code
		return true;
	}
}
