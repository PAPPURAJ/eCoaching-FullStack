package com.github.pappuraj.ecoaching.service;

import com.github.pappuraj.ecoaching.model.Student;

import java.util.List;

public interface StudentServiceInterface {
    Student addStudent(Student student);
    List<Student> getAllStudent();
    Student getStudentById(int id);

    Student updateStudent(int id, Student student);
    boolean delete(int id);

}
