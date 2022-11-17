package com.srivanireddy.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.srivanireddy.entity.Laptop;
import com.srivanireddy.entity.Song;
import com.srivanireddy.entity.Student;
import com.srivanireddy.utils.HibernateUtils;

public class MappingApp {

	public static void main( String[] args )
    {
    	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    	
    	
    	if(sessionFactory != null)
    	{
	    	//initialize the session object
	    	Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        
	    	Laptop laptop = new Laptop();
	    	laptop.setLaptopId(103);
	    	laptop.setLaptopName("MacBook");
	    	
	        Student student = new Student();
	        student.setStudentId(3);
	        student.setStudentName("Harish");
	        student.setStudentMarks(30);
	        student.setLaptop(laptop);
	        
	        session.save(student);
	        session.save(laptop);
	        
	        session.getTransaction().commit();   
	        session.close();
    	}

    }
}
