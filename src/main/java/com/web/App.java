package com.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.web.model.Address;
import com.web.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Project Started...!" );
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml"); //no need to add filename or path(optional)
        
        //to do operations on data we need to use sessionfactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        
        Student student1 = new Student(101,"Dedeepya","Tenali");
        Address address = new Address();
        address.setCity("Tenali");
        address.setStreet("Old Society");
        address.setOpen(true);
        address.setX(1245.567);
        address.setAddedDate(new Date());
        
        //Reading image
        FileInputStream fis = new FileInputStream("src/main/java/download.jpg");
        byte[] data = new byte[fis.available()];
        System.out.println(data.length);
        fis.read(data);
        address.setImage(data);
        
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        //save function is deprecated now we use persist to save data to db
        session.persist(student1);
        session.persist(address);
        
        tx.commit();
        //get returns null if data not found in db
        //load throws exception if data not found in db now it is deprecated
        Student dbstud = (Student)session.get(Student.class, 101);
        Address dbadd = (Address)session.get(Address.class, 1);
        
        System.out.println(dbstud.toString());
        System.out.println(dbadd.getCity());
        
        session.clear();
        sessionFactory.close();
//        sessionFactory.getCurrentSession();
    }
}
