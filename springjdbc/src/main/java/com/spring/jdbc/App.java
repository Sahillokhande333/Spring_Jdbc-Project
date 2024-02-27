package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("program started");
		
	
		ApplicationContext context =new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
//		
//	    JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
//		// insert Query
//	  String query="insert into student(id,name,city) values(?,?,?)";
//	int result=template.update(query,2,"sudatt","mumbai");
//		System.out.println("data of students:" + result);
//		
		StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
//		INSERT
//		Student student =new Student();
//		student.setId(25);
//		
//		student.setName("manish");
//		
//		student.setCity("gujrat");
//			
//		int result=studentDao.insert(student);
//		System.out.println("data of students added:" + result);
		
		
		//UPDATE
//		Student student=new Student();
//		student.setId(7);
//		student.setName("Shri");
//		student.setCity("pune");
//		int result=studentDao.change(student);
//		System.out.println("data of students updated:" + result);
//		
		
		//DELETE
//		int result=studentDao.delete(7);
//		System.out.println("data of students updated after delete:" + result);
		
		//System.out.println(student);
//		Student student = studentDao.getStudent(2);
//		
//		
		
		List<Student> student=studentDao.getAllStudents(); 
		for(Student s:student)
		{
			System.out.println(s);
		}
		
		
	}

}
