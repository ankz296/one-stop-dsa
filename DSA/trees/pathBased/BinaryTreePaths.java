package DSA.trees.pathBased;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths {


    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * https://leetcode.com/problems/binary-tree-paths/
     * Pattern: DFS (Backtracking) | Approach: Root se leaf tak har path track karo.
     * String build karte jao — node add karo, leaf pe result mein daalo, backtrack karo!
     */
    public static List<String> binaryTreePaths(
            TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, new StringBuilder(), result);
        return result;
    }

    private static void dfs(TreeNode root, StringBuilder sb, List<String> result) {

        if (root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            result.add(sb.toString());
        } else {
            sb.append("->");
            dfs(root.left, sb, result);
            dfs(root.right, sb, result);
        }
        sb.setLength(len);
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode node = q.poll();
            if (i < arr.length && arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                q.offer(node.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println("=== Binary Tree Paths ===\n");

        // Test 1: Normal
        //     1
        //    / \
        //   2   3
        //    \
        //     5
        TreeNode t1 = buildTree(
                new Integer[]{1, 2, 3, null, 5}
        );
        System.out.println("Test 1: " +
                binaryTreePaths(t1));
        // [1->2->5, 1->3]

        // Test 2: Single node
        TreeNode t2 = buildTree(new Integer[]{1});
        System.out.println("Test 2: " +
                binaryTreePaths(t2));
        // [1]

        // Test 3: Left skewed
        //   1
        //  /
        // 2
        ///
        //3
        TreeNode t3 = buildTree(
                new Integer[]{1, 2, null, 3}
        );
        System.out.println("Test 3: " +
                binaryTreePaths(t3));
        // [1->2->3]
    }
}
