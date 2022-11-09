package com.srivanireddy.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srivanireddy.entity.Song;
import com.srivanireddy.utils.HibernateUtils;

public class DeleteApp {

public static void main(String[] args) {
		
		//id-2 row has to be deleted
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		
		
		if(sessionFactory != null)
    	{
			Session session = sessionFactory.openSession();
			
			Song song = session.load(Song.class, 2);
			
			session.beginTransaction();
			session.delete(song);
			session.getTransaction().commit();
			
			session.close();
    	}

	}


}
