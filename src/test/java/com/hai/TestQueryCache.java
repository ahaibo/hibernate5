package com.hai;

import com.hai.model.Person1;
import org.hibernate.CacheMode;
import org.hibernate.query.Query;
import org.hibernate.stat.Statistics;
import org.junit.Test;

import javax.persistence.LockModeType;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by as on 2017/3/1.
 */
public class TestQueryCache extends TestBaseClass {

    @Test
    public void test() {

        String hql = "from Person1 where name like :name";
        Query query = session.createQuery(hql, Person1.class);
        query.setParameter("name", "zhangsan%");
        query.setLockMode(LockModeType.PESSIMISTIC_WRITE);

        //开启查询缓存
        query.setCacheable(true);

        //指定查询缓存策略
        query.setCacheRegion("myQueryCacheRegion");

        //查询
        List<Person1> list = query.list();

        for (Person1 p : list) {
            System.out.println(p);
        }

        tx.commit();
    }
}
