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
import marceloferracin.autocifra.utils.Validations;

/**
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
        PlaylistItem playlistItem = mPlaylistItemList.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mActivity).inflate(R.layout.playlist_item, null);
        }

        View letterTitleDividerLine = convertView.findViewById(R.id.letterTitleDividerLine);
        TextView letterTitleTextView = (TextView) convertView.findViewById(R.id.letterTitleTextView);
        TextView playlistTextView = (TextView) convertView.findViewById(R.id.playlistNameTextView);
        TextView contributorTextView = (TextView) convertView.findViewById(R.id.contributorNameTextView);
        View playlistListViewDivider = convertView.findViewById(R.id.playlistListViewDivider);

        playlistTextView.setText(playlistItem.getPlaylist());
        contributorTextView.setText(playlistItem.getContributor());

        String firstCharCurrentItem = Character.toString(playlistItem.getPlaylist().toUpperCase().charAt(0));

        if (position > 0) {
            String firstCharPreviousItem = Character.toString(mPlaylistItemList.get(position - 1).getPlaylist().toUpperCase().charAt(0));

            if (!firstCharCurrentItem.equals(firstCharPreviousItem)) {
                letterTitleTextView.setText(firstCharCurrentItem);
                letterTitleTextView.setVisibility(View.VISIBLE);
                letterTitleDividerLine.setVisibility(View.VISIBLE);
            } else {
                letterTitleTextView.setVisibility(View.GONE);
                letterTitleDividerLine.setVisibility(View.GONE);
            }
        } else {
            letterTitleTextView.setText(firstCharCurrentItem);
            letterTitleTextView.setVisibility(View.VISIBLE);
            letterTitleDividerLine.setVisibility(View.VISIBLE);
        }

        if (position < mPlaylistItemList.size() - 1) {
            String firstCharNextItem = Character.toString(mPlaylistItemList.get(position + 1).getPlaylist().toUpperCase().charAt(0));

            if (firstCharCurrentItem.equals(firstCharNextItem)) {
                playlistListViewDivider.setVisibility(View.VISIBLE);
            } else {
                playlistListViewDivider.setVisibility(View.GONE);
            }
        } else {
            playlistListViewDivider.setVisibility(View.GONE);
        }

        return convertView;
    }

    @Override
    public int getPositionForSection(int section) {
        for (int i = section; i >= 0; i--) {
            for (int j = 0; j < getCount(); j++) {
                if (i == 0) {
                    for (int k = 0; k <= 9; k++) {
                        if (Validations.match(String.valueOf(getItem(j).getPlaylist().charAt(0)), String.valueOf(k))) {
                            return j;
                        }
                    }
                } else {
                    if (Validations.match(String.valueOf(getItem(j).getPlaylist().charAt(0)), String.valueOf(mSections.charAt(i)))) {
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