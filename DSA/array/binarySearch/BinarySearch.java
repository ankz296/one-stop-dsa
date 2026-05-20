package DSA.array.binarySearch;

public class BinarySearch {

    /**
     * https://leetcode.com/problems/binary-search/
     */
    public static int binarySarch(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            // Left pe khade ho,
            // dono ke beech ka AADHA RAASTA chalo
            // mathematically both are same -> int mid = (left + right) / 2 -> overflow bug possible
            /**
             * int left  = 1_500_000_000;  // 1.5 Billion
             * int right = 2_000_000_000;  // 2.0 Billion
             *
             * // WRONG ❌
             * int mid = (left + right) / 2;
             * // left + right = 3_500_000_000
             * // Integer MAX   = 2_147_483_647  ← 2.1 Billion
             * // 3.5B > 2.1B → OVERFLOW! → negative number aata hai 💥
             *
             * left  = 1_500_000_000
             * right = 2_000_000_000
             *
             * // WRONG ❌
             * (left + right) / 2
             * = 3_500_000_000 / 2  ← already overflow!
             *
             * // CORRECT ✅
             * left + (right - left) / 2
             * = 1_500_000_000 + (2_000_000_000 - 1_500_000_000) / 2
             * = 1_500_000_000 + 500_000_000 / 2
             * = 1_500_000_000 + 250_000_000
             * = 1_750_000_000 ✅  ← safe!
             */
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    static void main(String[] args) {
        //int[] nums = {2, 3, -2, 4};
        int[] nums = {-1, 0, 3, 5, 9, 12};

        System.out.println(binarySarch(nums, 9));
    }
}
