package marceloferracin.autocifra.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.models.CifraItem;

public class CifraActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cifra);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CifraItem cifra = (CifraItem) getIntent().getSerializableExtra("cifra");

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
        TextView cifraContentTextView = (TextView) findViewById(R.id.cifraContentTextView);
        cifraContentTextView.setText(getString(R.string.test_cifra));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}