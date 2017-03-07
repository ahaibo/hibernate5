package com.hai.model;

import javax.persistence.*;

/**
 * Created by as on 2017/3/1.
 */
@Entity
@Table(name = "batch_operation_class")
public class BatchOperationClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String val;

    public BatchOperationClass() {
    }

    public BatchOperationClass(String val) {
        this.val = val;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
