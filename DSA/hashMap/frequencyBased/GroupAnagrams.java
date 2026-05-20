package DSA.hashMap.frequencyBased;

import java.util.*;

public class GroupAnagrams {

    /**
     * https://leetcode.com/problems/group-anagrams/
     * https://algomaster.io/practice/dsa/group-anagrams?list=am-300
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // chars ko sort karna hai
            // word ko sort karo → key banao
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // key ke group mein add karo
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
