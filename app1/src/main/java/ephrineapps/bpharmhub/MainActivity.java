package ephrineapps.bpharmhub;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            View ViewSyllabus=(View)findViewById(R.id.IncludeSyllabus);
            View ViewNotes=(View)findViewById(R.id.IncludeNotes);

            switch (item.getItemId()) {
                case R.id.navigation_home:

                    ViewSyllabus.setVisibility(View.VISIBLE);
                    ViewNotes.setVisibility(View.GONE);

                    return true;
                case R.id.navigation_notes:
                      ViewSyllabus.setVisibility(View.GONE);
                    ViewNotes.setVisibility(View.VISIBLE);


                    return true;
                case R.id.navigation_questionpapers:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
