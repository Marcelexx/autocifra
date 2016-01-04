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

        map.put("AM", 7);
        map.put("BM", 8);
        map.put("CM", 9);
        map.put("DM", 10);
        map.put("EM", 11);
        map.put("FM", 12);
        map.put("GM", 13);

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
