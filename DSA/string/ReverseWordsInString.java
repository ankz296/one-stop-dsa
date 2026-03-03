package DSA.string;

public class ReverseWordsInString {

    public static String reverseWords(String s) {
        // Step 1: trim spaces
        s = s.trim();

        StringBuilder builder = new StringBuilder();
        // Step 2: split by spaces (regex "\\s+" handles multiple spaces)
        String[] list = s.split("\s++");
        for (int i = list.length - 1; i >= 0; i--) {
            builder.append(list[i]);
            if (i != 0) builder.append(" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
