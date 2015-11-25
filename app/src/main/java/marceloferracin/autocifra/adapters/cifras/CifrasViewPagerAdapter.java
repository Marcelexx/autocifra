package marceloferracin.autocifra.adapters.cifras;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import marceloferracin.autocifra.fragments.cifrassubfragments.PlaylistCifrasFragment;
import marceloferracin.autocifra.fragments.cifrassubfragments.TopCifrasFragment;

/**
 *
 * Created by Marcelo on 24/11/2015.
 */

public class CifrasViewPagerAdapter extends FragmentStatePagerAdapter {
    private CharSequence mTitles[];
    private int mNumOfTabs;

    public CifrasViewPagerAdapter(FragmentManager fragmentManager, CharSequence titles[], int numOfTabs) {
        super(fragmentManager);

        mTitles = titles;
        mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TopCifrasFragment();
        } else {
            return new PlaylistCifrasFragment();
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