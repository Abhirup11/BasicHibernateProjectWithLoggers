package com.hibernate.demo.Application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hibernate.demo.Application.entity.embedable.Certificate;
import com.hibernate.demo.Application.entity.embedable.Student;

public class AppForEmbedable {
	public static Logger logger=LoggerFactory.getLogger(AppForEmbedable.class.getName());

	public static void main(String[] args) {
		/*
		 * Configuration configuration = new Configuration(); SessionFactory factory =
		 * configuration.configure("hibernate.cfg.xml").buildSessionFactory(); Session
		 * session = factory.openSession(); factory.close();
		 */
		
		Certificate certificate=new Certificate(1254, "AWS practioner associate");
		Student student=new Student(1,"Abhirup Chatterjee",certificate);
		System.out.println(student);
		
		logger.info("Creating the Configuration...");
		Configuration configuration = new Configuration();
		logger.info("initializing the configuration object...");
		configuration.configure("hibernate.cfg.xml");
		logger.info("building session factory...");
		SessionFactory factory= configuration.buildSessionFactory();
		logger.info("opening session...");
		Session session = factory.openSession();
		logger.info("begining transaction...");
		Transaction tx = session.beginTransaction();
		logger.info("Saving entity to db...");
		session.save(student);
		logger.info("Comiting the transaction...");
		tx.commit();
		logger.info("Closing session...");
		session.close();
		logger.info("Closing session factory...");
		factory.close();
		
	}
}
