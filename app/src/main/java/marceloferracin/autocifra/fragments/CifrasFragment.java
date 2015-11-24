package marceloferracin.autocifra.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.adapters.CifrasViewPagerAdapter;
import marceloferracin.autocifra.layout.SlidingTabLayout;


public class CifrasFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cifras, container, false);
        setHasOptionsMenu(true);
        initComponents(v);

        return v;
    }

    private void initComponents(View v) {
        TextView toolbarTitle = (TextView) getActivity().findViewById(R.id.main_toolbar_title);
        toolbarTitle.setText(getString(R.string.cifras_title));

        CharSequence titles[] = {"Top 20", "Playlists"};
        int numOfTabs = 2;
        CifrasViewPagerAdapter cifrasViewPagerAdapter = new CifrasViewPagerAdapter(getFragmentManager(), titles, numOfTabs);

        ViewPager cifrasViewPager = (ViewPager) v.findViewById(R.id.cifrasViewPager);
        cifrasViewPager.setAdapter(cifrasViewPagerAdapter);

        SlidingTabLayout cifrasSlidingTabs = (SlidingTabLayout) v.findViewById(R.id.cifrasSlidingTabs);
        cifrasSlidingTabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        cifrasSlidingTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        cifrasSlidingTabs.setViewPager(cifrasViewPager);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_music, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return id == R.id.top_music_settings || super.onOptionsItemSelected(item);
    }
}