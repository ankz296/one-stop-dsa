package DSA.hashMap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    private static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        Map<Character, String> cTw = new HashMap<>();
        Map<String, Character> wtc = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (cTw.containsKey(ch)) {
                if (!cTw.get(ch).equals(word)) return false;
            } else {
                cTw.put(ch, word);
            }

            if (wtc.containsKey(word)) {
                if (!wtc.get(word).equals(ch)) return false;
            } else {
                wtc.put(word, ch);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }
}
