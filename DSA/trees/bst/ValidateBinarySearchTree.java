package DSA.trees.bst;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * https://leetcode.com/problems/validate-binary-search-tree/
     * Pattern: DFS (Top Down) | Approach: Har node ke liye valid range pass karo — min aur max.
     * Node ka value is range mein hona chahiye. Left child ko max=node.val, Right child ko min=node.val pass karo!
     */
    public static boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean dfs(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;

        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
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
        System.out.println("=== Validate BST ===\n");

        // Test 1: Valid BST
        //   2
        //  / \
        // 1   3
        TreeNode t1 = buildTree(new Integer[]{2, 1, 3});
        System.out.println("Test 1 (valid): " +
                isValidBST(t1)); // true

        // Test 2: Invalid BST
        //     5
        //    / \
        //   1   4
        //      / \
        //     3   6
        TreeNode t2 = buildTree(
                new Integer[]{5, 1, 4, null, null, 3, 6}
        );
        System.out.println("Test 2 (invalid): " +
                isValidBST(t2)); // false

        // Test 3: Tricky — equal values
        //   2
        //  / \
        // 2   2
        TreeNode t3 = buildTree(new Integer[]{2, 2, 2});
        System.out.println("Test 3 (equal vals): " +
                isValidBST(t3)); // false

        // Test 4: Integer.MIN_VALUE edge case
        TreeNode t4 = buildTree(
                new Integer[]{Integer.MIN_VALUE}
        );
        System.out.println("Test 4 (MIN_VALUE): " +
                isValidBST(t4)); // true
    }
}
