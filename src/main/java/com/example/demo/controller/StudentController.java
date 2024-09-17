package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.vo.StudentDepartmentVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	/*
	 * @GetMapping("/your-endpoint") public ResponseEntity<String> getMethod() {
	 * return ResponseEntity.ok("GET response"); }
	 */

	
	  
	@GetMapping("/{id}")
	public String getStudentWithDepartment(@PathVariable Long id) {
		System.out.println("print getMapping");
		return studentService.getStudentWithDepartment(id);
	}
	  /*
		 * @GetMapping("/{id}") public StudentDepartmentVO
		 * getStudentWithDepartment(@PathVariable Long id){ return
		 * studentService.getStudentWithDepartment(id); 
		 * }
		 */
		
	 
}
