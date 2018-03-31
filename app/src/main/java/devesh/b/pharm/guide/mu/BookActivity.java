package devesh.b.pharm.guide.mu;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BookActivity extends AppCompatActivity {
    public static final String NotesURL = "com.example.myfirstapp.MESSAGE";
    public static final String TAG="B.Pharm Hub";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

    }

public void NotesSelectSem7(View v){
        // Cognosy
        if(v.getTag().toString().equals("sem7cognoglycosides")){

            Intent intent = new Intent(this, WebBrowserActivity.class);
           intent.putExtra(NotesURL, "https://docs.google.com/presentation/d/1-fVef36o9vmIqQKRCyQYgl9UVbIrudz2hZvOUKumjWQ/edit?usp=sharing");
            startActivity(intent);


        }
        if(v.getTag().toString().equals("sem7cognonutraceutics")) {
            Intent intent = new Intent(this, WebBrowserActivity.class);
            intent.putExtra(NotesURL, "https://docs.google.com/presentation/d/1FgFJVyh0I9kH9nt7OQyJbR2D1ukCwXQ-j7s3haqzvbI/edit?usp=sharing");
            startActivity(intent);


        }

    // Ceutics
    if(v.getTag().toString().equals("sem7ceuticsTOXICITYSTUDIES")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/presentation/d/12K5FQpEV6sy-qKKW6Qm9fUycRBW60V3UAbstjn3xnhE/edit?usp=sharing");
        startActivity(intent);

    }
    if(v.getTag().toString().equals("sem7ceuticsTabletTechnology")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/document/d/1yhl0bVaGC5WbLwb0dXgDL0dbWqCwMdaVNYq1tilfFBM/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7ceuticsstabilitystudies")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/presentation/d/1NyFd0CqTWfCQtwTOsEppdeQJLjiS5_YZ_zDKOT-B2aU/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7ceuticsstabilitystudies1")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/presentation/d/1QA5TqtwUKRLCzLOnmjWmEXSW-3oSbkPSAsffari4eps/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7ceuticsSRDDSEVALUATION")){

        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/document/d/1_eyOZmpTS9Vod4hovql1X8kbZI5xLYXvbF1NvdLdHTI/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7ceuticsContainersandclosures")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/presentation/d/1Vr6RT9TT8yLeo2Xho-ZnGuX5SnWbi8bOR8yASjILsXc/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7ceuticsICHguideline1478588402168")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/document/d/16XbX1wJvyncTijSzrpnZ_eZQh-T-Ck94R0KdRRRvsxI/edit?usp=sharing");
        startActivity(intent);
    }

    //PJ
    if(v.getTag().toString().equals("sem7pjFSSA2006")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/document/d/16XbX1wJvyncTijSzrpnZ_eZQh-T-Ck94R0KdRRRvsxI/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7pjFSSA2006")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/document/d/112KTGffGbKnU9rQaITWTpbWEy07ArJ0u9V3I6JGlWng/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7pjForensicpharmacyPharmacyAct25august2015")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/presentation/d/1ohHlWdacgWg3wTuFW9khlqKCCenjBPpGx2AGHJMumjk/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7pjForensicpharmacyPatentsAct1970")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/presentation/d/1MPZJ3E1hseT62EBSTsYKBSAv8qQgnJGJEgI1bCIfz9s/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7pjForensicPharmacyHistory5December20141")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/presentation/d/1QdPkPYrFPhvAnXtguNTeNugt5z-rRRLlCuexKu976us/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7pjForensicpharmacyDCAPartII15January2015")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/presentation/d/1Cc3Q-l6HcPIAtN9g3iu-wj7MZUfdIhz-KS7pgt2XRCs/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7pjForensicPharmacyMagicRemediesAct1954")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/presentation/d/1FWqfeIXepBdJBaU6UFQWaZYwo5EbdRb-NI6-8io2oeo/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7pjForensicPharmacyIntroductionandHistory")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/document/d/1cZgiKRJHOT012JSwuZCFlhf-4m6T4Zob4UdcsUYonYE/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7pjDrugs_magic_remedies_advertisement_act")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/document/d/1RVcgWLRAKE4xk1eNcAHqH1KdBIYCIqemfBOKwQ16ykc/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7pJDrugsMagicRemediesActOA")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/presentation/d/1vJb1LMxSSDXE7D5xc3nKpw8d0LToikPUk0nQXFc2y-8/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7pjDPCO-2013")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/presentation/d/1xoMiKbmvKLaFL7z-FXXlRE78QAs03XumWew_KFWE4xo/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7pjDPCO2013-20September2015")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/presentation/d/1mS3vwtfzV-e9tNoz0KaP0TqhE0xf-a6oykh5MZfZJus/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7pjDMRactfinal")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/document/d/13u8KI2FUOdFDrr4tLkPXC0obaFOKI2vwmPeuQ3Ulq2Y/edit?usp=sharing");
        startActivity(intent);
    }
    if(v.getTag().toString().equals("sem7pjChopraandHatheeCommittee")){
        Intent intent = new Intent(this, WebBrowserActivity.class);
        intent.putExtra(NotesURL, "https://docs.google.com/document/d/1v42jZuWT9Q7qc7bbgPaLPY8I-BhRsctsGDZxMVNSLUY/edit?usp=sharing");
        startActivity(intent);
    }




    if(v.getTag().toString().equals("")|| v.getTag().toString().equals(null)){
        Toast.makeText(this, "Error!! no Link", Toast.LENGTH_SHORT).show();
    }


    }



    public void SemTabClick(View v){
    if(v.getTag().toString().equals("sem7")){

    }
    if(v.getTag().toString().equals("sem8")){

    }

    }


    public void GetTotal(){
// Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

    public void CreateView() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

       for (int j = 1; j < t; j++) {

                    final CardView mcard = new CardView(BookActivity.this);
                    mcard.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    mcard.setCardElevation(10);
                    mcard.setUseCompatPadding(true);
                    mcard.setId(j + 0);
                    mcard.setOnClickListener(clicks);
                    //mcard.setText("Button"+(i+1));
                    // btn.setLayoutParams(lprams);


                    myLayout.addView(mcard);

                    LinearLayout LL = new LinearLayout(BookActivity.this);
                    LL.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    LL.setOrientation(LinearLayout.HORIZONTAL);
                    LL.setPadding(30, 20, 30, 20);
                    mcard.addView(LL);

                    LinearLayout LL1 = new LinearLayout(BookActivity.this);
                    LL1.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    LL1.setOrientation(LinearLayout.VERTICAL);
                    LL.addView(LL1);

                    final TextView tx = new TextView(BookActivity.this);
                    tx.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));


                    tx.setTypeface(null, Typeface.BOLD);
                    tx.setTextSize(18);
                    tx.setText("Loading....");
                    LL1.addView(tx);


                    final TextView tx1 = new TextView(BookActivity.this);
                    tx1.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    tx1.setText("Loading....");
                    LL1.addView(tx1);


                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    final int idj = j;
                    DatabaseReference title = database.getReference("app/users/" + UserUID + "/data/MedicalBills/" + j + "/title");
                    title.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // This method is called once with the initial value and again
                            // whenever data at this location is updated.
                            String value = dataSnapshot.getValue(String.class);
                            Log.d(TAG, "Value is: " + value);
                            if (value != null) {
                                tx.setText(value);
                                View Loading = (View) findViewById(R.id.loading);
                                Loading.setVisibility(View.GONE);

                            } else {

                                CardView cv = (CardView) findViewById(idj);
                                cv.setVisibility(View.GONE);

                                View Loading = (View) findViewById(R.id.loading);
                                Loading.setVisibility(View.GONE);

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            // Failed to read value
                            Log.w(TAG, "Failed to read value.", error.toException());
                        }
                    });

                    DatabaseReference desc = database.getReference("app/users/" + UserUID + "/data/MedicalBills/" + j + "/desc");
                    desc.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // This method is called once with the initial value and again
                            // whenever data at this location is updated.
                            String value = dataSnapshot.getValue(String.class);
                            Log.d(TAG, "Value is: " + value);
                            if (value != null) {
                                tx1.setText(value);

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            // Failed to read value
                            Log.w(TAG, "Failed to read value.", error.toException());
                        }
                    });


                }

            }
        });


    }


}
