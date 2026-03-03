package DSA.TwoPointers;

import java.util.Arrays;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int i = m - 1;      // nums1 last valid index
//        int j = n - 1;      // nums2 last index
//        int k = m + n - 1;  // nums1 last index (final place)
//
//        while (i >= 0 && j >= 0) {
//            if (nums1[i] > nums2[j]) {
//                nums1[k] = nums1[i];
//                i--;
//            } else {
//                nums1[k] = nums2[j];
//                j--;
//            }
//            k--;
//        }
//
//        // Agar nums2 ke elements bache hain
//        while (j >= 0) {
//            nums1[k] = nums2[j];
//            j--;
//            k--;
//        }
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0}, nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

    }
}
