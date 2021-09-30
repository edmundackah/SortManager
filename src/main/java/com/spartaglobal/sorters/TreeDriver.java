package com.spartaglobal.sorters;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TreeDriver implements Sortable {
    private BinaryTree binaryTree = new BinaryTree();
    private static Logger logger = Logger.getLogger("Sorting Application");

    @Override
    public int[] sort(int[] arr) {
        logger.debug("Building Binary Tree");
        for (int x : arr) {
            binaryTree.insert(x);
        }

        logger.debug("Returning tree nodes values");
        return binaryTree.inorder();
    }
}
