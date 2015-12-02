package marceloferracin.autocifra.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.activities.MainActivity;
import marceloferracin.autocifra.adapters.talent.TalentViewPagerAdapter;
import marceloferracin.autocifra.layout.SlidingTabLayout;

/**
 *
 * Created by Marcelo Ferracin on 02/12/2015.
 */

public class TalentFragment extends Fragment {
    private boolean mIsSearch;
    private Drawable mNavigationDrawerOriginalBackground;
    private Toolbar mToolbar;
    private MainActivity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_talent, container, false);
        setHasOptionsMenu(true);
        initComponents(v);
        mActivity = (MainActivity) getActivity();

        return v;
    }

    private void initComponents(View v) {
        TextView toolbarTitle = (TextView) getActivity().findViewById(R.id.main_toolbar_title);
        toolbarTitle.setText(getString(R.string.talent_title));

        CharSequence titles[] = getResources().getStringArray(R.array.talentOptions);
        int numOfTabs = 3;
        TalentViewPagerAdapter talentViewPagerAdapter = new TalentViewPagerAdapter(getFragmentManager(), titles, numOfTabs);

        ViewPager talentViewPager = (ViewPager) v.findViewById(R.id.talentViewPager);
        talentViewPager.setAdapter(talentViewPagerAdapter);

        SlidingTabLayout talentSlidingTabs = (SlidingTabLayout) v.findViewById(R.id.talentSlidingTabs);
        talentSlidingTabs.setDistributeEvenly(true);

        talentSlidingTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        talentSlidingTabs.setViewPager(talentViewPager);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_lists, menu);

        mToolbar = mActivity.getToolbar();
        final DrawerLayout drawer = mActivity.getDrawer();

        final SearchView searchView = (SearchView) menu.findItem(R.id.top_cifras_search).getActionView();
        mNavigationDrawerOriginalBackground = mToolbar.getNavigationIcon();
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIsSearch = true;
                drawer.closeDrawers();
                mToolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                searchViewCloseEvent();

                return false;
            }
        });

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!drawer.isDrawerOpen(GravityCompat.START)) {
                    if (!mIsSearch) {
                        drawer.openDrawer(GravityCompat.START);
                    } else {
                        searchView.onActionViewCollapsed();
                        searchViewCloseEvent();
                    }
                } else {
                    drawer.closeDrawers();
                }
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

    private void searchViewCloseEvent() {
        mIsSearch = false;
        mToolbar.setNavigationIcon(mNavigationDrawerOriginalBackground);
    }
}