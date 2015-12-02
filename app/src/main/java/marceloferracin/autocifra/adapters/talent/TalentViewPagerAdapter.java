package marceloferracin.autocifra.adapters.talent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import marceloferracin.autocifra.fragments.rankingsubfragments.TopMusicianRankingFragment;
import marceloferracin.autocifra.fragments.talentsubfragments.TopMusicianTalentFragment;

/**
 *
 * Created by Marcelo Ferracin on 02/12/2015.
 */

public class TalentViewPagerAdapter extends FragmentStatePagerAdapter {
    private CharSequence mTitles[];
    private int mNumOfTabs;

    public TalentViewPagerAdapter(FragmentManager fragmentManager, CharSequence titles[], int numOfTabs) {
        super(fragmentManager);

        mTitles = titles;
        mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TopMusicianTalentFragment();
            case 1:
                return new TopMusicianRankingFragment();
            case 2:
                return new TopMusicianRankingFragment();
            default:
                return new TopMusicianTalentFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}