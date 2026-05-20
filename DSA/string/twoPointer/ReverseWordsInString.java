package DSA.string.twoPointer;

public class ReverseWordsInString {

    /**
     * https://leetcode.com/problems/reverse-words-in-a-string/
     * https://algomaster.io/practice/dsa/reverse-words-in-a-string?list=am-300
     */
    public static String reverseWords(String s) {

        // reverse the whole array
        // reverse the individual word
        // clean the spaces
        char[] arr = s.toCharArray();
        int n = arr.length;

        reverseTheFullArray(arr, 0, n - 1);

        reverseIndividualWords(arr, n);

        return cleanSpaces(arr, n);
    }

    private static String cleanSpaces(char[] arr, int n) {

        int left = 0, right = 0;
        while (right < n) {
            while (right < n && arr[right] == ' ') right++;
            while (right < n && arr[right] != ' ') arr[left++] = arr[right++];
            while (right < n && arr[right] == ' ') right++;
            if (right < n) arr[left++] = ' ';
        }
        return new String(arr, 0, left);
    }

    private static void reverseIndividualWords(char[] arr, int n) {
        int start = 0;
        for (int end = 0; end < n; end++) {
            if (end == n || arr[end] == ' ') {
                reverseTheFullArray(arr, start, end - 1);
                start = end + 1;
            }
        }
    }

    private static void reverseTheFullArray(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
    }
}
