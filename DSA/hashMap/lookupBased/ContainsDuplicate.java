package DSA.hashMap.lookupBased;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * https://leetcode.com/problems/contains-duplicate
     * https://github.com/nikoo28/java-solutions/blob/master/src/main/java/leetcode/easy/ContainsDuplicate.java
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> intSet = new HashSet<>();

        for (int num : nums) {
            if (intSet.contains(num)) {
                return true;
            }
            intSet.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}
