package com.hai.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by as on 2017/3/1.
 */
@Entity
public class Address2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String zipcode;

    @ManyToMany
    @JoinTable(
            name = "person2_address2_table",
            joinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "person2_id", referencedColumnName = "id")
    )
    private List<Person2> person2s;

    public Address2() {
    }

    public Address2(String street, String zipcode, List<Person2> person2s) {
        this.street = street;
        this.zipcode = zipcode;
        this.person2s = person2s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public List<Person2> getPerson2s() {
        return person2s;
    }

    public void setPerson2s(List<Person2> person2s) {
        this.person2s = person2s;
    }
}
