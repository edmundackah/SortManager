package com.spartaglobal.testing.controller;

import com.spartaglobal.controller.SortManager;
import com.spartaglobal.view.DisplayManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortManagerTest {

    @Test
    public void GivenAnArrayWithDuplicates_AndBinaryTreeIsSelected_ThrowAnException() {
        final int[] evenTestArray = {45, 7, 1,  0, 5, 1};

        SortManager sortManager = new SortManager(new DisplayManager());

        //Binary Tree is option 4
        sortManager.setAlgoChoice(4);
        sortManager.setArraySize(80);

        Exception exception = Assertions.assertThrows(Exception.class, () -> {sortManager.sortArray();});

        String testString = "\nBinary Tree cannot have duplicate values!\nTerminating sort";
        System.out.println(exception.getMessage());

        assertTrue(testString.equals(exception.getMessage()));
    }
}
