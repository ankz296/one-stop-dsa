package DSA.string.patternMatching;

public class RepeatedStringMatch {

    /**
     * https://leetcode.com/problems/repeated-string-match/
     */
    public static int repeatedStringMatch(String a, String b) {
        // problem statement ->
        //the minimum number of times you should repeat string a so that string b is a substring of it.
        // to start with min repeate we are dividing b/a
        int minRepeated = (int) Math.ceil((double) b.length() / (double) a.length());
        StringBuilder sb = new StringBuilder();

        // minRepeats se shuru karo
        for (int i = 0; i < minRepeated; i++) {
            sb.append(a);
        }
        // check karo
        if (sb.toString().contains(b)) return minRepeated;

        // ek aur try karo (ceil + 1)
        sb.append(a);
        if (sb.toString().contains(b)) return minRepeated + 1;
        // nahi mila
        return -1;
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "cabcabca";
        System.out.println(repeatedStringMatch(a, b));
    }
}
