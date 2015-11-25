package marceloferracin.autocifra.adapters.playlists;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.models.PlaylistItem;
import marceloferracin.autocifra.utils.StringMatcher;

/**
 *
 * Created by Marcelo Ferracin on 24/11/2015.
 */

public class PlaylistListAdapter extends ArrayAdapter<PlaylistItem> implements SectionIndexer {
    private List<PlaylistItem> mPlaylistItemList;
    private Activity mActivity;
    private String mSections = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public PlaylistListAdapter(Activity activity, int textViewResourceId, List<PlaylistItem> playlistItemList) {
        super(activity, textViewResourceId, playlistItemList);

        mPlaylistItemList = new ArrayList<>();
        mActivity = activity;

        for (int i = 0; i < playlistItemList.size(); ++i) {
            mPlaylistItemList.add(playlistItemList.get(i));
        }
    }

    @Override
    public int getCount() {
        return mPlaylistItemList.size();
    }

    @Override
    public PlaylistItem getItem(int position) {
        return mPlaylistItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mActivity).inflate(R.layout.top_cifras_item, null);
        }

        TextView musicTextView = (TextView) convertView.findViewById(R.id.musicTextView);
        TextView artistTextView = (TextView) convertView.findViewById(R.id.artistTextView);

        musicTextView.setText(mPlaylistItemList.get(position).getPlaylist());
        artistTextView.setText(mPlaylistItemList.get(position).getContributor());

        return convertView;
    }

    //TODO Trocar desta aba para a de Artistas
    @Override
    public int getPositionForSection(int section) {
        for (int i = section; i >= 0; i--) {
            for (int j = 0; j < getCount(); j++) {
                if (i == 0) {
                    for (int k = 0; k <= 9; k++) {
                        if (StringMatcher.match(String.valueOf(getItem(j).getPlaylist().charAt(0)), String.valueOf(k))) {
                            return j;
                        }
                    }
                } else {
                    if (StringMatcher.match(String.valueOf(getItem(j).getPlaylist().charAt(0)), String.valueOf(mSections.charAt(i)))) {
                        return j;
                    }
                }
            }
        }

        return 0;
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }

    @Override
    public Object[] getSections() {
        String[] sections = new String[mSections.length()];
        for (int i = 0; i < mSections.length(); i++)
            sections[i] = String.valueOf(mSections.charAt(i));
        return sections;
    }
}