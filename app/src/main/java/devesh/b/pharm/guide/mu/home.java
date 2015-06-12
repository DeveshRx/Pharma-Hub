package devesh.b.pharm.guide.mu;

/* B.Pharm Guide App is Written & Developed by Devesh Chaushari

*/

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class home extends Activity {
	InterstitialAd mInterstitialAd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		getActionBar().hide();

		setContentView(R.layout.home);

		getActionBar().setDisplayShowHomeEnabled(false);
		getActionBar().setDisplayShowTitleEnabled(false);

		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);

		mInterstitialAd = new InterstitialAd(this); // interstitial ad

	//	mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");  // Sample test ID


			mInterstitialAd.setAdUnitId("ca-app-pub-6702661245453687/7563439851"); // WARNING
		// !!!!!->
		// My
		// OWN
		// f**kin
		// AD
		// id

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
		AdRequest adRequest = new AdRequest.Builder()
				.addTestDevice("YOUR_DEVICE_HASH")
				.build();

		mInterstitialAd.loadAd(adRequest);
	}

		
		


	public void syllabus(View v) {

		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();

	}

	
	
	
	public void scheme(View view) {
	 Intent intent1 = new Intent(this, Scheme.class);
	 startActivity(intent1);         

	 finish();

	}
	public void exit(View view) {
		if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
        	finish();    
        	} 
		 

		}

	@Override
	public void onBackPressed() {

	
		if (mInterstitialAd.isLoaded()) {
			mInterstitialAd.show();
			finish();

		}else {
			finish();
		}
	}
	public void about(View v) {

		Intent intent = new Intent(this, About.class);
		startActivity(intent);
		

	}

}
