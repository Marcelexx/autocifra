package marceloferracin.autocifra.fragments.cifrassubfragments;

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
import marceloferracin.autocifra.adapters.cifras.TopCifrasListAdapter;
import marceloferracin.autocifra.models.CifraItem;

/**
 *
 * Created by Marcelo Ferracin on 24/11/2015.
 */

public class TopCifrasFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cifras_top, container, false);

        initComponents(v);

        return v;
    }

    private void initComponents(View v) {
        ListView topMusicCypherListView = (ListView) v.findViewById(R.id.topMusicCypherListView);

        //TODO Ler do servidor
        List<CifraItem> cifraItemList = setPartialCifras();

        final TopCifrasListAdapter adapter = new TopCifrasListAdapter(getActivity(), R.layout.cifras_top_item, cifraItemList);
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

        CifraItem cifraItem3 = new CifraItem();
        cifraItem3.setArtist("Armandinho");
        cifraItem3.setMusic("Desenho de Deus");

        CifraItem cifraItem4 = new CifraItem();
        cifraItem4.setArtist("Ana Carolina");
        cifraItem4.setMusic("Pra Rua Me Levar");

        CifraItem cifraItem5 = new CifraItem();
        cifraItem5.setArtist("Thrice");
        cifraItem5.setMusic("Stare At The Sun");

        CifraItem cifraItem6 = new CifraItem();
        cifraItem6.setArtist("Metallica");
        cifraItem6.setMusic("Nothing Else Matters");

        CifraItem cifraItem7 = new CifraItem();
        cifraItem7.setArtist("Marcos e Belluti");
        cifraItem7.setMusic("Domingo de Manhã");

        CifraItem cifraItem8 = new CifraItem();
        cifraItem8.setArtist("The Eagles");
        cifraItem8.setMusic("Hotel California");

        CifraItem cifraItem9 = new CifraItem();
        cifraItem9.setArtist("Jota Quest");
        cifraItem9.setMusic("Só Hoje");

        CifraItem cifraItem10 = new CifraItem();
        cifraItem10.setArtist("Paula Fernandes");
        cifraItem10.setMusic("Pássaro de Fogo");

        cifraItemList.add(cifraItem1);
        cifraItemList.add(cifraItem2);
        cifraItemList.add(cifraItem3);
        cifraItemList.add(cifraItem4);
        cifraItemList.add(cifraItem5);
        cifraItemList.add(cifraItem6);
        cifraItemList.add(cifraItem7);
        cifraItemList.add(cifraItem8);
        cifraItemList.add(cifraItem9);
        cifraItemList.add(cifraItem10);

        return cifraItemList;
    }
}