package DSA.linkedList.reversal;

import java.util.List;

public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * https://leetcode.com/problems/reverse-linked-list/
     * https://github.com/nikoo28/java-solutions/blob/master/src/main/java/leetcode/ReverseLinkedList.java
     * https://algomaster.io/practice/dsa/reverse-linked-list?list=am-300
     * Here I follow both git and Claude AI response
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null && head.next != null) {
            ListNode nextNode = head.next; // adding next into temp variable
            head.next = prev; // pointing next to prev -> opposide direction
            prev = head; //
            head = nextNode;
        }
        head.next = prev;
        return head;
    }

    // Helper — list banao
    public static ListNode createList(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : vals) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper — print karo
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
        System.out.println("=== Reverse Linked List ===\n");

        // Test 1: Normal list
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Before: ");
        printList(head1);
        head1 = reverseList(head1);
        System.out.print("After:  ");
        printList(head1);

        System.out.println();

        // Test 2: Two nodes
        ListNode head2 = createList(new int[]{1, 2});
        System.out.print("Before: ");
        printList(head2);
        head2 = reverseList(head2);
        System.out.print("After:  ");
        printList(head2);

        System.out.println();

        // Test 3: Single node
        ListNode head3 = createList(new int[]{1});
        System.out.print("Before: ");
        printList(head3);
        head3 = reverseList(head3);
        System.out.print("After:  ");
        printList(head3);
    }
}
