package DSA.graphs.bfs_dfs;

public class NumberOfIslands {

    /**
     * https://leetcode.com/problems/number-of-islands/
     * Pattern: BFS/DFS + Grid Traversal | Approach: Har cell scan karo. '1' mila → island count++
     * → BFS/DFS se poora island mark karo (visited '0' kar do). Next unvisited '1' → new island!
     */
    public static int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(rows, cols, grid, r, c);
                }
            }
        }
        return count;
    }

    public static void dfs(int rows, int cols, char[][] grid, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0') return;

        grid[r][c] = '0';

        dfs(rows, cols, grid, r + 1, c); // down
        dfs(rows, cols, grid, r - 1, c); // up
        dfs(rows, cols, grid, r, c + 1); // right
        dfs(rows, cols, grid, r, c - 1); // left
    }

    public static void main(String[] args) {
        System.out.println("=== Number of Islands ===\n");

        // Test 1: 3 islands
        char[][] grid1 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Test 1: " +
                numIslands(grid1)); // 3

        // Test 2: 1 island
        char[][] grid2 = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        System.out.println("Test 2: " +
                numIslands(grid2)); // 1

        // Test 3: All water
        char[][] grid3 = {
                {'0', '0'},
                {'0', '0'}
        };
        System.out.println("Test 3: " +
                numIslands(grid3)); // 0

        // Test 4: All land
        char[][] grid4 = {
                {'1', '1'},
                {'1', '1'}
        };
        System.out.println("Test 4: " +
                numIslands(grid4)); // 1
    }
}
