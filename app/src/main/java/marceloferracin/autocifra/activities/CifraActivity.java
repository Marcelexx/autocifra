package marceloferracin.autocifra.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.models.CifraItem;
import marceloferracin.autocifra.utils.CifraUtils;

public class CifraActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout parent = (LinearLayout) inflater.inflate(R.layout.activity_cifra, null);

        CifraItem cifra = (CifraItem) getIntent().getSerializableExtra("cifra");


        //TODO Remover
        cifra.setMusic(getString(R.string.test_cifra));



        createComponentsLayout(inflater, parent, cifra);

        setContentView(parent);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (cifra != null) {
            TextView toolbarTitle = (TextView) findViewById(R.id.main_toolbar_title);
            String cifraTitle = cifra.getMusic() + " - " + cifra.getArtist();
            toolbarTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 19);
            toolbarTitle.setText(cifraTitle);
        }

        initComponents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_default, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void initComponents() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void createComponentsLayout(LayoutInflater inflater, LinearLayout parent, CifraItem cifra) {
        LinearLayout cifraContentLinearLayout = (LinearLayout) parent.findViewById(R.id.cifraContentLinearLayout);

        CifraUtils cifraUtils = new CifraUtils();
        String[] splitCifra = cifra.getMusic().split("[\n]");

        for (String line : splitCifra) {
            View custom = inflater.inflate(R.layout.cifra_content, null);

            if (line.startsWith("--ch")) {
                int wordsCount = cifraUtils.countWords(line);

                if (wordsCount < 5 && cifraUtils.isCifra(line)) {
                    String normalizedLine = line.replaceAll("[\n]", "").replaceAll("\\s+", " ").toUpperCase().trim();

                    setLineText(custom, normalizedLine, wordsCount);
                }
            } else {
                setLineText(custom, line, 0);
            }

            cifraContentLinearLayout.addView(custom);
        }
    }

    private void setLineText(View layout, String text, int columnsQuantity) {
        //TODO Trocar nomes de components
        LinearLayout addCifraOneChordLayout = (LinearLayout) layout.findViewById(R.id.addCifraOneChordLayout);
        LinearLayout addCifraTwoChordLayout = (LinearLayout) layout.findViewById(R.id.addCifraTwoChordLayout);
        LinearLayout addCifraFourChordLayout = (LinearLayout) layout.findViewById(R.id.addCifraFourChordLayout);

        TextView addCifraFourChordSpinner1 = (TextView) layout.findViewById(R.id.addCifraFourChordSpinner1);
        TextView addCifraFourChordSpinner2 = (TextView) layout.findViewById(R.id.addCifraFourChordSpinner2);
        TextView addCifraFourChordSpinner3 = (TextView) layout.findViewById(R.id.addCifraFourChordSpinner3);
        TextView addCifraFourChordSpinner4 = (TextView) layout.findViewById(R.id.addCifraFourChordSpinner4);

        switch (columnsQuantity) {
            case 0:
                TextView addCifraOneChordSpinner = (TextView) layout.findViewById(R.id.addCifraOneChordSpinner);

                addCifraOneChordSpinner.setText(text);

                addCifraOneChordLayout.setVisibility(View.VISIBLE);
                addCifraTwoChordLayout.setVisibility(View.GONE);
                addCifraFourChordLayout.setVisibility(View.GONE);
                break;
            case 1:
                String[] splitLine1 = text.split("\\s");

                TextView addCifraTwoChordSpinner1 = (TextView) layout.findViewById(R.id.addCifraTwoChordSpinner1);
                TextView addCifraTwoChordSpinner2 = (TextView) layout.findViewById(R.id.addCifraTwoChordSpinner2);

                addCifraTwoChordSpinner1.setText(splitLine1[0]);
                addCifraTwoChordSpinner2.setText(splitLine1[1]);

                addCifraOneChordLayout.setVisibility(View.GONE);
                addCifraTwoChordLayout.setVisibility(View.VISIBLE);
                addCifraFourChordLayout.setVisibility(View.GONE);
                break;
            case 2:
                String[] splitLine2 = text.split("\\s");

                addCifraFourChordSpinner1.setText(splitLine2[0]);
                addCifraFourChordSpinner2.setText(splitLine2[1]);
                addCifraFourChordSpinner3.setText(splitLine2[2]);
                addCifraFourChordSpinner4.setText(splitLine2[3]);

                addCifraOneChordLayout.setVisibility(View.GONE);
                addCifraTwoChordLayout.setVisibility(View.GONE);
                addCifraFourChordLayout.setVisibility(View.VISIBLE);
                break;
            case 3:
                String[] splitLine3 = text.split("\\s");

                addCifraFourChordSpinner1.setText(splitLine3[0]);
                addCifraFourChordSpinner2.setText(splitLine3[1]);
                addCifraFourChordSpinner3.setText(splitLine3[2]);
                addCifraFourChordSpinner4.setText(splitLine3[3]);

                addCifraOneChordLayout.setVisibility(View.GONE);
                addCifraTwoChordLayout.setVisibility(View.GONE);
                addCifraFourChordLayout.setVisibility(View.VISIBLE);
                break;
        }
    }
}