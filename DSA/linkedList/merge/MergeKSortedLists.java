package DSA.linkedList.merge;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    // first we take head of every list to heap
    // then we pop until heap become empty
    // in while loop we add next node of current node's
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /*
    https://leetcode.com/problems/merge-k-sorted-lists
    https://algomaster.io/practice/dsa/merge-k-sorted-lists?list=am-300
    Here we choose Claude AI's response
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // first time push head of every list
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!heap.isEmpty()) {
            ListNode node = heap.poll();// its give minimum num
            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                heap.offer(node.next);
            }
        }

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
        System.out.println("=== Merge K Sorted Lists ===\n");

        // Test 1: 3 lists
        ListNode[] lists1 = {
                createList(new int[]{1, 4, 5}),
                createList(new int[]{1, 3, 4}),
                createList(new int[]{2, 6})
        };
        System.out.print("Merged: ");
        printList(mergeKLists(lists1));

        // Test 2: Empty lists
        ListNode[] lists2 = {};
        System.out.println("Empty: " +
                mergeKLists(lists2)); // null

        // Test 3: One list
        ListNode[] lists3 = {
                createList(new int[]{1, 2, 3})
        };
        System.out.print("Single list: ");
        printList(mergeKLists(lists3));
    }
}
