package com.example.demo.service;

import java.util.Collection;

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

}
