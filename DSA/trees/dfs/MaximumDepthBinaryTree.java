package DSA.trees.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/
     * Approach: Har node ke liye left aur right subtree ki depth nikalo. 1 + max(leftDepth, rightDepth) = current node ki depth!
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }

    // Helper — tree banao from array (level order)
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode node = queue.poll();

            if (i < arr.length && arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                queue.offer(node.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }


    public static void main(String[] args) {
        System.out.println("=== Maximum Depth of Binary Tree ===\n");

        // Test 1: Normal tree
        //      3
        //     / \
        //    9  20
        //      /  \
        //     15   7
        TreeNode t1 = buildTree(
                new Integer[]{3, 9, 20, null, null, 15, 7}
        );
        System.out.println("Test 1: " + maxDepth(t1)); // 3

        // Test 2: Single node
        TreeNode t2 = buildTree(new Integer[]{1});
        System.out.println("Test 2: " + maxDepth(t2)); // 1

        // Test 3: Empty tree
        System.out.println("Test 3: " + maxDepth(null)); // 0

        // Test 4: Skewed tree (left)
        //    1
        //   /
        //  2
        // /
        //3
        TreeNode t4 = buildTree(
                new Integer[]{1, 2, null, 3, null}
        );
        System.out.println("Test 4: " + maxDepth(t4)); // 3
    }
}
