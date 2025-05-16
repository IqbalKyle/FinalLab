package org.team2.FinalLab;

import java.util.Map;

//Binary search tree untuk menyimpan urutan ID  
public class bst {
    private class Node {
        int key;
        Node left, right;
        Node(int k) { key = k; }
    }
    private Node root;

    // Insert key baru
    public void insert(int key) {
        root = insertRec(root, key);
    }
    private Node insertRec(Node node, int key) {
        if (node == null) return new Node(key);
        if (key < node.key) node.left = insertRec(node.left, key);
        else if (key > node.key) node.right = insertRec(node.right, key);
        return node;
    }

    // Cari key
    public boolean search(int key) {
        return searchRec(root, key);
    }
    private boolean searchRec(Node node, int key) {
        if (node == null) return false;
        if (key == node.key) return true;
        return key < node.key ? searchRec(node.left, key) : searchRec(node.right, key);
    }

    // Hapus key
    public void delete(int key) {
        root = deleteRec(root, key);
    }
    private Node deleteRec(Node node, int key) {
        if (node == null) return null;
        if (key < node.key) node.left = deleteRec(node.left, key);
        else if (key > node.key) node.right = deleteRec(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node succ = minNode(node.right);
            node.key = succ.key;
            node.right = deleteRec(node.right, succ.key);
        }
        return node;
    }
    private Node minNode(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    //Traversal inorder untuk menampilkan kontak yang berurutan
    public void inorderPrint(Map<Integer, String> map) {
        inorderRec(root, map);
        System.out.println();
    }
    private void inorderRec(Node node, Map<Integer, String> map) {
        if (node == null) return;
        inorderRec(node.left, map);
        String name = map.get(node.key);
        System.out.println("ID: " + node.key + " - Name: " + (name != null ? name : "<no name>"));
        inorderRec(node.right, map);
    }
}
