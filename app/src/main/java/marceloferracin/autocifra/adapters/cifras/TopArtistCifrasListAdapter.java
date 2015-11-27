package marceloferracin.autocifra.adapters.cifras;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.models.ArtistItem;

/**
 *
 * Created by Marcelo Franco on 25/11/2015.
 */

public class TopArtistCifrasListAdapter extends ArrayAdapter<ArtistItem> {
    private List<ArtistItem> mArtistItemList;
    private Activity mActivity;

    public TopArtistCifrasListAdapter(Activity activity, int textViewResourceId, List<ArtistItem> artistItemList) {
        super(activity, textViewResourceId, artistItemList);

        mArtistItemList = new ArrayList<>();
        mActivity = activity;

        for (int i = 0; i < artistItemList.size(); ++i) {
            mArtistItemList.add(artistItemList.get(i));
        }
    }

    @Override
    public int getCount() {
        return mArtistItemList.size();
    }

    @Override
    public ArtistItem getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mActivity).inflate(R.layout.cifras_top_artist_item, null);
        }

        TextView artistNameTextView = (TextView) convertView.findViewById(R.id.artistNameTextView);

        artistNameTextView.setText(mArtistItemList.get(position).getArtistName());

        return convertView;
    }
}