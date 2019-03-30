package devesh.b.pharm.guide.mu;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
//import com.google.firebase.messaging.RemoteMessage;

public class NotificationActivity extends AppCompatActivity {
    public static final String TAG = "Bpharm Hub ";
    public String NTotal;
    public String ContentURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        //Toast.makeText(this, "Loading.....", Toast.LENGTH_SHORT).show();
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NotificationGetTotal();
      //  ForceCrash();
    }



    public void NotificationGetTotal() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference GetT = database.getReference("BPharmHub/notifications/total");
        GetT.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Get Total Value is: " + value);
                if(value!=null){
                    if(value.equals("0")){
                        TextView NoNotification=(TextView)findViewById(R.id.textViewNoNotification);
                        NoNotification.setVisibility(View.VISIBLE);
                    }else {

                        NTotal=value;
                        LoadNotifications();

                        TextView NoNotification=(TextView)findViewById(R.id.textViewNoNotification);
                        NoNotification.setVisibility(View.GONE);

                    }
                }else {
                    TextView NoNotification=(TextView)findViewById(R.id.textViewNoNotification);
                    NoNotification.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }



    public void LoadNotifications() {


        LinearLayout LLViewNotice = (LinearLayout) findViewById(R.id.LLNotice);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(v.getTag().toString().equals("x")){


                }else {
                    ContentURL=v.getTag().toString();

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(ContentURL));
                    startActivity(intent);

                }
            }

        };

        int t = Integer.parseInt(NTotal);
        for (int j = t; j >= 1; j--) {


            String No = String.valueOf(j);
            final CardView mcard = new CardView(this);
            mcard.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            mcard.setCardElevation(5);
            mcard.setUseCompatPadding(true);
            // mcard.setId(j);
            //mcard.setTag(No);
               mcard.setOnClickListener(click);

            if(LLViewNotice!=null){
                LLViewNotice.addView(mcard);
                LinearLayout LL = new LinearLayout(this);
                LL.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                LL.setOrientation(LinearLayout.HORIZONTAL);
                LL.setPadding(30, 20, 30, 20);
                mcard.addView(LL);

                //     ImageView img = new ImageView(AdminActivity.this);
                //       Drawable DOCDrawable = getResources().getDrawable(R.drawable.financial512);
                //     img.setImageDrawable(DOCDrawable);
                // img.requestLayout();
                // LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(200, 200);
                // img.setLayoutParams(layoutParams);
                ///  img.getLayoutParams().height = 20;
                //  img.getLayoutParams().width = 20;
                //   LL.addView(img);

                LinearLayout LL1 = new LinearLayout(this);
                LL1.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                LL1.setOrientation(LinearLayout.VERTICAL);
                LL.addView(LL1);


                final TextView txTitle = new TextView(this);
                txTitle.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                txTitle.setTypeface(null, Typeface.BOLD);
                txTitle.setTextSize(18);
                txTitle.setText(" ");
                LL1.addView(txTitle);

                final TextView txNotice = new TextView(this);
                txNotice.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                txNotice.setTypeface(null, Typeface.ITALIC);
                txNotice.setTextSize(16);
                txNotice.setText(" ");
                LL1.addView(txNotice);

                DatabaseReference GetTitle = database.getReference("BPharmHub/notifications/"+No+"/title");
                DatabaseReference GetNMesssage = database.getReference("BPharmHub/notifications/"+No+"/msg");
                DatabaseReference GetContentURL = database.getReference("BPharmHub/notifications/"+No+"/url");

final int JJ=j;
                GetTitle.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        String value = dataSnapshot.getValue(String.class);
                        Log.d(TAG, "Notification Title value is: " + value);
                        if(value!=null){
                            txTitle.setText(value);

                            if(JJ==1){
                                LinearLayout LLloading=(LinearLayout)findViewById(R.id.LLLoading);
                                LLloading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });

                GetNMesssage.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        String value = dataSnapshot.getValue(String.class);
                        Log.d(TAG, "Notification Msg value is: " + value);
                        if(value!=null){
                            txNotice.setText(value);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });

                GetContentURL.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        String value = dataSnapshot.getValue(String.class);
                        Log.d(TAG, "Notification Msg value is: " + value);
                        if(value!=null){
                            mcard.setTag(value);
                        }else {
                            mcard.setTag("x");
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


    }


}
