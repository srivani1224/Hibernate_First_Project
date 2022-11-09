package com.srivanireddy.hibernate.hibernate_first_project;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srivanireddy.entity.Song;

/**
 * Hello world!
 *
 */
public class CreateApp 
{
    public static void main( String[] args )
    {
    	//create configuration
    	Configuration configuration = new Configuration();
    	
    	// if file name is hibernate.cfg.xml can directly write configuration.configure() else 
    	// need to specify file name in configure function ex : configuration.configure("myhibernate.cfg.xml");
    	configuration.configure();
    	configuration.addAnnotatedClass(Song.class);
    	
    	//create session factory
    	SessionFactory buildSessionFactory = configuration.buildSessionFactory();
    	
    	//initialize the session object
    	Session session = buildSessionFactory.openSession();
    	
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
