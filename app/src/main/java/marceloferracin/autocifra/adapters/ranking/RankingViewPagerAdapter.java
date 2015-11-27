package marceloferracin.autocifra.adapters.ranking;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import marceloferracin.autocifra.fragments.rankingsubfragments.TopContributorRankingFragment;
import marceloferracin.autocifra.fragments.rankingsubfragments.TopMusicianRankingFragment;

/**
 *
 * Created by Marcelo Ferracin on 26/11/2015.
 */

public class RankingViewPagerAdapter extends FragmentStatePagerAdapter {
    private CharSequence mTitles[];
    private int mNumOfTabs;

    public RankingViewPagerAdapter(FragmentManager fragmentManager, CharSequence titles[], int numOfTabs) {
        super(fragmentManager);

        mTitles = titles;
        mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TopContributorRankingFragment();
            case 1:
                return new TopMusicianRankingFragment();
            default:
                return new TopContributorRankingFragment();
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