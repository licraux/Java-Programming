import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PepTalk {

    private static List<String> syllables = new ArrayList<>();
    private static final char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

    public static String processInput(String input) {
        // 1. case Input starts with vowel
        // regex: [aeiou](?<=[aeiou])[bcdfghjklmnpqrstvwxys]{1,4}
        if ("aeiouAEIOU".indexOf(input.charAt(0)) != -1) {
            addSyllables(input);
            List<String> syllablesTransformed = transformSyllablesVowel();
            return createPepTalk(syllablesTransformed);
        }
        else {
            int indexOfFirstVowel = countToFirstConsonant(input);
            syllables.add(input.substring(0, indexOfFirstVowel));
            input = input.substring(indexOfFirstVowel, input.length());
            addSyllables(input);
            List<String> syllablesTransformed = transformSyllablesCons();
            return createPepTalk(syllablesTransformed);
        }
    }

    public static int countToFirstConsonant(String input) {
        int index = 100;
        for (char consonant: vowels) {
            if (input.indexOf(consonant) != -1) {
                if (input.indexOf(consonant) < index) {
                    index = input.indexOf(consonant);
                }
            }
        }
        return index;
    }

    public static void addSyllables(String input) {
        Matcher matches = Pattern.compile("[aeiouAEIOU](?<=[aeiouAEIOU])[bcdfghjklmnpqrstvwxysz]{1,4}|[aeiouAEIOU]")
                .matcher(input);
        while (matches.find()) {
            syllables.add(matches.group());
        }
    }

    public static List<String> transformSyllablesVowel() {

        List<String> result = new ArrayList<>();
        String storeConsonantsCur = "";
        String storeConsonantsBef = "";

        if (syllables.size() > 1) {
            for (int i = 0; i < syllables.size(); i++) {
                String syll = syllables.get(i);
                int lenthOfSyll = syll.length();
                storeConsonantsBef = storeConsonantsCur;
                switch (lenthOfSyll) {
                    case 1 -> storeConsonantsCur = "";
                    case 2, 3 -> storeConsonantsCur = syll.substring(syll.length()-1);
                    case 4, 5 -> storeConsonantsCur = syll.substring(syll.length() - 2);
                }
                if (i == 0) {
                    result.add(syll.substring(0, syll.length() - storeConsonantsCur.length()));
                }
                else if  (i == syllables.size() - 1) {
                    result.add(storeConsonantsBef + syll);
                }
                else {
                    result.add(storeConsonantsBef + syll.substring(0, syll.length() - storeConsonantsCur.length()));
                }
            }
        }
        else {
            result.add(syllables.get(0));
        }
        return result;
    }

    public static List<String> transformSyllablesCons() {
        if (syllables.size() > 2 ) {
            String storeFirstCons = syllables.get(0);
            syllables.remove(0);
            List<String> transSyllables = transformSyllablesVowel();
            transSyllables.set(0, storeFirstCons + transSyllables.get(0));
            return transSyllables;
        }
        else {
            String syllable = syllables.get(0) + syllables.get(1);
            ArrayList<String> transSyllables = new ArrayList<String>();
            transSyllables.add(syllable);
            return transSyllables;
        }
    }

    public static String createPepTalk(List<String> syllablesTransformed) {
        StringBuilder result = new StringBuilder();
        for (String syllable: syllablesTransformed) {
            int lengthSyllable = syllable.length();
            if (lengthSyllable > 1) {
                if (("aeiouAEIOU".indexOf(syllable.charAt(1)) != -1) && (lengthSyllable == 2)) {
                    result.append(syllable).append("p").append(syllable.substring(1).toLowerCase());
                }
                else {
                    int indexOfConstant = countToFirstConsonant(syllable);
                    switch (lengthSyllable) {
                        case 2, 3, 5, 4 -> result.append(syllable).append("p").append(syllable.substring(indexOfConstant).toLowerCase());
                    }
                }
            }
            else {
                result.append(syllable).append("p").append(syllable.toLowerCase());
            }
        }
        return result.toString();
    }

    public static void clearList() {
        syllables.clear();
    }
}
