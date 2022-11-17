package com.srivanireddy.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srivanireddy.entity.Laptop;
import com.srivanireddy.entity.Song;
import com.srivanireddy.entity.Student;

public class HibernateUtils {

	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory() {
		
		try 
		{
			if(sessionFactory == null)
			{
				
				//create configuration
		    	Configuration configuration = new Configuration();
		    	
		    	// if file name is hibernate.cfg.xml can directly write configuration.configure() else 
		    	// need to specify file name in configure function ex : configuration.configure("myhibernate.cfg.xml");
		    	configuration.configure();
		    	configuration.addAnnotatedClass(Song.class);
		    	configuration.addAnnotatedClass(Student.class);
		    	configuration.addAnnotatedClass(Laptop.class);
		    	
		    	//create session factory
		    	sessionFactory = configuration.buildSessionFactory();
		    	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Problem with creating SessionFactory object");
		}
    	
		return sessionFactory;
		
	}
}
