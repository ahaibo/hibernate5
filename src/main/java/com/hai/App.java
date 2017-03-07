package com.hai;

import com.hai.util.HibernateUtil;
import org.hibernate.SessionFactory;

/**
 * Created by as on 2017/3/1.
 */
public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        } finally {
            if (null != sessionFactory) {
                sessionFactory.close();
            }

        }
    }
}
