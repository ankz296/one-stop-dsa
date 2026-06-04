package DSA.trees.bst;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestorBST {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
     * Pattern: BST Property | Approach: BST mein LCA dhundhna bahut easy hai! Dono nodes (p aur q) se compare karo —
     * agar current node dono ke beech mein hai → wahi LCA hai! BST property use karo, koi extra space nahi!
     */
    public static TreeNode lowestCommonAncestor(
            TreeNode root, TreeNode p, TreeNode q) {

        TreeNode curr = root;

        while (curr != null) {
            if (curr.val > p.val && curr.val > q.val) {
                curr = curr.left;
            } else if (curr.val < p.val && curr.val < q.val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;

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
        System.out.println("=== LCA of BST ===\n");

        //       6
        //      / \
        //     2   8
        //    / \ / \
        //   0  4 7  9
        //     / \
        //    3   5
        TreeNode root = buildBST(
                new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}
        );

        // Test 1: p=2, q=8 → LCA=6
        TreeNode p1 = new TreeNode(2);
        TreeNode q1 = new TreeNode(8);
        System.out.println("Test 1 (p=2,q=8): " +
                lowestCommonAncestor(root, p1, q1).val); // 6

        // Test 2: p=2, q=4 → LCA=2
        TreeNode p2 = new TreeNode(2);
        TreeNode q2 = new TreeNode(4);
        System.out.println("Test 2 (p=2,q=4): " +
                lowestCommonAncestor(root, p2, q2).val); // 2

        // Test 3: p=3, q=5 → LCA=4
        TreeNode p3 = new TreeNode(3);
        TreeNode q3 = new TreeNode(5);
        System.out.println("Test 3 (p=3,q=5): " +
                lowestCommonAncestor(root, p3, q3).val); // 4
    }
}
