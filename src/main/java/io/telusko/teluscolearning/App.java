package io.telusko.teluscolearning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
        Alien telusko = new Alien();
        telusko.setAid(103);
        telusko.setAname("sheetal");
        telusko.setColor("black");

        Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class);

        StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        telusko = (Alien) session.get(Alien.class, 101);
//        session.save(telusko);
//        tx.commit();
        System.out.println(telusko);
    }
}
