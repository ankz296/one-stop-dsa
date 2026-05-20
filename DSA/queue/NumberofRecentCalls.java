import java.util.*;

public class NumberofRecentCalls {

    /**
     * https://leetcode.com/problems/number-of-recent-calls/
     * https://algomaster.io/practice/dsa/number-of-recent-calls?list=am-300
     * Here we choose claude AI's response.
     */
    static Queue<Integer> integerQueue;

    // Constructor fix kiya ✅
    public NumberofRecentCalls() {
        integerQueue = new ArrayDeque<>();
    }

    public static int ping(int t) {
        // new request add karo
        integerQueue.add(t);

        // purane requests hatao
        while (integerQueue.peek() < t - 3000) {
            integerQueue.poll();
        }

        return integerQueue.size();
    }

    public static void main(String[] args) {
        // Constructor call karo ✅
        new NumberofRecentCalls();

        // LeetCode test cases
        System.out.println(ping(1));    // 1
        System.out.println(ping(100));  // 2
        System.out.println(ping(3001)); // 3
        System.out.println(ping(3002)); // 3
    }
}