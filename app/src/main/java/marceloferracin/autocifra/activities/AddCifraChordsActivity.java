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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.utils.Dictionaries;

public class AddCifraChordsActivity extends AppCompatActivity {
    private List<View> mContentLayoutList;
    private int mChordSelectionNumber = 0;

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
        Spinner addCifraNumberOfChordsSpinner = (Spinner) findViewById(R.id.addCifraNumberOfChordsSpinner);
        CharSequence numberOfChords[] = getResources().getStringArray(R.array.numberOfChordsOptions);
        addCifraNumberOfChordsSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numberOfChords));
        addCifraNumberOfChordsSpinner.setOnItemSelectedListener(setNumberOfChordsItemSelect());

        if (mChordSelectionNumber != 0) {
            addCifraNumberOfChordsSpinner.setSelection(mChordSelectionNumber);
        }
    }

    private void initLyricsComponents(View custom, boolean hasCifra, int cifraCount, Map<String, Integer> chordSelectionMap) {
        //TODO Alterar spinner para mudar acordes em todos os tempos
        final Spinner addCifraOneChordSpinner = (Spinner) custom.findViewById(R.id.addCifraOneChordSpinner);

        final Spinner addCifraTwoChordSpinner1 = (Spinner) custom.findViewById(R.id.addCifraTwoChordSpinner1);
        final Spinner addCifraTwoChordSpinner2 = (Spinner) custom.findViewById(R.id.addCifraTwoChordSpinner2);

        final Spinner addCifraFourChordSpinner1 = (Spinner) custom.findViewById(R.id.addCifraFourChordSpinner1);
        final Spinner addCifraFourChordSpinner2 = (Spinner) custom.findViewById(R.id.addCifraFourChordSpinner2);
        final Spinner addCifraFourChordSpinner3 = (Spinner) custom.findViewById(R.id.addCifraFourChordSpinner3);
        final Spinner addCifraFourChordSpinner4 = (Spinner) custom.findViewById(R.id.addCifraFourChordSpinner4);

        //One Chord
        addCifraOneChordSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                addCifraTwoChordSpinner1.setSelection(position);
                addCifraFourChordSpinner1.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Two Chords
        addCifraTwoChordSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                addCifraOneChordSpinner.setSelection(position);
                addCifraFourChordSpinner1.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        addCifraTwoChordSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                addCifraFourChordSpinner3.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Four Chords
        addCifraFourChordSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                addCifraOneChordSpinner.setSelection(position);
                addCifraTwoChordSpinner1.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        addCifraFourChordSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                addCifraTwoChordSpinner2.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        createSpinnerAdapter(addCifraOneChordSpinner);

        createSpinnerAdapter(addCifraTwoChordSpinner1);
        createSpinnerAdapter(addCifraTwoChordSpinner2);

        createSpinnerAdapter(addCifraFourChordSpinner1);
        createSpinnerAdapter(addCifraFourChordSpinner2);
        createSpinnerAdapter(addCifraFourChordSpinner3);
        createSpinnerAdapter(addCifraFourChordSpinner4);

        if (hasCifra) {
            switch (cifraCount) {
                case 1:
                    addCifraOneChordSpinner.setSelection(chordSelectionMap.get("a"));
                    addCifraTwoChordSpinner1.setSelection(chordSelectionMap.get("a"));
                    addCifraFourChordSpinner1.setSelection(chordSelectionMap.get("a"));

                    if (mChordSelectionNumber == 0) {
                        mChordSelectionNumber = 0;
                    }
                    break;
                case 2:
                    addCifraOneChordSpinner.setSelection(chordSelectionMap.get("b"));

                    addCifraTwoChordSpinner1.setSelection(chordSelectionMap.get("b"));
                    addCifraTwoChordSpinner2.setSelection(chordSelectionMap.get("c"));

                    addCifraFourChordSpinner1.setSelection(chordSelectionMap.get("b"));
                    addCifraFourChordSpinner3.setSelection(chordSelectionMap.get("c"));

                    if (mChordSelectionNumber == 0) {
                        mChordSelectionNumber = 1;
                    }
                    break;
                case 3:
                    addCifraOneChordSpinner.setSelection(chordSelectionMap.get("d"));

                    addCifraTwoChordSpinner1.setSelection(chordSelectionMap.get("d"));
                    addCifraTwoChordSpinner2.setSelection(chordSelectionMap.get("f"));

                    addCifraFourChordSpinner1.setSelection(chordSelectionMap.get("d"));
                    addCifraFourChordSpinner2.setSelection(chordSelectionMap.get("e"));
                    addCifraFourChordSpinner3.setSelection(chordSelectionMap.get("f"));
                    addCifraFourChordSpinner4.setSelection(chordSelectionMap.get("g"));

                    if (mChordSelectionNumber == 0) {
                        mChordSelectionNumber = 2;
                    }
                    break;
                case 4:
                    addCifraOneChordSpinner.setSelection(chordSelectionMap.get("g"));

                    addCifraTwoChordSpinner1.setSelection(chordSelectionMap.get("g"));
                    addCifraTwoChordSpinner2.setSelection(chordSelectionMap.get("i"));

                    addCifraFourChordSpinner1.setSelection(chordSelectionMap.get("g"));
                    addCifraFourChordSpinner2.setSelection(chordSelectionMap.get("h"));
                    addCifraFourChordSpinner3.setSelection(chordSelectionMap.get("i"));
                    addCifraFourChordSpinner4.setSelection(chordSelectionMap.get("j"));

                    if (mChordSelectionNumber == 0) {
                        mChordSelectionNumber = 2;
                    }
                    break;
            }
        }
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

    private AdapterView.OnItemSelectedListener setChordsInSpinners() {
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
        Map<String, Integer> chordSelectionMap = new HashMap<>();
        chordSelectionMap.put("a", -1);
        chordSelectionMap.put("b", -1);
        chordSelectionMap.put("c", -1);
        chordSelectionMap.put("d", -1);
        chordSelectionMap.put("e", -1);
        chordSelectionMap.put("f", -1);
        chordSelectionMap.put("g", -1);
        chordSelectionMap.put("h", -1);
        chordSelectionMap.put("i", -1);
        chordSelectionMap.put("j", -1);

        int cifraCount = 0;
        boolean hasCifra = false;

        mContentLayoutList = new ArrayList<>();
        LinearLayout addCifraComponentsLinearLayout = (LinearLayout) parent.findViewById(R.id.addCifraComponentsLinearLayout);

        String[] cifraLyrics = getIntent().getStringArrayExtra("cifraLyrics");

        for (String cifraLyricsInLine : cifraLyrics) {
            if (!cifraLyricsInLine.trim().equals("") && !cifraLyricsInLine.trim().equals("\n")) {
                int wordsCount = countWords(cifraLyricsInLine);
                View custom = inflater.inflate(R.layout.cifra_content, null);

                if (wordsCount < 5 && isCifra(cifraLyricsInLine)) {
                    String normalizedLine = cifraLyricsInLine.replaceAll("[\n]", "").replaceAll("\\s+", " ").toUpperCase().trim();
                    String[] splitLine = normalizedLine.split("\\s");

                    switch (wordsCount) {
                        case 1:
                            chordSelectionMap.put("a", (int) Dictionaries.chordsDictionary().get(splitLine[0].toUpperCase().trim()) + 1);
                            break;
                        case 2:
                            chordSelectionMap.put("b", (int) Dictionaries.chordsDictionary().get(splitLine[0].toUpperCase().trim()) + 1);
                            chordSelectionMap.put("c", (int) Dictionaries.chordsDictionary().get(splitLine[1].toUpperCase().trim()) + 1);
                            break;
                        case 3:
                            chordSelectionMap.put("d", (int) Dictionaries.chordsDictionary().get(splitLine[0].toUpperCase().trim()) + 1);
                            chordSelectionMap.put("e", (int) Dictionaries.chordsDictionary().get(splitLine[1].toUpperCase().trim()) + 1);
                            chordSelectionMap.put("f", (int) Dictionaries.chordsDictionary().get(splitLine[2].toUpperCase().trim()) + 1);
                            break;
                        case 4:
                            chordSelectionMap.put("g", (int) Dictionaries.chordsDictionary().get(splitLine[0].toUpperCase().trim()) + 1);
                            chordSelectionMap.put("h", (int) Dictionaries.chordsDictionary().get(splitLine[1].toUpperCase().trim()) + 1);
                            chordSelectionMap.put("i", (int) Dictionaries.chordsDictionary().get(splitLine[2].toUpperCase().trim()) + 1);
                            chordSelectionMap.put("j", (int) Dictionaries.chordsDictionary().get(splitLine[3].toUpperCase().trim()) + 1);
                            break;
                    }

                    cifraCount = wordsCount;
                    hasCifra = true;
                } else {
                    TextView addCifraLyricsTextView = (TextView) custom.findViewById(R.id.addCifraLyricsTextView);
                    addCifraLyricsTextView.setText(cifraLyricsInLine);

                    initLyricsComponents(custom, hasCifra, cifraCount, chordSelectionMap);
                    mContentLayoutList.add(custom);

                    addCifraComponentsLinearLayout.addView(custom);
                    hasCifra = false;
                }
            }
        }
    }

    private boolean isCifra(String line) {
        String normalizedLine = line.replaceAll("[\n]", "").replaceAll("\\s+", " ").toUpperCase().trim();
        String[] splitLine = normalizedLine.split("\\s");

        boolean isCifra = false;

        for (String cifra : splitLine) {
            if (Dictionaries.chordsDictionary().containsKey(cifra)) {
                isCifra = true;
            } else {
                isCifra = false;
                break;
            }
        }

        return isCifra;
    }

    private int countWords(String s) {
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