package com.example.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.model.StudentReq;
import com.example.model.StudentRes;
import com.example.service.StudentService;

import jakarta.validation.Valid;

@RequestMapping("/student")
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/addStudent")
	public ResponseEntity<Student> createStudent(@RequestBody @Valid StudentReq student) {
//		Student student1 = new Student();
//		student1.setId(student.getId());
//		student1.setName(student.getName());
//		student1.setSchool(student.getSchool());
		Student stud = studentService.createStudent(student);
		return new ResponseEntity<Student>(stud, HttpStatus.OK);
	}
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
		Student student = null ;
		try {
			 student = studentService.getStudent(id);
		} catch (Exception e) {
			System.out.println("No student found with this id " +id);
		}
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}
	@GetMapping("/tets")
	public String test() {
		return "testing is done" ;
	}
}
