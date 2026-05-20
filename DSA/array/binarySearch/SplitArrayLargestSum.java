package DSA.array.binarySearch;

public class SplitArrayLargestSum {

    /**
     * https://leetcode.com/problems/split-array-largest-sum/description/
     * https://www.youtube.com/watch?v=eq6dAJefOqc&t=3s
     */
    public static int splitArray(int[] nums, int k) {

        int left = 0, right = 0;
        int result = 0;
        // yaha hume lower and upper limit mil jayegi
        for (int i : nums) {
            left = Math.max(i, left); // max element
            right += i; // total sum
        }
        // ab ye limit ke inside hum logic dekhenge
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (isSplitPossible(nums, mid, k)) {
                result = mid;
                right = mid - 1; // agar 2 pieces me mil raha hai to or chhota karo
            } else {
                left = mid + 1; // limit increase karo
            }
        }
        return result;
    }

    private static boolean isSplitPossible(int[] nums, int mid, int k) {
        int pieces = 1;
        int sum = 0;

        for (int i : nums) {
            sum += i;

            if (sum > mid) {
                pieces++;
                sum = i;
            }
        }
        return pieces <= k;
    }

    static void main(String[] args) {
        //int[] nums = {2, 3, -2, 4};
        int[] nums = {7,2,5,10,8};

        System.out.println(splitArray(nums, 2));
    }
}
