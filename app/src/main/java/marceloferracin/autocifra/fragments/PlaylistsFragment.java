package marceloferracin.autocifra.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.adapters.playlists.PlaylistListAdapter;
import marceloferracin.autocifra.models.PlaylistItem;

/**
 * Created by Marcelo Ferracin on 24/11/2015.
 */

public class PlaylistsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_playlists, container, false);
        setHasOptionsMenu(true);
        initComponents(v);

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_music, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return id == R.id.top_cifras_settings || super.onOptionsItemSelected(item);
    }

    private void initComponents(View v) {
        TextView toolbarTitle = (TextView) getActivity().findViewById(R.id.main_toolbar_title);
        toolbarTitle.setText(getString(R.string.playlists_title));

        ListView topMusicCypherListView = (ListView) v.findViewById(R.id.playlistsListView);

        //TODO Ler do servidor
        List<PlaylistItem> playlistItemList = setPartialPlaylists();

        topMusicCypherListView.setFastScrollEnabled(true);

        final PlaylistListAdapter adapter = new PlaylistListAdapter(getActivity(), R.layout.top_playlist_cifras_item, playlistItemList);
        topMusicCypherListView.setAdapter(adapter);
    }

    private List<PlaylistItem> setPartialPlaylists() {
        List<PlaylistItem> playlistItemList = new ArrayList<>();

        PlaylistItem playlistItem1 = new PlaylistItem();
        playlistItem1.setPlaylist("Churrasco I");
        playlistItem1.setContributor("Marcelo");

        PlaylistItem playlistItem2 = new PlaylistItem();
        playlistItem2.setPlaylist("Luau II");
        playlistItem2.setContributor("Zé da Praia");

        PlaylistItem playlistItem3 = new PlaylistItem();
        playlistItem3.setPlaylist("Músicas de Reunião");
        playlistItem3.setContributor("Senhor Sério");

        PlaylistItem playlistItem4 = new PlaylistItem();
        playlistItem4.setPlaylist("Pegada Leve");
        playlistItem4.setContributor("Maria Gudá");

        PlaylistItem playlistItem5 = new PlaylistItem();
        playlistItem5.setPlaylist("Batidão");
        playlistItem5.setContributor("MC Viola");

        PlaylistItem playlistItem6 = new PlaylistItem();
        playlistItem6.setPlaylist("Clássicos");
        playlistItem6.setContributor("Old Guy");

        PlaylistItem playlistItem7 = new PlaylistItem();
        playlistItem7.setPlaylist("Melhor do Sertanejo");
        playlistItem7.setContributor("Só Arrocha");

        PlaylistItem playlistItem8 = new PlaylistItem();
        playlistItem8.setPlaylist("Lançamentos");
        playlistItem8.setContributor("Só Arrocha");

        PlaylistItem playlistItem9 = new PlaylistItem();
        playlistItem9.setPlaylist("Rock Clássico");
        playlistItem9.setContributor("Angus Young");

        PlaylistItem playlistItem10 = new PlaylistItem();
        playlistItem10.setPlaylist("MPB");
        playlistItem10.setContributor("Leãozinho");

        playlistItemList.add(playlistItem1);
        playlistItemList.add(playlistItem2);
        playlistItemList.add(playlistItem3);
        playlistItemList.add(playlistItem4);
        playlistItemList.add(playlistItem5);
        playlistItemList.add(playlistItem6);
        playlistItemList.add(playlistItem7);
        playlistItemList.add(playlistItem8);
        playlistItemList.add(playlistItem9);
        playlistItemList.add(playlistItem10);

        Collections.sort(playlistItemList, new Comparator<PlaylistItem>() {
            @Override
            public int compare(PlaylistItem s1, PlaylistItem s2) {
                return s1.getPlaylist().compareToIgnoreCase(s2.getPlaylist());
            }
        });

        return playlistItemList;
    }
}