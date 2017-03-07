package com.hai;

import com.hai.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Created by as on 2017/3/1.
 */
public class TestBaseClass {
    protected static SessionFactory sessionFactory;
    protected static Session session;
    protected Transaction tx;

    @BeforeClass
    public static void beforeClass() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Before
    public void before() {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }

    @After
    public void after() {
        session.close();
    }

    @AfterClass
    public static void teardown() {
        sessionFactory.close();
    }

}
