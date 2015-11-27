package marceloferracin.autocifra.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.fragments.CifrasFragment;
import marceloferracin.autocifra.fragments.PlaylistsFragment;
import marceloferracin.autocifra.fragments.RankingFragment;

public class MainActivity extends AppCompatActivity {
    private static DrawerLayout mDrawer;
    private static Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);

        initComponents();
    }

    public static Toolbar getToolbar() {
        return mToolbar;
    }

    public static DrawerLayout getDrawer() {
        return mDrawer;
    }

    private void initComponents() {
        mDrawer = (DrawerLayout) findViewById(R.id.cifra_options_drawer);
        String[] cifraOptions = getResources().getStringArray(R.array.autoCifraOptionsArray);
        ListView drawerList = (ListView) findViewById(R.id.cifra_options_drawer_list);

        drawerList.setAdapter(new ArrayAdapter<>(this,
                R.layout.cifra_options_item, cifraOptions));

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                changeFragment(position);
            }
        });

        changeFragment(0);

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mDrawer.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.syncState();
    }

    private void changeFragment(int position) {
        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (position) {
            default:
            case 0:
                fragment = new CifrasFragment();
                break;
            case 1:
                fragment = new PlaylistsFragment();
                break;
            case 2:
                fragment = new RankingFragment();
                break;
        }

        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        mDrawer.closeDrawers();
    }
}
