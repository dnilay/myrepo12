package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@GetMapping("/")
	public ResponseEntity<?> getEmployee()
	{
		return ResponseEntity.ok(Employee.builder().firstName("John").lastName("Doe").email("john@email.com").build());
	}

}
