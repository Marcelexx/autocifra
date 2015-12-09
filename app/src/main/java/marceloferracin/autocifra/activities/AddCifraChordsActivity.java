package marceloferracin.autocifra.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import marceloferracin.autocifra.R;

public class AddCifraChordsActivity extends AppCompatActivity {
    private LinearLayout mAddCifraMainLayout;
    private LinearLayout mAddCifraContentLayout;

    private LinearLayout mAddCifraOneChordLayout;
    private LinearLayout mAddCifraTwoChordLayout;
    private LinearLayout mAddCifraFourChordLayout;

    private Spinner mAddCifraOneTuningSpinner;

    private Spinner mAddCifraTwoTuningSpinner1;
    private Spinner mAddCifraTwoTuningSpinner2;

    private Spinner mAddCifraFourTuningSpinner1;
    private Spinner mAddCifraFourTuningSpinner2;
    private Spinner mAddCifraFourTuningSpinner3;
    private Spinner mAddCifraFourTuningSpinner4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cifra_chords);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView toolbarTitle = (TextView) findViewById(R.id.main_toolbar_title);
        toolbarTitle.setText(getString(R.string.add_cifra_title));

        initComponents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_default, menu);
        return true;
    }

    private void initComponents() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mAddCifraMainLayout = (LinearLayout) findViewById(R.id.addCifraMainLayout);
        mAddCifraContentLayout = (LinearLayout) findViewById(R.id.addCifraContentLayout);

        TextView addCifraLyricsTextView = (TextView) findViewById(R.id.addCifraLyricsTextView);
        String cifraLyrics =  getIntent().getStringExtra("cifraLyrics");
        String[] cifraLyricsInLines = cifraLyrics.split("\r\n|\r|\n");

//        for (String line : cifraLyricsInLines) {
//            //TODO Clone layout set text
//            mAddCifraMainLayout.addView(mAddCifraContentLayout);
//            addCifraLyricsTextView.setText(line);
//        }

        addCifraLyricsTextView.setText(cifraLyrics);

        Spinner addCifraNumberOfChrods = (Spinner) findViewById(R.id.addCifraNumberOfChrods);

        mAddCifraOneChordLayout = (LinearLayout) findViewById(R.id.addCifraOneChordLayout);
        mAddCifraTwoChordLayout = (LinearLayout) findViewById(R.id.addCifraTwoChordLayout);
        mAddCifraFourChordLayout = (LinearLayout) findViewById(R.id.addCifraFourChordLayout);

        mAddCifraOneTuningSpinner = (Spinner) findViewById(R.id.addCifraOneChordSpinner);

        mAddCifraTwoTuningSpinner1 = (Spinner) findViewById(R.id.addCifraTwoChordSpinner1);
        mAddCifraTwoTuningSpinner2 = (Spinner) findViewById(R.id.addCifraTwoChordSpinner2);

        mAddCifraFourTuningSpinner1 = (Spinner) findViewById(R.id.addCifraFourChordSpinner1);
        mAddCifraFourTuningSpinner2 = (Spinner) findViewById(R.id.addCifraFourChordSpinner2);
        mAddCifraFourTuningSpinner3 = (Spinner) findViewById(R.id.addCifraFourChordSpinner3);
        mAddCifraFourTuningSpinner4 = (Spinner) findViewById(R.id.addCifraFourChordSpinner4);

        CharSequence numberOfChords[] = getResources().getStringArray(R.array.numberOfChordsOptions);
        addCifraNumberOfChrods.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numberOfChords));
        addCifraNumberOfChrods.setOnItemSelectedListener(setNumberOfChordsItemSelect());

        setSpinnersAdapters();
    }

    private AdapterView.OnItemSelectedListener setNumberOfChordsItemSelect() {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mAddCifraOneChordLayout.setVisibility(View.VISIBLE);
                        mAddCifraTwoChordLayout.setVisibility(View.GONE);
                        mAddCifraFourChordLayout.setVisibility(View.GONE);
                        break;
                    case 1:
                        mAddCifraOneChordLayout.setVisibility(View.GONE);
                        mAddCifraTwoChordLayout.setVisibility(View.VISIBLE);
                        mAddCifraFourChordLayout.setVisibility(View.GONE);
                        break;
                    case 2:
                        mAddCifraOneChordLayout.setVisibility(View.GONE);
                        mAddCifraTwoChordLayout.setVisibility(View.GONE);
                        mAddCifraFourChordLayout.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        mAddCifraOneChordLayout.setVisibility(View.GONE);
                        mAddCifraTwoChordLayout.setVisibility(View.GONE);
                        mAddCifraFourChordLayout.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
    }

    private void setSpinnersAdapters() {
        createSpinnerAdapter(mAddCifraOneTuningSpinner);

        createSpinnerAdapter(mAddCifraTwoTuningSpinner1);
        createSpinnerAdapter(mAddCifraTwoTuningSpinner2);

        createSpinnerAdapter(mAddCifraFourTuningSpinner1);
        createSpinnerAdapter(mAddCifraFourTuningSpinner2);
        createSpinnerAdapter(mAddCifraFourTuningSpinner3);
        createSpinnerAdapter(mAddCifraFourTuningSpinner4);
    }

    private void createSpinnerAdapter(Spinner spinner) {
        CharSequence chords[] = getResources().getStringArray(R.array.chordsOptions);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chords));
    }
}