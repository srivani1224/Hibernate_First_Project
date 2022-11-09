package com.srivanireddy.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srivanireddy.entity.Song;

public class DeleteApp {

public static void main(String[] args) {
		
		//id-1 song name has to be update to TELUSA TELUSA
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Song.class);
		
		SessionFactory buildSessionFactory = configuration.buildSessionFactory();
		
		Session session = buildSessionFactory.openSession();
		
		Song song = session.load(Song.class, 2);
		
		session.beginTransaction();
		session.delete(song);
		session.getTransaction().commit();
		
		session.close();

	}


}
