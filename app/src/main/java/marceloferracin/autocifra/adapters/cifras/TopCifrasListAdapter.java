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
import marceloferracin.autocifra.models.CifraItem;

/**
 *
 * Created by Marcelo Ferracin on 22/11/2015.
 */

public class TopCifrasListAdapter extends ArrayAdapter<CifraItem> {
    private List<CifraItem> mCifraItemList;
    private Activity mActivity;

    public TopCifrasListAdapter(Activity activity, int textViewResourceId, List<CifraItem> cifraItemList) {
        super(activity, textViewResourceId, cifraItemList);

        mCifraItemList = new ArrayList<>();
        mActivity = activity;

        for (int i = 0; i < cifraItemList.size(); ++i) {
            mCifraItemList.add(cifraItemList.get(i));
        }
    }

    @Override
    public int getCount() {
        return mCifraItemList.size();
    }

    @Override
    public CifraItem getItem(int position) {
        return mCifraItemList.get(position);
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

        musicTextView.setText(mCifraItemList.get(position).getMusic());
        artistTextView.setText(mCifraItemList.get(position).getArtist());

        return convertView;
    }
}