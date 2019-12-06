/*
 * Copyright (C) 2019 Stefan Nyffenegger
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package main.java.ch.wimf.user;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.cfg.Configuration;

/**
 * User Data Access Object
 *
 * @author Stefan Nyffenegger
 */
public class UserDao {

    static Session sessionObj;
    static SessionFactory sessionFactoryObj;
    
    public final static Logger logger = Logger.getLogger(UserDao.class);

    /**
     * 
     * @param u
     * @return 
     */
    @Deprecated
    public static int register(User u) {
        int i = 0;

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        i = (Integer) session.save(u);

        t.commit();
        session.close();

        return i;
    }

    /**
     * Create Hibernate SessionFactory Object
     * @return 
     */
    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");

        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }

    /**
     * Display users
     * @return List with users
     */
    public static List getUsers() {
        List usersList = new ArrayList();
        try {
            // Getting Session Object From SessionFactory
            sessionObj = buildSessionFactory().openSession();
            // Transaction Object From Session Object
            sessionObj.beginTransaction();

            usersList = sessionObj.createQuery("FROM main.java.ch.wimf.user.User").list();
        } catch (HibernateException sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\nTransaction Is Being Rolled Back...\n");
                sessionObj.getTransaction().rollback();
            }
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return usersList;
    }
}
