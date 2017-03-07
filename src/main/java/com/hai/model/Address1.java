package com.hai.model;

import javax.persistence.*;

/**
 * Created by as on 2017/3/1.
 */
@Entity
public class Address1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String zipcode;

    @ManyToOne
    @JoinColumn(name = "person1_id")
    private Person1 person;

    public Address1() {
    }

    public Address1(String street, String zipcode) {
        this.street = street;
        this.zipcode = zipcode;
    }

    public Address1(String street, String zipcode, Person1 person) {
        this.street = street;
        this.zipcode = zipcode;
        this.person = person;
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

    public Person1 getPerson() {
        return person;
    }

    public void setPerson(Person1 person) {
        this.person = person;
    }
}
