package com.spartaglobal.sorters;

import java.util.ArrayList;

public class BinarySearchTree implements Sortable {
    private Node node;
    private ArrayList<Integer> sortedNumbers = new ArrayList<>();

    @Override
    public int[] sort(int[] arr) {

        for (int x : arr) {
            node = insert(x);
        }
        getSortedNumbers(node);

        return sortedNumbers.stream().mapToInt(i -> i).toArray();
    }

    private void getSortedNumbers(Node node) {
        if(node != null) {
            getSortedNumbers(node.left);
            sortedNumbers.add(node.number);
            getSortedNumbers(node.right);
        }
    }

    private Node insert(int number) {
        if (node == null) {
            node = new Node(number);
        }

        if (number < node.number) {
            node.left = insert(number);
        }

        else if (number > node.number) {
            node.right = insert(number);
        }
        return node;
    }

    private class Node {
        private int number;
        private Node left, right;

        public Node(int number) {
            super();
            this.number = number;
            this.left = null;
            this.right = null;
        }
    }
}
