package com.example.demo.service;

import java.util.Collection;

import com.example.demo.model.Student;

public interface StudentService {
	public Collection<Student> displayAllStudent();
	public Student createStudent(Student student);

}
