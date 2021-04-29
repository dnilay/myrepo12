package com.example.demo.rest;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	

	@GetMapping(path = "/students")
	public ResponseEntity<Collection<Student>> displayAllStudent()
	{
		return ResponseEntity.status(HttpStatus.OK).body(studentService.displayAllStudent());
	}

	@PostMapping(path = "/students")
	public ResponseEntity<Student> createStudent( @RequestBody Student student)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(student));
	}
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> findStudentById(@PathVariable("id") Integer id) throws Exception
	{
		return ResponseEntity.status(HttpStatus.OK).body(studentService.findStudentById(id));
	}
}
