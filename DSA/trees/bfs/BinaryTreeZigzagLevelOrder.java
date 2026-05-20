package DSA.trees.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrder {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
     * Approach: 102 jaisa hi — bas alternate levels mein reverse karo! Even level → left to right, Odd level → right to left.
     * LinkedList use karo — addFirst ya addLast se direction control karo!
     */
    public static List<List<Integer>> zigzagLevelOrder(
            TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (leftToRight) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
            leftToRight = !leftToRight;
        }


        return result;
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
        System.out.println("=== Zigzag Level Order ===\n");

        // Test 1: Normal
        //     3
        //    / \
        //   9  20
        //     /  \
        //    15   7
        TreeNode t1 = buildTree(
                new Integer[]{3, 9, 20, null, null, 15, 7}
        );
        System.out.println("Test 1: " +
                zigzagLevelOrder(t1));
        // [[3],[20,9],[15,7]]

        // Test 2: Single node
        TreeNode t2 = buildTree(new Integer[]{1});
        System.out.println("Test 2: " +
                zigzagLevelOrder(t2));
        // [[1]]

        // Test 3: 4 levels
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        TreeNode t3 = buildTree(
                new Integer[]{1, 2, 3, 4, 5, null, 6}
        );
        System.out.println("Test 3: " +
                zigzagLevelOrder(t3));
        // [[1],[3,2],[4,5,6]]
    }
}
