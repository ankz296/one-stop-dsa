package DSA.array.perfixSum;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /**
     * https://www.youtube.com/watch?v=HumVp2ckSk0
     * https://leetcode.com/problems/product-of-array-except-self
     * https://algomaster.io/practice/dsa/product-of-array-except-self?list=am-300
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0, temp = 1; i < n; i++) {
            result[i] = temp;
            temp *= nums[i];
        }

        for (int i = n - 1, temp = 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }

    static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
