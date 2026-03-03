package DSA.array.twoPointer;

import java.util.Arrays;

public class TwoSumOfSortedArray {

    /**
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
     * https://algomaster.io/practice/dsa/two-sum-ii-input-array-is-sorted?list=am-300
     */
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }

    static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));
    }
}
