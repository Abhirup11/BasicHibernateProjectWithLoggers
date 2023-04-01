package com.hibernate.demo.Application;

import java.io.IOException;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hibernate.demo.Application.entity.Users;
import com.hibernate.demo.Application.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
	public static Logger logger=LoggerFactory.getLogger(App.class.getName());
    public static void main( String[] args )throws IOException
    {
        logger.info("Welcome to demo Hibernate Application ! \n");
      //Create the student object.
        Users user = new Users(1,"Vivek","vivek@123",new Date(),"Jai",null,null);
 
		
    	Transaction tx = null;
    	//Get the session object.
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	try{
              //Start hibernate session.
    	      tx = session.beginTransaction();
    	      logger.info("Begin Transaction Started "+tx+"\n");
 
              //Insert a new student record in the database.
    	      logger.info("Saving User....\n");
    	      session.save(user); 
 
              //Commit hibernate transaction if no exception occurs.
    	      logger.info("Comitting User....\n");
    	      tx.commit();
    	      logger.info("Saved Successfully.");
    	  }catch (HibernateException e) {
    	     if(tx!=null){
                 //Roll back if any exception occurs. 
    	    	 logger.error("Inside Hibernate Exception ... Prompting Rollback....");
    	         tx.rollback();
    	     }
    	     e.printStackTrace(); 
    	  }finally {
             //Close hibernate session.
    		  logger.info("Closing session...");
    	     session.close(); 
    	  }
        
    }
}
