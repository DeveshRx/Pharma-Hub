package devesh.b.pharm.guide.mu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Devesh & Madhuri on 5/21/2015.
 */
public class GoPro extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gopro);


    }
    public void getpr(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=devesh.b.pharm.guide.premium"));
        startActivity(intent);
    }
}