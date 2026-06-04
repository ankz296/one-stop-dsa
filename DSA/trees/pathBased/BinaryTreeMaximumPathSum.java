package DSA.trees.pathBased;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaximumPathSum {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int maxSum = Integer.MIN_VALUE;// global!

    /**
     * https://leetcode.com/problems/binary-tree-maximum-path-sum/
     * Pattern: DFS (Bottom Up) + Global Max | Approach: Har node pe max path sum calculate karo jo us node se guzre.
     * 543 Diameter jaisa — height ki jagah sum track karo. Global max maintain karo!
     */
    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private static int dfs(TreeNode node) {
        if (node == null) return 0;

        // Step 1: Left aur right ka best contribution
        // Math.max(0,...) → negative? toh 0 (ignore!)
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Step 2: Is node se guzarne wala best path
        // Left + Node + Right (dono sides!)
        maxSum = Math.max(maxSum, left + node.val + right);

        // Step 3: Parent ko return karo
        // Sirf ek side (parent extend karega)
        return node.val + Math.max(left, right);
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
        System.out.println("=== Binary Tree Max Path Sum ===\n");

        // Test 1: Normal
        //    -10
        //    / \
        //   9  20
        //     /  \
        //    15   7
        TreeNode t1 = buildTree(
                new Integer[]{-10, 9, 20, null, null, 15, 7}
        );
        System.out.println("Test 1: " +
                maxPathSum(t1)); // 42

        // Test 2: Simple
        //   1
        //  / \
        // 2   3
        TreeNode t2 = buildTree(
                new Integer[]{1, 2, 3}
        );
        System.out.println("Test 2: " +
                maxPathSum(t2)); // 6

        // Test 3: All negative
        //   -3
        TreeNode t3 = buildTree(
                new Integer[]{-3}
        );
        System.out.println("Test 3: " +
                maxPathSum(t3)); // -3

        // Test 4: Mixed
        //     2
        //    / \
        //  -1   3
        TreeNode t4 = buildTree(
                new Integer[]{2, -1, 3}
        );
        System.out.println("Test 4: " +
                maxPathSum(t4)); // 5 (2+3)
    }
}
