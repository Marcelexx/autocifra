package marceloferracin.autocifra.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.utils.Dictionaries;

public class AddCifraChordsActivity extends AppCompatActivity {
    private List<View> mContentLayoutList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout parent = (LinearLayout) inflater.inflate(R.layout.activity_add_cifra_chords, null);

        createCifraLayouts(inflater, parent);
        setContentView(parent);

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
        Spinner addCifraNumberOfChords = (Spinner) findViewById(R.id.addCifraNumberOfChrods);
        CharSequence numberOfChords[] = getResources().getStringArray(R.array.numberOfChordsOptions);
        addCifraNumberOfChords.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numberOfChords));
        addCifraNumberOfChords.setOnItemSelectedListener(setNumberOfChordsItemSelect());
    }

    private void initLyricsComponents(Spinner spinner) {
        createSpinnerAdapter(spinner);
    }

    private AdapterView.OnItemSelectedListener setNumberOfChordsItemSelect() {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (mContentLayoutList != null) {
                    for (View content : mContentLayoutList) {
                        LinearLayout addCifraOneChordLayout = (LinearLayout) content.findViewById(R.id.addCifraOneChordLayout);
                        LinearLayout addCifraTwoChordLayout = (LinearLayout) content.findViewById(R.id.addCifraTwoChordLayout);
                        LinearLayout addCifraFourChordLayout = (LinearLayout) content.findViewById(R.id.addCifraFourChordLayout);

                        switch (position) {
                            case 0:
                                addCifraOneChordLayout.setVisibility(View.VISIBLE);
                                addCifraTwoChordLayout.setVisibility(View.GONE);
                                addCifraFourChordLayout.setVisibility(View.GONE);
                                break;
                            case 1:
                                addCifraOneChordLayout.setVisibility(View.GONE);
                                addCifraTwoChordLayout.setVisibility(View.VISIBLE);
                                addCifraFourChordLayout.setVisibility(View.GONE);
                                break;
                            case 2:
                                addCifraOneChordLayout.setVisibility(View.GONE);
                                addCifraTwoChordLayout.setVisibility(View.GONE);
                                addCifraFourChordLayout.setVisibility(View.VISIBLE);
                                break;
                            case 3:
                                addCifraOneChordLayout.setVisibility(View.GONE);
                                addCifraTwoChordLayout.setVisibility(View.GONE);
                                addCifraFourChordLayout.setVisibility(View.GONE);
                                break;
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
    }

    private void createSpinnerAdapter(Spinner spinner) {
        CharSequence chords[] = getResources().getStringArray(R.array.chordsOptions);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chords));
    }

    private void createCifraLayouts(LayoutInflater inflater, LinearLayout parent) {
        int a = -1;
        int b = -1;
        int c = -1;
        int d = -1;
        int e = -1;
        int f = -1;
        int g = -1;
        int h = -1;
        int i = -1;
        int j = -1;

        mContentLayoutList = new ArrayList<>();
        LinearLayout addCifraComponentsLinearLayout = (LinearLayout) parent.findViewById(R.id.addCifraComponentsLinearLayout);

        String[] cifraLyrics = getIntent().getStringArrayExtra("cifraLyrics");

        for (String cifraLyricsInLine : cifraLyrics) {
            if (!cifraLyricsInLine.trim().equals("") && !cifraLyricsInLine.trim().equals("\n")) {
                int wordsCount = countWords(cifraLyricsInLine);
                View custom = inflater.inflate(R.layout.cifra_content, null);

                if (wordsCount < 5 && isCifra(cifraLyricsInLine)) {
                    String[] splittedLine = cifraLyricsInLine.split("\\s[a-zA-Z]");

                    switch (wordsCount) {
                        case 1:
                            a = (int) Dictionaries.chordsDictionary().get(cifraLyricsInLine.trim());
                            break;
                        case 2:
                            b = (int) Dictionaries.chordsDictionary().get(splittedLine[0]);
                            c = (int) Dictionaries.chordsDictionary().get(splittedLine[1]);
                            break;
                        case 3:
                            d = (int) Dictionaries.chordsDictionary().get(splittedLine[0]);
                            e = (int) Dictionaries.chordsDictionary().get(splittedLine[1]);
                            f = (int) Dictionaries.chordsDictionary().get(splittedLine[2]);
                            break;
                        case 4:
                            g = (int) Dictionaries.chordsDictionary().get(splittedLine[0]);
                            h = (int) Dictionaries.chordsDictionary().get(splittedLine[1]);
                            i = (int) Dictionaries.chordsDictionary().get(splittedLine[2]);
                            j = (int) Dictionaries.chordsDictionary().get(splittedLine[3]);
                            break;
                    }
                } else {
                    TextView addCifraLyricsTextView = (TextView) custom.findViewById(R.id.addCifraLyricsTextView);
                    addCifraLyricsTextView.setText(cifraLyricsInLine);

                    switch (wordsCount) {
                        case 1:
                            Spinner addCifraOneChordSpinner = (Spinner) custom.findViewById(R.id.addCifraOneChordSpinner);
                            createSpinnerAdapter(addCifraOneChordSpinner);
                            addCifraOneChordSpinner.setSelection(a);
                            break;
                        case 2:
                            Spinner addCifraTwoChordSpinner1 = (Spinner) custom.findViewById(R.id.addCifraTwoChordSpinner1);
                            Spinner addCifraTwoChordSpinner2 = (Spinner) custom.findViewById(R.id.addCifraTwoChordSpinner2);
                            createSpinnerAdapter(addCifraTwoChordSpinner1);
                            createSpinnerAdapter(addCifraTwoChordSpinner2);

                            addCifraTwoChordSpinner1.setSelection(b);
                            addCifraTwoChordSpinner2.setSelection(c);
                            break;
                        case 3:
                            Spinner addCifraFourChordSpinner1 = (Spinner) custom.findViewById(R.id.addCifraFourChordSpinner1);
                            Spinner addCifraFourChordSpinner2 = (Spinner) custom.findViewById(R.id.addCifraFourChordSpinner2);
                            Spinner addCifraFourChordSpinner3 = (Spinner) custom.findViewById(R.id.addCifraFourChordSpinner3);
                            Spinner addCifraFourChordSpinner4 = (Spinner) custom.findViewById(R.id.addCifraFourChordSpinner4);
                            createSpinnerAdapter(addCifraFourChordSpinner1);
                            createSpinnerAdapter(addCifraFourChordSpinner2);
                            createSpinnerAdapter(addCifraFourChordSpinner3);
                            createSpinnerAdapter(addCifraFourChordSpinner4);

                            addCifraFourChordSpinner1.setSelection(d);
                            addCifraFourChordSpinner2.setSelection(e);
                            addCifraFourChordSpinner3.setSelection(f);
                            addCifraFourChordSpinner4.setSelection(g);
                            break;
                        case 4:
                            Spinner addCifraFourSpinner1 = (Spinner) custom.findViewById(R.id.addCifraFourChordSpinner1);
                            Spinner addCifraFourSpinner2 = (Spinner) custom.findViewById(R.id.addCifraFourChordSpinner2);
                            Spinner addCifraFourSpinner3 = (Spinner) custom.findViewById(R.id.addCifraFourChordSpinner3);
                            Spinner addCifraFourSpinner4 = (Spinner) custom.findViewById(R.id.addCifraFourChordSpinner4);
                            createSpinnerAdapter(addCifraFourSpinner1);
                            createSpinnerAdapter(addCifraFourSpinner2);
                            createSpinnerAdapter(addCifraFourSpinner3);
                            createSpinnerAdapter(addCifraFourSpinner4);

                            addCifraFourSpinner1.setSelection(g);
                            addCifraFourSpinner2.setSelection(h);
                            addCifraFourSpinner3.setSelection(i);
                            addCifraFourSpinner4.setSelection(j);
                            break;
                    }

                    mContentLayoutList.add(custom);

                    addCifraComponentsLinearLayout.addView(custom);
                }
            }
        }
    }

    private boolean isCifra(String line) {
        String normalizedLine = line.toUpperCase();
        String[] splittedLine = normalizedLine.split("\\s[a-zA-Z]");

        for (String cifra : splittedLine) {
            if (Dictionaries.chordsDictionary().containsKey(cifra)) {
                return true;
            }
        }

        return false;
    }

    private int countWords(String s){
        int wordCount = 0;
        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
                word = true;
            } else if (!Character.isLetter(s.charAt(i)) && word) {
                wordCount++;
                word = false;
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }

        return wordCount;
    }
}