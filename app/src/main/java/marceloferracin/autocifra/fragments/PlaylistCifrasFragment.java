package marceloferracin.autocifra.fragments;

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
import marceloferracin.autocifra.adapters.PlaylistCifrasListAdapter;
import marceloferracin.autocifra.models.PlaylistItem;

/**
 *
 * Created by Marcelo Ferracin on 24/11/2015.
 */

public class PlaylistCifrasFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_playlist_cifras, container, false);

        initComponents(v);

        return v;
    }

    private void initComponents(View v) {
        ListView playlistCypherListView = (ListView) v.findViewById(R.id.playlistCypherListView);

        //TODO Ler do servidor
        List<PlaylistItem> playlistItemList = setPartialPlaylists();

        //TODO Trocar layout do item
        final PlaylistCifrasListAdapter adapter = new PlaylistCifrasListAdapter(getActivity(), R.layout.playlist_cifas_item, playlistItemList);
        playlistCypherListView.setAdapter(adapter);
    }

    private List<PlaylistItem> setPartialPlaylists() {
        List<PlaylistItem> playlistItemList = new ArrayList<>();

        PlaylistItem playlistItem1 = new PlaylistItem();
        playlistItem1.setPlaylist("Churrasco I");
        playlistItem1.setContributor("Zé da pinga");

        PlaylistItem playlistItem2 = new PlaylistItem();
        playlistItem2.setPlaylist("Quebra Tudo");
        playlistItem2.setContributor("Metal Life");

        playlistItemList.add(playlistItem1);
        playlistItemList.add(playlistItem2);

        return playlistItemList;
    }
}
