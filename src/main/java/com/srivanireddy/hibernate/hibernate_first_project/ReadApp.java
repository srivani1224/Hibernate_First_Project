package com.srivanireddy.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srivanireddy.entity.Song;
import com.srivanireddy.utils.HibernateUtils;

public class ReadApp {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		
		if(sessionFactory != null)
    	{
			Session session = sessionFactory.openSession();
			
			//can use get or load method
			Song song = session.get(Song.class, 1);
			
			Song song1 = session.load(Song.class, 1);
			
			System.out.println(song.toString());
			System.out.println(song1.toString());
			session.close();
    	}
	}

}
