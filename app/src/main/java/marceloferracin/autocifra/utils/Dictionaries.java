package marceloferracin.autocifra.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by Marcelo Ferracin on 11/12/2015.
 */

public class Dictionaries {
    public static Map chordsDictionary() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("B", 1);
        map.put("C", 2);
        map.put("D", 3);
        map.put("E", 4);
        map.put("F", 5);
        map.put("G", 6);

        map.put("Am", 7);
        map.put("Bm", 8);
        map.put("Cm", 9);
        map.put("Dm", 10);
        map.put("Em", 11);
        map.put("Fm", 12);
        map.put("Gm", 13);

        map.put("A#", 14);
        map.put("B#", 15);
        map.put("C#", 16);
        map.put("D#", 17);
        map.put("E#", 18);
        map.put("F#", 19);
        map.put("G#", 20);

        return map;
    }
}
