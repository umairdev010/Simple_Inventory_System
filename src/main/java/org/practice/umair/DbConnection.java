package org.practice.umair;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConnection {

    public static Session getSession(){

        try {

            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

            return sessionFactory.openSession();

        } catch (Exception e) {
            System.out.println("ERROR OCCURED WHILE CONNECTING DB : " + e);
            return null;
        }

    }

}
