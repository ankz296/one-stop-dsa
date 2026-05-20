package DSA.array.binarySearch;

public class SearchInRotatedSortedArray {

    /**
     * https://leetcode.com/problems/search-in-rotated-sorted-array
     * https://algomaster.io/practice/dsa/search-in-rotated-sorted-array?list=am-300
     */
    public static int search(int[] nums, int target) {

        // in rotation array -> array could be after some rotation so we have to find rotation point so after that
        // it can be possible target can be in left side or in right side

        int left = 0, right = nums.length - 1;

        while (left <= right) {

            // mid find karna hai
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // left half mein jao
                } else {
                    left = mid + 1;  // right half mein jao
                }
            } else {
                // right half is sorted
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;  // right half mein jao
                } else {
                    right = mid - 1; // left half mein jao
                }
            }
        }
        return -1;
    }

    static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        System.out.println(search(nums, 0));
    }
}
