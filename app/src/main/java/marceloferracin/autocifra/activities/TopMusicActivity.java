package marceloferracin.autocifra.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.adapters.TopMusicAdapter;
import marceloferracin.autocifra.models.Cifra;


public class TopMusicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_music);

        Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ((TextView) findViewById(R.id.main_toolbar_title)).setText("Top 20");
        //TODO Trocar por Strings
        toolbar.setTitle("");

        setSupportActionBar(toolbar);

        initComponents();
    }

    private void initComponents() {
        ListView topMusicCypherListView = (ListView) findViewById(R.id.topMusicCypherListView);

        List<Cifra> cifraList = setPartialCifras();

        final TopMusicAdapter adapter = new TopMusicAdapter(this, R.layout.music_item_layout, cifraList);
        topMusicCypherListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top_music, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return id == R.id.top_music_settings || super.onOptionsItemSelected(item);
    }

    private List<Cifra> setPartialCifras() {
        List<Cifra> cifraList = new ArrayList<>();

        Cifra cifra1 = new Cifra();
        cifra1.setArtist("Jorge e Mateus");
        cifra1.setMusic("Nocaute");

        Cifra cifra2 = new Cifra();
        cifra2.setArtist("Led Zeppelin");
        cifra2.setMusic("Stairway To Heaven");

        cifraList.add(cifra1);
        cifraList.add(cifra2);

        return cifraList;
    }
}
