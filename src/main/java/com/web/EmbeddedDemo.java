package com.web;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.web.model.Certificate;
import com.web.model.Student;

public class EmbeddedDemo {

	public static void main(String[] args) {
		
		System.out.println( "Project Started...!" );
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml"); //no need to add filename or path(optional)
        
        //to do operations on data we need to use sessionfactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        Student student1 = new Student();
        student1.setId(100);
        student1.setName("Dedeepya");
        student1.setCity("Tenali");
        
        Certificate certificate = new Certificate();
        certificate.setCourse("CSE");
        certificate.setDuration("1 year");
        
        student1.setCertificate(certificate);
        
        session.persist(student1);
        tx.commit();
        session.close();
        sessionFactory.close();
	}
}
