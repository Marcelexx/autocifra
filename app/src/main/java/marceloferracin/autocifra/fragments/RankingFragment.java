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
import marceloferracin.autocifra.adapters.ranking.RankingViewPagerAdapter;
import marceloferracin.autocifra.layout.SlidingTabLayout;

/**
 *
 * Created by Marcelo Ferracin on 26/11/2015.
 */

public class RankingFragment extends Fragment {
    private boolean mIsSearch;
    private Drawable mNavigationDrawerOriginalBackground;
    private Toolbar mToolbar;
    private MainActivity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ranking, container, false);
        setHasOptionsMenu(true);
        initComponents(v);
        mActivity = (MainActivity) getActivity();

        return v;
    }

    private void initComponents(View v) {
        TextView toolbarTitle = (TextView) getActivity().findViewById(R.id.main_toolbar_title);
        toolbarTitle.setText(getString(R.string.ranking_title));

        CharSequence titles[] = getResources().getStringArray(R.array.rankingOptions);
        int numOfTabs = 2;
        RankingViewPagerAdapter rankingViewPagerAdapter = new RankingViewPagerAdapter(getFragmentManager(), titles, numOfTabs);

        ViewPager rankingViewPager = (ViewPager) v.findViewById(R.id.rankingViewPager);
        rankingViewPager.setAdapter(rankingViewPagerAdapter);

        SlidingTabLayout rankingSlidingTabs = (SlidingTabLayout) v.findViewById(R.id.rankingSlidingTabs);
        rankingSlidingTabs.setDistributeEvenly(true);

        rankingSlidingTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        rankingSlidingTabs.setViewPager(rankingViewPager);
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