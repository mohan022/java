package com.example.service;

import com.example.entity.Student;
import com.example.model.StudentReq;

public interface StudentService {

	public Student createStudent(StudentReq student) throws RuntimeException;
	public boolean studentExist(Student student);
	public Student getStudent(int id) throws Exception;
	

}
