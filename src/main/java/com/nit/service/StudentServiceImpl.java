package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.nit.entity.Student;
import com.nit.repository.StudentRepository;

@Service("stud_service")
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
    }

    @Override
    public String updateStudent(Student student) {
        return "Student Data Updated With id value:: "
                + studentRepository.save(student).getId();
    }

    @Override
    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Student with " + id + " Deleted Successfully";
    }

    @Override
    public Page<Student> getStudentDataByPage(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
}

