//package marceloferracin.autocifra.activities;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.Spinner;
//import android.widget.TextView;
//
//import marceloferracin.autocifra.R;
//
//public class AddCifraWriteActivity extends AppCompatActivity {
//    private LinearLayout mAddCifraMainLayout;
//    private LinearLayout mAddCifraContentLayout;
//
//    private RelativeLayout mAddCifraOneChordLayout;
//    private RelativeLayout mAddCifraTwoChordLayout;
//    private RelativeLayout mAddCifraFourChordLayout;
//    private RelativeLayout mAddCifraEightChordLayout;
//
//    private Spinner mAddCifraOneTuningSpinner;
//
//    private Spinner mAddCifraTwoTuningSpinner1;
//    private Spinner mAddCifraTwoTuningSpinner2;
//
//    private Spinner mAddCifraFourTuningSpinner1;
//    private Spinner mAddCifraFourTuningSpinner2;
//    private Spinner mAddCifraFourTuningSpinner3;
//    private Spinner mAddCifraFourTuningSpinner4;
//
//    private Spinner mAddCifraEightTuningSpinner1;
//    private Spinner mAddCifraEightTuningSpinner2;
//    private Spinner mAddCifraEightTuningSpinner3;
//    private Spinner mAddCifraEightTuningSpinner4;
//    private Spinner mAddCifraEightTuningSpinner5;
//    private Spinner mAddCifraEightTuningSpinner6;
//    private Spinner mAddCifraEightTuningSpinner7;
//    private Spinner mAddCifraEightTuningSpinner8;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_cifra_write);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        TextView toolbarTitle = (TextView) findViewById(R.id.main_toolbar_title);
//        toolbarTitle.setText(getString(R.string.add_cifra_title));
//
//        initComponents();
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_default, menu);
//        return true;
//    }
//
//    private void initComponents() {
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//
//        mAddCifraMainLayout = (LinearLayout) findViewById(R.id.addCifraMainLayout);
//        mAddCifraContentLayout = (LinearLayout) findViewById(R.id.addCifraContentLayout);
//
//
//        Spinner addCifraNumberOfChrods = (Spinner) findViewById(R.id.addCifraNumberOfChrods);
//
//        mAddCifraOneChordLayout = (RelativeLayout) findViewById(R.id.addCifraOneChordLayout);
//        mAddCifraTwoChordLayout = (RelativeLayout) findViewById(R.id.addCifraTwoChordLayout);
//        mAddCifraFourChordLayout = (RelativeLayout) findViewById(R.id.addCifraFourChordLayout);
//        mAddCifraEightChordLayout = (RelativeLayout) findViewById(R.id.addCifraEightChordLayout);
//
//        mAddCifraOneTuningSpinner = (Spinner) findViewById(R.id.addCifraOneChordSpinner);
//
//        mAddCifraTwoTuningSpinner1 = (Spinner) findViewById(R.id.addCifraTwoChordSpinner1);
//        mAddCifraTwoTuningSpinner2 = (Spinner) findViewById(R.id.addCifraTwoChordSpinner2);
//
//        mAddCifraFourTuningSpinner1 = (Spinner) findViewById(R.id.addCifraFourChordSpinner1);
//        mAddCifraFourTuningSpinner2 = (Spinner) findViewById(R.id.addCifraFourChordSpinner2);
//        mAddCifraFourTuningSpinner3 = (Spinner) findViewById(R.id.addCifraFourChordSpinner3);
//        mAddCifraFourTuningSpinner4 = (Spinner) findViewById(R.id.addCifraFourChordSpinner4);
//
//        mAddCifraEightTuningSpinner1 = (Spinner) findViewById(R.id.addCifraEightChordSpinner1);
//        mAddCifraEightTuningSpinner2 = (Spinner) findViewById(R.id.addCifraEightChordSpinner2);
//        mAddCifraEightTuningSpinner3 = (Spinner) findViewById(R.id.addCifraEightChordSpinner3);
//        mAddCifraEightTuningSpinner4 = (Spinner) findViewById(R.id.addCifraEightChordSpinner4);
//        mAddCifraEightTuningSpinner5 = (Spinner) findViewById(R.id.addCifraEightChordSpinner5);
//        mAddCifraEightTuningSpinner6 = (Spinner) findViewById(R.id.addCifraEightChordSpinner6);
//        mAddCifraEightTuningSpinner7 = (Spinner) findViewById(R.id.addCifraEightChordSpinner7);
//        mAddCifraEightTuningSpinner8 = (Spinner) findViewById(R.id.addCifraEightChordSpinner8);
//
//        CharSequence numberOfChords[] = getResources().getStringArray(R.array.numberOfChordsOptions);
//        addCifraNumberOfChrods.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numberOfChords));
//        addCifraNumberOfChrods.setOnItemSelectedListener(setNumberOfChordsItemSelect());
//
//        setSpinnersAdapters();
//    }
//
//    private AdapterView.OnItemSelectedListener setNumberOfChordsItemSelect() {
//        return new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                switch (position) {
//                    case 0:
//                        mAddCifraOneChordLayout.setVisibility(View.VISIBLE);
//                        mAddCifraTwoChordLayout.setVisibility(View.GONE);
//                        mAddCifraFourChordLayout.setVisibility(View.GONE);
//                        mAddCifraEightChordLayout.setVisibility(View.GONE);
//                        break;
//                    case 1:
//                        mAddCifraMainLayout.addView(mAddCifraContentLayout);
//
//                        mAddCifraOneChordLayout.setVisibility(View.GONE);
//                        mAddCifraTwoChordLayout.setVisibility(View.VISIBLE);
//                        mAddCifraFourChordLayout.setVisibility(View.GONE);
//                        mAddCifraEightChordLayout.setVisibility(View.GONE);
//                        break;
//                    case 2:
//                        mAddCifraOneChordLayout.setVisibility(View.GONE);
//                        mAddCifraTwoChordLayout.setVisibility(View.GONE);
//                        mAddCifraFourChordLayout.setVisibility(View.VISIBLE);
//                        mAddCifraEightChordLayout.setVisibility(View.GONE);
//                        break;
//                    case 3:
//                        mAddCifraOneChordLayout.setVisibility(View.GONE);
//                        mAddCifraTwoChordLayout.setVisibility(View.GONE);
//                        mAddCifraFourChordLayout.setVisibility(View.GONE);
//                        mAddCifraEightChordLayout.setVisibility(View.VISIBLE);
//                        break;
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        };
//    }
//
//    private void setSpinnersAdapters() {
//        createSpinnerAdapter(mAddCifraOneTuningSpinner);
//
//        createSpinnerAdapter(mAddCifraTwoTuningSpinner1);
//        createSpinnerAdapter(mAddCifraTwoTuningSpinner2);
//
//        createSpinnerAdapter(mAddCifraFourTuningSpinner1);
//        createSpinnerAdapter(mAddCifraFourTuningSpinner2);
//        createSpinnerAdapter(mAddCifraFourTuningSpinner3);
//        createSpinnerAdapter(mAddCifraFourTuningSpinner4);
//
//        createSpinnerAdapter(mAddCifraEightTuningSpinner1);
//        createSpinnerAdapter(mAddCifraEightTuningSpinner2);
//        createSpinnerAdapter(mAddCifraEightTuningSpinner3);
//        createSpinnerAdapter(mAddCifraEightTuningSpinner4);
//        createSpinnerAdapter(mAddCifraEightTuningSpinner5);
//        createSpinnerAdapter(mAddCifraEightTuningSpinner6);
//        createSpinnerAdapter(mAddCifraEightTuningSpinner7);
//        createSpinnerAdapter(mAddCifraEightTuningSpinner8);
//    }
//
//    private void createSpinnerAdapter(Spinner spinner) {
//        CharSequence chords[] = getResources().getStringArray(R.array.chordsOptions);
//        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chords));
//    }
//}

package marceloferracin.autocifra.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import marceloferracin.autocifra.R;

public class AddCifraWriteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cifra_write);
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

        Spinner addCifraNumberOfChrods = (Spinner) findViewById(R.id.addCifraNumberOfChrods);
        final EditText addCifraEditText = (EditText) findViewById(R.id.addCifraEditText);
        Button addCifraSendButton = (Button) findViewById(R.id.addCifraSendButton);

        CharSequence numberOfChords[] = getResources().getStringArray(R.array.numberOfChordsOptions);
        addCifraNumberOfChrods.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numberOfChords));
        addCifraSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCifraWriteActivity.this, AddCifraChordsActivity.class);
                intent.putExtra("cifraLyrics", addCifraEditText.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}