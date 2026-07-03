package DSA.interviewDSA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBST {

    class TreeNode {

        int value;
        TreeNode left, right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    // Serialize: Tree → String
    public String serializer(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        serializerHelper(node, sb);
        return sb.toString();
    }

    public void serializerHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }

        sb.append(node.value);
        serializerHelper(node.left, sb);
        serializerHelper(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {

        String value = queue.poll();

        if (value == null) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);

        return node;
    }
}
