package com.netsurfingzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netsurfingzone.entity.Student;
import com.netsurfingzone.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/usingsave")
	public Student usingSave(@RequestBody Student student) {
		Student createResponse = studentService.save(student);
		return createResponse;
	}

	@PostMapping("/usingpersist")
	public Student usingPersist(@RequestBody Student student) {
		Student createResponse = studentService.persist(student);
		return createResponse;
	}
	
	@GetMapping("/retrieve/{id}")
	public Student getStudent(@PathVariable Long id) {
		Student response = studentService.retrieveEntity(id);
		return response;
	}
}
