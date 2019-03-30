package devesh.b.pharm.guide.premium;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.auth.FirebaseAuth;

public class BrowserActivity extends AppCompatActivity {
    public final String TAG = "BPharm Hub";
    public String Orientation;
    String URL;
    private AdView mAdView;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        isInternetOn();

        MobileAds.initialize(this, getString(R.string.Ads_AppADMob_ID));

        mAdView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.Ads_Int_ID));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
       mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());

            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app..
                // FirebaseAuth.getInstance().signOut();

                finish();
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                FirebaseAuth.getInstance().signOut();

                finish();
            }
        });


        Orientation = "p";
        Intent intent = getIntent();
        hideSystemUI();
        URL = intent.getStringExtra("URL2Load");

        WebView myWebView = (WebView) findViewById(R.id.WebView1);
        myWebView.setWebViewClient(new MyWebViewClient());
        WebSettings webSettings = myWebView.getSettings();

        myWebView.getSettings().setBuiltInZoomControls(true);

        webSettings.setJavaScriptEnabled(true);
        myWebView.getSettings().setBuiltInZoomControls(true);

        if (URL != null) {

            if (URL.equals("0") || URL.equals("000")) {
                Toast.makeText(getApplicationContext(), "URL not Available !! Try Agin Later", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Loading....", Toast.LENGTH_SHORT).show();

                myWebView.loadUrl(URL);

            }


        } else {
            Toast.makeText(getApplicationContext(), "URL not Available ! Try Agin Later", Toast.LENGTH_LONG).show();


        }

    }

    // This snippet hides the system bars.
    private void hideSystemUI() {
        // Set the IMMERSIVE flag.
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        View mDecorView = getWindow().getDecorView();
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            View decorView = getWindow().getDecorView();

            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    public void BackBroswer(View v) {

        if (mInterstitialAd.isLoaded()) {
            //FirebaseAuth.getInstance().signOut();
            mInterstitialAd.show();


        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
            //   FirebaseAuth.getInstance().signOut();

            finish();
        }
    }

    public void ChangeOrientation(View v) {
        if (Orientation.equals("p")) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            Orientation = "l";

        } else if (Orientation.equals("l")) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            Orientation = "p";

        }

    }

    public final boolean isInternetOn() {

        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {

            // if connected with internet
            // Toast.makeText(this, " Connected ", Toast.LENGTH_LONG).show();


            return true;

        } else if (
                connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {


            Toast.makeText(this, "Please Connect to Internet...", Toast.LENGTH_LONG).show();

            return false;
        }
        return false;
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Uri.parse(url).getHost().equals("https://accounts.google.com") || Uri.parse(url).getHost().equals("accounts.google.com")) {
                Log.i(TAG, "Trying to Google Login !!");
                finish();
                return false;
            }
            if (Uri.parse(url).getHost().equals("https://docs.google.com") || Uri.parse(url).getHost().equals("docs.google.com")) {


                return false;
            }

            Log.i(TAG, "Webview URL: " + Uri.parse(url).getHost().toString());


            // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
            //     Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            //   startActivity(intent);

            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            if (url.startsWith("intent://")) {
                Toast.makeText(BrowserActivity.this, "You cannot use any 3rd party app because This is copyrighted content", Toast.LENGTH_SHORT).show();
                finish();
            }

            LinearLayout LLLoad = (LinearLayout) findViewById(R.id.ProgressLLView);
            LLLoad.setVisibility(View.GONE);

            super.onPageFinished(view, url);
        }


    }

    @Override
    public void onBackPressed() {
        if (mInterstitialAd.isLoaded()) {
               //FirebaseAuth.getInstance().signOut();
            mInterstitialAd.show();


        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
            //   FirebaseAuth.getInstance().signOut();

            finish();
        }
        super.onBackPressed();
    }


}
