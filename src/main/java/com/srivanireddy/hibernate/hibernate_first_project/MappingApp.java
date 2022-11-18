package com.srivanireddy.hibernate.hibernate_first_project;

import java.util.ArrayList;
import java.util.List;

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
	        
	        
	        List<Laptop> laptopList = new ArrayList<>();
	        
	    	Laptop laptop1 = new Laptop();
	    	laptop1.setLaptopId(106);
	    	laptop1.setLaptopName("lap-3");
	    	
	    	Laptop laptop2 = new Laptop();
	    	laptop2.setLaptopId(107);
	    	laptop2.setLaptopName("lap-4");
	    	
	        Student student = new Student();
	        student.setStudentId(3);
	        student.setStudentName("Harish");
	        student.setStudentMarks(90);
	        
	    	laptopList.add(laptop1);
	    	laptopList.add(laptop2);
	        student.setLaptop(laptopList);

	    	session.save(laptop1);
	    	session.save(laptop2);
	        session.save(student);
	        
	        session.getTransaction().commit();   
	        session.close();
    	}

    }
}
