package com.example.demo.dao;

import java.util.Collection;

import com.example.demo.model.Student;

public interface StudentDao {
	
	public Collection<Student> displayAllStudent();
	
	public Student createStudent(Student student);
	public Student findStudentById(Integer id) throws Exception;

}
