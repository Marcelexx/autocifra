package marceloferracin.autocifra.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import marceloferracin.autocifra.BuildConfig;
import marceloferracin.autocifra.R;
import marceloferracin.autocifra.activities.MainActivity;

/**
 *
 * Created by Marcelo Ferracin on 03/12/2015.
 */

public class AboutFragment extends Fragment {
    private MainActivity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_about, container, false);
        setHasOptionsMenu(true);
        mActivity = (MainActivity) getActivity();
        initComponents(v);

        return v;
    }

    private void initComponents(View v) {
        TextView toolbarTitle = (TextView) mActivity.findViewById(R.id.main_toolbar_title);
        toolbarTitle.setText(getString(R.string.about_title));

        TextView aboutVersionTextView = (TextView) v.findViewById(R.id.aboutVersionTextView);
        String versionText = getString(R.string.version_name) + " " + BuildConfig.VERSION_NAME;
        aboutVersionTextView.setText(versionText);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_cifra, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }
}