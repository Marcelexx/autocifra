package marceloferracin.autocifra.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.models.PlaylistItem;

/**
 *
 * Created by Marcelo Ferracin on 24/11/2015.
 */

public class PlaylistCifrasListAdapter extends ArrayAdapter<PlaylistItem> {
    private List<PlaylistItem> mPlaylistItemList;
    private Activity mActivity;

    public PlaylistCifrasListAdapter(Activity activity, int textViewResourceId, List<PlaylistItem> playlistItemList) {
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
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mActivity).inflate(R.layout.playlist_cifas_item, null);
        }

        TextView playlistNameTextView = (TextView) convertView.findViewById(R.id.playlistNameTextView);
        TextView contributorNameTextView = (TextView) convertView.findViewById(R.id.contributorNameTextView);

        playlistNameTextView.setText(mPlaylistItemList.get(position).getPlaylist());
        contributorNameTextView.setText(mPlaylistItemList.get(position).getContributor());

        return convertView;
    }
}
