package DSA.linkedList.reversal;

public class ReverseLinkedListII {
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
     * https://leetcode.com/problems/reverse-linked-list-ii/
     * https://www.youtube.com/watch?v=oDL8vuu2Q0E
     * https://algomaster.io/practice/dsa/reverse-linked-list-ii?list=am-300
     * https://github.com/nikoo28/java-solutions/blob/master/src/main/java/leetcode/medium/ReverseLinkedListII.java
     * Here we choose Nikhil Lohia's Git Solutions
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // create a dummy node to mark the head of this list
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        // make markers for currentNode and for the node before reversing
        ListNode leftPre = dummyNode;
        ListNode currentNode = head;

        // run the both node til left
        for (int i = 0; i < left - 1; i++) {
            leftPre = leftPre.next;
            currentNode = currentNode.next;
        }

        // make a marker to node where we start reversing
        ListNode subListHead = currentNode;

        ListNode preNode = null;
        for (int i = 0; i <= right - left; i++) {
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }

        // join the nodes
        leftPre.next = preNode;
        subListHead.next = currentNode;

        return dummyNode.next;

        /*
            ListNode dummy = new ListNode(0);
        dummy.next = head;

        // leftPrev pe jao
        ListNode leftPrev = dummy;
        for (int i = 0; i < left - 1; i++) {
            leftPrev = leftPrev.next;
        }

        ListNode curr = leftPrev.next;

        // Reverse karo
        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;
            curr.next     = next.next;
            next.next     = leftPrev.next;
            leftPrev.next = next;
        }

        return dummy.next;
         */
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

        System.out.println("=== Reverse Linked List II ===\n");

        // Test 1: Normal case
        // 1→2→3→4→5, left=2, right=4
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Before: ");
        printList(head1);
        head1 = reverseBetween(head1, 2, 4);
        System.out.print("After:  ");
        printList(head1);
        System.out.println();

        // Test 2: left=1 (dummy node test)
        // 1→2→3→4→5, left=1, right=3
        ListNode head2 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Before: ");
        printList(head2);
        head2 = reverseBetween(head2, 1, 3);
        System.out.print("After:  ");
        printList(head2);
        System.out.println();

        // Test 3: Full list reverse
        // 1→2→3, left=1, right=3
        ListNode head3 = createList(new int[]{1, 2, 3});
        System.out.print("Before: ");
        printList(head3);
        head3 = reverseBetween(head3, 1, 3);
        System.out.print("After:  ");
        printList(head3);
        System.out.println();

        // Test 4: Single element range
        // 1→2→3, left=2, right=2
        ListNode head4 = createList(new int[]{1, 2, 3});
        System.out.print("Before: ");
        printList(head4);
        head4 = reverseBetween(head4, 2, 2);
        System.out.print("After:  ");
        printList(head4);
    }
}

