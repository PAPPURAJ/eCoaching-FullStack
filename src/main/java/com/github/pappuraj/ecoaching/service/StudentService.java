package com.github.pappuraj.ecoaching.service;

import com.github.pappuraj.ecoaching.Exception.StudentAlreadyExist;
import com.github.pappuraj.ecoaching.Exception.StudentNotFoundException;
import com.github.pappuraj.ecoaching.model.Student;
import com.github.pappuraj.ecoaching.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentServiceInterface{


    private  final StudentRepository studentRepository;
    @Override
    public Student addStudent(Student student) {
        if(studentRepository.findByEmail(student.getEmail()).isPresent())
            throw new StudentAlreadyExist(student.getEmail());
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow((() -> new StudentNotFoundException("Student not found with id "+id)));
    }

    @Override
    public Student updateStudent(int id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    @Override
    public boolean delete(int id) {
         studentRepository.findById(id).orElseThrow((() -> new StudentNotFoundException("Student not found with id "+id)));
         studentRepository.deleteById(id);
        return true;
    }
}
