package DSA.dynamicProgramming.oneD_DP;

public class HouseRobber {

    /**
     * https://leetcode.com/problems/house-robber/description/
     * Pattern: 1D Dynamic Programming | Approach: Har ghar ke liye do choices — rob karo ya skip karo.
     * dp[i] = max(dp[i-1], dp[i-2] + nums[i]). Adjacent ghar rob nahi kar sakte!
     */
    public static int rob(int[] nums) {

        if (nums.length == 1) return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        int curr = 0;
        for (int i = 2; i < nums.length; i++) {
            curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        System.out.println("=== House Robber ===\n");

        // Test 1
        System.out.println("Test 1 [1,2,3,1]: " +
                rob(new int[]{1, 2, 3, 1})); // 4

        // Test 2
        System.out.println("Test 2 [2,7,9,3,1]: " +
                rob(new int[]{2, 7, 9, 3, 1})); // 12

        // Test 3: Single
        System.out.println("Test 3 [5]: " +
                rob(new int[]{5})); // 5

        // Test 4: Two houses
        System.out.println("Test 4 [2,1]: " +
                rob(new int[]{2, 1})); // 2
    }
}
