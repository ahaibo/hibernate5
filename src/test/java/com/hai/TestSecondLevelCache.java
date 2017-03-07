package com.hai;

import com.hai.model.Address1;
import com.hai.model.Person1;
import org.hibernate.CacheMode;
import org.hibernate.stat.Statistics;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by as on 2017/3/1.
 */
public class TestSecondLevelCache extends TestBaseClass {

    @Test
    public void test() {
        Person1 person1 = new Person1("zhangsan");

        List<Address1> list = new ArrayList<Address1>();
        list.add(new Address1("street1", "000001"));
        list.add(new Address1("street3", "000003"));
        list.add(new Address1("street2", "000002"));

        person1.setAddresses(list);

        //设置缓存模式
        session.setCacheMode(CacheMode.NORMAL);
        Statistics statistics = sessionFactory.getStatistics();
        statistics.setStatisticsEnabled(true);

        Integer id = (Integer) session.save(person1);
        tx.commit();
        session.evict(person1);

        Person1 p1 = session.get(Person1.class, id);
        assertThat(statistics.getSecondLevelCachePutCount(), is(1L));
        session.evict(p1);

        session.get(Person1.class, id);
        assertThat(statistics.getSecondLevelCacheHitCount(), is(1L));
    }
}
