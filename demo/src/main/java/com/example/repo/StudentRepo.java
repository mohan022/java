package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Student;
import com.example.model.StudentReq;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {


}
