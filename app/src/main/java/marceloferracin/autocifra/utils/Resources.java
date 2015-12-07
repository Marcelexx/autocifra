package marceloferracin.autocifra.utils;

import android.content.Context;

import marceloferracin.autocifra.R;

/**
 *
 * Created by Marcelo Ferracin on 07/12/2015.
 */

public class Resources {
    public static String getStringById(Context context, int id) {
        try {
            return context.getString(id);
        } catch (Exception ex) {
            return context.getString(R.string.string_not_found);
        }
    }
}
