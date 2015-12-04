package marceloferracin.autocifra.controls;

import android.content.Context;
import android.content.SharedPreferences;

import marceloferracin.autocifra.utils.Constants;

/**
 *
 * Created by Marcelo Ferracin on 03/12/2015.
 */

public class SharedPreferencesControl {
    private Context mContext;

    public SharedPreferencesControl(Context context) {
        mContext = context;
    }

    public void setIsLogged(boolean isLogged) {
        SharedPreferences prefs = mContext.getSharedPreferences(Constants.sharedPreferences, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(Constants.loginPreference, isLogged).apply();
    }

    public boolean getIsLogged() {
        SharedPreferences prefs = mContext.getSharedPreferences(Constants.sharedPreferences, Context.MODE_PRIVATE);
        return prefs.getBoolean(Constants.loginPreference, false);
    }
}