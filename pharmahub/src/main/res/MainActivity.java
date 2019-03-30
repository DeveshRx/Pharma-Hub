package ephrineapps.bpharmhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "URL2Load";
    public static final String LogTag = "Bpharm Hub ";
    public String PcognoSelectStatus;
    public String PceuticsSelectStatus;
    public String PchemSelectStatus;
    public String PaSelectStatus;
    public String PjSelectStatus;
    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            View ViewSyllabus = (View) findViewById(R.id.IncludeSyllabus);
            View ViewNotes = (View) findViewById(R.id.IncludeNotes);

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

        PcognoSelectStatus = "0";
        PceuticsSelectStatus = "0";
        PchemSelectStatus = "0";
        PaSelectStatus = "0";
        PjSelectStatus = "0";

    }

    public void SyllabusClick(View v) {
        String Tag = v.getTag().toString();

        String SyllabusURL = "0";

        if (Tag.equals("FY")) {

            SyllabusURL = getString(R.string.FYSyllabus_OLD);

        } else if (Tag.equals("FY1")) {

            SyllabusURL = getString(R.string.FYSyllabus_2016_New);

        } else if (Tag.equals("SY")) {

            SyllabusURL = getString(R.string.SYSyllabus_OLD);


        } else if (Tag.equals("SY1")) {

            SyllabusURL = getString(R.string.SYSyllabus_New);

        } else if (Tag.equals("TY")) {
            SyllabusURL = getString(R.string.TYSyllabus_OLD);

        } else if (Tag.equals("TY1")) {

            SyllabusURL = getString(R.string.TYSyllabus_New);

        } else if (Tag.equals("Final")) {
            SyllabusURL = getString(R.string.FinalSyllabus_OLD);

        }

        Intent intent = new Intent(this, BrowserActivity.class);
        intent.putExtra(EXTRA_MESSAGE, SyllabusURL);  //Add URL
        startActivity(intent);

    }

    public void NotesSelectSem7(View v) {
        String Tag = v.getTag().toString();

        String NotesURL = "0";
        // PharmaCognosy
        if (Tag.equals("sem7cognoNutraceuticals(1)")) {
            NotesURL = getString(R.string.sem7cognoNutraceuticals1);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }

        if (Tag.equals("sem7cognonEUTRACEUTICALS1")) {
            NotesURL = getString(R.string.sem7cognonEUTRACEUTICALS1);// Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }

        if (Tag.equals("sem7cognonaturalpesticide")) {
            NotesURL = getString(R.string.sem7cognonaturalpesticide);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }

        if (Tag.equals("sem7cognocardiacglycosides")) {
            NotesURL = getString(R.string.sem7cognocardiacglycosides);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }

        if (Tag.equals("sem7cognoCardiacGlycosides(1)")) {
            NotesURL = getString(R.string.sem7cognoCardiacGlycosides1);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7cognoglycosides")) {
            NotesURL = getString(R.string.sem7cognoglycosides);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }

        //PharmaCeutics

        if (Tag.equals("sem7ceuticsSTABILITYSTUDIESupdated")) {
            NotesURL = getString(R.string.sem7ceuticsSTABILITYSTUDIESupdated);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7ceuticsPARENTRALSCONTAINERS")) {
            NotesURL = getString(R.string.sem7ceuticsPARENTRALSCONTAINERS);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7ceuticsParenteralsTypesofproducts")) {
            NotesURL = getString(R.string.sem7ceuticsParenteralsTypesofproducts);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7ceuticsOphthalmicPreparations2_1479488103494_1479565618611")) {
            NotesURL = getString(R.string.sem7ceuticsOphthalmicPreparations2_1479488103494_1479565618611);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7ceuticsOCRD_1479531207097")) {
            NotesURL = getString(R.string.sem7ceuticsOCRD_1479531207097);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7ceuticsLVP")) {
            NotesURL = getString(R.string.sem7ceuticsLVP);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7ceuticsimpPPTtabletexcipients(1)")) {
            NotesURL = getString(R.string.sem7ceuticsimpPPTtabletexcipients1);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7ceuticsEvaluationofSRformulations")) {
            NotesURL = getString(R.string.sem7ceuticsEvaluationofSRformulations);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7ceuticsacceleratedstabilitystudes_1479487312088_1479565618596")) {
            NotesURL = getString(R.string.sem7ceuticsacceleratedstabilitystudes_1479487312088_1479565618596);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7ceuticsTOXICITYSTUDIES")) {
            NotesURL = getString(R.string.sem7ceuticsTOXICITYSTUDIES);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7ceuticsTabletTechnology")) {
            NotesURL = getString(R.string.sem7ceuticsTabletTechnology);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7ceuticsstabilitystudies")) {
            NotesURL = getString(R.string.sem7ceuticsstabilitystudies);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }

        if (Tag.equals("sem7ceuticsstabilitystudies1")) {
            NotesURL = getString(R.string.sem7ceuticsstabilitystudies1);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7ceuticsSRDDSEVALUATION")) {
            NotesURL = getString(R.string.sem7ceuticsSRDDSEVALUATION);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7ceuticsContainersandclosures")) {
            NotesURL = getString(R.string.sem7ceuticsContainersandclosures);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7ceuticsICHguideline1478588402168")) {
            NotesURL = getString(R.string.sem7ceuticsICHguideline1478588402168);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }

        // Pharma Chem

        if (Tag.equals("sem7pchemLocal_ana1")) {
            NotesURL = getString(R.string.sem7pchemLocal_ana1);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pchemAntiviral")) {
            NotesURL = getString(R.string.sem7pchemAntiviral);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pchemAntineoplastics")) {
            NotesURL = getString(R.string.sem7pchemAntineoplastics);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pchemanticancer")) {
            NotesURL = getString(R.string.sem7pchemanticancer);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pchemDiuretics")) {
            NotesURL = getString(R.string.sem7pchemDiuretics);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pchemsynthesisall")) {
            NotesURL = getString(R.string.sem7pchemsynthesisall);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }

        // Pharma Analysis

        if (Tag.equals("sem7pamanjuHPTLC")) {
            NotesURL = getString(R.string.sem7pamanjuHPTLC);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7paSLmassspect1478597249577")) {
            NotesURL = getString(R.string.sem7paSLmassspect1478597249577);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7paAnalysischapterwiseQuestionBank")) {
            NotesURL = getString(R.string.sem7paAnalysischapterwiseQuestionBank);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7paMASSSPECTROSCOPY")) {
            NotesURL = getString(R.string.sem7paMASSSPECTROSCOPY);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7paanalyticalmethodvalidation")) {
            NotesURL = getString(R.string.sem7paanalyticalmethodvalidation);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }

        // Pharma Juris

        if (Tag.equals("sem7pjTheFactoriesAct")) {
            NotesURL = getString(R.string.sem7pjTheFactoriesAct);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjTheBombayshopsandestablishmentsact1948")) {
            NotesURL = getString(R.string.sem7pjTheBombayshopsandestablishmentsact1948);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjScheduleY")) {
            NotesURL = getString(R.string.sem7pjScheduleY);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjPatentsAct2005")) {
            NotesURL = getString(R.string.sem7pjPatentsAct2005);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjNarcoticDrugsandPsychotropicSubstancesAct1985")) {
            NotesURL = getString(R.string.sem7pjNarcoticDrugsandPsychotropicSubstancesAct1985);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjMedicinalToiletPreparationsExciseDutiesAct")) {
            NotesURL = getString(R.string.sem7pjMedicinalToiletPreparationsExciseDutiesAct);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjINTRODUCTIONTODRUGREGULATORYAFFAIRS")) {
            NotesURL = getString(R.string.sem7pjINTRODUCTIONTODRUGREGULATORYAFFAIRS);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjIndianpenalcodesectionsrelatedtoPharmacy1")) {
            NotesURL = getString(R.string.sem7pjIndianpenalcodesectionsrelatedtoPharmacy1);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjIndianPenalCodeIPC")) {
            NotesURL = getString(R.string.sem7pjIndianPenalCodeIPC);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjFSSA2006")) {
            NotesURL = getString(R.string.sem7pjFSSA2006);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjForensicpharmacyPharmacyAct25august2015")) {
            NotesURL = getString(R.string.sem7pjForensicpharmacyPharmacyAct25august2015);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjForensicpharmacyPatentsAct1970")) {
            NotesURL = getString(R.string.sem7pjForensicpharmacyPatentsAct1970);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjForensicPharmacyHistory5December2014")) {
            NotesURL = getString(R.string.sem7pjForensicPharmacyHistory5December2014);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjForensicpharmacyDCAPartII15January2015")) {
            NotesURL = getString(R.string.sem7pjForensicpharmacyDCAPartII15January2015);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjForensicPharmacyMagicRemediesAct1954")) {
            NotesURL = getString(R.string.sem7pjForensicPharmacyMagicRemediesAct1954);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjForensicPharmacyIntroductionandHistory")) {
            NotesURL = getString(R.string.sem7pjForensicPharmacyIntroductionandHistory);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjForensicPharmacyExciseDutyAct")) {
            NotesURL = getString(R.string.sem7pjForensicPharmacyExciseDutyAct);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjDrugsmagicremediesadvertisementAct")) {
            NotesURL = getString(R.string.sem7pjDrugsmagicremediesadvertisementAct);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjDrugsMagicRemediesActOA")) {
            NotesURL = getString(R.string.sem7pjDrugsMagicRemediesActOA);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjDPCO2013")) {
            NotesURL = getString(R.string.sem7pjDPCO2013);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjDPCO201320September2015")) {
            NotesURL = getString(R.string.sem7pjDPCO201320September2015);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjDMRactfinal")) {
            NotesURL = getString(R.string.sem7pjDMRactfinal);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }
        if (Tag.equals("sem7pjChopraandHatheeCommittee1")) {
            NotesURL = getString(R.string.sem7pjChopraandHatheeCommittee1);  // Add URL for Notes
            Log.v(LogTag, "Notes URL: " + NotesURL);
        }


        Intent intent = new Intent(this, BrowserActivity.class);
        intent.putExtra(EXTRA_MESSAGE, NotesURL);  //Add URL
        startActivity(intent);

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

    public void HallTicketClick(View v) {
        String Tag = v.getTag().toString();

        String HallTicketURL = "0";
        if (Tag.equals("AltHallTicket")) {
            HallTicketURL = getString(R.string.AltHallTicket);
        }

        if (Tag.equals("Sem8HallTicket")) {
            HallTicketURL = getString(R.string.Sem8HallTicket);
        }
        if (Tag.equals("Sem7HallTicket")) {
            HallTicketURL = getString(R.string.Sem7HallTicket);
        }

        Intent intent = new Intent(this, BrowserActivity.class);
        intent.putExtra(EXTRA_MESSAGE, HallTicketURL);  //Add URL
        startActivity(intent);

    }


}
