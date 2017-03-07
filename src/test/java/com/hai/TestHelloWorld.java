package com.hai;

import com.hai.comparator.SortComponentComparator;
import com.hai.component.Phone;
import com.hai.component.Project;
import com.hai.component.SortComponent;
import com.hai.model.Employee;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by as on 2017/3/1.
 */
public class TestHelloWorld extends TestBaseClass {


    @Test
    public void testAddEmployee() {
        Employee employee = new Employee(20, "zhangsan2");

        Set<String> phones = new HashSet<String>();
        phones.add("13000000000");
        phones.add("13000000001");
        employee.setPhones(phones);

        Integer id = (Integer) session.save(employee);
        session.flush();
        session.clear();

        Employee employee1 = session.get(Employee.class, 1);

        assertThat(employee1, notNullValue());
        assertThat(employee1.getName(), is("zhangsan2"));
    }

    @Test
    public void testEmbeddedSet() {
        Employee employee = new Employee(20, "zhangsan3");

        Set<Phone> phones = new HashSet<Phone>();
        phones.add(Phone.newInstance("1", "13000000000"));
        phones.add(Phone.newInstance("2", "13000000001"));
        employee.setPhones2(phones);

        Integer id = (Integer) session.save(employee);
        session.flush();
        session.clear();

        Employee employee1 = session.get(Employee.class, id);

        assertThat(employee1, notNullValue());
        assertThat(employee1.getName(), is("zhangsan3"));
    }

    @Test
    public void testBasicList() {
        Employee employee = new Employee(22, "lisi1");

        employee.getPhoneList().add("111");
        employee.getPhoneList().add("333");
        employee.getPhoneList().add("222");

        Integer id = (Integer) session.save(employee);

        session.flush();
        session.clear();

        Employee employee1 = session.get(Employee.class, id);

        assertThat(employee1, notNullValue());
        assertThat(employee.getPhoneList().get(1), is("333"));
    }

    @Test
    public void testProjectFloatMap() {
        Employee employee = new Employee(22, "lisi2");

        Map<Project, Float> map = new HashMap<Project, Float>();
        map.put(new Project("aaa"), 1.1F);
        map.put(new Project("bbb"), 1.2F);

        employee.setProjectFloatMap(map);

        Integer id = (Integer) session.save(employee);

        session.flush();
        session.clear();

        Employee employee1 = session.get(Employee.class, id);

        assertThat(employee1, notNullValue());
    }

    @Test
    public void testSortedSet() {
        Employee employee = new Employee(22, "lisi3");

        SortedSet<SortComponent> set = new TreeSet<SortComponent>(new SortComponentComparator());
        set.add(new SortComponent(2));
        set.add(new SortComponent(1));
        set.add(new SortComponent(3));

        employee.setSortedSet(set);

        Integer id = (Integer) session.save(employee);

        session.flush();
        session.clear();

        Employee employee1 = session.get(Employee.class, id);

        assertThat(employee1, notNullValue());
    }
}
