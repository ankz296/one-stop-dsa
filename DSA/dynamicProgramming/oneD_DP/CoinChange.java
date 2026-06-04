package DSA.dynamicProgramming.oneD_DP;

import java.util.Arrays;

public class CoinChange {

    /**
     * https://leetcode.com/problems/coin-change/
     * Pattern: 1D DP (Unbounded Knapsack) | Approach: Har amount ke liye minimum coins calculate karo.
     * dp[i] = min(dp[i], dp[i - coin] + 1). Bottom up — amount 0 se target tak!
     */
    public static int coinChange(int[] coins, int amount) {

        // 1. Table banayi amount + 1 size ki
        int[] dp = new int[amount + 1];

        // 2. Shuru me sab me badhi value daali (Infinity ki tarah)
        Arrays.fill(dp, amount + 1);

        // 3. Base Case set kiya
        dp[0] = 0;

        // 4. Outer loop: 1 rupee se lekar 11 rupee tak ka hisab chalega
        for (int i = 1; i <= amount; i++) {

            // Inner loop: Har amount ke liye teeno sikke [1, 2, 5] test honge
            for (int coin : coins) {

                // Agar sikka amount se chota hai, tabhi use kar sakte hain
                if (i >= coin) {

                    // MATH.MIN dono choices me se best uthayega
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        // Agar target amount ka value change nahi hua, matlab combination impossible hai
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println("=== Coin Change ===\n");

        // Test 1
        System.out.println("Test 1 [1,5,6] amt=11: " +
                coinChange(new int[]{1, 5, 6}, 11)); // 2

        // Test 2
        System.out.println("Test 2 [1,2,5] amt=11: " +
                coinChange(new int[]{1, 2, 5}, 11)); // 3

        // Test 3: Impossible
        System.out.println("Test 3 [2] amt=3: " +
                coinChange(new int[]{2}, 3)); // -1

        // Test 4: Amount=0
        System.out.println("Test 4 [1] amt=0: " +
                coinChange(new int[]{1}, 0)); // 0
    }

}
