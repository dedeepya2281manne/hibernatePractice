package com.web.model.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {

	public static void main(String[] args) {
		
		System.out.println("Project Started");
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
		
        Question question = new Question();
        Answer answer = new Answer();
        
        question.setQuesId(1212);
        question.setQues("What is java? ");
        answer.setAnsId(343);
        answer.setAns("A Programming language");
        question.setAnswer(answer);
        
        session.persist(answer);
        session.persist(question);
        tx.commit();
        
        session.close();
        sessionFactory.close();
	}
}
