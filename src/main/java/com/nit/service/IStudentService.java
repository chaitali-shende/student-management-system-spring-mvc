package com.nit.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nit.entity.Student;

public interface IStudentService {
	
	public void addStudent(Student student);

	public Iterable<Student> getAllStudents();

	public Student getStudentById(Long id);

	public String updateStudent(Student student);

	public String deleteStudent(Long id);
	
	public Page<Student> getStudentDataByPage(Pageable pePageable);
}
