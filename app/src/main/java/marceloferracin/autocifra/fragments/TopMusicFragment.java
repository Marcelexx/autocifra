package marceloferracin.autocifra.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.adapters.TopMusicAdapter;
import marceloferracin.autocifra.models.Cifra;


public class TopMusicFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_music, container, false);
        setHasOptionsMenu(true);
        initComponents(v);

        return v;
    }

    private void initComponents(View v) {
        ListView topMusicCypherListView = (ListView) v.findViewById(R.id.topMusicCypherListView);
        TextView toolbarTitle = (TextView) getActivity().findViewById(R.id.main_toolbar_title);
        //TODO Trocar por string
        toolbarTitle.setText("Top 2");

        //TODO Ler do servidor
        List<Cifra> cifraList = setPartialCifras();

        final TopMusicAdapter adapter = new TopMusicAdapter(getActivity(), R.layout.music_item_layout, cifraList);
        topMusicCypherListView.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_music, menu);
        super.onCreateOptionsMenu(menu, inflater);
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
