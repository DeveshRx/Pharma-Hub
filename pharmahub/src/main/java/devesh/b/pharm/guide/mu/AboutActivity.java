package devesh.b.pharm.guide.mu;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {
    public static final String LogTag = "Bpharm Hub ";
    boolean installed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        isAppInstalled("devesh.b.pharm.guide.mu.ebook");
        Button UninstallEbookBT = (Button) findViewById(R.id.uninstallEbookButton);
        if (installed) {
            UninstallEbookBT.setVisibility(View.VISIBLE);

        } else {
            UninstallEbookBT.setVisibility(View.GONE);

        }

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

    public void uninstallEbook(View v) {
        isAppInstalled("devesh.b.pharm.guide.mu.ebook");

        if (installed) {

            Intent intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package:devesh.b.pharm.guide.mu.ebook"));
            startActivity(intent);

        }
    }

    private boolean isAppInstalled(String uri) {

        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }

}
