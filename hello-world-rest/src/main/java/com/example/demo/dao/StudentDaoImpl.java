package com.example.demo.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import com.example.demo.model.Student;
@EnableAutoConfiguration
@Component
public class StudentDaoImpl implements StudentDao {
	private static Map<Integer, Student> studentCollections;
	
	static
	{
		studentCollections=new HashMap<Integer,Student>();
		studentCollections.put(1, new Student(UUID.randomUUID().toString(), "John", "Doe", "john@email.com"));
		studentCollections.put(2, new Student(UUID.randomUUID().toString(), "Marry", "Public", "marry@email.com"));
		studentCollections.put(3, new Student(UUID.randomUUID().toString(), "Sachin", "Tendulkar", "sachin@email.com"));
		studentCollections.put(4, new Student(UUID.randomUUID().toString(), "David", "Warner", "david@email.com"));
	}

	@Override
	public Collection<Student> displayAllStudent() {
		// TODO Auto-generated method stub
		return studentCollections.values();
	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		studentCollections.put(studentCollections.size()+1, student);
		return student;
	}

	@Override
	public Student findStudentById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Student student=studentCollections.get(id);
		if(student==null)
		{
			throw new Exception();
		}
		return student;
	}

}
