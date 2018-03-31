package devesh.b.pharm.guide.mu;

/* B.Pharm Guide App is Written & Developed by Devesh Chaushari

*/

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class home extends Activity {
	InterstitialAd mInterstitialAd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		//getActionBar().hide();

		setContentView(R.layout.home);

	//getActionBar().setDisplayShowHomeEnabled(false);
	//	getActionBar().setDisplayShowTitleEnabled(false);
		final ImageView gpat = (ImageView) findViewById(R.id.imageView10);

		gpat.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click

                Intent gpatapp = getPackageManager().getLaunchIntentForPackage("devesh.ephrine.gpat");
                Intent gpatapppro = getPackageManager().getLaunchIntentForPackage("devesh.ephrine.gpat.pro");

                if (gpatapp != null && gpatapppro != null) {
                    startActivity(gpatapppro);//null pointer check in case package name was not found
                }else if (gpatapp != null && gpatapppro == null) {
                    startActivity(gpatapp);//null pointer check in case package name was not found
                }else if (gpatapp == null && gpatapppro != null) {
                    startActivity(gpatapppro);//null pointer check in case package name was not found
                }else{
                   Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setData(Uri.parse("market://details?id=" + "devesh.ephrine.gpat"));
                    startActivity(intent);

                    Context context = getApplicationContext();
                    CharSequence text = "Install GPAT #1 Self Study Hub";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
			}
		});

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6702661245453687~6086706651");
        AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);

		mInterstitialAd = new InterstitialAd(this); // interstitial ad

//		mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");  // Sample test ID


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
				//.addTestDevice("YOUR_DEVICE_HASH")
				.build();

		mInterstitialAd.loadAd(adRequest);
	}

		
		


	public void syllabus(View v) {

		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();

	}

	
	public void papers(View v){
		Intent intent1 = new Intent(this, papers.class);
		startActivity(intent1);

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

	public void NoteBook(View v){
		Intent intent = new Intent(this, BookActivity.class);
		startActivity(intent);

	}

}
