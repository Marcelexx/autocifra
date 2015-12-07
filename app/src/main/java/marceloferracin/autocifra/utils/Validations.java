package marceloferracin.autocifra.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
    private final static char KOREAN_UNICODE_START = '가';
    private final static char KOREAN_UNICODE_END = '힣';
    private final static char KOREAN_UNIT = '까' - '가';
    private final static char[] KOREAN_INITIAL = {'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ',
            'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'};

    public static boolean match(String value, String keyword) {
        if (value == null || keyword == null) {
            return false;
        }

        if (keyword.length() > value.length()) {
            return false;
        }

        int i = 0, j = 0;

        do {
            if (isKorean(value.charAt(i)) && isInitialSound(keyword.charAt(j))) {
                if (keyword.charAt(j) == getInitialSound(value.charAt(i))) {
                    i++;
                    j++;
                } else if (j > 0) {
                    break;
                } else {
                    i++;
                }
            } else {
                if (keyword.charAt(j) == value.charAt(i)) {
                    i++;
                    j++;
                } else if (j > 0) {
                    break;
                } else {
                    i++;
                }
            }
        } while (i < value.length() && j < keyword.length());

        return (j == keyword.length());
    }

    private static boolean isKorean(char c) {
        return c >= KOREAN_UNICODE_START && c <= KOREAN_UNICODE_END;
    }

    private static boolean isInitialSound(char c) {
        for (char i : KOREAN_INITIAL) {
            if (c == i) {
                return true;
            }
        }

        return false;
    }

    private static char getInitialSound(char c) {
        if (!isKorean(c)) {
            return c;
        }

        return KOREAN_INITIAL[(c - KOREAN_UNICODE_START) / KOREAN_UNIT];
    }

    public static boolean emailValidation(String email) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);

        return matcher.find();
    }

    public static boolean passwordConfirmation(String password, String confirmPassword) {
        Pattern pattern = Pattern.compile(password, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(confirmPassword);

        return matcher.matches();
    }
}