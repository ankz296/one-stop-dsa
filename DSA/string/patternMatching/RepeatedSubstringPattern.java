package DSA.string.patternMatching;

public class RepeatedSubstringPattern {

    /**
     * https://leetcode.com/problems/repeated-substring-pattern/
     */
    public static boolean repeatedSubstringPattern(String s) {

        //Agar string s kisi substring ko repeat karke bani hai — toh s+s mein se
        // pehla aur aakhri character hatao, usme s milega! Yeh ek clever math trick hai.
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }

    public static void main(String[] args) {
        String a = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern(a));
    }
}
