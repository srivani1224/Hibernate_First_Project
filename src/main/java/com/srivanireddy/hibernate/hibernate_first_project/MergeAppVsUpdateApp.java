package com.srivanireddy.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srivanireddy.entity.Song;
import com.srivanireddy.utils.HibernateUtils;

public class MergeAppVsUpdateApp {

	public static void main(String[] args) {
		
		//id-1 song name has to be update to TELUSA TELUSA
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		
		if(sessionFactory != null)
    	{			
			/*  In this way the singer will be set to null as i am creating a new object
			 	
				Song song = new Song();
				song.setId(1);
				song.setName("TELUSA TELUSA");
				
				session.beginTransaction();
				session.update(song);
				session.getTransaction().commit();
			
			*/
			
			
			
			// So instead of creating a new object as above load the object from db and update the column val you want to 
		
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Song song = session.get(Song.class, 1); //TELUSA TELUSA
			session.getTransaction().commit();
			session.close();
			
			song.setName("Telusa Telusa");
			
			Session newSession = sessionFactory.openSession();
			newSession.beginTransaction();
			Song song2 = newSession.get(Song.class, 1); //TELUSA TELUSA
			
			// Now there are two objects of song-row-1 in newSession they are song and song2 both of them have same primary keys 
			// but songNames are different so if we use update query it is confused taht which object has to be pushed to db
			// so merge() will handle this situation
			// if update is used following exception occurs [ org.hibernate.NonUniqueObjectException: A different object with the same identifier value was already associated with the session ]
			newSession.merge(song); 
			
			newSession.getTransaction().commit();
			newSession.close();
		}

	}

}
