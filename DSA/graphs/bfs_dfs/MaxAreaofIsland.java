package DSA.graphs.bfs_dfs;

public class MaxAreaofIsland {

    static int maxArea = 0;

    /**
     * https://leetcode.com/problems/max-area-of-island/
     * Pattern: BFS/DFS + Grid | Approach: 200 Number of Islands jaisa — but count++ ki jagah area count karo!
     * Har connected '1' cell = +1 area. Global max track karo.
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        maxArea = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    // DFS se area nikalo
                    maxArea = Math.max(maxArea, dfs(rows, cols, grid, r, c));
                }
            }
        }
        return maxArea;
    }

    public static int dfs(int rows, int cols, int[][] grid, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) return 0;

        grid[r][c] = 0;
        return 1 + dfs(rows, cols, grid, r + 1, c) +
                dfs(rows, cols, grid, r - 1, c) +
                dfs(rows, cols, grid, r, c + 1) +
                dfs(rows, cols, grid, r, c - 1);
        // in this logic we are trying to check all 1 values if they are one we consider them continues to check till 0 will come
        // that way we will get max are for that particular zone by left,right,top and bottom through
    }

    public static void main(String[] args) {
        System.out.println("=== Max Area of Island ===\n");

        // Test 1
        int[][] grid1 = {
                {0, 0, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println("Test 1: " +
                maxAreaOfIsland(grid1)); // 4

        // Test 2: All water
        int[][] grid2 = {{0, 0, 0}, {0, 0, 0}};
        System.out.println("Test 2: " +
                maxAreaOfIsland(grid2)); // 0

        // Test 3: All land
        int[][] grid3 = {{1, 1}, {1, 1}};
        System.out.println("Test 3: " +
                maxAreaOfIsland(grid3)); // 4
    }
}
