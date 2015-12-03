package marceloferracin.autocifra.activities;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.controls.SharedPreferencesControl;
import marceloferracin.autocifra.fragments.AboutFragment;
import marceloferracin.autocifra.fragments.CifrasFragment;
import marceloferracin.autocifra.fragments.PlaylistsFragment;
import marceloferracin.autocifra.fragments.RankingFragment;
import marceloferracin.autocifra.fragments.TalentFragment;

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

    public Toolbar getToolbar() {
        return mToolbar;
    }

    public DrawerLayout getDrawer() {
        return mDrawer;
    }

    private void initComponents() {
        ImageView profilePhotoImageView = (ImageView) findViewById(R.id.profilePhotoImageView);
        TextView profileNameTextView = (TextView) findViewById(R.id.profileNameTextView);
        TextView profileLevelTextView = (TextView) findViewById(R.id.profileLevelTextView);
        mDrawer = (DrawerLayout) findViewById(R.id.cifraOptionsDrawer);
        String[] cifraOptions = getResources().getStringArray(R.array.autoCifraOptionsArray);
        ListView drawerList = (ListView) findViewById(R.id.cifraOptionsDrawerList);

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

        SharedPreferencesControl sharedPreferencesControl = new SharedPreferencesControl();

        if (sharedPreferencesControl.getIsLogged(this)) {
            profilePhotoImageView.setBackground(getResources().getDrawable(R.mipmap.ic_account_circle_white_48dp));
            //TODO Trocar por nome
            profileNameTextView.setText("Marcelo Ferracin");
            profileLevelTextView.setText("Nível 1");
            profileLevelTextView.setVisibility(View.VISIBLE);
        } else {
            profilePhotoImageView.setBackground(getResources().getDrawable(R.mipmap.ic_add_circle_white_48dp));
            profileNameTextView.setText(getString(R.string.profile_login_message));
            profileLevelTextView.setVisibility(View.GONE);
        }
    }

    private void changeFragment(int position) {
        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        Resources r = getResources();
        boolean hasElevation = false;

        switch (position) {
            case 0:
                fragment = new CifrasFragment();
                break;
            case 1:
                fragment = new PlaylistsFragment();
                hasElevation = true;
                break;
            case 2:
                fragment = new RankingFragment();
                break;
            case 3:
                fragment = new TalentFragment();
                break;
            case 4:
                fragment = new AboutFragment();
                break;
            default:
                fragment = new CifrasFragment();
                break;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (hasElevation) {
                mToolbar.setElevation(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, r.getDisplayMetrics()));
            } else {
                mToolbar.setElevation(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, r.getDisplayMetrics()));
            }
        }

        fragmentManager.beginTransaction().replace(R.id.contentFrame, fragment).commit();
        mDrawer.closeDrawers();
    }
}
