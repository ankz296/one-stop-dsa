package DSA.trees.bfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * https://leetcode.com/problems/binary-tree-right-side-view/
     * Approach: 102 jaisa level order — bas har level ka last element lo! Wahi right side se dikhega!
     */
    public static List<Integer> rightSideView(
            TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // level ka last node
                if (i == size - 1) {
                    result.add(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
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


        System.out.println("=== Right Side View ===\n");

        // Test 1: Normal
        //     1
        //    / \
        //   2   3
        //    \   \
        //     5   4
        TreeNode t1 = buildTree(
                new Integer[]{1, 2, 3, null, 5, null, 4}
        );
        System.out.println("Test 1: " +
                rightSideView(t1)); // [1,3,4]

        // Test 2: Left only
        //   1
        //  /
        // 2
        ///
        //3
        TreeNode t2 = buildTree(
                new Integer[]{1, 2, null, 3}
        );
        System.out.println("Test 2: " +
                rightSideView(t2)); // [1,2,3]

        // Test 3: Single node
        TreeNode t3 = buildTree(new Integer[]{1});
        System.out.println("Test 3: " +
                rightSideView(t3)); // [1]

        // Test 4: Empty
        System.out.println("Test 4: " +
                rightSideView(null)); // []
    }
}
