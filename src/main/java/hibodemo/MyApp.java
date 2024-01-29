package hibodemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MyApp {
    public static void main(String[] args) {
        Laptop laptop  = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Dell");

        Student student = new Student();
        student.setName("Naveen");
        student.setRollNo(1);
        student.setMarks(100);
        student.setLaptop(laptop);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sessionFactory = config.buildSessionFactory(registry);
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(laptop);
        session.save(student);


    }
}
