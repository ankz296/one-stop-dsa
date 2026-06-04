package DSA.graphs.topologicalSort;

import java.util.*;

public class CourseScheduleII {

    /**
     * https://leetcode.com/problems/course-schedule-ii
     * Pattern: Topological Sort | Approach: 207 jaisa — but sirf cycle detect nahi, actual order bhi return karo!
     * DFS mein node done hone pe result mein add karo (reverse order). Ya Kahn's mein queue se process karte jao.
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[idx++] = course;

            for (int next : graph.get(course)) {
                inDegree[next]--;
                if (inDegree[next] == 0) queue.offer(next);
            }
        }

        return idx == numCourses ? order : new int[]{};

    }

    public static void main(String[] args) {
        System.out.println("=== Course Schedule II ===\n");

        // Test 1: Simple
        System.out.println("Test 1: " + Arrays.toString(findOrder(2, new int[][]{{1, 0}}))); // [0,1]

        // Test 2: Multiple valid orders
        System.out.println("Test 2: " + Arrays.toString(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}))); // [0,1,2,3] or [0,2,1,3]

        // Test 3: Cycle — empty array
        System.out.println("Test 3: " + Arrays.toString(findOrder(2, new int[][]{{0, 1}, {1, 0}}))); // []

        // Test 4: No prerequisites
        System.out.println("Test 4: " + Arrays.toString(findOrder(3, new int[][]{}))); // [0,1,2]
    }
}
