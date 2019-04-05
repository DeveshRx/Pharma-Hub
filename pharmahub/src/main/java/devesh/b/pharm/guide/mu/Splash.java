package devesh.b.pharm.guide.mu;

/* B.Pharm Guide App is Written & Developed by Devesh Chaushari

 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.multidex.MultiDex;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        MultiDex.install(this);

        setContentView(R.layout.splashscreen);
        //	ActionBar actionBar = getActionBar();
        //	actionBar.hide();

  /*      FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference Crash = database.getReference("app/CrashSG");
        // Read from the database
        Crash.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Log", "Crash???: " + value);
                if(value.equals("t")){
                    Crashlytics.getInstance().crash(); // Force a crash
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Log", "Failed to read value.", error.toException());
            }
        });
*/
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(2 * 1000);
/*
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(Splash.this, new String[]{android.Manifest.permission.CAMERA, android.Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_CONTACTS}, 1);
                            Log.d("QR", "Cam Not Permission ");
                        } else if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                            Log.d("QR", "Cam Permission ");

                        }
                    } */
                    // After 5 seconds redirect to another intent
                    Intent i = new Intent(getBaseContext(), HomeActivity.class);
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

  /*  @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);

                    // Remove activity
                    finish();                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(Splash.this, "Please Grant The Permission", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

*/
}


