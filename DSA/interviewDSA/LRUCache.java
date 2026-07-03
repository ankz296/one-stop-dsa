package DSA.interviewDSA;

import java.util.HashMap;

public class LRUCache {

    // ─── Node class for Doubly Linked List ───
    class Node {

        int key, value;
        Node next, pre;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail; // dummy nodes

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head and tail — no null checks needed
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.pre = head;

    }

    // ─── GET — O(1) ───
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        // remove from current location
        removeNode(node);
        // add to first location
        addToFront(node);

        return node.value;
    }

    // ─── PUT — O(1) ───
    public void put(int key, int value) {

        // scenario
        // key is available
        // size full
        // new key

        // Update existing key
        if (map.containsKey(key)) {
            Node existNode = map.get(key);
            existNode.value = value;
            removeNode(existNode);
            addToFront(existNode);
            return;
        }

        // Capacity full — remove LRU (tail side)
        if (map.size() == capacity) {
            Node lru = tail.pre;
            removeNode(lru);
            map.remove(lru.key);
        }

        // Add new node
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToFront(newNode);
    }

    // ─── Helper: Add node after head ───
    private void addToFront(Node node) {
        Node nextNode = head.next;

        node.pre = head;
        head.next = node;

        node.next = nextNode;
        nextNode.pre = node;
    }

    // ─── Helper: Remove node from list ───
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // ─── Print current cache state ───
    public void printCache() {
        System.out.print("Cache (MRU → LRU): ");
        Node curr = head.next;
        while (curr != tail) {
            System.out.print("[" + curr.key + "=" + curr.value + "] ");
            curr = curr.next;
        }
        System.out.println();
    }

    // ─── MAIN — Test Cases ───
    public static void main(String[] args) {

        System.out.println("=== LRU Cache Test ===\n");

        LRUCache cache = new LRUCache(3); // capacity = 3

        // Test 1: Basic put
        System.out.println("--- put(1,10), put(2,20), put(3,30) ---");
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        cache.printCache();
        // Expected: [3=30] [2=20] [1=10]

        // Test 2: get existing key
        System.out.println("\n--- get(1) ---");
        System.out.println("get(1) = " + cache.get(1));
        cache.printCache();
        // Expected: [1=10] [3=30] [2=20]
        // 1 moved to front (most recently used)

        // Test 3: Capacity full — LRU eviction
        System.out.println("\n--- put(4,40) — capacity full, evict LRU ---");
        cache.put(4, 40);
        cache.printCache();
        // Expected: [4=40] [1=10] [3=30]
        // 2 was LRU — evicted

        // Test 4: get evicted key
        System.out.println("\n--- get(2) — already evicted ---");
        System.out.println("get(2) = " + cache.get(2));
        // Expected: -1

        // Test 5: Update existing key
        System.out.println("\n--- put(3, 300) — update existing ---");
        cache.put(3, 300);
        cache.printCache();
        // Expected: [3=300] [4=40] [1=10]
        // 3 updated and moved to front

        // Test 6: One more eviction
        System.out.println("\n--- put(5,50) — evict LRU again ---");
        cache.put(5, 50);
        cache.printCache();
        // Expected: [5=50] [3=300] [4=40]
        // 1 was LRU — evicted

        // Test 7: get remaining keys
        System.out.println("\n--- Final gets ---");
        System.out.println("get(1) = " + cache.get(1));   // -1 evicted
        System.out.println("get(3) = " + cache.get(3));   // 300
        System.out.println("get(4) = " + cache.get(4));   // 40
        System.out.println("get(5) = " + cache.get(5));   // 50

        System.out.println("\n=== All Tests Done ===");
    }
}
