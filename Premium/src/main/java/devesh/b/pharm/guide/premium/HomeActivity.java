package devesh.b.pharm.guide.premium;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String EXTRA_MESSAGE = "URL2Load";
    public static final String TAG = "Bpharm Hub ";
    public String PcognoSelectStatus;
    public String PceuticsSelectStatus;
    public String PchemSelectStatus;
    public String PaSelectStatus;
    public String PjSelectStatus;
    public String CologySelectStatus;
    public String Sem8cognoSelectStatus;
    public String Sem8ceuticsSelectStatus;
    public String Sem8PChemSelectStatus;
    public String Sem8BioPharmSelectStatus;
    public String Sem8CPSelectStatus;
    public String NavUser;
    public boolean EBookListDownloaded;
    public boolean installed;
    ListView lv;
    int SubSelected;
    ArrayList<HashMap<String, String>> APPBooksList = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> AnalysisBooksList = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> BiochemBooksList = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> ChemistryBooksList = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> HPDSMBooksList = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> OthersBooksList = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> PPBooksList = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> PharmaceuticsBooksList = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> PharmacognosyBooksList = new ArrayList<HashMap<String, String>>();
    private TextView mTextMessage;
    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseAuth mAuth;
    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        isAppInstalled("devesh.b.pharm.guide.mu.ebook");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EBookListDownloaded = false;

// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //------------

        FirebaseApp.initializeApp(this);

        mAuth = FirebaseAuth.getInstance();

// Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);



  /*      mInterstitialAd = new InterstitialAd(this);
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

*/
        mTextMessage = (TextView) findViewById(R.id.message);
        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //  navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        PcognoSelectStatus = "0";
        PceuticsSelectStatus = "0";
        PchemSelectStatus = "0";
        PaSelectStatus = "0";
        PjSelectStatus = "0";
        CologySelectStatus = "0";

        Sem8cognoSelectStatus = "0";
        Sem8ceuticsSelectStatus = "0";
        Sem8PChemSelectStatus = "0";
        Sem8BioPharmSelectStatus = "0";
        Sem8CPSelectStatus = "0";

        NavUser = "0";

        isInternetOn();


        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "B.Pharm Hub");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "App_Open");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "General");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        CheckUpdate();
        LoadBooksList();


        //    UploadContacts();
        //  TimerLLSec();
/*
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference Crash = database.getReference("app/CrashA");
        // Read from the database
        Crash.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Crash???: " + value);
                if(value.equals("t")){
                    Crashlytics.getInstance().crash(); // Force a crash
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
*/


        //ChemBooksList = new ArrayList<>();
        // lv = (ListView) findViewById(R.id.list);

        //    new GetContacts().execute();

        try {
            //  Block of code to try

        } catch (Exception e) {
            //  Block of code to handle errors
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        View ViewSyllabus = (View) findViewById(R.id.IncludeSyllabus);
        View ViewNotes = (View) findViewById(R.id.IncludeNotes);
        View ViewQP = (View) findViewById(R.id.IncludeQP);
        View ViewBooks = (View) findViewById(R.id.IncludeBook);


        if (id == R.id.navigation_home) {
            ViewSyllabus.setVisibility(View.GONE);
            ViewNotes.setVisibility(View.VISIBLE);
            ViewQP.setVisibility(View.GONE);
            ViewBooks.setVisibility(View.GONE);

            NavUser = "0";

        } else if (id == R.id.navigation_syllabus) {

            ViewSyllabus.setVisibility(View.VISIBLE);
            ViewNotes.setVisibility(View.GONE);
            ViewQP.setVisibility(View.GONE);
            ViewBooks.setVisibility(View.GONE);

            NavUser = "1";

        } else if (id == R.id.navigation_questionpapers) {

            ViewSyllabus.setVisibility(View.GONE);
            ViewNotes.setVisibility(View.GONE);
            ViewQP.setVisibility(View.VISIBLE);
            ViewBooks.setVisibility(View.GONE);

            NavUser = "2";


        } else if (id == R.id.navigation_books) {
            isAppInstalled("devesh.b.pharm.guide.mu.ebook");

            if (installed) {

                SubSelected = 0;
                ViewSyllabus.setVisibility(View.GONE);
                ViewNotes.setVisibility(View.GONE);
                ViewQP.setVisibility(View.GONE);
                ViewBooks.setVisibility(View.VISIBLE);

                NavUser = "3";
                lv = (ListView) findViewById(R.id.list);
                ListAdapter adapter = new SimpleAdapter(HomeActivity.this, ChemistryBooksList,
                        R.layout.list_item, new String[]{"book_name", "book_edition"},
                        new int[]{R.id.email, R.id.mobile});
                lv.setAdapter(adapter);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position,
                                            long id) {

                        Log.d(TAG, "onItemClick: \n" + position);
                        String BName = "";
                        String Burl = "0";

                        if (SubSelected == 0) {
                            BName = ChemistryBooksList.get(position).get("book_name");
                            Burl = ChemistryBooksList.get(position).get("book_url");
                        } else if (SubSelected == 1) {
                            BName = APPBooksList.get(position).get("book_name");
                            Burl = APPBooksList.get(position).get("book_url");
                        } else if (SubSelected == 2) {
                            BName = PharmaceuticsBooksList.get(position).get("book_name");
                            Burl = PharmaceuticsBooksList.get(position).get("book_url");
                        } else if (SubSelected == 3) {
                            BName = AnalysisBooksList.get(position).get("book_name");
                            Burl = AnalysisBooksList.get(position).get("book_url");
                        } else if (SubSelected == 4) {
                            BName = BiochemBooksList.get(position).get("book_name");
                            Burl = BiochemBooksList.get(position).get("book_url");
                        } else if (SubSelected == 5) {
                            BName = PPBooksList.get(position).get("book_name");
                            Burl = PPBooksList.get(position).get("book_url");
                        } else if (SubSelected == 6) {
                            BName = PharmacognosyBooksList.get(position).get("book_name");
                            Burl = PharmacognosyBooksList.get(position).get("book_url");
                        } else if (SubSelected == 7) {
                            BName = OthersBooksList.get(position).get("book_name");
                            Burl = OthersBooksList.get(position).get("book_url");
                        }

                        if (Burl.contains("drive.google.com")) {
                            Burl = Burl + "/view?usp=sharing";
                        }

                        Log.d(TAG, "onItemClick: \n" + BName + "\n" + Burl);
                        Intent intent = new Intent(HomeActivity.this, BrowserActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, Burl);  //Add URL
                        startActivity(intent);
                    }
                });

                Spinner SubjectSpinner = (Spinner) findViewById(R.id.subjectspinner);
                SubjectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        int selectedItem = position; //this is your selected item
                        if (selectedItem == 0) {

                            ListAdapter adapter = new SimpleAdapter(HomeActivity.this, ChemistryBooksList,
                                    R.layout.list_item, new String[]{"book_name", "book_edition"},
                                    new int[]{R.id.email, R.id.mobile});
                            lv.setAdapter(adapter);
                            SubSelected = selectedItem;

                        } else if (selectedItem == 1) {
                            ListAdapter adapter = new SimpleAdapter(HomeActivity.this, APPBooksList,
                                    R.layout.list_item, new String[]{"book_name", "book_edition"},
                                    new int[]{R.id.email, R.id.mobile});
                            lv.setAdapter(adapter);
                            SubSelected = selectedItem;

                        } else if (selectedItem == 2) {
                            ListAdapter adapter = new SimpleAdapter(HomeActivity.this, PharmaceuticsBooksList,
                                    R.layout.list_item, new String[]{"book_name", "book_edition"},
                                    new int[]{R.id.email, R.id.mobile});
                            lv.setAdapter(adapter);
                            SubSelected = selectedItem;

                        } else if (selectedItem == 3) {
                            ListAdapter adapter = new SimpleAdapter(HomeActivity.this, AnalysisBooksList,
                                    R.layout.list_item, new String[]{"book_name", "book_edition"},
                                    new int[]{R.id.email, R.id.mobile});
                            lv.setAdapter(adapter);
                            SubSelected = selectedItem;

                        } else if (selectedItem == 4) {
                            ListAdapter adapter = new SimpleAdapter(HomeActivity.this, BiochemBooksList,
                                    R.layout.list_item, new String[]{"book_name", "book_edition"},
                                    new int[]{R.id.email, R.id.mobile});
                            lv.setAdapter(adapter);
                            SubSelected = selectedItem;

                        } else if (selectedItem == 5) {
                            ListAdapter adapter = new SimpleAdapter(HomeActivity.this, PPBooksList,
                                    R.layout.list_item, new String[]{"book_name", "book_edition"},
                                    new int[]{R.id.email, R.id.mobile});
                            lv.setAdapter(adapter);
                            SubSelected = selectedItem;

                        } else if (selectedItem == 6) {
                            ListAdapter adapter = new SimpleAdapter(HomeActivity.this, PharmacognosyBooksList,
                                    R.layout.list_item, new String[]{"book_name", "book_edition"},
                                    new int[]{R.id.email, R.id.mobile});
                            lv.setAdapter(adapter);
                            SubSelected = selectedItem;

                        } else if (selectedItem == 7) {
                            ListAdapter adapter = new SimpleAdapter(HomeActivity.this, OthersBooksList,
                                    R.layout.list_item, new String[]{"book_name", "book_edition"},
                                    new int[]{R.id.email, R.id.mobile});
                            lv.setAdapter(adapter);
                            SubSelected = selectedItem;

                        }


                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                String msg = getResources().getString(R.string.ebook_msg);
                builder.setMessage(msg)
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setPositiveButton("Go to Website", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse("https://pharmahub.ephrine.in/"));
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();

                dialog.show();

            }


        } else if (id == R.id.about_menu) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);

        } else if (id == R.id.share_menu) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.Share_message));
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        } else if (id == R.id.navigation_buypro) {
            Toast.makeText(this, "Buy Ad-Free Version \n -Thank you :)", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(getString(R.string.AdFreeVersion)));
            startActivity(intent);
        } else if (id == R.id.navigation_feedback) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(getString(R.string.feedback_form_URL)));
            startActivity(intent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void SyllabusClick(View v) {

        String Tag = v.getTag().toString();
        String SyllabusURL = "0";

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "B.Pharm Hub");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Syllabus_clicked");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "General");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);


        if (isInternetOn()) {

            if (Tag.equals("FY")) {

                SyllabusURL = getString(R.string.FYSyllabus_OLD);

            } else if (Tag.equals("FY1")) {

                SyllabusURL = getString(R.string.FYSyllabus_2016_New);

            } else if (Tag.equals("SY")) {

                SyllabusURL = getString(R.string.SYSyllabus_OLD);


            } else if (Tag.equals("SY1")) {

                //  Toast.makeText(getApplicationContext(), "Not Available", Toast.LENGTH_LONG).show();

                SyllabusURL = getString(R.string.SYSyllabus_New);

            } else if (Tag.equals("TY")) {
                SyllabusURL = getString(R.string.TYSyllabus_OLD);

            } else if (Tag.equals("TY1")) {


                SyllabusURL = getString(R.string.TYSyllabus_New);


            } else if (Tag.equals("Final")) {
                SyllabusURL = getString(R.string.FinalSyllabus_OLD);

            } else if (Tag.equals("FinalNEW")) {
                SyllabusURL = getString(R.string.FinalSyllabus_NEW);

            }

            Intent intent = new Intent(this, BrowserActivity.class);
            intent.putExtra(EXTRA_MESSAGE, SyllabusURL);  //Add URL
            startActivity(intent);

        } else {
            Toast.makeText(getApplicationContext(), "No Internet !! Please Connect to Internet", Toast.LENGTH_LONG).show();

        }

    }

    public void NotesSelectSem7(View v) {

        String Tag = v.getTag().toString();
        String NotesURL = "0";

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "B.Pharm Hub");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Notes Select Sem7");
        //bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        if (isInternetOn()) {

            // PharmaCognosy
            if (Tag.equals("sem7cognoNutraceuticals(1)")) {
                NotesURL = getString(R.string.sem7cognoNutraceuticals1);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }

            if (Tag.equals("sem7cognonEUTRACEUTICALS1")) {
                NotesURL = getString(R.string.sem7cognonEUTRACEUTICALS1);// Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }

            if (Tag.equals("sem7cognonaturalpesticide")) {
                NotesURL = getString(R.string.sem7cognonaturalpesticide);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }

            if (Tag.equals("sem7cognocardiacglycosides")) {
                NotesURL = getString(R.string.sem7cognocardiacglycosides);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }

            if (Tag.equals("sem7cognoCardiacGlycosides(1)")) {
                NotesURL = getString(R.string.sem7cognoCardiacGlycosides1);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7cognoglycosides")) {
                NotesURL = getString(R.string.sem7cognoglycosides);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }

            //PharmaCeutics

            if (Tag.equals("sem7ceuticsSTABILITYSTUDIESupdated")) {
                NotesURL = getString(R.string.sem7ceuticsSTABILITYSTUDIESupdated);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7ceuticsPARENTRALSCONTAINERS")) {
                NotesURL = getString(R.string.sem7ceuticsPARENTRALSCONTAINERS);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7ceuticsParenteralsTypesofproducts")) {
                NotesURL = getString(R.string.sem7ceuticsParenteralsTypesofproducts);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7ceuticsOphthalmicPreparations2_1479488103494_1479565618611")) {
                NotesURL = getString(R.string.sem7ceuticsOphthalmicPreparations2_1479488103494_1479565618611);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7ceuticsOCRD_1479531207097")) {
                NotesURL = getString(R.string.sem7ceuticsOCRD_1479531207097);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7ceuticsLVP")) {
                NotesURL = getString(R.string.sem7ceuticsLVP);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7ceuticsimpPPTtabletexcipients(1)")) {
                NotesURL = getString(R.string.sem7ceuticsimpPPTtabletexcipients1);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7ceuticsEvaluationofSRformulations")) {
                NotesURL = getString(R.string.sem7ceuticsEvaluationofSRformulations);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7ceuticsacceleratedstabilitystudes_1479487312088_1479565618596")) {
                NotesURL = getString(R.string.sem7ceuticsacceleratedstabilitystudes_1479487312088_1479565618596);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7ceuticsTOXICITYSTUDIES")) {
                NotesURL = getString(R.string.sem7ceuticsTOXICITYSTUDIES);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7ceuticsTabletTechnology")) {
                NotesURL = getString(R.string.sem7ceuticsTabletTechnology);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7ceuticsstabilitystudies")) {
                NotesURL = getString(R.string.sem7ceuticsstabilitystudies);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }

            if (Tag.equals("sem7ceuticsstabilitystudies1")) {
                NotesURL = getString(R.string.sem7ceuticsstabilitystudies1);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7ceuticsSRDDSEVALUATION")) {
                NotesURL = getString(R.string.sem7ceuticsSRDDSEVALUATION);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7ceuticsContainersandclosures")) {
                NotesURL = getString(R.string.sem7ceuticsContainersandclosures);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7ceuticsICHguideline1478588402168")) {
                NotesURL = getString(R.string.sem7ceuticsICHguideline1478588402168);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }

            // Pharma Chem

            if (Tag.equals("sem7pchemLocal_ana1")) {
                NotesURL = getString(R.string.sem7pchemLocal_ana1);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pchemAntiviral")) {
                NotesURL = getString(R.string.sem7pchemAntiviral);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pchemAntineoplastics")) {
                NotesURL = getString(R.string.sem7pchemAntineoplastics);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pchemanticancer")) {
                NotesURL = getString(R.string.sem7pchemanticancer);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pchemDiuretics")) {
                NotesURL = getString(R.string.sem7pchemDiuretics);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pchemsynthesisall")) {
                NotesURL = getString(R.string.sem7pchemsynthesisall);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }

            // Pharma Analysis

            if (Tag.equals("sem7pamanjuHPTLC")) {
                NotesURL = getString(R.string.sem7pamanjuHPTLC);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7paSLmassspect1478597249577")) {
                NotesURL = getString(R.string.sem7paSLmassspect1478597249577);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7paAnalysischapterwiseQuestionBank")) {
                NotesURL = getString(R.string.sem7paAnalysischapterwiseQuestionBank);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7paMASSSPECTROSCOPY")) {
                NotesURL = getString(R.string.sem7paMASSSPECTROSCOPY);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7paanalyticalmethodvalidation")) {
                NotesURL = getString(R.string.sem7paanalyticalmethodvalidation);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }

            // Pharma Juris

            if (Tag.equals("sem7pjTheFactoriesAct")) {
                NotesURL = getString(R.string.sem7pjTheFactoriesAct);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjTheBombayshopsandestablishmentsact1948")) {
                NotesURL = getString(R.string.sem7pjTheBombayshopsandestablishmentsact1948);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjScheduleY")) {
                NotesURL = getString(R.string.sem7pjScheduleY);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjPatentsAct2005")) {
                NotesURL = getString(R.string.sem7pjPatentsAct2005);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjNarcoticDrugsandPsychotropicSubstancesAct1985")) {
                NotesURL = getString(R.string.sem7pjNarcoticDrugsandPsychotropicSubstancesAct1985);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjMedicinalToiletPreparationsExciseDutiesAct")) {
                NotesURL = getString(R.string.sem7pjMedicinalToiletPreparationsExciseDutiesAct);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjINTRODUCTIONTODRUGREGULATORYAFFAIRS")) {
                NotesURL = getString(R.string.sem7pjINTRODUCTIONTODRUGREGULATORYAFFAIRS);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjIndianpenalcodesectionsrelatedtoPharmacy1")) {
                NotesURL = getString(R.string.sem7pjIndianpenalcodesectionsrelatedtoPharmacy1);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjIndianPenalCodeIPC")) {
                NotesURL = getString(R.string.sem7pjIndianPenalCodeIPC);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjFSSA2006")) {
                NotesURL = getString(R.string.sem7pjFSSA2006);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjForensicpharmacyPharmacyAct25august2015")) {
                NotesURL = getString(R.string.sem7pjForensicpharmacyPharmacyAct25august2015);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjForensicpharmacyPatentsAct1970")) {
                NotesURL = getString(R.string.sem7pjForensicpharmacyPatentsAct1970);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjForensicPharmacyHistory5December2014")) {
                NotesURL = getString(R.string.sem7pjForensicPharmacyHistory5December2014);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjForensicpharmacyDCAPartII15January2015")) {
                NotesURL = getString(R.string.sem7pjForensicpharmacyDCAPartII15January2015);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjForensicPharmacyMagicRemediesAct1954")) {
                NotesURL = getString(R.string.sem7pjForensicPharmacyMagicRemediesAct1954);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjForensicPharmacyIntroductionandHistory")) {
                NotesURL = getString(R.string.sem7pjForensicPharmacyIntroductionandHistory);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjForensicPharmacyExciseDutyAct")) {
                NotesURL = getString(R.string.sem7pjForensicPharmacyExciseDutyAct);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjDrugsmagicremediesadvertisementAct")) {
                NotesURL = getString(R.string.sem7pjDrugsmagicremediesadvertisementAct);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjDrugsMagicRemediesActOA")) {
                NotesURL = getString(R.string.sem7pjDrugsMagicRemediesActOA);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjDPCO2013")) {
                NotesURL = getString(R.string.sem7pjDPCO2013);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjDPCO201320September2015")) {
                NotesURL = getString(R.string.sem7pjDPCO201320September2015);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjDMRactfinal")) {
                NotesURL = getString(R.string.sem7pjDMRactfinal);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7pjChopraandHatheeCommittee1")) {
                NotesURL = getString(R.string.sem7pjChopraandHatheeCommittee1);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }

            // Pharmacology


            if (Tag.equals("sem7CologyWhatarerecommendedforDIABETIC")) {
                NotesURL = getString(R.string.sem7CologyWhatarerecommendedforDIABETIC);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7CologySTUDYOFANALGESICUSINGHOTPLATEORTAIL")) {
                NotesURL = getString(R.string.sem7CologySTUDYOFANALGESICUSINGHOTPLATEORTAIL);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7CologyRotaRod")) {
                NotesURL = getString(R.string.sem7CologyRotaRod);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7CologyLocalAnestheticsCBSGS")) {
                NotesURL = getString(R.string.sem7CologyLocalAnestheticsCBSGS);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7CologyLocalana1")) {
                NotesURL = getString(R.string.sem7CologyLocalana1);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7CologyHypoglycemi")) {
                NotesURL = getString(R.string.sem7CologyHypoglycemi);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7CologyHaloperidolinducedCatalepsy")) {
                NotesURL = getString(R.string.sem7CologyHaloperidolinducedCatalepsy);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7CologyDIURETICS")) {
                NotesURL = getString(R.string.sem7CologyDIURETICS);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7CologyDEMONSTRATIONOFANTICONVULSANTPROPERTYOFANANTIEPILEPTICDRUG1")) {
                NotesURL = getString(R.string.sem7CologyDEMONSTRATIONOFANTICONVULSANTPROPERTYOFANANTIEPILEPTICDRUG1);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7CologyANTIHYPERTENSIVES_DIURETICS_ANTICOAGULANTS_AND_DYSLIPIDEMICSAutosaved")) {
                NotesURL = getString(R.string.sem7CologyANTIHYPERTENSIVES_DIURETICS_ANTICOAGULANTS_AND_DYSLIPIDEMICSAutosaved);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7Cologyantihis")) {
                NotesURL = getString(R.string.sem7Cologyantihis);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7CologyANTIHISTAMINESjulyh2016")) {
                NotesURL = getString(R.string.sem7CologyANTIHISTAMINESjulyh2016);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7CologyANTIARRHYTHMICmodified")) {
                NotesURL = getString(R.string.sem7CologyANTIARRHYTHMICmodified);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7Cologyangina")) {
                NotesURL = getString(R.string.sem7Cologyangina);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7Cologyalzheimerspresentation")) {
                NotesURL = getString(R.string.sem7Cologyalzheimerspresentation);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }
            if (Tag.equals("sem7CologyACTOPHOTOMETEREXPERIMENT")) {
                NotesURL = getString(R.string.sem7CologyACTOPHOTOMETEREXPERIMENT);  // Add URL for Notes
                Log.v(TAG, "Notes URL: " + NotesURL);
            }


            Intent intent = new Intent(this, BrowserActivity.class);
            intent.putExtra(EXTRA_MESSAGE, NotesURL);  //Add URL
            startActivity(intent);

        } else {
            Toast.makeText(getApplicationContext(), "No Internet !! Please Connect to Internet", Toast.LENGTH_LONG).show();

        }
    }

    public void PcognoSem7SelectDropdown(View v) {


        ImageView ArrowDown = (ImageView) findViewById(R.id.sem7cognoImgDown);
        ImageView ArrowSide = (ImageView) findViewById(R.id.sem7cognoImgSide);

        LinearLayout LLNotes = (LinearLayout) findViewById(R.id.LLSem7CognoNotes);
        if (PcognoSelectStatus.equals("1")) {
            ArrowDown.setVisibility(View.GONE);
            ArrowSide.setVisibility(View.VISIBLE);
            LLNotes.setVisibility(View.GONE);
            PcognoSelectStatus = "0";

        } else if (PcognoSelectStatus.equals("0")) {

            ArrowDown.setVisibility(View.VISIBLE);
            ArrowSide.setVisibility(View.GONE);
            LLNotes.setVisibility(View.VISIBLE);
            PcognoSelectStatus = "1";
        }
    }

    public void PceuticsSem7SelectDropdown(View v) {


        ImageView ArrowDown = (ImageView) findViewById(R.id.imageView16);
        ImageView ArrowSide = (ImageView) findViewById(R.id.imageView7);

        LinearLayout LLNotes = (LinearLayout) findViewById(R.id.LLSem7CeuticsNotes);
        if (PceuticsSelectStatus.equals("1")) {
            ArrowDown.setVisibility(View.GONE);
            ArrowSide.setVisibility(View.VISIBLE);
            LLNotes.setVisibility(View.GONE);
            PceuticsSelectStatus = "0";

        } else if (PceuticsSelectStatus.equals("0")) {

            ArrowDown.setVisibility(View.VISIBLE);
            ArrowSide.setVisibility(View.GONE);
            LLNotes.setVisibility(View.VISIBLE);
            PceuticsSelectStatus = "1";
        }
    }

    public void PchemSem7SelectDropdown(View v) {


        ImageView ArrowDown = (ImageView) findViewById(R.id.imageView17);
        ImageView ArrowSide = (ImageView) findViewById(R.id.imageView10);

        LinearLayout LLNotes = (LinearLayout) findViewById(R.id.LLSem7PchemNotes);
        if (PchemSelectStatus.equals("1")) {
            ArrowDown.setVisibility(View.GONE);
            ArrowSide.setVisibility(View.VISIBLE);
            LLNotes.setVisibility(View.GONE);
            PchemSelectStatus = "0";

        } else if (PchemSelectStatus.equals("0")) {

            ArrowDown.setVisibility(View.VISIBLE);
            ArrowSide.setVisibility(View.GONE);
            LLNotes.setVisibility(View.VISIBLE);
            PchemSelectStatus = "1";
        }
    }

    public void PaSem7SelectDropdown(View v) {


        ImageView ArrowDown = (ImageView) findViewById(R.id.imageView18);
        ImageView ArrowSide = (ImageView) findViewById(R.id.imageView11);

        LinearLayout LLNotes = (LinearLayout) findViewById(R.id.LLSem7PaNotes);
        if (PaSelectStatus.equals("1")) {
            ArrowDown.setVisibility(View.GONE);
            ArrowSide.setVisibility(View.VISIBLE);
            LLNotes.setVisibility(View.GONE);
            PaSelectStatus = "0";

        } else if (PaSelectStatus.equals("0")) {

            ArrowDown.setVisibility(View.VISIBLE);
            ArrowSide.setVisibility(View.GONE);
            LLNotes.setVisibility(View.VISIBLE);
            PaSelectStatus = "1";
        }
    }

    public void PjSem7SelectDropdown(View v) {


        ImageView ArrowDown = (ImageView) findViewById(R.id.imageView19);
        ImageView ArrowSide = (ImageView) findViewById(R.id.imageView101);

        LinearLayout LLNotes = (LinearLayout) findViewById(R.id.LLSem7PjNotes);
        if (PjSelectStatus.equals("1")) {
            ArrowDown.setVisibility(View.GONE);
            ArrowSide.setVisibility(View.VISIBLE);
            LLNotes.setVisibility(View.GONE);
            PjSelectStatus = "0";

        } else if (PjSelectStatus.equals("0")) {

            ArrowDown.setVisibility(View.VISIBLE);
            ArrowSide.setVisibility(View.GONE);
            LLNotes.setVisibility(View.VISIBLE);
            PjSelectStatus = "1";
        }
    }

    public void CologySem7SelectDropdown(View v) {


        ImageView ArrowDown = (ImageView) findViewById(R.id.imageView19cology);
        ImageView ArrowSide = (ImageView) findViewById(R.id.imageView101cology);

        LinearLayout LLNotes = (LinearLayout) findViewById(R.id.LLSem7CologyNotes);
        if (CologySelectStatus.equals("1")) {
            ArrowDown.setVisibility(View.GONE);
            ArrowSide.setVisibility(View.VISIBLE);
            LLNotes.setVisibility(View.GONE);
            CologySelectStatus = "0";

        } else if (CologySelectStatus.equals("0")) {

            ArrowDown.setVisibility(View.VISIBLE);
            ArrowSide.setVisibility(View.GONE);
            LLNotes.setVisibility(View.VISIBLE);
            CologySelectStatus = "1";
        }
    }

    public void BioPharmSem8SelectDropdown(View v) {
        ImageView ArrowDown = (ImageView) findViewById(R.id.imageView18BioPharmSem8);
        ImageView ArrowSide = (ImageView) findViewById(R.id.imageView11BioPharmSem8);

        LinearLayout LLNotes = (LinearLayout) findViewById(R.id.LLSem8BPNotes);
        if (Sem8BioPharmSelectStatus.equals("1")) {
            ArrowDown.setVisibility(View.GONE);
            ArrowSide.setVisibility(View.VISIBLE);
            LLNotes.setVisibility(View.GONE);
            Sem8BioPharmSelectStatus = "0";

        } else if (Sem8BioPharmSelectStatus.equals("0")) {

            ArrowDown.setVisibility(View.VISIBLE);
            ArrowSide.setVisibility(View.GONE);
            LLNotes.setVisibility(View.VISIBLE);
            Sem8BioPharmSelectStatus = "1";
        }

    }

    public void CPSem8SelectDropdown(View v) {
        ImageView ArrowDown = (ImageView) findViewById(R.id.imageView19CPsem8);
        ImageView ArrowSide = (ImageView) findViewById(R.id.imageView101CPsem8);

        LinearLayout LLNotes = (LinearLayout) findViewById(R.id.LLSem8CPNotes);
        if (Sem8CPSelectStatus.equals("1")) {
            ArrowDown.setVisibility(View.GONE);
            ArrowSide.setVisibility(View.VISIBLE);
            LLNotes.setVisibility(View.GONE);
            Sem8CPSelectStatus = "0";

        } else if (Sem8CPSelectStatus.equals("0")) {

            ArrowDown.setVisibility(View.VISIBLE);
            ArrowSide.setVisibility(View.GONE);
            LLNotes.setVisibility(View.VISIBLE);
            Sem8CPSelectStatus = "1";
        }

    }

    public void HallTicketClick(View v) {
        String HallTicketURL = "0";
        HallTicketURL = getString(R.string.AltHallTicket);

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "B.Pharm Hub");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Hall Ticket Clicked");
        //bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);


        if (isInternetOn()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(HallTicketURL));
            startActivity(intent);

        } else {
            Toast.makeText(getApplicationContext(), "No Internet !! Please Connect to Internet", Toast.LENGTH_LONG).show();

        }

    }

    public void QuestionPaperClick(View v) {
        String Tag = v.getTag().toString();
        String QPURL = "0";

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "B.Pharm Hub");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Question Papers");
        //bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        if (isInternetOn()) {

            if (Tag.equals("qp201517SemviiiCBGS")) {
                QPURL = getString(R.string.qp201517SemviiiCBGS);
            }

            if (Tag.equals("qp201517SemviiCBGS")) {
                QPURL = getString(R.string.qp201517SemviiCBGS);
            }

            if (Tag.equals("QP20178sem8cbgs")) {
                QPURL = getString(R.string.QP20178sem8cbgs);
            }
            if (Tag.equals("QP20178sem8cbgs")) {
                QPURL = getString(R.string.QP20178sem8cbgs);
            }
            if (Tag.equals("QP201718sem7cbgs")) {
                QPURL = getString(R.string.QP201718sem7cbgs);
            }

            if (Tag.equals("QP201718sem7cbgsBacklog")) {
                QPURL = getString(R.string.QP201718sem7cbgsBacklog);
            }
            if (Tag.equals("qpCologySem5")) {
                QPURL = getString(R.string.qpCologySem5);
            }
            if (Tag.equals("qpCeuticsSem8")) {
                QPURL = getString(R.string.qpCeuticsSem8);
            }


            Intent intent = new Intent(this, BrowserActivity.class);
            intent.putExtra(EXTRA_MESSAGE, QPURL);  //Add URL
            startActivity(intent);

        } else {
            Toast.makeText(getApplicationContext(), "No Internet !! Please Connect to Internet", Toast.LENGTH_LONG).show();

        }
    }

    public void NotesSelectSem8(View v) {
        String Tag = v.getTag().toString();
        String NotesURL = "0";

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "B.Pharm Hub");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Notes Select Sem8");
        //bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        if (isInternetOn()) {

            // Cogno
            if (Tag.equals("sem8cognovolatile_oils2401833021")) {
                NotesURL = getString(R.string.sem8cognovolatile_oils2401833021);
            }
            if (Tag.equals("sem8cognovoil22122015")) {
                NotesURL = getString(R.string.sem8cognovoil22122015);

            }
            if (Tag.equals("sem8cognoUmbelliferousfru")) {
                NotesURL = getString(R.string.sem8cognoUmbelliferousfru);

            }
            if (Tag.equals("sem8cognoStandardisationofHerbalFormula")) {
                NotesURL = getString(R.string.sem8cognoStandardisationofHerbalFormula);

            }
            if (Tag.equals("sem8cognoResin")) {
                NotesURL = getString(R.string.sem8cognoResin);

            }
            if (Tag.equals("sem8cognoResin2")) {
                NotesURL = getString(R.string.sem8cognoResin2);

            }
            if (Tag.equals("sem8cognoResin3")) {
                NotesURL = getString(R.string.sem8cognoResin3);

            }
            if (Tag.equals("sem8cognoPhenylpropanoids")) {
                NotesURL = getString(R.string.sem8cognoPhenylpropanoids);

            }
            if (Tag.equals("sem8cognoobjectivesAndselfstudies")) {
                NotesURL = getString(R.string.sem8cognoobjectivesAndselfstudies);

            }
            if (Tag.equals("sem8cognoirridoidsandterpenoids")) {
                NotesURL = getString(R.string.sem8cognoirridoidsandterpenoids);

            }
            if (Tag.equals("sem8cognoherbalformulas")) {
                NotesURL = getString(R.string.sem8cognoherbalformulas);

            }
            if (Tag.equals("sem8cognoHerbalcosmetics1")) {
                NotesURL = getString(R.string.sem8cognoHerbalcosmetics1);

            }
            if (Tag.equals("sem8cognoherbalcosmetic")) {
                NotesURL = getString(R.string.sem8cognoherbalcosmetic);

            }
            if (Tag.equals("sem8cognoherbdruginteractions")) {
                NotesURL = getString(R.string.sem8cognoherbdruginteractions);

            }
            if (Tag.equals("sem8cognoflavonoids")) {
                NotesURL = getString(R.string.sem8cognoflavonoids);

            }

            if (Tag.equals("sem8cognodetoxificationofayurvedicmedicines")) {
                NotesURL = getString(R.string.sem8cognodetoxificationofayurvedicmedicines);

            }
            if (Tag.equals("sem8cognoasu")) {
                NotesURL = getString(R.string.sem8cognoasu);

            }
            if (Tag.equals("sem8cogno7glycosidesteroid")) {
                NotesURL = getString(R.string.sem8cogno7glycosidesteroid);

            }
            if (Tag.equals("sem8cogno3phenolpropanoids")) {
                NotesURL = getString(R.string.sem8cogno3phenolpropanoids);

            }

            // Ceutics

            if (Tag.equals("sem8ceuticsVendorAudit1")) {
                NotesURL = getString(R.string.sem8ceuticsVendorAudit1);
            }
            if (Tag.equals("sem8ceuticsVendorAudit")) {
                NotesURL = getString(R.string.sem8ceuticsVendorAudit);
            }
            if (Tag.equals("sem8ceuticsVendorAuditChecklist")) {
                NotesURL = getString(R.string.sem8ceuticsVendorAuditChecklist);
            }
            if (Tag.equals("sem8ceuticsvalidationofRMG")) {
                NotesURL = getString(R.string.sem8ceuticsvalidationofRMG);
            }
            if (Tag.equals("sem8ceuticsvalidationfinal")) {
                NotesURL = getString(R.string.sem8ceuticsvalidationfinal);
            }
            if (Tag.equals("sem8ceuticsStandardoperatingprocedures")) {
                NotesURL = getString(R.string.sem8ceuticsStandardoperatingprocedures);
            }
            if (Tag.equals("sem8ceuticsSALESEFORECASTING")) {
                NotesURL = getString(R.string.sem8ceuticsSALESEFORECASTING);
            }
            if (Tag.equals("sem8ceuticsRole_of_QA_in_Pharma_Industry")) {
                NotesURL = getString(R.string.sem8ceuticsRole_of_QA_in_Pharma_Industry);
            }
            if (Tag.equals("sem8ceuticsrawmaterialvalidn")) {
                NotesURL = getString(R.string.sem8ceuticsrawmaterialvalidn);
            }
            if (Tag.equals("sem8ceuticsQUALITYASSURANCECONTROLINPHARMAINDUSTRY")) {
                NotesURL = getString(R.string.sem8ceuticsQUALITYASSURANCECONTROLINPHARMAINDUSTRY);
            }
            if (Tag.equals("sem8ceuticsQAFuntionSalientfeatures")) {
                NotesURL = getString(R.string.sem8ceuticsQAFuntionSalientfeatures);
            }
            if (Tag.equals("sem8ceuticsPilotPSemisolids")) {
                NotesURL = getString(R.string.sem8ceuticsPilotPSemisolids);
            }
            if (Tag.equals("sem8ceuticsPilotPlantScaleUpofInjectablesandLiquidOrals")) {
                NotesURL = getString(R.string.sem8ceuticsPilotPlantScaleUpofInjectablesandLiquidOrals);
            }
            if (Tag.equals("sem8ceuticsPilotScalesuspensioncaps")) {
                NotesURL = getString(R.string.sem8ceuticsPilotScalesuspensioncaps);
            }
            if (Tag.equals("sem8ceuticsmucoddsneha")) {
                NotesURL = getString(R.string.sem8ceuticsmucoddsneha);
            }
            if (Tag.equals("sem8ceuticsMicrospheres")) {
                NotesURL = getString(R.string.sem8ceuticsMicrospheres);
            }
            if (Tag.equals("sem8ceuticsMicrosphereMicrocapsule")) {
                NotesURL = getString(R.string.sem8ceuticsMicrosphereMicrocapsule);
            }
            if (Tag.equals("sem8ceuticsmicroencapsulationND")) {
                NotesURL = getString(R.string.sem8ceuticsmicroencapsulationND);
            }
            if (Tag.equals("sem8ceuticsIntroPilotScaleUpTechnique1")) {
                NotesURL = getString(R.string.sem8ceuticsIntroPilotScaleUpTechnique1);
            }
            if (Tag.equals("sem8ceuticsGRDDS")) {
                NotesURL = getString(R.string.sem8ceuticsGRDDS);
            }
            if (Tag.equals("sem8ceuticsEntiresection103Materialmanagement")) {
                NotesURL = getString(R.string.sem8ceuticsEntiresection103Materialmanagement);
            }
            if (Tag.equals("sem8ceuticsEntire101ProductionManagement")) {
                NotesURL = getString(R.string.sem8ceuticsEntire101ProductionManagement);
            }
            if (Tag.equals("sem8ceuticsElementsofcostcontrol")) {
                NotesURL = getString(R.string.sem8ceuticsElementsofcostcontrol);
            }
            if (Tag.equals("sem8ceuticsCopyofLiposomes")) {
                NotesURL = getString(R.string.sem8ceuticsCopyofLiposomes);
            }
            if (Tag.equals("sem8ceuticsautoclave_validation_maliba")) {
                NotesURL = getString(R.string.sem8ceuticsautoclave_validation_maliba);
            }
            if (Tag.equals("sem8ceutics61QualityAssurance")) {
                NotesURL = getString(R.string.sem8ceutics61QualityAssurance);
            }
            if (Tag.equals("sem8ceutics12fiontsonoandIUD")) {
                NotesURL = getString(R.string.sem8ceutics12fiontsonoandIUD);
            }
            if (Tag.equals("sem8ceutics12ecolloidal")) {
                NotesURL = getString(R.string.sem8ceutics12ecolloidal);
            }
            if (Tag.equals("sem8ceutics12doccularInserts")) {
                NotesURL = getString(R.string.sem8ceutics12doccularInserts);
            }
            if (Tag.equals("sem8ceutics12ctransdermaldds")) {
                NotesURL = getString(R.string.sem8ceutics12ctransdermaldds);
            }
            if (Tag.equals("sem8ceutics12bfloatingDDS")) {
                NotesURL = getString(R.string.sem8ceutics12bfloatingDDS);
            }
            if (Tag.equals("sem8ceutics12amultiparticulatedds")) {
                NotesURL = getString(R.string.sem8ceutics12amultiparticulatedds);
            }
            if (Tag.equals("sem8ceutics11introductiontoNDDS")) {
                NotesURL = getString(R.string.sem8ceutics11introductiontoNDDS);
            }

            // PChem
            if (Tag.equals("sem8pchemSynthesisSem8CBSGS")) {
                NotesURL = getString(R.string.sem8pchemSynthesisSem8CBSGS);
            }
            if (Tag.equals("sem8pchemSedativeHypnoticDrugs")) {
                NotesURL = getString(R.string.sem8pchemSedativeHypnoticDrugs);
            }
            if (Tag.equals("sem8pchemRashmiantipsychotics")) {
                NotesURL = getString(R.string.sem8pchemRashmiantipsychotics);
            }
            if (Tag.equals("sem8pchemOpioidAnalgesics1")) {
                NotesURL = getString(R.string.sem8pchemOpioidAnalgesics1);
            }
            if (Tag.equals("sem8pchemNSAIDS")) {
                NotesURL = getString(R.string.sem8pchemNSAIDS);
            }
            if (Tag.equals("sem8pchemAnalgesics")) {
                NotesURL = getString(R.string.sem8pchemAnalgesics);
            }
            if (Tag.equals("sem8pchemadrenocorticosteroids")) {
                NotesURL = getString(R.string.sem8pchemadrenocorticosteroids);
            }
            if (Tag.equals("sem8pchem24_Anxiolytics_final")) {
                NotesURL = getString(R.string.sem8pchem24_Anxiolytics_final);
            }
            if (Tag.equals("sem8pchem22_CalciumHomeostasis_final")) {
                NotesURL = getString(R.string.sem8pchem22_CalciumHomeostasis_final);
            }
            if (Tag.equals("sem8pchem21_Thyroid_drugs_final")) {
                NotesURL = getString(R.string.sem8pchem21_Thyroid_drugs_final);
            }
            if (Tag.equals("sem8pchem20_AdrenoSteroids_SexH_part3_final")) {
                NotesURL = getString(R.string.sem8pchem20_AdrenoSteroids_SexH_part3_final);
            }
            if (Tag.equals("sem8pchem19_20_AdrenoSteroids_SexHormones_final")) {
                NotesURL = getString(R.string.sem8pchem19_20_AdrenoSteroids_SexHormones_final);
            }
            if (Tag.equals("sem8pchem18_AdrenoSteroids_GC_final")) {
                NotesURL = getString(R.string.sem8pchem18_AdrenoSteroids_GC_final);
            }
            if (Tag.equals("sem8pchem10_Adrenergic_drugs_part4_final")) {
                NotesURL = getString(R.string.sem8pchem10_Adrenergic_drugs_part4_final);
            }
            if (Tag.equals("sem8pchem10nsaids")) {
                NotesURL = getString(R.string.sem8pchem10nsaids);
            }
            if (Tag.equals("sem8pchem09_Adrenergic_drugs_part3_final")) {
                NotesURL = getString(R.string.sem8pchem09_Adrenergic_drugs_part3_final);
            }
            if (Tag.equals("sem8pchem08_Adrenergic_drugs_part12_final")) {
                NotesURL = getString(R.string.sem8pchem08_Adrenergic_drugs_part12_final);
            }
            if (Tag.equals("sem8pchem02ThyroidHormones")) {
                NotesURL = getString(R.string.sem8pchem02ThyroidHormones);
            }
            if (Tag.equals("sem8pchem8cholinergicsdrugs")) {
                NotesURL = getString(R.string.sem8pchem8cholinergicsdrugs);
            }

            // BipPharm

            if (Tag.equals("sem8BPChapter1Introduction_1490373071611")) {
                NotesURL = getString(R.string.sem8BPChapter1Introduction_1490373071611);
            }
            if (Tag.equals("sem8BPChapter2Absorptionofdrugs_1490373071646")) {
                NotesURL = getString(R.string.sem8BPChapter2Absorptionofdrugs_1490373071646);
            }
            if (Tag.equals("sem8BPChapter3Distributionofdrugs_1490373071635")) {
                NotesURL = getString(R.string.sem8BPChapter3Distributionofdrugs_1490373071635);
            }
            if (Tag.equals("sem8BPChapter4Proteinbindingofdrugs_1490373071624")) {
                NotesURL = getString(R.string.sem8BPChapter4Proteinbindingofdrugs_1490373071624);
            }
            if (Tag.equals("sem8BPChapter5Metabolismofdrugs_1490373071650")) {
                NotesURL = getString(R.string.sem8BPChapter5Metabolismofdrugs_1490373071650);
            }
            if (Tag.equals("sem8BPChapter6Excretionofdrugs_1490373071679")) {
                NotesURL = getString(R.string.sem8BPChapter6Excretionofdrugs_1490373071679);
            }
            if (Tag.equals("sem8BPChapter7DrugInteractions_1490373071675")) {
                NotesURL = getString(R.string.sem8BPChapter7DrugInteractions_1490373071675);
            }
            if (Tag.equals("sem8BPChapter8PharmacokineticsBasicConsiderations_1490373071641")) {
                NotesURL = getString(R.string.sem8BPChapter8PharmacokineticsBasicConsiderations_1490373071641);
            }
            if (Tag.equals("sem8BPChapter9CompartmentModellling_14903730716548")) {
                NotesURL = getString(R.string.sem8BPChapter9CompartmentModellling_14903730716548);
            }
            if (Tag.equals("sem8BPChapter10NonlinearPharmacokinietics_1490373071657")) {
                NotesURL = getString(R.string.sem8BPChapter10NonlinearPharmacokinietics_1490373071657);
            }
            if (Tag.equals("sem8BPChapter11BioavailabilityandBioequivalence_1490373071661")) {
                NotesURL = getString(R.string.sem8BPChapter11BioavailabilityandBioequivalence_1490373071661);
            }
            if (Tag.equals("sem8BPChapter12ApplicationsofPharmacokineticPrinciples_1490373071668")) {
                NotesURL = getString(R.string.sem8BPChapter12ApplicationsofPharmacokineticPrinciples_1490373071668);
            }
            if (Tag.equals("sem8BPChapter13DrugConcentrationandPharmacologicResponse_1490373071665")) {
                NotesURL = getString(R.string.sem8BPChapter13DrugConcentrationandPharmacologicResponse_1490373071665);
            }
            if (Tag.equals("sem8BPChapter14ControlledReleaseMedication_1490373071672")) {
                NotesURL = getString(R.string.sem8BPChapter14ControlledReleaseMedication_1490373071672);
            }

            // Clinic Pharma
            if (Tag.equals("sem8CPtherapeuticdrugmonitoring")) {
                NotesURL = getString(R.string.sem8CPtherapeuticdrugmonitoring);
            }
            if (Tag.equals("sem8CPTherapeuticDrugMonitoring1")) {
                NotesURL = getString(R.string.sem8CPTherapeuticDrugMonitoring1);
            }
            if (Tag.equals("sem8CPPrinciplesofdrugtherapyinpregnancy")) {
                NotesURL = getString(R.string.sem8CPPrinciplesofdrugtherapyinpregnancy);
            }
            if (Tag.equals("sem8CPPharmacovigilance3May2017")) {
                NotesURL = getString(R.string.sem8CPPharmacovigilance3May2017);
            }
            if (Tag.equals("sem8CPpediatrictherapy")) {
                NotesURL = getString(R.string.sem8CPpediatrictherapy);
            }
            if (Tag.equals("sem8CPpediatricdrugstherapy")) {
                NotesURL = getString(R.string.sem8CPpediatricdrugstherapy);
            }
            if (Tag.equals("sem8CPPatientcounselling1")) {
                NotesURL = getString(R.string.sem8CPPatientcounselling1);
            }
            if (Tag.equals("sem8CPPatientCompilance")) {
                NotesURL = getString(R.string.sem8CPPatientCompilance);
            }
            if (Tag.equals("sem8CPIntroductiontoClinicalPharmacy")) {
                NotesURL = getString(R.string.sem8CPIntroductiontoClinicalPharmacy);
            }
            if (Tag.equals("sem8CPintrotodrugs")) {
                NotesURL = getString(R.string.sem8CPintrotodrugs);
            }
            if (Tag.equals("sem8CPichintro")) {
                NotesURL = getString(R.string.sem8CPichintro);
            }
            if (Tag.equals("sem8CPICHGCPandEthicscomittee")) {
                NotesURL = getString(R.string.sem8CPICHGCPandEthicscomittee);
            }
            if (Tag.equals("sem8CPFinalGlossaryoftermsinClinicalresearch")) {
                NotesURL = getString(R.string.sem8CPFinalGlossaryoftermsinClinicalresearch);
            }
            if (Tag.equals("sem8CPdrugsusedinpregnancy")) {
                NotesURL = getString(R.string.sem8CPdrugsusedinpregnancy);
            }
            if (Tag.equals("sem8CPdrugsusedingeritrics")) {
                NotesURL = getString(R.string.sem8CPdrugsusedingeritrics);
            }
            if (Tag.equals("sem8CPdrugstherapyin")) {
                NotesURL = getString(R.string.sem8CPdrugstherapyin);
            }
            if (Tag.equals("sem8CPDrugInteractions")) {
                NotesURL = getString(R.string.sem8CPDrugInteractions);
            }
            if (Tag.equals("sem8CPDrugDiscoveryDevelopment16")) {
                NotesURL = getString(R.string.sem8CPDrugDiscoveryDevelopment16);
            }
            if (Tag.equals("sem8CPCompl1")) {
                NotesURL = getString(R.string.sem8CPCompl1);
            }
            if (Tag.equals("sem8CPclinicaltrials")) {
                NotesURL = getString(R.string.sem8CPclinicaltrials);
            }
            if (Tag.equals("sem8CPclinicaltrialshistory")) {
                NotesURL = getString(R.string.sem8CPclinicaltrialshistory);
            }
            if (Tag.equals("sem8CPclinicalpharmacy")) {
                NotesURL = getString(R.string.sem8CPclinicalpharmacy);
            }
            if (Tag.equals("sem8CPclinicalpharma")) {
                NotesURL = getString(R.string.sem8CPclinicalpharma);
            }
            if (Tag.equals("sem8CPClinicalADR")) {
                NotesURL = getString(R.string.sem8CPClinicalADR);
            }
            if (Tag.equals("sem8CPBA_BE")) {
                NotesURL = getString(R.string.sem8CPBA_BE);
            }
            if (Tag.equals("sem8CPadversedrugreaction")) {
                NotesURL = getString(R.string.sem8CPadversedrugreaction);
            }
            if (Tag.equals("sem8CPADRmonitoring")) {
                NotesURL = getString(R.string.sem8CPADRmonitoring);
            }


            Intent intent = new Intent(this, BrowserActivity.class);
            intent.putExtra(EXTRA_MESSAGE, NotesURL);  //Add URL
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "No Internet !! Please Connect to Internet", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            CheckUpdate();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.notification) {
            Intent intent = new Intent(this, NotificationActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.disableads) {
            Toast.makeText(this, "Buy Ad-Free Version \n -Thank you :)", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(getString(R.string.AdFreeVersion)));
            startActivity(intent);
            return true;
        }
        if (id == R.id.feedback) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(getString(R.string.feedback_form_URL)));
            startActivity(intent);
            return true;
        }
        if (id == R.id.menu_item_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.Share_message));
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    @Override
    public void onBackPressed() {
        if (mInterstitialAd.isLoaded()) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            //FirebaseAuth.getInstance().signOut();
            mInterstitialAd.show();


        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
            //   FirebaseAuth.getInstance().signOut();

            finish();
        }
        super.onBackPressed();
    }
*/
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

    public void SubmitStudyMaterial(View v) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "B.Pharm Hub");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Study Material Submit Button");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "General");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.Submit_notes_URL)));
        startActivity(intent);
    }

    public void CheckUpdate() {
        final String CurrentVersionCode = getString(R.string.app_version_code);
        // Write a message to the database

        final CardView UpdateCard = (CardView) findViewById(R.id.NewUpdateCardView);
        UpdateCard.setVisibility(View.GONE);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("BPharmHub/VersionCode");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Update Value is: " + value);
                if (value != null) {
                    int v = Integer.valueOf(value);
                    int Cv = Integer.valueOf(CurrentVersionCode);

                    if (v > Cv) {
                        UpdateCard.setVisibility(View.VISIBLE);

                    } else {
                        UpdateCard.setVisibility(View.GONE);
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }

    public void UpdateIT(View v) {
        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    public void LoadBooksList() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();


        DatabaseReference APPBookDB = database.getReference("/BPharmHub/books/APP");
        APPBookDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //   String value = dataSnapshot.getValue(String.class);
                //  Log.d(TAG, "Value is: " + value);

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    // TODO: handle the post
                    //String BookSubject=postSnapshot.getKey();
                    HashMap<String, String> APPBook = new HashMap<>();

                    String BookName = postSnapshot.child("book_name").getValue(String.class);
                    String BookEdition = postSnapshot.child("book_edition").getValue(String.class);
                    String BookURL = postSnapshot.child("book_url").getValue(String.class);

                    Log.d(TAG, "onDataChange: " + "\n" + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // tmp hash map for single contact
                    // adding each child node to HashMap key => value
                    //      contact.put("id", id);
                    APPBook.put("book_name", BookName);
                    APPBook.put("book_url", BookURL);
                    APPBook.put("book_edition", BookEdition);

                    Log.d(TAG, " Book HashMap added: " + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // adding contact to contact list
                    APPBooksList.add(APPBook);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        DatabaseReference AnalysisBookDB = database.getReference("/BPharmHub/books/Analysis");
        AnalysisBookDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //   String value = dataSnapshot.getValue(String.class);
                //  Log.d(TAG, "Value is: " + value);

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    // TODO: handle the post
                    //String BookSubject=postSnapshot.getKey();
                    HashMap<String, String> AnalysisBook = new HashMap<>();

                    String BookName = postSnapshot.child("book_name").getValue(String.class);
                    String BookEdition = postSnapshot.child("book_edition").getValue(String.class);
                    String BookURL = postSnapshot.child("book_url").getValue(String.class);

                    Log.d(TAG, "onDataChange: " + "\n" + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // tmp hash map for single contact
                    // adding each child node to HashMap key => value
                    //      contact.put("id", id);
                    AnalysisBook.put("book_name", BookName);
                    AnalysisBook.put("book_url", BookURL);
                    AnalysisBook.put("book_edition", BookEdition);

                    Log.d(TAG, " Book HashMap added: " + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // adding contact to contact list
                    AnalysisBooksList.add(AnalysisBook);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        DatabaseReference BiochemBookDB = database.getReference("/BPharmHub/books/Biochem");
        BiochemBookDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //   String value = dataSnapshot.getValue(String.class);
                //  Log.d(TAG, "Value is: " + value);

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    // TODO: handle the post
                    //String BookSubject=postSnapshot.getKey();
                    HashMap<String, String> Book = new HashMap<>();

                    String BookName = postSnapshot.child("book_name").getValue(String.class);
                    String BookEdition = postSnapshot.child("book_edition").getValue(String.class);
                    String BookURL = postSnapshot.child("book_url").getValue(String.class);

                    Log.d(TAG, "onDataChange: " + "\n" + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // tmp hash map for single contact
                    // adding each child node to HashMap key => value
                    //      contact.put("id", id);
                    Book.put("book_name", BookName);
                    Book.put("book_url", BookURL);
                    Book.put("book_edition", BookEdition);

                    Log.d(TAG, " Book HashMap added: " + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // adding contact to contact list
                    BiochemBooksList.add(Book);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        DatabaseReference ChemistryBookDB = database.getReference("/BPharmHub/books/Chemistry");
        ChemistryBookDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //   String value = dataSnapshot.getValue(String.class);
                //  Log.d(TAG, "Value is: " + value);

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    // TODO: handle the post
                    //String BookSubject=postSnapshot.getKey();
                    HashMap<String, String> Book = new HashMap<>();

                    String BookName = postSnapshot.child("book_name").getValue(String.class);
                    String BookEdition = postSnapshot.child("book_edition").getValue(String.class);
                    String BookURL = postSnapshot.child("book_url").getValue(String.class);

                    Log.d(TAG, "onDataChange: " + "\n" + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // tmp hash map for single contact
                    // adding each child node to HashMap key => value
                    //      contact.put("id", id);
                    Book.put("book_name", BookName);
                    Book.put("book_url", BookURL);
                    Book.put("book_edition", BookEdition);

                    Log.d(TAG, " Book HashMap added: " + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // adding contact to contact list
                    ChemistryBooksList.add(Book);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        DatabaseReference HPDSMBookDB = database.getReference("/BPharmHub/books/HPDSM");
        HPDSMBookDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //   String value = dataSnapshot.getValue(String.class);
                //  Log.d(TAG, "Value is: " + value);

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    // TODO: handle the post
                    //String BookSubject=postSnapshot.getKey();
                    HashMap<String, String> Book = new HashMap<>();

                    String BookName = postSnapshot.child("book_name").getValue(String.class);
                    String BookEdition = postSnapshot.child("book_edition").getValue(String.class);
                    String BookURL = postSnapshot.child("book_url").getValue(String.class);

                    Log.d(TAG, "onDataChange: " + "\n" + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // tmp hash map for single contact
                    // adding each child node to HashMap key => value
                    //      contact.put("id", id);
                    Book.put("book_name", BookName);
                    Book.put("book_url", BookURL);
                    Book.put("book_edition", BookEdition);

                    Log.d(TAG, " Book HashMap added: " + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // adding contact to contact list
                    HPDSMBooksList.add(Book);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        DatabaseReference OthersBookDB = database.getReference("/BPharmHub/books/Others");
        OthersBookDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //   String value = dataSnapshot.getValue(String.class);
                //  Log.d(TAG, "Value is: " + value);

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    // TODO: handle the post
                    //String BookSubject=postSnapshot.getKey();
                    HashMap<String, String> Book = new HashMap<>();

                    String BookName = postSnapshot.child("book_name").getValue(String.class);
                    String BookEdition = postSnapshot.child("book_edition").getValue(String.class);
                    String BookURL = postSnapshot.child("book_url").getValue(String.class);

                    Log.d(TAG, "onDataChange: " + "\n" + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // tmp hash map for single contact
                    // adding each child node to HashMap key => value
                    //      contact.put("id", id);
                    Book.put("book_name", BookName);
                    Book.put("book_url", BookURL);
                    Book.put("book_edition", BookEdition);

                    Log.d(TAG, " Book HashMap added: " + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // adding contact to contact list
                    OthersBooksList.add(Book);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        DatabaseReference PPBookDB = database.getReference("/BPharmHub/books/PP");
        PPBookDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //   String value = dataSnapshot.getValue(String.class);
                //  Log.d(TAG, "Value is: " + value);

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    // TODO: handle the post
                    //String BookSubject=postSnapshot.getKey();
                    HashMap<String, String> Book = new HashMap<>();

                    String BookName = postSnapshot.child("book_name").getValue(String.class);
                    String BookEdition = postSnapshot.child("book_edition").getValue(String.class);
                    String BookURL = postSnapshot.child("book_url").getValue(String.class);

                    Log.d(TAG, "onDataChange: " + "\n" + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // tmp hash map for single contact
                    // adding each child node to HashMap key => value
                    //      contact.put("id", id);
                    Book.put("book_name", BookName);
                    Book.put("book_url", BookURL);
                    Book.put("book_edition", BookEdition);

                    Log.d(TAG, " Book HashMap added: " + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // adding contact to contact list
                    PPBooksList.add(Book);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        DatabaseReference PharmaceuticsBookDB = database.getReference("/BPharmHub/books/Pharmaceutics");
        PharmaceuticsBookDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //   String value = dataSnapshot.getValue(String.class);
                //  Log.d(TAG, "Value is: " + value);

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    // TODO: handle the post
                    //String BookSubject=postSnapshot.getKey();
                    HashMap<String, String> Book = new HashMap<>();

                    String BookName = postSnapshot.child("book_name").getValue(String.class);
                    String BookEdition = postSnapshot.child("book_edition").getValue(String.class);
                    String BookURL = postSnapshot.child("book_url").getValue(String.class);

                    Log.d(TAG, "onDataChange: " + "\n" + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // tmp hash map for single contact
                    // adding each child node to HashMap key => value
                    //      contact.put("id", id);
                    Book.put("book_name", BookName);
                    Book.put("book_url", BookURL);
                    Book.put("book_edition", BookEdition);

                    Log.d(TAG, " Book HashMap added: " + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // adding contact to contact list
                    PharmaceuticsBooksList.add(Book);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        DatabaseReference PharmacognosyBookDB = database.getReference("/BPharmHub/books/Pharmacognosy");
        PharmacognosyBookDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //   String value = dataSnapshot.getValue(String.class);
                //  Log.d(TAG, "Value is: " + value);

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    // TODO: handle the post
                    //String BookSubject=postSnapshot.getKey();
                    HashMap<String, String> Book = new HashMap<>();

                    String BookName = postSnapshot.child("book_name").getValue(String.class);
                    String BookEdition = postSnapshot.child("book_edition").getValue(String.class);
                    String BookURL = postSnapshot.child("book_url").getValue(String.class);

                    Log.d(TAG, "onDataChange: " + "\n" + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // tmp hash map for single contact
                    // adding each child node to HashMap key => value
                    //      contact.put("id", id);
                    Book.put("book_name", BookName);
                    Book.put("book_url", BookURL);
                    Book.put("book_edition", BookEdition);

                    Log.d(TAG, " Book HashMap added: " + BookName + "\n" + BookEdition + "\n" + BookURL);

                    // adding contact to contact list
                    PharmacognosyBooksList.add(Book);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


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
