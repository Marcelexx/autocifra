package marceloferracin.autocifra.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.adapters.playlists.PlaylistItemListAdapter;
import marceloferracin.autocifra.models.CifraItem;
import marceloferracin.autocifra.models.PlaylistItem;

public class PlaylistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PlaylistItem playlist = (PlaylistItem) getIntent().getSerializableExtra("cifra");

        if (playlist != null) {
            TextView toolbarTitle = (TextView) findViewById(R.id.main_toolbar_title);
            String playlistTitle = playlist.getPlaylist();
            toolbarTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 19);
            toolbarTitle.setText(playlistTitle);
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
        ListView playlistCifrasListView = (ListView) findViewById(R.id.playlistCifrasListView);

        //TODO Ler do servidor
        List<CifraItem> cifraItemList = setPartialCifras();

        PlaylistItemListAdapter adapter = new PlaylistItemListAdapter(this, R.layout.cifras_top_item, cifraItemList);
        playlistCifrasListView.setAdapter(adapter);
        playlistCifrasListView.setOnItemClickListener(musicItemClick(adapter));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private AdapterView.OnItemClickListener musicItemClick(final PlaylistItemListAdapter adapter) {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PlaylistActivity.this, CifraActivity.class);
                intent.putExtra("cifra", adapter.getItem(position));
                startActivity(intent);
            }
        };
    }

    private List<CifraItem> setPartialCifras() {
        List<CifraItem> cifraItemList = new ArrayList<>();

        CifraItem cifraItem1 = new CifraItem();
        cifraItem1.setArtist("Jorge e Mateus");
        cifraItem1.setMusic("Nocaute");

        CifraItem cifraItem2 = new CifraItem();
        cifraItem2.setArtist("Led Zeppelin");
        cifraItem2.setMusic("Stairway To Heaven");

        CifraItem cifraItem3 = new CifraItem();
        cifraItem3.setArtist("Armandinho");
        cifraItem3.setMusic("Desenho de Deus");

        CifraItem cifraItem4 = new CifraItem();
        cifraItem4.setArtist("Ana Carolina");
        cifraItem4.setMusic("Pra Rua Me Levar");

        CifraItem cifraItem5 = new CifraItem();
        cifraItem5.setArtist("Thrice");
        cifraItem5.setMusic("Stare At The Sun");

        CifraItem cifraItem6 = new CifraItem();
        cifraItem6.setArtist("Metallica");
        cifraItem6.setMusic("Nothing Else Matters");

        CifraItem cifraItem7 = new CifraItem();
        cifraItem7.setArtist("Marcos e Belluti");
        cifraItem7.setMusic("Domingo de Manhã");

        CifraItem cifraItem8 = new CifraItem();
        cifraItem8.setArtist("The Eagles");
        cifraItem8.setMusic("Hotel California");

        CifraItem cifraItem9 = new CifraItem();
        cifraItem9.setArtist("Jota Quest");
        cifraItem9.setMusic("Só Hoje");

        CifraItem cifraItem10 = new CifraItem();
        cifraItem10.setArtist("Paula Fernandes");
        cifraItem10.setMusic("Pássaro de Fogo");

        cifraItemList.add(cifraItem1);
        cifraItemList.add(cifraItem2);
        cifraItemList.add(cifraItem3);
        cifraItemList.add(cifraItem4);
        cifraItemList.add(cifraItem5);
        cifraItemList.add(cifraItem6);
        cifraItemList.add(cifraItem7);
        cifraItemList.add(cifraItem8);
        cifraItemList.add(cifraItem9);
        cifraItemList.add(cifraItem10);

        return cifraItemList;
    }
}