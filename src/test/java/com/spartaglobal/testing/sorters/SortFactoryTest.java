package com.spartaglobal.testing.sorters;

import com.spartaglobal.sorters.BubbleSort;
import com.spartaglobal.sorters.SortFactory;
import com.spartaglobal.sorters.Sortable;
import org.junit.jupiter.api.Test;

import java.beans.Expression;

import static org.junit.jupiter.api.Assertions.*;

public class SortFactoryTest {

    @Test
    public void GivenValueLessThanOne_ShouldReturnNull() {
        assertEquals(null, new SortFactory().getSortable(0));
    }

    @Test
    public void GivenValueGreaterThanFour_ShouldReturnNull() {
        assertEquals(null, new SortFactory().getSortable(5));
    }

    @Test
    public void GivenOne_ShouldReturnTypeSortable() {
        Sortable testObject = new SortFactory().getSortable(1);
        assertEquals(true, testObject instanceof Sortable);
    }

    @Test
    public void GivenTwo_ShouldReturnTypeSortable() {
        Sortable testObject = new SortFactory().getSortable(2);
        assertEquals(true, testObject instanceof Sortable);
    }

    @Test
    public void GivenThree_ShouldReturnTypeSortable() {
        Sortable testObject = new SortFactory().getSortable(3);
        assertEquals(true, testObject instanceof Sortable);
    }

    @Test
    public void GivenFour_ShouldReturnTypeSortable() {
        Sortable testObject = new SortFactory().getSortable(4);
        assertEquals(true, testObject instanceof Sortable);
    }
}
