package marceloferracin.autocifra.utils;

/**
 *
 * Created by Marcelo Ferracin on 06/01/2016.
 */

public class CifraUtils {
    public boolean isCifra(String line) {
        String normalizedLine = line.replaceAll("[\n]", "").replaceAll("\\s+", " ").toUpperCase().trim();
        String[] splitLine = normalizedLine.split("\\s");

        boolean isCifra = false;

        for (String cifra : splitLine) {
            if (Dictionaries.chordsDictionary().containsKey(cifra)) {
                isCifra = true;
            } else {
                isCifra = false;
                break;
            }
        }

        return isCifra;
    }

    public int countWords(String s) {
        int wordCount = 0;
        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
                word = true;
            } else if (!Character.isLetter(s.charAt(i)) && word) {
                wordCount++;
                word = false;
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }

        return wordCount;
    }
}
