package com.spartaglobal.sorters;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class BinaryTree {
    private static Logger logger = Logger.getLogger("Sorting Application");
    private ArrayList<Integer> sortedArray = new ArrayList<>();
    private Node root;

    class Node {
        private int data;
        private Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Constructor
    BinaryTree() {
        root = null;
    }

    // This method mainly calls insertRec()
    public void insert(int data) {
        logger.debug("Inserting a value into a node");
        root = insertRec(root, data);
    }

    /* A recursive function to
       insert a new key in BST */
    public Node insertRec(Node root, int data) {

        /* If the tree is empty,
           return a new node */
        if (root == null) {
            logger.debug("Creating a new node for the binary tree");
            root = new Node(data);
            return root;
        }

        /* Otherwise, recur down the tree */
        logger.debug("Comparing node contents to determine optimal branch [Binary Tree]");

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        // return the (unchanged) node pointer
        return root;
    }

    // This method mainly calls InorderRec()
    public int[] inorder() {
        inorderRec(root);
        return sortedArray.stream().mapToInt(i -> i).toArray();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            logger.debug("Writing node value to ArrayList");
            sortedArray.add(root.data);
            inorderRec(root.right);
        }
    }
}
