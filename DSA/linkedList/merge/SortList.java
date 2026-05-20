package DSA.linkedList.merge;

public class SortList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * https://leetcode.com/problems/sort-list/description/
     * https://algomaster.io/practice/dsa/sort-list?list=am-300
     * Here we use Claude AI's response
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Split
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null; // break the list

        // Sort
        ListNode left = sortList(head);
        ListNode rightListNode = sortList(right);

        return mergeList(left, rightListNode);
    }

    private static ListNode mergeList(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        curr.next = (left != null) ? left : right;
        return dummy.next;
    }

    private static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public static ListNode createList(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : vals) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" → ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Sort List ===\n");

        // Test 1: Normal
        // 4→2→1→3 → 1→2→3→4
        ListNode h1 = createList(new int[]{4, 2, 1, 3});
        System.out.print("Before: ");
        printList(h1);
        System.out.print("After:  ");
        printList(sortList(h1));
        System.out.println();

        // Test 2: Already sorted
        // 1→2→3→4 → 1→2→3→4
        ListNode h2 = createList(new int[]{1, 2, 3, 4});
        System.out.print("Before: ");
        printList(h2);
        System.out.print("After:  ");
        printList(sortList(h2));
        System.out.println();

        // Test 3: Reverse sorted
        // 4→3→2→1 → 1→2→3→4
        ListNode h3 = createList(new int[]{4, 3, 2, 1});
        System.out.print("Before: ");
        printList(h3);
        System.out.print("After:  ");
        printList(sortList(h3));
        System.out.println();

        // Test 4: Duplicates
        // 3→1→2→1 → 1→1→2→3
        ListNode h4 = createList(new int[]{3, 1, 2, 1});
        System.out.print("Before: ");
        printList(h4);
        System.out.print("After:  ");
        printList(sortList(h4));
    }
}
