package marceloferracin.autocifra.fragments.rankingsubfragments;

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
import marceloferracin.autocifra.adapters.ranking.TopContributorRankingListAdapter;
import marceloferracin.autocifra.models.Profile;

/**
 *
 * Created by Marcelo Ferracin on 26/11/2015.
 */

public class TopContributorRankingFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ranking_contributor, container, false);

        initComponents(v);

        return v;
    }

    private void initComponents(View v) {
        ListView contributorRankingListView = (ListView) v.findViewById(R.id.contributorRankingListView);

        //TODO Ler do servidor
        List<Profile> profileItemList = setPartialProfiles();

        final TopContributorRankingListAdapter adapter = new TopContributorRankingListAdapter(getActivity(), R.layout.ranking_contributor_item, profileItemList);
        contributorRankingListView.setAdapter(adapter);
    }

    private List<Profile> setPartialProfiles() {
        List<Profile> profileItemList = new ArrayList<>();

        Profile profileItem1 = new Profile();
        profileItem1.setName("Marcelo Ferracin");

        Profile profileItem2 = new Profile();
        profileItem2.setName("Mariana Nogueira");

        Profile profileItem3 = new Profile();
        profileItem3.setName("Wellington Messias");

        Profile profileItem4 = new Profile();
        profileItem4.setName("Zeca Pagodinho");

        Profile profileItem5 = new Profile();
        profileItem5.setName("Kiko Loureiro");

        Profile profileItem6 = new Profile();
        profileItem6.setName("Martinho da Vila");

        Profile profileItem7 = new Profile();
        profileItem7.setName("Angelica");

        Profile profileItem8 = new Profile();
        profileItem8.setName("Fabio de Melo");

        Profile profileItem9 = new Profile();
        profileItem9.setName("Joao da Costa");

        Profile profileItem10 = new Profile();
        profileItem10.setName("Paula Fernandes");

        profileItemList.add(profileItem1);
        profileItemList.add(profileItem2);
        profileItemList.add(profileItem3);
        profileItemList.add(profileItem4);
        profileItemList.add(profileItem5);
        profileItemList.add(profileItem6);
        profileItemList.add(profileItem7);
        profileItemList.add(profileItem8);
        profileItemList.add(profileItem9);
        profileItemList.add(profileItem10);

        return profileItemList;
    }
}