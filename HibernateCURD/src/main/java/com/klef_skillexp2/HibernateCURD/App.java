
package com.klef_skillexp2.HibernateCURD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // CREATE
        Student s = new Student(2,"Rahul","Java");
        session.save(s);

        // READ
        Student st = session.get(Student.class,1);
        System.out.println("Student Name: " + st.getName());

        // UPDATE
        st.setCourse("Spring Boot");
        session.update(st);

        // DELETE (optional)
        // session.delete(st);

        tx.commit();

        session.close();
        factory.close();
    }
}
