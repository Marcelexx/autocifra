package marceloferracin.autocifra.adapters.talent;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.models.TalentItem;

/**
 *
 * Created by Marcelo Ferracin on 02/12/2015.
 */

public class TopMusicianTalentListAdapter extends ArrayAdapter<TalentItem> {
    private List<TalentItem> mTalentItemList;
    private Activity mActivity;

    public TopMusicianTalentListAdapter(Activity activity, int textViewResourceId, List<TalentItem> talentItemList) {
        super(activity, textViewResourceId, talentItemList);

        mTalentItemList = new ArrayList<>(talentItemList);
        mActivity = activity;
    }

    @Override
    public int getCount() {
        return mTalentItemList.size();
    }

    @Override
    public TalentItem getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mActivity).inflate(R.layout.talent_top_musician_item, null);
        }

        TextView musicianNameTextView = (TextView) convertView.findViewById(R.id.musicianNameTextView);
        TextView musicNameTextView = (TextView) convertView.findViewById(R.id.musicNameTextView);
        TextView artistNameTextView = (TextView) convertView.findViewById(R.id.artistNameTextView);

        String musicianRow = (position + 1) + " - " + mTalentItemList.get(position).getProfile().getName();
        String musicRow = mTalentItemList.get(position).getMusic();
        String artistRow = mTalentItemList.get(position).getArtist();

        musicianNameTextView.setText(musicianRow);
        musicNameTextView.setText(musicRow);
        artistNameTextView.setText(artistRow);

        return convertView;
    }
}