package com.hai.model;

import com.hai.component.Name;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by as on 2017/2/28.
 */
@Entity
@Table(name = "employee2")
public class Employee2 {

    private int id;
    private int age;
    @EmbeddedId
    private Name name;

    public Employee2() {
    }
    public Employee2(int age, Name name) {
        this.age = age;
        this.name = name;
    }

    public Employee2(int id, int age, Name name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
