package DSA.trees.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal/
     * Approach: Queue use karo. Har level ke liye — queue ka current size = us level ke nodes! Size baar process karo,
     * result mein add karo.Children queue mein daalo!
     */
    public static List<List<Integer>> levelOrder(
            TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> integerQueue = new LinkedList<>();
        integerQueue.offer(root);

        while (!integerQueue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = integerQueue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = integerQueue.poll();
                level.add(node.val);

                if (node.left != null) integerQueue.offer(node.left);
                if (node.right != null) integerQueue.offer(node.right);

            }
            result.add(level);
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
        System.out.println("=== Level Order Traversal ===\n");

        // Test 1: Normal tree
        //     3
        //    / \
        //   9  20
        //     /  \
        //    15   7
        TreeNode t1 = buildTree(
                new Integer[]{3, 9, 20, null, null, 15, 7}
        );
        System.out.println("Test 1: " + levelOrder(t1));
        // [[3],[9,20],[15,7]]

        // Test 2: Single node
        TreeNode t2 = buildTree(new Integer[]{1});
        System.out.println("Test 2: " + levelOrder(t2));
        // [[1]]

        // Test 3: Empty
        System.out.println("Test 3: " + levelOrder(null));
        // []

        // Test 4: Left skewed
        //   1
        //  /
        // 2
        ///
        //3
        TreeNode t4 = buildTree(
                new Integer[]{1, 2, null, 3}
        );
        System.out.println("Test 4: " + levelOrder(t4));
        // [[1],[2],[3]]
    }
}
