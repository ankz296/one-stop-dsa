package DSA.trees.pathBased;

import java.util.LinkedList;
import java.util.Queue;

public class CountGoodNodesBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    /**
     * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
     * Pattern: DFS (Top Down) | Approach: Root se leaf tak path ka maximum track karo.
     * Har node pe check karo — kya current node ka value path ke maximum se bada ya equal hai? Agar haan → Good Node!
     */
    private static int dfs(TreeNode root, int maxSofar) {

        if (root == null) return 0;

        // Yeh line sirf ek kaam karti hai:
        //"Kya YEH node good hai?"
        int good = root.val >= maxSofar ? 1 : 0;

        // update curr maxSum

        maxSofar = Math.max(maxSofar, root.val);

        return good + // YEH node good hai? (0 ya 1)
                dfs(root.left, maxSofar) + // Left subtree mein kitne good nodes?
                dfs(root.right, maxSofar); // Right subtree mein kitne good nodes?
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
        System.out.println("=== Count Good Nodes ===\n");

        // Test 1: Normal
        //     3
        //    / \
        //   1   4
        //  /   / \
        // 3   1   5
        TreeNode t1 = buildTree(
                new Integer[]{3, 1, 4, 3, null, 1, 5}
        );
        System.out.println("Test 1: " +
                goodNodes(t1)); // 4

        // Test 2: All good
        //   3
        //  / \
        // 3   4
        TreeNode t2 = buildTree(
                new Integer[]{3, 3, 4}
        );
        System.out.println("Test 2: " +
                goodNodes(t2)); // 3

        // Test 3: Single node
        TreeNode t3 = buildTree(new Integer[]{1});
        System.out.println("Test 3: " +
                goodNodes(t3)); // 1
    }

}
