package DSA.array.kadane;

public class MaximumProductSubarray {

    /**
     * https://leetcode.com/problems/maximum-product-subarray/
     * https://algomaster.io/practice/dsa/maximum-product-subarray?list=am-300
     * https://www.youtube.com/watch?v=Y6B-7ZctiW8
     */
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int max = nums[0];

        for (int i = 0; i < n; i++) {

            // if any of left or rightProduct become zero then make it to 1
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            // prefix product
            leftProduct *= nums[i];

            // suffix product
            rightProduct *= nums[n - 1 - i];

            max = Math.max(max, Math.max(leftProduct, rightProduct));
        }
        return max;

    }

    static void main(String[] args) {
        //int[] nums = {2, 3, -2, 4};
        int[] nums = {-2, 0, -1};

        System.out.println(maxProduct(nums));
    }
}
