package com.srivanireddy.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srivanireddy.entity.Song;
import com.srivanireddy.utils.HibernateUtils;

public class UpdateAppPersistenceContext {

	public static void main(String[] args) {
		
		//id-1 song name has to be update to TELUSA TELUSA
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		
		if(sessionFactory != null)
    	{
			Session session = sessionFactory.openSession();
			
			
			/*  In this way the singer will be set to null as i am creating a new object
			 	
				Song song = new Song();
				song.setId(1);
				song.setName("TELUSA TELUSA");
				
				session.beginTransaction();
				session.update(song);
				session.getTransaction().commit();
			
			*/
			
			
			
			// So instead of creating a new object as above load the object from db and update the column val you want to 
			Song song = session.get(Song.class, 1);
			
			session.beginTransaction();
			
			// Without update statement (session.update(song);) the song name will be updated in the database. this is because when we load
			// song-row-1 from db the object is in persistence state. the copy of it song is created outside session. changes are made
			// to copy object. when we commit transaction it will push changes to db. before pushing hibernate performs dirty checking
			/// if object inside session and copy object are different the changes are reflected to other object and pushed to db.
			// hence update query is automatically fired. if object inside session and copy object are same update query is not fired.
			song.setName("Telusa Telusa");
			session.getTransaction().commit();
			
			
			session.beginTransaction();
						
			// Even setName() is called multiple times the comparison b/w object inside session and copy object is done only once
			// when we commit transaction so update query is fired only once not multiple times.
			song.setName("abcd");
			song.setName("ab");
			song.setName("TELUSA TELUSA");
			
			session.getTransaction().commit();
			
			session.close();
		}

	}

}
