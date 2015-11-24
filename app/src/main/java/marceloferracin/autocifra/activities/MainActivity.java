package marceloferracin.autocifra.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.fragments.TopMusicFragment;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        initComponents();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initComponents() {
        mDrawer = (DrawerLayout) findViewById(R.id.cifra_options_drawer);
        String[] cifraOptions = getResources().getStringArray(R.array.cifraOptionsArray);
        ListView drawerList = (ListView) findViewById(R.id.cifra_options_drawer_list);

        drawerList.setAdapter(new ArrayAdapter<>(this,
                R.layout.cifra_options_item, cifraOptions));

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Fragment fragment;
                FragmentManager fragmentManager = getFragmentManager();
                switch (position) {
                    default:
                    case 0:
                        fragment = new TopMusicFragment();
                        break;
                    case 1:
                        fragment = new TopMusicFragment();
                        break;
                }

                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                mDrawer.closeDrawers();
            }
        });

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mDrawer.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.syncState();
    }
}
