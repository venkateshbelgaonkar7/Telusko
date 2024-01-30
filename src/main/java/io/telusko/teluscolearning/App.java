package io.telusko.teluscolearning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class App {
    public static void main(String[] args) {
        Alien telusko = new Alien();
        telusko.setAid(101);
        telusko.setAname("sheetal");
        telusko.setColor("black");

        Alien a;

        Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
//        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
        SessionFactory sf = conf.buildSessionFactory(reg);

        Session session1 = sf.openSession();
        session1.beginTransaction();

        a = session1.get(Alien.class, 101);
        System.out.println(a);

        session1.getTransaction().commit();
        session1.close();

//        Session session2 = sf.openSession();
//        session2.beginTransaction();
//
//        a = (Alien) session2.get(Alien.class, 101);
//        System.out.println(a);
//
//        session2.getTransaction().commit();
//        session2.close();


//        telusko = (Alien) session.get(Alien.class, 101);
//        session.save(telusko);
//        tx.commit();
//        System.out.println(telusko);
    }
}
