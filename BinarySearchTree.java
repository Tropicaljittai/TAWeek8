public class BinarySearchTree<T extends Comparable<T>> {

    private int nodes = 0;
    private Node root = null;

    private class Node {
        Integer data;
        Node left, right;

        public Node(Node left, Node right, Integer elem) {
            this.data = elem;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // (A) NODE FUNCTION THAT COUNTS THE NUMBER OF ITEMS IN THE TREE
    public int size() {
        return nodes;
    }

    // (B) Write a function that returns the sum of all the keys in a binary tree.
    public int sumOfItems() {
        return sumOfItems(root);
    }
    private int sumOfItems(Node node){
        if(node == null) return 0;
        return Integer.sum(sumOfItems(node.left), sumOfItems(node.right)) + node.data;
    }

    // (C) Write a function that returns the maximum value of all the keys in a binary
    //     tree. Assume all values are nonnegative; return -1 if the tree is empty.
    public int maxNum() {
        if(isEmpty()) return -1;
        return maxNum(root);
    }
    private int maxNum(Node node) {
        while (node.right != null) node = node.right;
        return node.data;
    }
    public boolean add(Integer elem) {

        if (has(elem)) {
            return false;
        }
        else {
            root = add(root, elem);
            nodes++;
            return true;
        }
    }

    private Node add(Node node, Integer data) {
        if (node == null) {
            node = new Node(null, null, data);
        } else {
            if (data.compareTo(node.data) < 0) {
                node.left = add(node.left, data);
            } else {
                node.right = add(node.right, data);
            }
        }
        return node;
    }

    public boolean remove(Integer data) {
        if (has(data)) {
            root = remove(root, data);
            nodes--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, Integer data) {
        if (node == null) return null;
        int comparer = data.compareTo(node.data);
        if (comparer < 0) {
            node.left = remove(node.left, data);
        }
        else if (comparer > 0) {
            node.right = remove(node.right, data);
        }
        else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node tmp = digMin(node.right);
                node.data = tmp.data;
                node.right = remove(node.right, tmp.data);
            }
        }
        return node;
    }

    public int minNum() {
        if(isEmpty()) return -1;
        return minNum(root);
    }

    private int minNum(Node node) {
        while (node.left != null) node = node.left;
        return node.data;
    }

    private Node digMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public boolean has(Integer data) {
        return has(root, data);
    }

    private boolean has(Node node, Integer data) {
        if (node == null) return false;
        int comparer = data.compareTo(node.data);
        if (comparer < 0) return has(node.left, data);
        else if (comparer > 0) return has(node.right, data);
        else return true;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public void traverse(String order) {
        switch (order) {
            case "PREORDER":
                preOrderTraversal(root);
                break;
            case "INORDER":
                inOrderTraversal(root);
                break;
            case "POSTORDER":
                postOrderTraversal(root);
                break;
        }
    }

    private void preOrderTraversal(Node node) {

        if (node == null) return;
        System.out.println(node.data);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    private void inOrderTraversal(Node node) {

        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.println(node.data);
        inOrderTraversal(node.right);
    }

    private void postOrderTraversal(Node node) {
        if (node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.data);
    }
}