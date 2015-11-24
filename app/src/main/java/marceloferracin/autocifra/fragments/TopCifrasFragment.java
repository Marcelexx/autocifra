package marceloferracin.autocifra.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.adapters.TopCifrasListAdapter;
import marceloferracin.autocifra.models.CifraItem;

/**
 *
 * Created by Marcelo Ferracin on 24/11/2015.
 */

public class TopCifrasFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_top_cifras, container, false);

        initComponents(v);

        return v;
    }

    private void initComponents(View v) {
        ListView topMusicCypherListView = (ListView) v.findViewById(R.id.topMusicCypherListView);

        //TODO Ler do servidor
        List<CifraItem> cifraItemList = setPartialCifras();

        final TopCifrasListAdapter adapter = new TopCifrasListAdapter(getActivity(), R.layout.top_cifras_item, cifraItemList);
        topMusicCypherListView.setAdapter(adapter);
    }

    private List<CifraItem> setPartialCifras() {
        List<CifraItem> cifraItemList = new ArrayList<>();

        CifraItem cifraItem1 = new CifraItem();
        cifraItem1.setArtist("Jorge e Mateus");
        cifraItem1.setMusic("Nocaute");

        CifraItem cifraItem2 = new CifraItem();
        cifraItem2.setArtist("Led Zeppelin");
        cifraItem2.setMusic("Stairway To Heaven");

        cifraItemList.add(cifraItem1);
        cifraItemList.add(cifraItem2);

        return cifraItemList;
    }
}
