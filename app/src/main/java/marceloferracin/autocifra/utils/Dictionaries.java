package marceloferracin.autocifra.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marcelo Ferracin on 11/12/2015.
 */

public class Dictionaries {
    public static Map chordsDictionary() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "A");
        map.put(1, "B");
        map.put(2, "C");
        map.put(3, "D");
        map.put(4, "E");
        map.put(5, "F");
        map.put(6, "G");

        map.put(7, "Am");
        map.put(8, "Bm");
        map.put(9, "Cm");
        map.put(10, "Dm");
        map.put(11, "Em");
        map.put(12, "Fm");
        map.put(13, "Gm");

        map.put(14, "A#");
        map.put(15, "B#");
        map.put(16, "C#");
        map.put(17, "D#");
        map.put(18, "E#");
        map.put(19, "F#");
        map.put(20, "G#");

        return map;
    }
}
