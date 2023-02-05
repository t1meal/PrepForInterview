package ru.gb.lesson_5.utils;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class Factory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        return sessionFactory;

    }
}
