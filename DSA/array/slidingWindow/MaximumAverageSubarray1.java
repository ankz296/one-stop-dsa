package DSA.array.slidingWindow;

public class MaximumAverageSubarray1 {

    /**
     * https://leetcode.com/problems/maximum-average-subarray-i/
     * https://algomaster.io/practice/dsa/maximum-average-subarray-i?list=am-300
     */
    public static double findMaxAverage(int[] nums, int k) {
        // first we find the sum of fixed windows
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxSum = sum;

        // lets start sliding the window
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];// add next element
            sum -= nums[i - k]; // remove first element

            maxSum = Math.max(maxSum, sum);
        }
        return maxSum / k;
    }

    static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(nums, 4));
    }
}
