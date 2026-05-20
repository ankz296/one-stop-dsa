package DSA.hashMap.frequencyBased;

import java.util.*;

public class TopKFrequentElements {

    /**
     * https://leetcode.com/problems/top-k-frequent-elements/description/
     * https://www.youtube.com/watch?v=EBNPu0GgM64
     */
    public static int[] topKFrequent(int[] nums, int k) {

        /**
         *
         * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
         *
         *
         * Approach 1: Sort by frequency
         * TC: O(n log n) ❌ not optimal
         *
         * Approach 2: Min Heap (size k)
         * TC: O(n log k) ✅ good
         *
         * Approach 3: Bucket Sort
         * TC: O(n) ✅✅ most optimal
         */
        // freq map to store int to freq
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // Bucket to store frequncy for num
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int i : nums) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }

        for (Integer key : frequencyMap.keySet()) {
            Integer frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> topK = new ArrayList<>();
        for (int pos = bucket.length - 1; pos >= 0 && topK.size() < k; pos--) {
            if (bucket[pos] != null) {
                topK.addAll(bucket[pos]);
            }
        }
        return topK.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }
}
