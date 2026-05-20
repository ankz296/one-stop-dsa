package DSA.linkedList.fastSlowPointer;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {


    /**
     * https://leetcode.com/problems/linked-list-cycle/
     * here we follow claude AI's response
     */
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    // ============ Helper — Cycle banao ============
    static ListNode createCycle(int[] val, int cycleIndex) {

        // node banayo
        ListNode[] nodes = new ListNode[val.length];
        for (int i = 0; i < val.length; i++) {
            nodes[i] = new ListNode(val[i]);
        }

        // node ko link karo
        for (int i = 0; i < val.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // Cycle banao agar cycleIndex valid hai
        if (cycleIndex > 0 && cycleIndex <= val.length) {
            nodes[val.length - 1].next = nodes[cycleIndex];
        }
        return nodes[0];
    }

    // ============ Main ============
    static void main(String[] args) {

        System.out.println("=== Linked List Cycle Detection ===\n");

        // Test 1: Cycle hai
        // 1 → 2 → 3 → 4 → 5
        //             ↑       ↓
        //             ← ← ← ←
        ListNode head1 = createCycle(new int[]{1, 2, 3, 4, 5}, 2);
        System.out.println("Test 1 (cycle at index 2): "
                + hasCycle(head1));

        // Test 2: Cycle nahi
        // 1 → 2 → 3 → null
        ListNode head2 = createCycle(new int[]{1, 2, 3}, -1);
        System.out.println("Test 2 (no cycle): " + hasCycle(head2));

        // Test 3: Single node, cycle hai
        // 1 → (back to 1)
        ListNode head3 = createCycle(
                new int[]{1},
                0  // khud pe cycle
        );
        System.out.println("Test 3 (single node cycle): "
                + hasCycle(head3));  // true

        // Test 4: Single node, cycle nahi
        ListNode head4 = createCycle(
                new int[]{1},
                -1
        );
        System.out.println("Test 4 (single node no cycle): "
                + hasCycle(head4));  // false

        // Test 5: Empty list
        System.out.println("Test 5 (empty list): "
                + hasCycle(null));  // false

    }
}
