package DSA.array.kadane;

public class MaximumSumCircularSubarray {

    /**
     * https://leetcode.com/problems/maximum-sum-circular-subarray/
     * https://algomaster.io/practice/dsa/maximum-sum-circular-subarray?list=am-300
     * https://www.youtube.com/watch?v=uOMqWzkTRNw
     */
    public static int maxSubarraySumCircular(int[] nums) {
        int currMax = nums[0], maxSum = nums[0], currMin = nums[0], minSum = nums[0], totalSum = 0;
        for (int i = 1; i < nums.length; i++) {

            // kadene's for maximum subarray
            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSum = Math.max(currMax, maxSum);

            // kadene's for minimum subarray
            currMin = Math.min(currMin + nums[i], nums[i]);
            minSum = Math.min(currMin, minSum);

            totalSum += nums[i];
        }
        totalSum += nums[0]; // nums[0] add karo (loop i=1 se shuru tha)
        // All negative edge case
        if (maxSum < 0) return maxSum;
        // max of both cases
        return Math.max(maxSum, totalSum - minSum);

    }

    static void main(String[] args) {
        //int[] nums = {2, 3, -2, 4};
        int[] nums = {1, -2, 3, -2};

        System.out.println(maxSubarraySumCircular(nums));
    }
}
