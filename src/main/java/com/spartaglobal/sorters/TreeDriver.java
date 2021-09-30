package com.spartaglobal.sorters;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TreeDriver implements Sortable {
    private BinaryTree binaryTree = new BinaryTree();

    @Override
    public int[] sort(int[] arr) {
        for (int x : arr) {
            binaryTree.insert(x);
        }

        return binaryTree.inorder();
    }
}
