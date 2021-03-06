package com.example.demo.service;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
@EnableAutoConfiguration
@Component
public class StudentServiceImpl implements StudentService{

	
	private StudentDao studentDao;
	
	@Autowired
	public StudentServiceImpl(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}


	@Override
	public Collection<Student> displayAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.displayAllStudent();
	}


	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		student.setStudentId(UUID.randomUUID().toString());
		return studentDao.createStudent(student);
	}


	@Override
	public Student findStudentById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return studentDao.findStudentById(id);
	}

}
