package DSA.array.perfixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    /**
     * https://leetcode.com/problems/subarray-sum-equals-k/
     * https://algomaster.io/practice/dsa/subarray-sum-equals-k?list=am-300
     * https://www.youtube.com/watch?v=XzwUBIkR9pA&pp=ygUdc3ViYXJyYXkgc3VtIGVxdWFscyBrIGluIGphdmE%3D
     */
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case — empty subarray
        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num; // prefix sum update karo

            // kya (sum - k) pehle mila tha?
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        }
        return count;
    }

    static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subarraySum(nums, 3));
    }
}
