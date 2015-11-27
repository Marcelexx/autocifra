package marceloferracin.autocifra.adapters.ranking;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.models.Profile;

/**
 *
 * Created by Marcelo Ferracin on 26/11/2015.
 */

public class TopContributorRankingListAdapter extends ArrayAdapter<Profile> {
    private List<Profile> mProfileItemList;
    private Activity mActivity;

    public TopContributorRankingListAdapter(Activity activity, int textViewResourceId, List<Profile> profileItemList) {
        super(activity, textViewResourceId, profileItemList);

        mProfileItemList = new ArrayList<>();
        mActivity = activity;

        for (int i = 0; i < profileItemList.size(); ++i) {
            mProfileItemList.add(profileItemList.get(i));
        }
    }

    @Override
    public int getCount() {
        return mProfileItemList.size();
    }

    @Override
    public Profile getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mActivity).inflate(R.layout.ranking_contributor_item, null);
        }

        TextView contributorNameTextView = (TextView) convertView.findViewById(R.id.contributorNameTextView);

        String contributorRow = (position + 1) + " - " + mProfileItemList.get(position).getName();
        contributorNameTextView.setText(contributorRow);

        return convertView;
    }
}