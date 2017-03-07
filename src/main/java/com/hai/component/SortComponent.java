package com.hai.component;

import javax.persistence.Embeddable;

/**
 * Created by as on 2017/3/1.
 */
@Embeddable
public class SortComponent {
    private int val;

    public SortComponent() {
    }

    public SortComponent(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
