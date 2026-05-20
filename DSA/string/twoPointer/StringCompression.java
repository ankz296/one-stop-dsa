package DSA.string.twoPointer;

public class StringCompression {

    /**
     * https://leetcode.com/problems/string-compression/
     */
    public static int compress(char[] chars) {
        // two pointer one for read and one for write
        int read = 0; // padhne wala
        int write = 0; // likhne wala
        int n = chars.length;
        while (read < n) {

            char curr = chars[read];
            int count = 0;

            // current char ka group count karo
            while (read < n && chars[read] == curr) {
                read++;
                count++;
            }

            // char likho
            chars[write++] = curr;

            // count likho (sirf 1 se zyada ho toh)
            if (count > 1) {
                // count ko string mein convert karo
                String stringCount = String.valueOf(count);
                for (char c : stringCount.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        return write;
    }

    static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'c', 'c', 'c', 'c', 'c', 'a', 'a', 'a'};
        System.out.println(compress(chars));
    }
}
