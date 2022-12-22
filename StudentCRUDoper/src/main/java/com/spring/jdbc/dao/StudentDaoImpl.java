package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jt;
	public JdbcTemplate getJt() {
		return jt;
	}
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	
	
	public int insert(Student student) {
		 //insert query
        String query = "insert into student(id,name,city,contactNum,percentage) values(?,?,?,?,?)";
        int r = this.jt.update(query,student.getId(),student.getName(),student.getCity(),student.getContact(),student.getPercentage());
		
		return r;
	}
	public Student getStudent(int sid) {
		
		String sql = "select * from student where id=?";
		RowMapper<Student> rm = new RowMapperImpl();
		Student st = this.jt.queryForObject(sql, rm,sid);
		return st;
	}
	public List<Student> getAllStudent() {
		String sql = "select * from student";
		List<Student> students = this.jt.query(sql, new RowMapperImpl());
		return students;
	}
	
	public int removeStudent(int id) {
		//delete
		String sql = "delete from student where id = ?";
		int r = this.jt.update(sql,id);
		return r;
		
	}
	
	public int update(Student student,int id) {
		 //update query
       String query = "update student "
       		+ "set name=?,city=?,contactNum=?,percentage=? "
       		+ "where id=?";
       int r = this.jt.update(query,student.getName(),student.getCity(),student.getContact(),student.getPercentage(),id);
      
		return r;
	}

}
