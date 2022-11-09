package com.srivanireddy.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srivanireddy.entity.Song;

public class UpdateApp {

	public static void main(String[] args) {
		
		//id-1 song name has to be update to TELUSA TELUSA
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Song.class);
		
		SessionFactory buildSessionFactory = configuration.buildSessionFactory();
		
		Session session = buildSessionFactory.openSession();
		
		
		/*  In this way the singer will be set to null as i am creating a new object
		 	
			Song song = new Song();
			song.setId(1);
			song.setName("TELUSA TELUSA");
			
			session.beginTransaction();
			session.update(song);
			session.getTransaction().commit();
		
		*/
		
		
		
		// So instead of creating a new object as above load the object from db and update the column val you want to 
		Song song = session.load(Song.class, 1);
		song.setName("TELUSA TELUSA");
		
		session.beginTransaction();
		session.update(song);
		session.getTransaction().commit();
		
		session.close();

	}

}
