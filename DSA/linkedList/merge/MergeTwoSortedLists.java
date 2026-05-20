package DSA.linkedList.merge;

import DSA.linkedList.reversal.ReverseLinkedListII;

public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * https://leetcode.com/problems/merge-two-sorted-lists/description/
     * https://algomaster.io/practice/dsa/merge-two-sorted-lists?list=am-300
     * Here we follow Claude AI's response
     */
    public static ListNode mergeTwoLists(
            ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        curr.next = list1 != null ? list1 : list2;

        return dummy.next;
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
        System.out.println("=== Merge Two Sorted Lists ===\n");

        // Test 1: Normal case
        // 1→2→4 + 1→3→4 = 1→1→2→3→4→4
        ListNode l1 = createList(new int[]{1, 2, 4});
        ListNode l2 = createList(new int[]{1, 3, 4});
        System.out.print("List1:  ");
        printList(l1);
        System.out.print("List2:  ");
        printList(l2);
        System.out.print("Merged: ");
        printList(mergeTwoLists(l1, l2));
        System.out.println();

        // Test 2: One empty
        // [] + 1→2→3 = 1→2→3
        ListNode l3 = null;
        ListNode l4 = createList(new int[]{1, 2, 3});
        System.out.print("List1:  null\n");
        System.out.print("List2:  ");
        printList(l4);
        System.out.print("Merged: ");
        printList(mergeTwoLists(l3, l4));
        System.out.println();

        // Test 3: Both empty
        System.out.println("Both empty: " +
                mergeTwoLists(null, null)); // null
    }
}
