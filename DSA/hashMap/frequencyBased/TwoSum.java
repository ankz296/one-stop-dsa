package DSA.hashMap.frequencyBased;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * https://leetcode.com/problems/two-sum/description/
     */
    public static int[] twoSum(int[] nums, int target) {
        // value → index map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            // complement pehle mila tha?
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            // nahi mila → current daalo map mein
            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // never reached
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
