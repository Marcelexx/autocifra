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
import marceloferracin.autocifra.models.Cifra;

/**
 *
 * Created by Marcelo Ferracin on 22/11/2015.
 */

public class TopMusicAdapter extends ArrayAdapter<Cifra> {
    private List<Cifra> mCifraList;
    private Activity mActivity;

    public TopMusicAdapter(Activity activity, int textViewResourceId, List<Cifra> cifraList) {
        super(activity, textViewResourceId, cifraList);

        mCifraList = new ArrayList<>();
        mActivity = activity;

        for (int i = 0; i < cifraList.size(); ++i) {
            mCifraList.add(cifraList.get(i));
        }
    }

    @Override
    public int getCount() {
        return mCifraList.size();
    }

    @Override
    public Cifra getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mActivity).inflate(
                    R.layout.music_item_layout, null);


        }

        TextView musicTextView = (TextView) convertView.findViewById(R.id.musicTextView);
        TextView artistTextView = (TextView) convertView.findViewById(R.id.artistTextView);

        musicTextView.setText(mCifraList.get(position).getMusic());
        artistTextView.setText(mCifraList.get(position).getArtist());

        return convertView;
    }
}