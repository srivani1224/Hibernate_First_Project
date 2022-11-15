package com.srivanireddy.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srivanireddy.entity.Song;
import com.srivanireddy.utils.HibernateUtils;

public class UpdateApp {

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
			song.setName("TELUSA TELUSA");
			
			session.beginTransaction();
			session.update(song);
			session.getTransaction().commit();
			
			session.close();
		}

	}

}
