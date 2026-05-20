package DSA.linkedList.fastSlowPointer;

public class LinkedListCycleII {


    /**
     * https://leetcode.com/problems/linked-list-cycle-ii/
     * https://leetcode.com/problems/linked-list-cycle-ii/submissions/2007278074/
     * here we follow claude AI's response
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }

        }
        return null;
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
                + detectCycle(head1).val);

        // Test 2: Cycle nahi
        // 1 → 2 → 3 → null
        ListNode head2 = createCycle(new int[]{1, 2, 3}, -1);
        System.out.println("Test 2 (no cycle): " + detectCycle(head2));

        // Test 3: Single node, cycle hai
        // 1 → (back to 1)
        ListNode head3 = createCycle(
                new int[]{1},
                0  // khud pe cycle
        );
        System.out.println("Test 3 (single node cycle): "
                + detectCycle(head3));  // true

        // Test 4: Single node, cycle nahi
        ListNode head4 = createCycle(
                new int[]{1},
                -1
        );
        System.out.println("Test 4 (single node no cycle): "
                + detectCycle(head4));  // false

        // Test 5: Empty list
        System.out.println("Test 5 (empty list): "
                + detectCycle(null));  // false

    }
}
