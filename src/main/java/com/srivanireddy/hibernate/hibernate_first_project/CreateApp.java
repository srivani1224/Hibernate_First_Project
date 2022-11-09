package com.srivanireddy.hibernate.hibernate_first_project;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srivanireddy.entity.Song;
import com.srivanireddy.utils.HibernateUtils;

public class CreateApp 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    	
    	
    	if(sessionFactory != null)
    	{
	    	//initialize the session object
	    	Session session = sessionFactory.openSession();
	    	
	        Song song_1 = new Song();
	        song_1.setId(1);
	        song_1.setName("Telusa Telusa");
	        song_1.setSinger("Revanth");
	        
	        session.beginTransaction();
	        session.save(song_1);
	        session.getTransaction().commit();
	        
	        System.out.println("Song saved... Check db...");
	        
	        session.close();
    	}
    }

}
