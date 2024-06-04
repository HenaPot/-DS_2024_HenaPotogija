package homework3;

import java.util.ArrayList;

public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    public ArrayList<Entry> get(String searchableName) {
        Node node = getNode(root, searchableName);
        if (node == null) return null;
        return node.values;
    }

    private Node getNode(Node node, String key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) node = node.left;
            else if (cmp > 0) node = node.right;
            else return node;
        }
        return null;
    }

    public void put(String searchableName, Entry entry) {
        root = put(root, searchableName, entry);
        root.color = BLACK;
    }

    private Node put(Node h, String key, Entry entry) {
        if (h == null) return new Node(key, entry, RED);

        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, entry);
        else if (cmp > 0) h.right = put(h.right, key, entry);
        else h.values.add(entry);

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }

    private boolean isRed(Node node) {
        if (node == null) return false;
        return node.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public int[] countRedAndBlackEdgesOnPath(String key) {
        int[] counts = new int[2]; // counts[0] for black edges, counts[1] for red edges
        countEdgesOnPath(root, key, counts);
        return counts;
    }

    private boolean countEdgesOnPath(Node node, String key, int[] counts) {
        if (node == null) return false;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            if (node.left != null) {
                if (node.left.color == RED) counts[1]++;
                else counts[0]++;
            }
            return countEdgesOnPath(node.left, key, counts);
        } else if (cmp > 0) {
            if (node.right != null) {
                if (node.right.color == RED) counts[1]++;
                else counts[0]++;
            }
            return countEdgesOnPath(node.right, key, counts);
        } else {
            return true;
        }
    }

    public int[] countRedAndBlackEdges() {
        int[] counts = new int[2];
        countEdges(root, counts);
        return counts;
    }

    private void countEdges(Node node, int[] counts) {
        if (node == null) return;
        if (node.left != null) {
            if (node.left.color == RED) counts[1]++;
            else counts[0]++;
            countEdges(node.left, counts);
        }
        if (node.right != null) {
            if (node.right.color == RED) counts[1]++;
            else counts[0]++;
            countEdges(node.right, counts);
        }
    }

}
