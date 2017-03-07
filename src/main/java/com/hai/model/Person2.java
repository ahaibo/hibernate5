package com.hai.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by as on 2017/3/1.
 */
@Entity
public class Person2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "person2s")
    private List<Address2> addresses;

    public Person2() {
    }

    public Person2(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address2> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address2> addresses) {
        this.addresses = addresses;
    }
}
