package DSA.dynamicProgramming.oneD_DP;

public class ClimbingStairs {

    /**
     * https://leetcode.com/problems/climbing-stairs/
     * Pattern: 1D Dynamic Programming | Approach: N steps tak pahunchne ke liye — ya 1 step lo ya 2 steps lo.
     * dp[i] = dp[i-1] + dp[i-2]. Yeh Fibonacci sequence hai!
     */
    public static int climbStairs(int n) {

        if (n <= 2) return n;
        int prev2 = 1; // n = 1 ke liye
        int prev1 = 2; // n = 2 ke liye
        int current = 0;
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println("=== Climbing Stairs ===\n");

        System.out.println("n=1: " + climbStairs(1)); // 1
        System.out.println("n=2: " + climbStairs(2)); // 2
        System.out.println("n=3: " + climbStairs(3)); // 3
        System.out.println("n=4: " + climbStairs(4)); // 5
        System.out.println("n=5: " + climbStairs(5)); // 8
        System.out.println("n=6: " + climbStairs(6)); // 13
    }
}
