package com.hai.util;

import com.hai.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by as on 2017/2/28.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (null == sessionFactory) {
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            Metadata metadata = new MetadataSources(serviceRegistry)
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Employee2.class)
                    .addAnnotatedClass(Person1.class)
                    .addAnnotatedClass(Address1.class)
                    .addAnnotatedClass(Person2.class)
                    .addAnnotatedClass(Address2.class)
                    .addAnnotatedClass(BatchOperationClass.class)
                    .buildMetadata();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        }
        return sessionFactory;
    }

    public static void closeSession(Session session) {
        if (null != session) {
            session.close();
        }
        if (null != sessionFactory) {
            sessionFactory.close();
        }
    }
}
