package marceloferracin.autocifra.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.activities.MainActivity;
import marceloferracin.autocifra.adapters.playlists.PlaylistListAdapter;
import marceloferracin.autocifra.models.PlaylistItem;

/**
 *
 * Created by Marcelo Ferracin on 24/11/2015.
 */

public class PlaylistsFragment extends Fragment {
    private boolean mIsSearch;
    private Drawable mNavigationDrawerOriginalBackground;
    private Toolbar mToolbar;
    private MainActivity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_playlists, container, false);
        setHasOptionsMenu(true);
        initComponents(v);
        mActivity = (MainActivity) getActivity();

        return v;
    }

    private void initComponents(View v) {
        TextView toolbarTitle = (TextView) getActivity().findViewById(R.id.main_toolbar_title);
        toolbarTitle.setText(getString(R.string.playlists_title));

        ListView topMusicCypherListView = (ListView) v.findViewById(R.id.playlistsListView);

        //TODO Ler do servidor
        List<PlaylistItem> playlistItemList = setPartialPlaylists();

        topMusicCypherListView.setFastScrollEnabled(true);

        final PlaylistListAdapter adapter = new PlaylistListAdapter(getActivity(), R.layout.cifras_top_playlist_item, playlistItemList);
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_lists, menu);

        mToolbar = mActivity.getToolbar();
        final DrawerLayout drawer = mActivity.getDrawer();

        final SearchView searchView = (SearchView) menu.findItem(R.id.top_cifras_search).getActionView();
        mNavigationDrawerOriginalBackground = mToolbar.getNavigationIcon();

        searchView.setOnSearchClickListener(setSearchClick(drawer));
        searchView.setOnCloseListener(setSearchClose());
        mToolbar.setNavigationOnClickListener(setToolbarNavigationClick(drawer, searchView));
        drawer.setDrawerListener(setDrawerListener(searchView));

        super.onCreateOptionsMenu(menu, inflater);
    }

    private void searchViewCloseEvent() {
        mIsSearch = false;
        mToolbar.setNavigationIcon(mNavigationDrawerOriginalBackground);
    }

    private View.OnClickListener setSearchClick(final DrawerLayout drawer) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIsSearch = true;
                drawer.closeDrawers();
                mToolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
            }
        };
    }

    private SearchView.OnCloseListener setSearchClose() {
        return new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                searchViewCloseEvent();

                return false;
            }
        };
    }

    private View.OnClickListener setToolbarNavigationClick(final DrawerLayout drawer, final SearchView searchView) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!drawer.isDrawerOpen(GravityCompat.START)) {
                    if (!mIsSearch) {
                        drawer.openDrawer(GravityCompat.START);
                    } else {
                        searchView.onActionViewCollapsed();
                        searchViewCloseEvent();
                    }
                } else {
                    drawer.closeDrawers();
                }
            }
        };
    }

    private DrawerLayout.DrawerListener setDrawerListener(final SearchView searchView) {
        return new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                if (mIsSearch) {
                    searchView.onActionViewCollapsed();
                    searchViewCloseEvent();
                    mIsSearch = false;
                }
            }

            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        };
    }
}