package DSA.array.perfixSum;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    /**
     * https://leetcode.com/problems/contiguous-array
     * https://algomaster.io/practice/dsa/contiguous-array?list=am-300
     * https://www.youtube.com/watch?v=LLl9fG1ZvMg
     */
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // // base case — index -1 pe sum 0 tha
        int sum = 0, maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // 0 ko -1 treat karo
                sum--;
            } else {
                sum++;
            }
            if (map.containsKey(sum)) {
                // same sum pehle mila tha — beech wala subarray balanced!
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                // pehli baar mila — index store karo
                // update mat karo! longest subarray chahiye
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 1, 1, 0, 0, 0};
        System.out.println(findMaxLength(nums));
    }
}
