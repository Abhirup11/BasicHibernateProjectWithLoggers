package com.hibernate.demo.Application.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	

	private static SessionFactory buildSessionFactory() {
		Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
		logger.info("Inside buildSessionFactory ...");
		SessionFactory sessionFactory = null;
		Configuration configuration = new Configuration();
		try {
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
			logger.info("SessionFactory Object Created: "+sessionFactory);
			
		} catch (Exception e) {
			logger.error("Could not execute buildSessionFactory ...");
			e.printStackTrace();
		}
		logger.info("returning buildSessionFactory ...");
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}