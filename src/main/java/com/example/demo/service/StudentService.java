package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.vo.Department;
import com.example.demo.vo.StudentDepartmentVO;

@Service
public class StudentService {

	private String baseUrl = "http://DEPARTMENTSERVICE:8080/department/";
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private MailService mailService;
	
	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student saveStudentByStudentId(Student student) {
		return studentRepository.save(student);
	}

	
	  public String getStudentWithDepartment(Long id) { Student student =
	  studentRepository.findById(id).get(); Department department =
	  restTemplate.getForObject(baseUrl + student.getDepartmentId(),
	  Department.class);
	  
	  StringBuffer buffer = new StringBuffer(); buffer.append("Please find below");
	  buffer.append("\n"); buffer.append(student.getStudentId() + " " +
	  student.getFirstName() + "" + student.getLastName() + "" +
	  student.getEmail()); buffer.append("\n");
	  buffer.append(department.getDepartmentName() + "" + department.getBranch() +
	  "" + department.getAddress() + "" + department.getSalary());
	  mailService.sendMail("tamminenisunil3@gmail.com","StudentWithDepartment",
	  buffer.toString());
	  
	  return "Student with department details sent to mail."; }
	 

	
	/*
	 * public StudentDepartmentVO getStudentWithDepartment(Long id) { Student
	 * student = studentRepository.findById(id).get(); Department department =
	 * restTemplate.getForObject(baseUrl + student.getDepartmentId(),
	 * Department.class);
	 * 
	 * StudentDepartmentVO vo = new StudentDepartmentVO();
	 * vo.setDepartment(department); vo.setStudent(student); return vo; }
	 */
	 

}
