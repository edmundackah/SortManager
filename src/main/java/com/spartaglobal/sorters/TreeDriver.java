package com.spartaglobal.sorters;

import com.spartaglobal.controller.SortManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TreeDriver implements Sortable {
    private BinaryTree binaryTree = new BinaryTree();

    private static String className = TreeDriver.class.getCanonicalName();
    private static Logger logger = Logger.getLogger(className);

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
