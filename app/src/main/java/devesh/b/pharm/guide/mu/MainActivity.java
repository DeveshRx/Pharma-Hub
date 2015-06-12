package devesh.b.pharm.guide.mu;

/* B.Pharm Guide App is Written & Developed by Devesh Chaushari

 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

//import com.google.ads.AdRequest;
//import com.google.android.gms.ads.AdListener;

public class MainActivity extends Activity {
	public String pg = "0";
	public String sem;
	public String pg4sub;
	InterstitialAd mInterstitialAd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getActionBar().setDisplayShowHomeEnabled(false);
		getActionBar().setDisplayShowTitleEnabled(false);

		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);



		
		mInterstitialAd = new InterstitialAd(this); // interstitial ad

		mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712"); // Sample
																				// test
																				// ID


		requestNewInterstitial();

		mInterstitialAd.setAdListener(new AdListener() {
			@Override
			public void onAdClosed() {
				requestNewInterstitial();
				finish();
			}
		});

	}

	private void requestNewInterstitial() {
		AdRequest adRequest = new AdRequest.Builder().addTestDevice(
				"YOUR_DEVICE_HASH").build();

		mInterstitialAd.loadAd(adRequest);
	}

	public void download_pdf(View v) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri
				.parse("http://pharmawiki.in/wp-content/uploads/2012/04/bpharm_final_year_syllabus_mumbai_univ.pdf"));
		startActivity(intent);

	}

	public void download_pdf_cbgs(View v) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri
				.parse("http://www.mu.ac.in/syllabus/B.Pharm%20Final%20Year.pdf"));
		startActivity(intent);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class MyWebViewClient extends WebViewClient {

		ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {

			/*if (Uri.parse(url).getHost().equals("m.itemvn.com")) {
				// This is my web site, so do not override; let my WebView load the page
				progress.setVisibility(View.VISIBLE);
				return false;
			}*/

			progress.setVisibility(View.VISIBLE);

			// Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
			startActivity(intent);
			return true;
		}





		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon ) {
			// TODO Auto-generated method stub
			progress.setVisibility(View.VISIBLE);

			//progressH.setProgress(view.getProgress());

		//	super.onPageStarted(view, url, favicon);
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			//super.onPageFinished(view, url);
			progress.setVisibility(View.INVISIBLE);

		}


	}

	public void offline_savepic(View v){
		Intent intent = new Intent(this, GoPro.class);
		startActivity(intent);
	}
	public void offline_savetxt(View v){
		Intent intent = new Intent(this, GoPro.class);
		startActivity(intent);
	}
	public void save_pdf(View v){
		Intent intent = new Intent(this, GoPro.class);
		startActivity(intent);
	}

	// sem.xml

	public void sem1(View v) {
		sem = "sem1";
		pg = "1";

	//	Intent sem1 = new Intent(this, sem1.class);
	//	startActivity(sem1);


			setContentView(R.layout.sem);

		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
		
		Button but1 = (Button) findViewById(R.id.button1);
		Button but2 = (Button) findViewById(R.id.button2);
		Button but3 = (Button) findViewById(R.id.button3);
		Button but4 = (Button) findViewById(R.id.button4);
		Button but5 = (Button) findViewById(R.id.button5);
		Button but6 = (Button) findViewById(R.id.button6);
		Button but7 = (Button) findViewById(R.id.button7);
		Button but8 = (Button) findViewById(R.id.button8);
		Button but9 = (Button) findViewById(R.id.button9);
		Button but10 = (Button) findViewById(R.id.button10);

		but1.setText("Physical Organic Chemistry");
		but2.setText("Physical Pharmacy 1");
		but3.setText("Anatomy, Physiology & Pathophysiology 1");
		but4.setText("E.V.S ");
		but5.setText("Communication Skill");
		but6.setText("Physical Pharmacy Lab");
		but7.setText("Anatomy, Physiology & Pathophysiology Lab");
		but8.setText("Computer Lab");
		but10.setVisibility(View.GONE);
		but9.setVisibility(View.GONE);


	}

	public void sem2(View v) {
		sem = "sem2";
		pg = "1";

		setContentView(R.layout.sem);

		

		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
		
		Button but1 = (Button) findViewById(R.id.button1);
		Button but2 = (Button) findViewById(R.id.button2);
		Button but3 = (Button) findViewById(R.id.button3);
		Button but4 = (Button) findViewById(R.id.button4);
		Button but5 = (Button) findViewById(R.id.button5);
		Button but6 = (Button) findViewById(R.id.button6);
		Button but7 = (Button) findViewById(R.id.button7);
		Button but8 = (Button) findViewById(R.id.button8);
		Button but9 = (Button) findViewById(R.id.button9);
		Button but10 = (Button) findViewById(R.id.button10);

		but1.setText("Pharmaceutical Chemistry");
		but2.setText("Biochemistry 1");
		but3.setText("Pharmaceutics");
		but4.setText("Physical Pharmacy 2");
		but5.setText("Anatomy, Physiology & Pathophysiology");
		but6.setText("Pharmaceutical Chemistry Lab");
		but7.setText("Pharmaceutics Lab");
		but8.setText("Physical Pharmacy Lab");
		but10.setVisibility(View.GONE);
		but9.setVisibility(View.GONE);

	}

	public void sem3(View v) {
		sem = "sem3";
		pg = "1";
		setContentView(R.layout.sem);


		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);

		Button but1 = (Button) findViewById(R.id.button1);
		Button but2 = (Button) findViewById(R.id.button2);
		Button but3 = (Button) findViewById(R.id.button3);
		Button but4 = (Button) findViewById(R.id.button4);
		Button but5 = (Button) findViewById(R.id.button5);
		Button but6 = (Button) findViewById(R.id.button6);
		Button but7 = (Button) findViewById(R.id.button7);
		Button but8 = (Button) findViewById(R.id.button8);
		Button but9 = (Button) findViewById(R.id.button9);
		Button but10 = (Button) findViewById(R.id.button10);

		but1.setText("Organic Chemistry");
		but2.setText("Biochemistry 2");
		but3.setText("Dispensing Pharmacy");
		but4.setText("Pharmaceutical Enginnering");
		but5.setText("Anatomy, Physiology & Pathophysiology 3");
		but6.setText("Maths");
		but7.setText("Organic Chemistry Lab");
		but8.setText("Biochemistry Lab");
		but9.setText("Dispensing Pharmacy Lab");
		but10.setVisibility(View.GONE);
	}

	public void sem4(View v) {
		sem = "sem4";
		pg = "1";

		setContentView(R.layout.sem);


		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);

		Button but1 = (Button) findViewById(R.id.button1);
		Button but2 = (Button) findViewById(R.id.button2);
		Button but3 = (Button) findViewById(R.id.button3);
		Button but4 = (Button) findViewById(R.id.button4);
		Button but5 = (Button) findViewById(R.id.button5);
		Button but6 = (Button) findViewById(R.id.button6);
		Button but7 = (Button) findViewById(R.id.button7);
		Button but8 = (Button) findViewById(R.id.button8);
		Button but9 = (Button) findViewById(R.id.button9);
		Button but10 = (Button) findViewById(R.id.button10);

		but1.setText("Organic Chemistry 2");
		but2.setText("Pharmaceutical Analysis");
		but3.setText("Pharmaceutics 2");
		but4.setText("MicroBiology");
		but5.setText("Pharmacology");
		but6.setText("Maths & Statictics");
		but7.setText("Pharmaceutical Analysis Lab");
		but8.setText("Pharmaceutics Lab 2");
		but9.setText("Pharmacology Lab");
		but10.setVisibility(View.VISIBLE);
		but10.setText("MicroBiology Lab");

	}

	public void sem5(View v) {
		sem = "sem5";
		pg = "1";

		setContentView(R.layout.sem);


		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);

		Button but1 = (Button) findViewById(R.id.button1);
		Button but2 = (Button) findViewById(R.id.button2);
		Button but3 = (Button) findViewById(R.id.button3);
		Button but4 = (Button) findViewById(R.id.button4);
		Button but5 = (Button) findViewById(R.id.button5);
		Button but6 = (Button) findViewById(R.id.button6);
		Button but7 = (Button) findViewById(R.id.button7);
		Button but8 = (Button) findViewById(R.id.button8);
		Button but9 = (Button) findViewById(R.id.button9);
		Button but10 = (Button) findViewById(R.id.button10);

		but1.setText("Organic Chemistry 3");
		but2.setText("Cosmeticology");
		but3.setText("Pharmaceutical Biotechnology");
		but4.setText("Pharmacology 2");
		but5.setText("Pharmaceutical Management");
		but6.setText("Organic Chemistry Lab 2");
		but8.setText("Cosmeticology Lab");

		but7.setText("Pharmaceutical Biotechnology Lab");

		but9.setVisibility(View.GONE);
		but10.setVisibility(View.GONE);

	}

	public void sem6(View v) {
		sem = "sem6";
		pg = "1";

		setContentView(R.layout.sem);

		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
		
		Button but1 = (Button) findViewById(R.id.button1);
		Button but2 = (Button) findViewById(R.id.button2);
		Button but3 = (Button) findViewById(R.id.button3);
		Button but4 = (Button) findViewById(R.id.button4);
		Button but5 = (Button) findViewById(R.id.button5);
		Button but6 = (Button) findViewById(R.id.button6);
		Button but7 = (Button) findViewById(R.id.button7);
		Button but8 = (Button) findViewById(R.id.button8);
		Button but9 = (Button) findViewById(R.id.button9);
		Button but10 = (Button) findViewById(R.id.button10);

		but1.setText("Pharmaceutical Chemistry 2");
		but2.setText("Pharmaceutical Analysis 2");
		but3.setText("Pharmaceutics 3");
		but4.setText("Pharmacognosy and Phytochemistry 1");
		but5.setText("Hospital Pharmacy & Drug Store Management");
		but6.setText("Pharmaceutical Chemistry Lab 2");
		but8.setText("Pharmaceutical Analysis Lab");

		but7.setText("Pharmaceutics Lab 3");
		but9.setText("Pharmacognosy and Phytochemistry Lab 1");
		but10.setVisibility(View.GONE);

	}

	// sem_subj.xml
	public void button1(View v) {

		if (sem == "sem1") {


			setContentView(R.layout.sem_subj);

			WebView myWebView = (WebView) findViewById(R.id.webView2);
            pg4sub="sem1_poc_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem1_poc.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//ImageView img = (ImageView) findViewById(R.id.imageView1);
			//ImageView img2 = (ImageView) findViewById(R.id.imageView2);

			//TextView sub = (TextView) findViewById(R.id.textView3);

			pg = "b3";

		//	sub.setText("Physical Organic Chemistry");

		//	img2.setImageResource(R.drawable.sem1_poc_pg2);

		//	img.setImageResource(R.drawable.sem1_poc);

		}
		if (sem == "sem2") {


			setContentView(R.layout.sem_subj);
			pg = "b4";


			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub="sem2_pchem_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem2_pchem.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmaceutical Chemistry");

		//	img.setImageResource(R.drawable.sem2_pchem);

		}

		if (sem == "sem3") {

			// sem 3 OC BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b1";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem3_oc_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem3_oc.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


	//		ImageView img = (ImageView) findViewById(R.id.imageView1);
	//		ImageView img2 = (ImageView) findViewById(R.id.imageView2);

	//		TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Organic Chemistry");

		//	img2.setImageResource(R.drawable.sem3_oc_pg2);

		//	img.setImageResource(R.drawable.sem3_oc);

		}
		if (sem == "sem4") {
			// sem 4 OC BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b2";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem4_oc_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem4_oc.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Organic Chemistry 2");
		//	img.setImageResource(R.drawable.sem4_oc);
		//	img2.setImageResource(R.drawable.sem4_oc_pg2);

		}
		if (sem == "sem5") {
			// sem 4 OC BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b5";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem5_oc_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem5_oc.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Organic Chemistry 3");
		//	img.setImageResource(R.drawable.sem5_oc);
		//	img2.setImageResource(R.drawable.sem5_oc_pg2);

		}
		if (sem == "sem6") {
			// sem 4 OC BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b6";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem6_pchem_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem6_pchem.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmaceutical Chemistry 2");
		//	img.setImageResource(R.drawable.sem6_pchem);
		//	img2.setImageResource(R.drawable.sem6_pchem_pg2);

		}

	}

	public void button2(View v) {

		if (sem == "sem1") {
			setContentView(R.layout.sem_subj);
			pg = "b3";


			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem1_pp_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem1_pp.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);
		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Physical Pharmacy 1");

			//img2.setImageResource(R.drawable.sem1_pp_pg2);

			//img.setImageResource(R.drawable.sem1_pp);
		}

		if (sem == "sem2") {

			// sem 3 OC BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b4";


			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem2_bc_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem2_bc.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);
//
		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Biochemistry");

		//	img2.setImageResource(R.drawable.sem2_bc_pg2);

		//	img.setImageResource(R.drawable.sem2_bc);

		}

		if (sem == "sem3") {
			// sem3 bc BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b1";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem3_bc_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem3_bc.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Biochemistry 2");

		//	img2.setImageResource(R.drawable.sem3_bc_pg2);

		//	img.setImageResource(R.drawable.sem3_bc);

		}
		if (sem == "sem4") {
			// sem 4 PA BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b2";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem4_pa_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem4_pa.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);
		//	ImageView img3 = (ImageView) findViewById(R.id.imageView3);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmaceutical Analysis");

		//	img.setImageResource(R.drawable.sem4_pa);

		//	img2.setImageResource(R.drawable.sem4_pa_pg2);

		//	img3.setImageResource(R.drawable.sem4_pa_pg3);

			// img4.setImageResource(R.drawable.sem4_pa_pg4);

		}
		if (sem == "sem5") {
			// sem3 bc BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b5";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem5_cl_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem5_cl.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Cosmeticology");

		//	img2.setImageResource(R.drawable.sem5_cl_pg2);

		//	img.setImageResource(R.drawable.sem5_cl);

		}
		if (sem == "sem6") {
			// sem3 bc BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b6";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem6_pa_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem6_pa.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	ImageView img3 = (ImageView) findViewById(R.id.imageView3);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

//			sub.setText("Pharmaceutical Analysis 2");

		//	img2.setImageResource(R.drawable.sem6_pa_pg2);

		//	img.setImageResource(R.drawable.sem6_pa);
		//	img3.setImageResource(R.drawable.sem6_pa_pg3);

		}

	}

	public void button3(View v) {

		if (sem == "sem1") {
			// sem3 dp BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b3";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem1_app_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem1_app.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Anatomy, Physiology & Pathophysiology 1");
		//	img.setImageResource(R.drawable.sem1_app);

		//	img2.setImageResource(R.drawable.sem1_app_pg2);

		}
		if (sem == "sem2") {
			// sem3 dp BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b4";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem2_pceutics_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem2_pceutics.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


		//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmaceutics");
		//	img.setImageResource(R.drawable.sem2_pceutics);

		//	img2.setImageResource(R.drawable.sem2_pceutics_pg2);

		}

		if (sem == "sem3") {
			// sem3 dp BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b1";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem3_dp_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem3_dp.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Dispensing Pharmacy");
		//	img.setImageResource(R.drawable.sem3_dp);

		//	img2.setImageResource(R.drawable.sem3_dp_pg2);

		}

		if (sem == "sem4") {
			// sem4 pceutics BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b2";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem4_pceutics_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem4_pceutics.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
		myWebView.setWebViewClient(new MyWebViewClient());



			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmaceutics 2");
		//	img.setImageResource(R.drawable.sem4_pceutics);

		//	img2.setImageResource(R.drawable.sem4_pceutics_pg2);

		}
		if (sem == "sem5") {
			// sem3 dp BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b5";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem5_pb_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem5_pb.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

			//TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmaceutical Biotechnology");
		//	img.setImageResource(R.drawable.sem5_pb);

		//	img2.setImageResource(R.drawable.sem5_pb_pg2);

		}
		if (sem == "sem6") {
			// sem3 dp BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b6";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem6_pceutics_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem6_pceutics.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
//
		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmaceutics 3");
		//	img.setImageResource(R.drawable.sem6_pceutics);

		//	img2.setImageResource(R.drawable.sem6_pceutics_pg2);

		}

	}

	public void button4(View v) {

		if (sem == "sem1") {
			// sem3 dp BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b3";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem1_evs_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem1_evs.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("E.V.S");
		//	img.setImageResource(R.drawable.sem1_evs);

		//	img2.setImageResource(R.drawable.sem1_evs_pg2);

		}
		if (sem == "sem2") {
			// sem3 dp BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b4";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem2_pp_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem2_pp.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
		myWebView.setWebViewClient(new MyWebViewClient());

		//	//ImageView img = (ImageView) findViewById(R.id.imageView1);
			//ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Physical Pharmacy 2");
		//	img.setImageResource(R.drawable.sem2_pp);

		//	img2.setImageResource(R.drawable.sem2_pp_pg2);

		}

		if (sem == "sem3") {
			// sem3 pe BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b1";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem3_pe_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem3_pe.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		///	img.setImageResource(R.drawable.sem3_pe);

		//	img2.setImageResource(R.drawable.sem3_pe_pg2);

		}
		if (sem == "sem4") {
			// sem4 microbiology BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b2";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem4_microbio_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem4_microbio.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Microbiology");
		//	img.setImageResource(R.drawable.sem4_microbio);

		//	img2.setImageResource(R.drawable.sem4_microbio_pg2);

		}

		if (sem == "sem5") {
			// sem4 microbiology BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b5";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem5_pcology_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem5_pcology.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//ImageView img = (ImageView) findViewById(R.id.imageView1);
			//ImageView img2 = (ImageView) findViewById(R.id.imageView2);

			//TextView sub = (TextView) findViewById(R.id.textView3);

			//sub.setText("Pharmacology 2");
		//	img.setImageResource(R.drawable.sem5_pcology);

		//	img2.setImageResource(R.drawable.sem5_pcology_pg2);

		}
		if (sem == "sem6") {
			// sem4 microbiology BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b6";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem6_pp_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem6_pp.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	ImageView img3 = (ImageView) findViewById(R.id.imageView3);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmacognosy and Phytochemistry 1");
			//img.setImageResource(R.drawable.sem6_pp);

		//	img2.setImageResource(R.drawable.sem6_pp_pg2);
		//	img3.setImageResource(R.drawable.sem6_pp_pg3);

		}

	}

	public void button5(View v) {

		if (sem == "sem1") {
			// sem3 dp BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b3";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem1_cs_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem1_cs.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Communication Skill");
		//	img.setImageResource(R.drawable.sem1_cs);

		}
		if (sem == "sem2") {
			// sem3 dp BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b4";
			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem2_app_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem2_app.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

		//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Anatomy, Physiology & Pathophysiology 2");
		//	img.setImageResource(R.drawable.sem2_app);

		//	img2.setImageResource(R.drawable.sem2_app_pg2);

		}

		if (sem == "sem3") {
			// sem3 APP BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b1";
			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem3_app_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem3_app.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Anatomy, Physiology & Pathophysiology 3");
		//	img.setImageResource(R.drawable.sem3_app);

		//	img2.setImageResource(R.drawable.sem3_app_pg2);

		}
		if (sem == "sem4") {
			// sem3 APP BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b2";
			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem4_cs_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem4_pcology.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

			//sub.setText("Phyarmacology");
		//	img.setImageResource(R.drawable.sem4_pcology);

		}

		if (sem == "sem5") {
			// sem4 microbiology BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b5";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem5_pm_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem5_pm.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//
		//	sub.setText("Pharmaceutical Management");
		//	img.setImageResource(R.drawable.sem5_pm);

		//	img2.setImageResource(R.drawable.sem5_pm_pg2);

		}
		if (sem == "sem6") {
			// sem4 microbiology BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b6";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem6_hp_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem6_hp.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//ImageView img = (ImageView) findViewById(R.id.imageView1);
			//ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Hospital Pharmacy & Drug Store Management");
		//	img.setImageResource(R.drawable.sem6_hp);

		//	img2.setImageResource(R.drawable.sem6_hp_pg2);

		}

	}

	public void button6(View v) {

		if (sem == "sem1") {
			// sem3 maths BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b3";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem1_pp_lab_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem1_pp_lab.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Physical Pharmacy Lab");
		//	img.setImageResource(R.drawable.sem1_pp_lab);

		}
		if (sem == "sem2") {
			// sem3 dp BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b4";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem2_pchem_lab_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem2_pchem_lab.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmaceutical Chemistry");
		//	img.setImageResource(R.drawable.sem2_pchem_lab);

		}

		if (sem == "sem3") {
			// sem3 maths BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b1";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem3_maths_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem3_maths.png");

			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Maths");
		//	img.setImageResource(R.drawable.sem3_maths);

		}

		if (sem == "sem4") {
			// sem3 maths BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b2";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem4_maths_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem4_maths.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Maths & ststics");
		//	img.setImageResource(R.drawable.sem4_maths);

		}
		if (sem == "sem5") {
			// sem3 maths BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b5";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem5_oc_lab_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem5_oc_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
		myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Organic Chemistry lab 2");
		//	img.setImageResource(R.drawable.sem5_oc_lab);

		}
		if (sem == "sem6") {
			// sem3 maths BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b6";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem6_pchem_lab__pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem6_pchem_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmaceutical Chemistry lab 2");
		//	img.setImageResource(R.drawable.sem6_pchem_lab);

		}

	}

	public void button7(View v) {

		if (sem == "sem1") {
			// sem3 oc lab BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b3";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem1_app_lab_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem1_app_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	ImageView img2 = (ImageView) findViewById(R.id.imageView2);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Anatomy, Physiology & Pathophysiology Lab");
		//	img.setImageResource(R.drawable.sem1_app_lab);

		//	img2.setImageResource(R.drawable.sem1_app_lab_pg2);

		}
		if (sem == "sem2") {
			// sem3 dp BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b4";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem2_pceutics_lab_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem2_pceutics_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmaceutics");
		//	img.setImageResource(R.drawable.sem2_pceutics_lab);

		}

		if (sem == "sem3") {
			// sem3 oc lab BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b1";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem3_oc_lab__pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem3_oc_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//ImageView img = (ImageView) findViewById(R.id.imageView1);

			//TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Organic Chemistry Lab");
			//img.setImageResource(R.drawable.sem3_oc_lab);

		}
		if (sem == "sem4") {
			// sem4 pa lab BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b2";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem4_pa_lab_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem4_pa_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmaceutical Analytics Lab");
		//	img.setImageResource(R.drawable.sem4_pa_lab);

		}

		if (sem == "sem5") {
			// sem3 maths BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b5";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem5_pb_lab_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem5_pb_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmaceutical Biotechnology Lab");
		//	img.setImageResource(R.drawable.sem5_pb_lab);

		}
		if (sem == "sem6") {
			// sem3 maths BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b6";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem6_pceutics_lab_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem6_pceutics_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmaceutics lab 3");
		//	img.setImageResource(R.drawable.sem6_pceutics_lab);

		}

	}

	public void button8(View v) {

		if (sem == "sem1") {
			// sem3 bc lab BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b3";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem1_comp_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem1_comp.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);
		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Computer Lab");
		//	img.setImageResource(R.drawable.sem1_comp);

		}
		if (sem == "sem2") {
			// sem3 dp BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b4";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem2_pp_lab_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem2_pp_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Physical Pharmacy lab");
		//	img.setImageResource(R.drawable.sem2_pp_lab);

		}

		if (sem == "sem3") {
			// sem3 bc lab BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b1";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem3_bc_lab_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem3_bc_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Biochemistry Lab");
		//	img.setImageResource(R.drawable.sem3_bc_lab);

		}
		if (sem == "sem4") {
			// sem4 pceutics lab BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b2";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem4_pceutics_lab_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem4_pceutics_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmaceutics Lab 2");
		//	img.setImageResource(R.drawable.sem4_pceutics_lab);

		}

		if (sem == "sem5") {
			// sem3 maths BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b5";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem5_cl_lab_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem5_cl_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Cosmeticology lab");
		//	img.setImageResource(R.drawable.sem5_cl_lab);

		}
		if (sem == "sem6") {
			// sem3 maths BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b6";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem6_pa_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem6_pa_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmaceutical Analysis lab");
		//	img.setImageResource(R.drawable.sem6_pa_lab);

		}

	}

	public void button9(View v) {

		if (sem == "sem3") {
			// sem3 dp lab BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b1";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem3_dp_lab_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem3_dp_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Dispensing Pharmacy Lab");
		//	img.setImageResource(R.drawable.sem3_dp_lab);

		}
		if (sem == "sem4") {
			// sem4 poclogy lab BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b2";
			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem4_pcology_lab_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem4_pcology_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Pharmacology Lab");
		//	img.setImageResource(R.drawable.sem4_pcology_lab);

		}
		if (sem == "sem6") {
			// sem3 maths BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b6";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem6_pp_lab_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem6_pp_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());

			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

	//		sub.setText("Pharmacognosy and Phytochemistry lab 1");
		//	img.setImageResource(R.drawable.sem6_pp_lab);

		}

	}

	public void button10(View v) {

		if (sem == "sem4") {
			// sem4 pcology lab BUTTON
			setContentView(R.layout.sem_subj);
			pg = "b2";

			WebView myWebView = (WebView) findViewById(R.id.webView2);
			pg4sub = "sem4_mb_lab_pg1";
			myWebView.loadUrl("https://sites.google.com/site/bpharmapp/sem4_mb_lab.png");
			WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			myWebView.setWebViewClient(new WebViewClient());
			myWebView.setWebViewClient(new MyWebViewClient());


			//	ImageView img = (ImageView) findViewById(R.id.imageView1);

		//	TextView sub = (TextView) findViewById(R.id.textView3);

		//	sub.setText("Microbiology Lab");
		//	img.setImageResource(R.drawable.sem4_mb_lab);

		}

	}


	public void scheme(View v){

		Intent intent = new Intent(this, Scheme.class);
		startActivity(intent);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.about) {
			Intent intent = new Intent(this, About.class);
			startActivity(intent);
			return true;
		}
		if (id == R.id.exit) {
			finish();
			return true;
		}
		if (id == R.id.fb) {
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri
					.parse("https://www.facebook.com/deveshappsstore"));
			startActivity(intent);
			return true;
		}
		if (id == R.id.gplus) {
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri
					.parse("https://plus.google.com/+DeveshChaudhari95"));
			startActivity(intent);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (pg == "0") {
				if (mInterstitialAd.isLoaded()) {
					
					//Intent intent1 = new Intent(this, home.class);
					//startActivity(intent1);
					mInterstitialAd.show();



				}
					Intent intent1 = new Intent(this, home.class);
					startActivity(intent1);
					finish();


			}
			if (pg == "1") {

				setContentView(R.layout.activity_main);
				AdView mAdView = (AdView) findViewById(R.id.adView);
				AdRequest adRequest = new AdRequest.Builder().build();
				mAdView.loadAd(adRequest);
				pg = "0";

			}

			if (pg == "b1") {
				// finish();
				setContentView(R.layout.sem);

				AdView mAdView = (AdView) findViewById(R.id.adView);
				AdRequest adRequest = new AdRequest.Builder().build();
				mAdView.loadAd(adRequest);

				Button but1 = (Button) findViewById(R.id.button1);
				Button but2 = (Button) findViewById(R.id.button2);
				Button but3 = (Button) findViewById(R.id.button3);
				Button but4 = (Button) findViewById(R.id.button4);
				Button but5 = (Button) findViewById(R.id.button5);
				Button but6 = (Button) findViewById(R.id.button6);
				Button but7 = (Button) findViewById(R.id.button7);
				Button but8 = (Button) findViewById(R.id.button8);
				Button but9 = (Button) findViewById(R.id.button9);
				Button but10 = (Button) findViewById(R.id.button10);

				but1.setText("Organic Chemistry");
				but2.setText("Biochemistry 2");
				but3.setText("Dispensing Pharmacy");
				but4.setText("Pharmaceutical Enginnering");
				but5.setText("Anatomy, Physiology & Pathophysiology 3");
				but6.setText("Maths");
				but7.setText("Organic Chemistry Lab");
				but8.setText("Biochemistry Lab");
				but9.setText("Dispensing Pharmacy Lab");
				but10.setVisibility(View.GONE);
				pg = "1";
			}
			if (pg == "b2") {
				setContentView(R.layout.sem);

				AdView mAdView = (AdView) findViewById(R.id.adView);
				AdRequest adRequest = new AdRequest.Builder().build();
				mAdView.loadAd(adRequest);

				Button but1 = (Button) findViewById(R.id.button1);
				Button but2 = (Button) findViewById(R.id.button2);
				Button but3 = (Button) findViewById(R.id.button3);
				Button but4 = (Button) findViewById(R.id.button4);
				Button but5 = (Button) findViewById(R.id.button5);
				Button but6 = (Button) findViewById(R.id.button6);
				Button but7 = (Button) findViewById(R.id.button7);
				Button but8 = (Button) findViewById(R.id.button8);
				Button but9 = (Button) findViewById(R.id.button9);
				Button but10 = (Button) findViewById(R.id.button10);

				but1.setText("Organic Chemistry 2");
				but2.setText("Pharmaceutical Analysis");
				but3.setText("Pharmaceutics 2");
				but4.setText("MicroBiology");
				but5.setText("Pharmacology");
				but6.setText("Maths & Statictics");
				but7.setText("Pharmaceutical Analysis Lab");
				but8.setText("Pharmaceutics Lab 2");
				but9.setText("Pharmacology Lab");
				but10.setVisibility(View.VISIBLE);
				but10.setText("MicroBiology Lab");
				pg = "1";

			}
			if (pg == "b3") {
				setContentView(R.layout.sem);

				AdView mAdView = (AdView) findViewById(R.id.adView);
				AdRequest adRequest = new AdRequest.Builder().build();
				mAdView.loadAd(adRequest);

				Button but1 = (Button) findViewById(R.id.button1);
				Button but2 = (Button) findViewById(R.id.button2);
				Button but3 = (Button) findViewById(R.id.button3);
				Button but4 = (Button) findViewById(R.id.button4);
				Button but5 = (Button) findViewById(R.id.button5);
				Button but6 = (Button) findViewById(R.id.button6);
				Button but7 = (Button) findViewById(R.id.button7);
				Button but8 = (Button) findViewById(R.id.button8);
				Button but9 = (Button) findViewById(R.id.button9);
				Button but10 = (Button) findViewById(R.id.button10);

				but1.setText("Physical Organic Chemistry");
				but2.setText("Physical Pharmacy 1");
				but3.setText("Anatomy, Physiology & Pathophysiology 1");
				but4.setText("E.V.S ");
				but5.setText("Communication Skill");
				but6.setText("Physical Pharmacy Lab");
				but7.setText("Anatomy, Physiology & Pathophysiology Lab");
				but8.setText("Computer Lab");
				but10.setVisibility(View.GONE);
				but9.setVisibility(View.GONE);
				pg = "1";

			}
			if (pg == "b4") {
				setContentView(R.layout.sem);

				AdView mAdView = (AdView) findViewById(R.id.adView);
				AdRequest adRequest = new AdRequest.Builder().build();
				mAdView.loadAd(adRequest);

				Button but1 = (Button) findViewById(R.id.button1);
				Button but2 = (Button) findViewById(R.id.button2);
				Button but3 = (Button) findViewById(R.id.button3);
				Button but4 = (Button) findViewById(R.id.button4);
				Button but5 = (Button) findViewById(R.id.button5);
				Button but6 = (Button) findViewById(R.id.button6);
				Button but7 = (Button) findViewById(R.id.button7);
				Button but8 = (Button) findViewById(R.id.button8);
				Button but9 = (Button) findViewById(R.id.button9);
				Button but10 = (Button) findViewById(R.id.button10);

				but1.setText("Pharmaceutical Chemistry");
				but2.setText("Biochemistry 1");
				but3.setText("Pharmaceutics");
				but4.setText("Physical Pharmacy 2");
				but5.setText("Anatomy, Physiology & Pathophysiology");
				but6.setText("Pharmaceutical Chemistry Lab");
				but7.setText("Pharmaceutics Lab");
				but8.setText("Physical Pharmacy Lab");
				but10.setVisibility(View.GONE);
				but9.setVisibility(View.GONE);
				pg = "1";
			}
			if (pg == "b5") {
				setContentView(R.layout.sem);

				AdView mAdView = (AdView) findViewById(R.id.adView);
				AdRequest adRequest = new AdRequest.Builder().build();
				mAdView.loadAd(adRequest);

				Button but1 = (Button) findViewById(R.id.button1);
				Button but2 = (Button) findViewById(R.id.button2);
				Button but3 = (Button) findViewById(R.id.button3);
				Button but4 = (Button) findViewById(R.id.button4);
				Button but5 = (Button) findViewById(R.id.button5);
				Button but6 = (Button) findViewById(R.id.button6);
				Button but7 = (Button) findViewById(R.id.button7);
				Button but8 = (Button) findViewById(R.id.button8);
				Button but9 = (Button) findViewById(R.id.button9);
				Button but10 = (Button) findViewById(R.id.button10);

				but1.setText("Organic Chemistry 3");
				but2.setText("Cosmeticology");
				but3.setText("Pharmaceutical Biotechnology");
				but4.setText("Pharmacology 2");
				but5.setText("Pharmaceutical Management");
				but6.setText("Organic Chemistry Lab 2");
				but8.setText("Cosmeticology Lab");

				but7.setText("Pharmaceutical Biotechnology Lab");

				but9.setVisibility(View.GONE);
				but10.setVisibility(View.GONE);
				pg = "1";

			}
			if (pg == "b6") {
				setContentView(R.layout.sem);

				AdView mAdView = (AdView) findViewById(R.id.adView);
				AdRequest adRequest = new AdRequest.Builder().build();
				mAdView.loadAd(adRequest);

				Button but1 = (Button) findViewById(R.id.button1);
				Button but2 = (Button) findViewById(R.id.button2);
				Button but3 = (Button) findViewById(R.id.button3);
				Button but4 = (Button) findViewById(R.id.button4);
				Button but5 = (Button) findViewById(R.id.button5);
				Button but6 = (Button) findViewById(R.id.button6);
				Button but7 = (Button) findViewById(R.id.button7);
				Button but8 = (Button) findViewById(R.id.button8);
				Button but9 = (Button) findViewById(R.id.button9);
				Button but10 = (Button) findViewById(R.id.button10);

				but1.setText("Pharmaceutical Chemistry 2");
				but2.setText("Pharmaceutical Analysis 2");
				but3.setText("Pharmaceutics 3");
				but4.setText("Pharmacognosy and Phytochemistry 1");
				but5.setText("Hospital Pharmacy & Drug Store Management");
				but6.setText("Pharmaceutical Chemistry Lab 2");
				but8.setText("Pharmaceutical Analysis Lab");

				but7.setText("Pharmaceutics Lab 3");
				but9.setText("Pharmacognosy and Phytochemistry Lab 1");
				but10.setVisibility(View.GONE);
				pg = "1";
			}
			// your code
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}
}
