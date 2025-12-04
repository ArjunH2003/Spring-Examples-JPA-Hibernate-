package com.example.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.StudentBean;



@Repository
public class StudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public String addStudent(StudentBean sb) {
		
		if(sb!=null) {
		Session s = sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		s.persist(sb);
		t.commit();
		s.close();
		
		return "Success";
		}
		
		return "Failed to add";
		
	}
	
	public String updateStudent(StudentBean sb) {
		
		if(sb!=null) {
			
			Session s = sessionFactory.openSession();
			Transaction t =s.beginTransaction();
			
			s.merge(sb);
			t.commit();
			s.close();
			return "Success";
		}
		
		return "Failed to update";
	}
	
	public String deleteStudent(int id) {
		
		Session s = sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		StudentBean sb = s.get(StudentBean.class, id);
		
		if(sb==null) {
			s.close();
			return "Invalid id!";
		}
		
		s.remove(sb);
		t.commit();
		s.close();
		return "deleted succesfully";
		
		
		
	}
	
	public StudentBean findStudentById(int id) {

	    Session s = sessionFactory.openSession();
	    StudentBean sb = s.get(StudentBean.class, id);
	    s.close();

	    return sb;  
	}

	public List<StudentBean> findAllStudents() {

	    Session s = sessionFactory.openSession();
	    
	    List<StudentBean> list = s.createQuery("from StudentBean", StudentBean.class).list();
	    
	    s.close();

	    return list;
	}


}
