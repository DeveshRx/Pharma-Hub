package devesh.b.pharm.guide.mu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class WebBrowserActivity extends Activity {
public final String TAG="BPharm Hub";
public String NotesURL;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

  /*      requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
*/

        setContentView(R.layout.activity_web_browser);
hideSystemUI();
        Intent intent = getIntent();
        NotesURL = intent.getStringExtra(BookActivity.NotesURL);

        WebView myWebView = (WebView) findViewById(R.id.webviewNotes);
        myWebView.setWebViewClient(new MyWebViewClient());
        WebSettings webSettings = myWebView.getSettings();

        myWebView.getSettings().setBuiltInZoomControls(true);

        webSettings.setJavaScriptEnabled(true);

        myWebView.loadUrl(NotesURL);

       // myWebView.setWebViewClient(new WebViewClient());

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Uri.parse(url).getHost().equals("https://accounts.google.com") || Uri.parse(url).getHost().equals("accounts.google.com") ) {
                Log.i(TAG, "Trying to Google Login !!");
                finish();
                return false;
            }
            if (Uri.parse(url).getHost().equals("https://docs.google.com") || Uri.parse(url).getHost().equals("docs.google.com")) {


                return false;
            }

               Log.i(TAG, "Webview URL"+ Uri.parse(url).getHost().toString());


            // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
       //     Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
         //   startActivity(intent);

            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            if (url.startsWith("intent://")) {
                Toast.makeText(WebBrowserActivity.this, "You cannot use any 3rd party app because This is copyrighted content", Toast.LENGTH_SHORT).show();
                finish();
            }
            super.onPageFinished(view, url);
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
}
