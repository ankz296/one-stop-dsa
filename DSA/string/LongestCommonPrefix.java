package DSA.string;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) { // we taking loop for first string
            char c = strs[0].charAt(i);// checking first strings every char to each strings
            for (int j = 1; j < strs.length; j++) {
                // if i equal to length of next string's or string's i char not equal to c
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] s = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(s));
    }
}
