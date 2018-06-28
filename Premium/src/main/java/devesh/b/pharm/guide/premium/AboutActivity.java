package devesh.b.pharm.guide.premium;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {
    public static final String LogTag = "Bpharm Hub ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void VisitWebsite(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.ephrine.in"));
        startActivity(intent);
    }

    public void contact(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.Contact_Form_URL)));
        startActivity(intent);

    }

    public void ClearCache(View v) {
        Toast.makeText(getApplicationContext(), "Temporary Cache Data Deleted", Toast.LENGTH_LONG).show();
        deleteAppData();
        finish();

    }

    private void deleteAppData() {
        try {
            // clearing app data
            String packageName = getApplicationContext().getPackageName();
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("pm clear " + packageName);
            Log.d(LogTag, "App Data Cleared !!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
