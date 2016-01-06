package marceloferracin.autocifra.adapters.profile;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import marceloferracin.autocifra.fragments.profilesubfragments.ProfileContribitionFragment;
import marceloferracin.autocifra.fragments.profilesubfragments.ProfileTalentFragment;

/**
 *
 * Created by Marcelo Ferracin on 06/01/2016.
 */

public class ProfileViewPagerAdapter extends FragmentStatePagerAdapter {
    private CharSequence mTitles[];
    private int mNumOfTabs;

    public ProfileViewPagerAdapter(FragmentManager fragmentManager, CharSequence titles[], int numOfTabs) {
        super(fragmentManager);

        mTitles = titles;
        mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ProfileContribitionFragment();
            case 1:
                return new ProfileTalentFragment();
            default:
                return new ProfileContribitionFragment();
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