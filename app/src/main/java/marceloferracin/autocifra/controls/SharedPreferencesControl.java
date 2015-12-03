package marceloferracin.autocifra.controls;

import android.content.Context;
import android.content.SharedPreferences;

import marceloferracin.autocifra.utils.Constants;

/**
 *
 * Created by Marcelo Ferracin on 03/12/2015.
 */

public class SharedPreferencesControl {
    public void setIsLogged(Context context, boolean isLogged) {
        SharedPreferences prefs = context.getSharedPreferences(Constants.sharedPreferences, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(Constants.loginPreference, isLogged).apply();
    }

    public boolean getIsLogged(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(Constants.sharedPreferences, Context.MODE_PRIVATE);
        return prefs.getBoolean(Constants.loginPreference, false);
    }
}
