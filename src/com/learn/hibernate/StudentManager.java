package com.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class StudentManager {
	private SessionFactory sessionFactory = null;
	
	StudentManager(){
		initSessionFactoru();
	}
	public static void main(String[] args){
		StudentManager smanger = new StudentManager();
		Student s= new Student();
		s.setStudentId(59);
		s.setStudentName("diffent");
		
		smanger.persist(s);
		
		smanger.findStudent(59);
	}
	
	public void initSessionFactoru (){
		
		 sessionFactory= new Configuration().configure().buildSessionFactory(
				    new StandardServiceRegistryBuilder().build() );
	}
	public void persist(Student s){
		
		Session session= sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		session.save(s);
		t.commit();
	}
	
	public void findStudent(int id){
		Session session= sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		Student s=(Student)session.load(Student.class,id);
		System.out.println("Student name :"+s.getStudentName());
	}
}
