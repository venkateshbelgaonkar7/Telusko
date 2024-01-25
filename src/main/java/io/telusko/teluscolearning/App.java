package io.telusko.teluscolearning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Alien telusko = new Alien();
        telusko.setAid(101);
        telusko.setAname("Green");
        telusko.setColor("Blue");

        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        session.save(telusko);
        tx.commit();
    }
}
