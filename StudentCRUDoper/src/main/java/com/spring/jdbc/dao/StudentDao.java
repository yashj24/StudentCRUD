package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;

public interface StudentDao {

	public int insert(Student student);
	public Student getStudent(int sid);
	public List<Student> getAllStudent();
	public int removeStudent(int id);
	public int update(Student student,int id);
}
