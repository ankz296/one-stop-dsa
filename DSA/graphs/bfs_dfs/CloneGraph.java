package DSA.graphs.bfs_dfs;

import java.util.*;

public class CloneGraph {

    static class Node {
        int val;
        List<Node> neighbors;

        Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    /**
     * https://leetcode.com/problems/clone-graph/submissions/
     * Pattern: BFS/DFS + HashMap | Approach: HashMap use karo — original node → cloned node mapping.
     * Har node ke liye clone banao, phir neighbors clone karo. HashMap ensure karta hai ek node ek baar clone ho!
     */
    public static Node cloneGraph(Node node) {

        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>(); //original->clone
        Queue<Node> queue = new LinkedList<>();

        // Start node clone karo -> key as original and value as a clone
        map.put(node, new Node(node.val));
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            // Har neighbor ke liye
            for (Node neighbor : curr.neighbors) {
                // Clone nahi hua? → banao aur queue mein daalo
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                // Clone ka neighbor add karo
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    // Helper — graph banao
    // adjList: [[2,4],[1,3],[2,4],[1,3]]
    public static Node buildGraph(int[][] adjList) {
        if (adjList.length == 0) return null;

        Node[] nodes = new Node[adjList.length + 1];
        for (int i = 1; i <= adjList.length; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < adjList.length; i++) {
            for (int neighbor : adjList[i]) {
                nodes[i + 1].neighbors.add(nodes[neighbor]);
            }
        }
        return nodes[1];
    }

    // Helper — graph print karo
    public static void printGraph(Node node) {
        if (node == null) {
            System.out.println("null");
            return;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        visited.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.val + " → [");
            List<String> nb = new ArrayList<>();
            for (Node n : curr.neighbors) {
                nb.add(String.valueOf(n.val));
                if (!visited.contains(n)) {
                    visited.add(n);
                    q.offer(n);
                }
            }
            System.out.println(String.join(",", nb) + "]");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Clone Graph ===\n");

        // Test 1: 4 nodes cycle
        // 1--2
        // |  |
        // 4--3
        int[][] adj1 = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        Node original = buildGraph(adj1);
        Node cloned = cloneGraph(original);

        System.out.println("Original:");
        printGraph(original);
        System.out.println("\nCloned:");
        printGraph(cloned);
        System.out.println("\nSame object? " +
                (original == cloned)); // false ✅

        // Test 2: Single node
        Node single = new Node(1);
        Node clonedSingle = cloneGraph(single);
        System.out.println("\nSingle node val: " +
                clonedSingle.val); // 1
    }
}
