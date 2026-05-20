package DSA.linkedList.reversal;

public class ReverseNodeskGroup {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            // Kth node dhundho
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) break;

            ListNode groupNext = kth.next;

            // Reverse karo
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Reconnect karo
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }

        return dummy.next;
    }

    private static ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
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
        System.out.println("=== Reverse Nodes in K-Group ===\n");

//        // Test 1: k=2
//        // 1→2→3→4→5 → 2→1→4→3→5
//        ListNode head1 = createList(new int[]{1,2,3,4,5});
//        System.out.print("Before: "); printList(head1);
//        head1 = reverseKGroup(head1, 2);
//        System.out.print("After:  "); printList(head1);
//        System.out.println();

        // Test 2: k=3
        // 1→2→3→4→5 → 3→2→1→4→5
        ListNode head2 = createList(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.print("Before: ");
        printList(head2);
        head2 = reverseKGroup(head2, 3);
        System.out.print("After:  ");
        printList(head2);
        System.out.println();

//        // Test 3: k=1 (no change)
//        ListNode head3 = createList(new int[]{1,2,3});
//        System.out.print("Before: "); printList(head3);
//        head3 = reverseKGroup(head3, 1);
//        System.out.print("After:  "); printList(head3);
//        System.out.println();
//
//        // Test 4: k = list length
//        // 1→2→3 → 3→2→1
//        ListNode head4 = createList(new int[]{1,2,3});
//        System.out.print("Before: "); printList(head4);
//        head4 = reverseKGroup(head4, 3);
//        System.out.print("After:  "); printList(head4);
    }
}
