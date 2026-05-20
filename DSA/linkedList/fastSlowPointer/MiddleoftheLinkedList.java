package DSA.linkedList.fastSlowPointer;

import java.util.List;


public class MiddleoftheLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * https://leetcode.com/problems/middle-of-the-linked-list/
     * https://github.com/nikoo28/java-solutions/blob/master/src/main/java/leetcode/easy/MiddleOfTheLinkedList.
     * https://algomaster.io/practice/dsa/middle-of-the-linked-list?list=am-300
     * here we follow claude AI's response
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper — list banao
    public static ListNode createList(int[] vals) {
        if (vals.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : vals) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper — list print karo
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
        System.out.println("=== Middle of Linked List ===\n");

        // Test 1: Odd length
        // 1→2→3→4→5 → middle=3
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("List: ");
        printList(head1);
        System.out.println("Middle: " +
                middleNode(head1).val); // 3

        System.out.println();

        // Test 2: Even length
        // 1→2→3→4 → middle=3
        ListNode head2 = createList(new int[]{1, 2, 3, 4});
        System.out.print("List: ");
        printList(head2);
        System.out.println("Middle: " +
                middleNode(head2).val); // 3

        System.out.println();

        // Test 3: Single node
        // 1 → middle=1
        ListNode head3 = createList(new int[]{1});
        System.out.print("List: ");
        printList(head3);
        System.out.println("Middle: " +
                middleNode(head3).val); // 1

        System.out.println();

        // Test 4: Two nodes
        // 1→2 → middle=2
        ListNode head4 = createList(new int[]{1, 2});
        System.out.print("List: ");
        printList(head4);
        System.out.println("Middle: " +
                middleNode(head4).val); // 2
    }
}
