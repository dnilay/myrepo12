package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Hello;

@RestController
public class HelloWorldController {
	
	@GetMapping("/api/hello")
	public ResponseEntity<Hello> sayHello()
	{
		Hello hello=new Hello("Hello John", System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.OK).body(hello);
	}
	
	

}
