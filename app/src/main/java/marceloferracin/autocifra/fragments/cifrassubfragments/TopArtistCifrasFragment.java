package marceloferracin.autocifra.fragments.cifrassubfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.adapters.cifras.TopArtistCifrasListAdapter;
import marceloferracin.autocifra.models.ArtistItem;

/**
 *
 * Created by Marcelo Ferracin on 25/11/2015.
 */

public class TopArtistCifrasFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_top_artist_cifras, container, false);

        initComponents(v);

        return v;
    }

    private void initComponents(View v) {
        ListView artistCypherListView = (ListView) v.findViewById(R.id.artistCypherListView);

        //TODO Ler do servidor
        List<ArtistItem> artistItemList = setPartialArtists();

        final TopArtistCifrasListAdapter adapter = new TopArtistCifrasListAdapter(getActivity(), R.layout.top_artist_cifras_item, artistItemList);
        artistCypherListView.setAdapter(adapter);
    }

    private List<ArtistItem> setPartialArtists() {
        List<ArtistItem> playlistItemList = new ArrayList<>();

        ArtistItem artistItem1 = new ArtistItem();
        artistItem1.setArtistName("Jorge e Mateus");

        ArtistItem artistItem2 = new ArtistItem();
        artistItem2.setArtistName("Marcus e Marcelo");

        playlistItemList.add(artistItem1);
        playlistItemList.add(artistItem2);

        return playlistItemList;
    }
}