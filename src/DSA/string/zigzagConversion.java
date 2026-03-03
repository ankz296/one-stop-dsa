package DSA.string;

public class zigzagConversion {

    public static String convert(String s, int numRows) {
        // Edge case: if the zigzag has only one row, the result is the string itself.
        if (s.length() == 1 || s.length() <= numRows) return s;

        // Create an array of StringBuilder for each row.
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // Current position and direction of traversal.
        int currentRows = 0;
        boolean goingDown = false;
        // Traverse the string and fill each row in the zigzag pattern.
        for (char c : s.toCharArray()) {
            // Append current character to the current row.
            rows[currentRows].append(c);
            // If we're at the first or the last row, change direction.
            if (currentRows == 0 || currentRows == numRows - 1) {
                goingDown = !goingDown;
            }
            // Move to the next row in the current direction.
            currentRows = currentRows + (goingDown ? 1 : -1);
        }
        // Combine all rows into one string.
        StringBuilder finalResult = new StringBuilder();
        for (StringBuilder row : rows) {
            finalResult.append(row);
        }
        return finalResult.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
