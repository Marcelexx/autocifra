package marceloferracin.autocifra.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.adapters.profile.ProfileViewPagerAdapter;
import marceloferracin.autocifra.layout.SlidingTabLayout;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics()));
        }
        setSupportActionBar(toolbar);

        TextView toolbarTitle = (TextView) findViewById(R.id.main_toolbar_title);
        toolbarTitle.setText(getString(R.string.profile_title));

        initComponents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_default, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void initComponents() {
        CharSequence titles[] = getResources().getStringArray(R.array.profileOptions);
        int numOfTabs = 2;
        ProfileViewPagerAdapter profileViewPagerAdapter = new ProfileViewPagerAdapter(getSupportFragmentManager(), titles, numOfTabs);

        ViewPager profileViewPager = (ViewPager) findViewById(R.id.profileViewPager);
        profileViewPager.setAdapter(profileViewPagerAdapter);

        SlidingTabLayout profileSlidingTabs = (SlidingTabLayout) findViewById(R.id.profileSlidingTabs);
        profileSlidingTabs.setDistributeEvenly(true);

        profileSlidingTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        profileSlidingTabs.setViewPager(profileViewPager);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}