package DSA.hashMap;

import java.util.HashMap;
import java.util.Map;

public class randomNote {

    public static void main(String[] args) {
        String randomNote = "aa", magazineNote = "aab";
        System.out.println(canConstruct(randomNote, magazineNote));
    }

    private static boolean canConstruct(String ransomNote, String magazine) {

        // Create a map to store character frequencies from the magazine.

        Map<Character, Integer> magazinefreq = new HashMap<>();

        // Fill the frequency map with characters from the magazine.
        for (char ch : magazine.toCharArray()) {
            magazinefreq.put(ch, magazinefreq.getOrDefault(ch, 0) + 1);
        }
        // Check against the frequency map with each character from ransomNote.
        for (char ch : ransomNote.toCharArray()) {
            // Check if the character is missing or not enough in the magazine.
            if (!magazinefreq.containsKey(ch) || magazinefreq.get(ch) == 0) {
                return false;
            }
            // Decrease the frequency count for the current character.
            magazinefreq.put(ch, magazinefreq.get(ch) - 1);
        }
        return true;
    }
}
