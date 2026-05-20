package DSA.trees.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * https://leetcode.com/problems/path-sum/
     * Approach: Root se leaf tak path ka sum check karo. Har node pe targetSum - node.val karo.
     * Leaf pe pahuncho aur remaining sum = 0 ho toh path mila!
     */
    public static boolean hasPathSum(
            TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }
        // Leaf node check
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
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
        System.out.println("=== Path Sum ===\n");

        // Test 1: Path exists
        //       5
        //      / \
        //     4   8
        //    /   / \
        //   11  13   4
        //  /  \       \
        // 7    2       1
        TreeNode t1 = buildTree(new Integer[]{
                5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1
        });
        System.out.println("Test 1 (sum=22): " +
                hasPathSum(t1, 22)); // true

        // Test 2: No path
        System.out.println("Test 2 (sum=5): " +
                hasPathSum(t1, 5));  // false

        // Test 3: Empty tree
        System.out.println("Test 3 (null): " +
                hasPathSum(null, 0)); // false

        // Test 4: Single node
        TreeNode t4 = buildTree(new Integer[]{1});
        System.out.println("Test 4 (sum=1): " +
                hasPathSum(t4, 1)); // true
        System.out.println("Test 4 (sum=2): " +
                hasPathSum(t4, 2)); // false
    }
}
