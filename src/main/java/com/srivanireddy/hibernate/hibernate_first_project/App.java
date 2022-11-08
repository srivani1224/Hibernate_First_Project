package com.srivanireddy.hibernate.hibernate_first_project;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//create configuration
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
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
