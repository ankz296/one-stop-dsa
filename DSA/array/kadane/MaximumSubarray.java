package DSA.array.kadane;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarray {

    /**
     * https://leetcode.com/problems/maximum-subarray
     * https://algomaster.io/practice/dsa/maximum-subarray?list=am-300
     * https://www.youtube.com/watch?v=c-wuQj44st4
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0; // making 0 because - values always reduce the sum
            }
        }
        return max;
    }

    static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
