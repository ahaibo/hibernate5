package com.hai.model;

import com.hai.comparator.SortComponentComparator;
import com.hai.component.Phone;
import com.hai.component.Project;
import com.hai.component.SortComponent;
import org.hibernate.annotations.SortComparator;

import javax.persistence.*;
import java.util.*;

/**
 * Created by as on 2017/2/28.
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private String name;
    @ElementCollection
    @CollectionTable(name = "phones", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "employee_phone")
    private Set<String> phones = new HashSet<String>();

    @ElementCollection
    @CollectionTable(name = "phones_embedded", joinColumns = @JoinColumn(name = "employee_id"))
    @AttributeOverrides({@AttributeOverride(name = "phoneType", column = @Column(name = "phone_type")), @AttributeOverride(name = "phoenNumber", column = @Column(name = "phoen_number"))})
    private Set<Phone> phones2 = new HashSet<Phone>();

    @ElementCollection
    @CollectionTable(name = "phone_list_basic_indexed", joinColumns = @JoinColumn(name = "employee_id"))
    @OrderColumn(name = "phone_order")//新增一列
    @Column(name = "phone")
    private List<String> phoneList = new ArrayList<String>();

    @ElementCollection
    @CollectionTable(name = "phone_list_basic_ordered", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "phone")
    @OrderBy//查询时自动按phone排序
    private List<String> phoneList2 = new ArrayList<String>();

    @ElementCollection
    @CollectionTable(name = "phone_list_embedded_indexed", joinColumns = @JoinColumn(name = "employee_id"))
    @AttributeOverrides({@AttributeOverride(name = "phoneType", column = @Column(name = "phone_type")), @AttributeOverride(name = "phoenNumber", column = @Column(name = "phoen_number"))})
    @OrderColumn(name = "phone_order")
    private List<Phone> phoneList3 = new ArrayList<Phone>();

    //basic key and basic value map
    @ElementCollection
    @CollectionTable(name = "base_map", joinColumns = @JoinColumn(name = "employee_id"))
    @MapKeyColumn(name = "map_key")
    @Column(name = "map_value")
    private Map<String, String> baseMap = new HashMap<String, String>();


    @ElementCollection
    @CollectionTable(name = "phone_map", joinColumns = @JoinColumn(name = "employee_id"))
    @MapKeyColumn(name = "phone_key")
    private Map<String, Phone> phoneMap = new HashMap<String, Phone>();


    @ElementCollection
    @CollectionTable(name = "project_float_map", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "project_float_map")
    private Map<Project, Float> projectFloatMap = new HashMap<Project, Float>();

    /*有序集合练习：@SortComparator*/
    @ElementCollection
    @CollectionTable(name = "sorted_set", joinColumns = @JoinColumn(name = "employee_id"))
    @SortComparator(SortComponentComparator.class)
    private SortedSet<SortComponent> sortedSet = new TreeSet<SortComponent>();

    public Employee() {
    }

    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Employee(int id, int age, String name) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public Set<Phone> getPhones2() {
        return phones2;
    }

    public void setPhones2(Set<Phone> phones2) {
        this.phones2 = phones2;
    }

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }

    public List<String> getPhoneList2() {
        return phoneList2;
    }

    public void setPhoneList2(List<String> phoneList2) {
        this.phoneList2 = phoneList2;
    }

    public List<Phone> getPhoneList3() {
        return phoneList3;
    }

    public void setPhoneList3(List<Phone> phoneList3) {
        this.phoneList3 = phoneList3;
    }

    public Map<String, String> getBaseMap() {
        return baseMap;
    }

    public void setBaseMap(Map<String, String> baseMap) {
        this.baseMap = baseMap;
    }

    public Map<String, Phone> getPhoneMap() {
        return phoneMap;
    }

    public void setPhoneMap(Map<String, Phone> phoneMap) {
        this.phoneMap = phoneMap;
    }

    public Map<Project, Float> getProjectFloatMap() {
        return projectFloatMap;
    }

    public void setProjectFloatMap(Map<Project, Float> projectFloatMap) {
        this.projectFloatMap = projectFloatMap;
    }

    public SortedSet<SortComponent> getSortedSet() {
        return sortedSet;
    }

    public void setSortedSet(SortedSet<SortComponent> sortedSet) {
        this.sortedSet = sortedSet;
    }
}
