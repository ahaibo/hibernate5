package com.hai.comparator;

import com.hai.component.SortComponent;

import java.util.Comparator;

/**
 * Created by as on 2017/3/1.
 */
public class SortComponentComparator implements Comparator<SortComponent> {
    public int compare(SortComponent o1, SortComponent o2) {
        return o1.getVal() - o2.getVal();
    }
}
