package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.model.StudentReq;
import com.example.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo repo;

	@Override
	public Student createStudent(StudentReq studenReq) throws RuntimeException {
//		if (!studentExist(student)) {
		Student student = Student.builder().id(studenReq.getId()).name(studenReq.getName())
				.school(studenReq.getSchool()).build();

		return repo.saveAndFlush(student);
//		}
//		throw new RuntimeException();
	}

	@Override
	public boolean studentExist(Student student) {
		boolean valid = true;
		Student std = repo.getById(student.getId());
		if (std != null) {
			return valid;
		}
		return false;
	}

	@Override
	public  Student getStudent(int id) throws Exception {
		try {
			Student student = new Student();
			student.setId(repo.getById(id).getId());
			student.setName(repo.getById(id).getName());
			student.setSchool(repo.getById(id).getSchool());
			return student;
		} catch (Exception e) {
			throw new Exception("No Student found in this username ");
		}
	}
}
