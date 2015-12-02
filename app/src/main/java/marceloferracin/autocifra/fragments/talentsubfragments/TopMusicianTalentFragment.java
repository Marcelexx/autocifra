package marceloferracin.autocifra.fragments.talentsubfragments;

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
import marceloferracin.autocifra.adapters.talent.TopMusicianTalentListAdapter;
import marceloferracin.autocifra.models.Profile;
import marceloferracin.autocifra.models.TalentItem;

/**
 *
 * Created by Marcelo Ferracin on 02/12/2015.
 */

public class TopMusicianTalentFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_talent_top_musician, container, false);

        initComponents(v);

        return v;
    }

    private void initComponents(View v) {
        ListView musicianTalentListView = (ListView) v.findViewById(R.id.musicianTalentListView);

        //TODO Ler do servidor
        List<TalentItem> videoItemList = setPartialProfiles();

        final TopMusicianTalentListAdapter adapter = new TopMusicianTalentListAdapter(getActivity(), R.layout.talent_top_musician_item, videoItemList);
        musicianTalentListView.setAdapter(adapter);
    }

    private List<TalentItem> setPartialProfiles() {
        List<TalentItem> talentItemList = new ArrayList<>();

        TalentItem talentItem1 = new TalentItem();
        Profile profile1 = new Profile();
        profile1.setName("Marcelo Ferracin");
        talentItem1.setProfile(profile1);
        talentItem1.setMusic("Army of Noise");
        talentItem1.setArtist("Bullet For My Valentine");

        TalentItem talentItem2 = new TalentItem();
        Profile profile2 = new Profile();
        profile2.setName("Mariana Nogueira");
        talentItem2.setProfile(profile2);
        talentItem2.setMusic("É Isso Aí");
        talentItem2.setArtist("Ana Carolina");

        TalentItem talentItem3 = new TalentItem();
        Profile profile3 = new Profile();
        profile3.setName("Wellington Messias");
        talentItem3.setProfile(profile3);
        talentItem3.setMusic("Fear of the Dark");
        talentItem3.setArtist("Iron Maiden");

        TalentItem talentItem4 = new TalentItem();
        Profile profile4 = new Profile();
        profile4.setName("Zeca Pagodinho");
        talentItem4.setProfile(profile4);
        talentItem4.setMusic("Não Deixe o Samba Morrer");
        talentItem4.setArtist("Alcione");

        TalentItem talentItem5 = new TalentItem();
        Profile profile5 = new Profile();
        profile5.setName("Kiko Loureiro");
        talentItem5.setProfile(profile5);
        talentItem5.setMusic("Hangar 18");
        talentItem5.setArtist("Megadeth");

        talentItemList.add(talentItem1);
        talentItemList.add(talentItem2);
        talentItemList.add(talentItem3);
        talentItemList.add(talentItem4);
        talentItemList.add(talentItem5);

        return talentItemList;
    }
}