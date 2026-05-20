package DSA.trees.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class DiameterBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int maxDiabmeter = 0;

    /*
    https://leetcode.com/problems/diameter-of-binary-tree/
    Approach: Har node pe diameter = left height + right height.
    Global max track karo. DFS se height return karo, lekin diameter update karte jao!
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        maxDiabmeter = 0;
        dfs(root);
        return maxDiabmeter;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        maxDiabmeter = Math.max(maxDiabmeter, left + right);

        return 1 + Math.max(left, right);
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
        System.out.println("=== Diameter of Binary Tree ===\n");

        // Test 1: Normal
        //     1
        //    / \
        //   2   3
        //  / \
        // 4   5
        TreeNode t1 = buildTree(
                new Integer[]{1, 2, 3, 4, 5}
        );
        System.out.println("Test 1: " +
                diameterOfBinaryTree(t1)); // 3

        // Test 2: Single node
        TreeNode t2 = buildTree(new Integer[]{1});
        System.out.println("Test 2: " +
                diameterOfBinaryTree(t2)); // 0

        // Test 3: Diameter not through root
        //       1
        //      /
        //     2
        //    / \
        //   3   4
        TreeNode t3 = buildTree(
                new Integer[]{1, 2, null, 3, 4}
        );
        System.out.println("Test 3: " +
                diameterOfBinaryTree(t3)); // 2 (3→2→4)

        // Test 4: Linear tree
        //  1→2→3→4
        TreeNode t4 = buildTree(
                new Integer[]{1, 2, null, 3, null, 4}
        );
        System.out.println("Test 4: " +
                diameterOfBinaryTree(t4)); // 3
    }
}
