package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entity.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;
	

	public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public StudentDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int insert(Student student) {
		// insert Query
				String query="insert into student(id,name,city) values(?,?,?)";
				int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	
	@Override
	public int change(Student student) {
		String query="update student set name=?,city=? 	where id=?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}
	

	@Override
	public int delete(int studentId) {
		String query="delete from student where id=?";
		int r = this.jdbcTemplate.update(query,studentId);
		return r;
	}
	

	@Override
	public Student getStudent(int studentId) {
		
		// select single student
		String query="select * from student where id=?";
		RowMapper<Student>rowMapper=new RowmapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return student;
	}
	

	@Override
	public List<Student> getAllStudents() {
		//select multiple student
		String query="select * from student";
		 List<Student> student = this.jdbcTemplate.query(query,new RowmapperImpl());
		return student;
	}



	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	
	
	
	

}
