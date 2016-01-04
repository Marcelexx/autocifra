package marceloferracin.autocifra.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.utils.Resources;

public class AddCifraActivity extends AppCompatActivity {
    private EditText mAddCifraMusicEditText;
    private EditText mAddCifraArtistEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cifra);
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

        mAddCifraMusicEditText = (EditText) findViewById(R.id.addCifraMusicEditText);
        mAddCifraArtistEditText = (EditText) findViewById(R.id.addCifraArtistEditText);
        Button addCifraContinueButton = (Button) findViewById(R.id.addCifraContinueButton);
        Spinner addCifraTuningSpinner = (Spinner) findViewById(R.id.addCifraTuningSpinner);

        addCifraContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int validationId = validateFields();

                if (validationId == -1) {
                    Intent intent = new Intent(AddCifraActivity.this, AddCifraWriteActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(AddCifraActivity.this, Resources.getStringById(AddCifraActivity.this,
                            validationId), Toast.LENGTH_SHORT).show();
                }
            }
        });

        CharSequence tunings[] = getResources().getStringArray(R.array.tuningOptions);
        addCifraTuningSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tunings));
        addCifraTuningSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(android.R.color.darker_gray));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private int validateFields() {
        if (mAddCifraMusicEditText.getText().toString().length() == 0
                || mAddCifraArtistEditText.getText().length() == 0) {
            return R.string.add_cifra_empty_fields;
        }

        return -1;
    }
}