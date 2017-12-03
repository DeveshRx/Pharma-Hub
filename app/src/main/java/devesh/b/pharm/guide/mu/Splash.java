package devesh.b.pharm.guide.mu;

/* B.Pharm Guide App is Written & Developed by Devesh Chaushari

*/

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);

		setContentView(R.layout.splashscreen);
	//	ActionBar actionBar = getActionBar();
	//	actionBar.hide();
		
	

		Thread background = new Thread() {
			public void run() {

				try {
					// Thread will sleep for 5 seconds
					sleep(1 * 1000);

					// After 5 seconds redirect to another intent
				
				    Intent i = new Intent(getBaseContext(), home.class);
					startActivity(i);

					// Remove activity
					finish();

				} catch (Exception e) {

				}
			}
		};

		// start thread
		background.start();

	}
	
}


