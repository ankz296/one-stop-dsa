package DSA.graphs.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    // BFS Solution

    /**
     * https://leetcode.com/problems/course-schedule/
     * https://github.com/nikoo28/java-solutions/blob/master/src/main/java/leetcode/medium/CourseSchedule.java
     * Pattern: Topological Sort + Cycle Detection | Approach: Graph banao (prerequisites = edges).
     * Cycle hai toh courses complete nahi ho sakte! DFS se cycle detect karo ya BFS (Kahn's Algorithm) use karo.
     */
    public static boolean canFinish(int numCourses,
                                    int[][] prerequisites) {

        // InDegree array + adjacency list
        int[] inDegree = new int[numCourses];
        /**
         * Outer List (List<...>): Yeh represent karti hai aapke Courses ko (Course 0, Course 1, Course 2, etc.).
         * Inner List (List<Integer>): Yeh represent karti hai us course ke Neighbors / Dependent Courses ko
         * (yani is course ko padhne ke baad aap kaun-kaun se aage ke course padh sakte ho).
         */
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); // Agar [1, 0] hai, yani 0 padhoge tabhi 1 padhoge (0 -> 1)
            inDegree[pre[0]]++;//Saare courses ki incoming dependencies count kar ke ek array (indegree[]) me rakh lijiye.
        }

        // InDegree=0 wale nodes se shuru karo
        //Ek Queue banayein aur un saare courses ko usme daal dein jinki indegree == 0 hai
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        //BFS
        int completed = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completed++;

            for (int next : graph.get(course)) {
                inDegree[next]--;
                if (inDegree[next] == 0) queue.offer(next);
            }
        }

        // Saare courses complete hue?
        return completed == numCourses;

    }

    public static void main(String[] args) {
        System.out.println("=== Course Schedule ===\n");

        // Test 1: Possible
        // 0 → 1
        System.out.println("Test 1: " +
                canFinish(2, new int[][]{{1, 0}})); // true

        // Test 2: Cycle
        // 0 → 1 → 0
        System.out.println("Test 2: " +
                canFinish(2,
                        new int[][]{{1, 0}, {0, 1}})); // false

        // Test 3: Complex
        // 0→1, 0→2, 1→3, 2→3
        System.out.println("Test 3: " +
                canFinish(4,
                        new int[][]{{1, 0}, {2, 0},
                                {3, 1}, {3, 2}})); // true

        // Test 4: No prerequisites
        System.out.println("Test 4: " +
                canFinish(3,
                        new int[][]{})); // true
    }
}
