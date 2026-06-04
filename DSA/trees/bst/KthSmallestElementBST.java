package DSA.trees.bst;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class KthSmallestElementBST {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
     * Pattern: BST Inorder Traversal | Approach: BST ka inorder traversal (Left → Root → Right) hamesha sorted order deta hai!
     * K-th element visit karo → answer mil gaya!
     */
    public static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            k--;
            if (k == 0) return curr.val;
            curr = curr.right;
        }
        return -1;
    }

    public static TreeNode buildBST(Integer[] arr) {
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
        System.out.println("=== Kth Smallest in BST ===\n");

        // Test 1:
        //     3
        //    / \
        //   1   4
        //    \
        //     2
        TreeNode t1 = buildBST(new Integer[]{3, 1, 4, null, 2});
        System.out.println("Test 1 (k=1): " + kthSmallest(t1, 1)); // 1
        System.out.println("Test 1 (k=3): " + kthSmallest(t1, 3)); // 3

        // Test 2:
        //       5
        //      / \
        //     3   6
        //    / \
        //   2   4
        //  /
        // 1
        TreeNode t2 = buildBST(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        System.out.println("Test 2 (k=3): " + kthSmallest(t2, 3)); // 3
    }
}
