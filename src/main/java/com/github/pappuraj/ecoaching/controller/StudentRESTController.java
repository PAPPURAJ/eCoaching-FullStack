package com.github.pappuraj.ecoaching.controller;

import com.github.pappuraj.ecoaching.model.Student;
import com.github.pappuraj.ecoaching.service.StudentService;
import com.github.pappuraj.ecoaching.service.StudentServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import java.util.List;
@RestController
@CrossOrigin()
public class StudentRESTController {


    @Autowired
    private StudentServiceInterface studentService;

    @GetMapping("/")
    public ResponseEntity getHome(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Welcome to our application!");
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudent(){

        return new ResponseEntity<>(studentService.getAllStudent(),HttpStatus.FOUND);


    }

    @PostMapping("/student")
    public ResponseEntity addStudent(@RequestBody Student student){
        try{
            studentService.addStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(student);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Data not added!");
        }
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") int id){
//       Student student=studentService.getStudentById(id);
//        if(student==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found!");
//        return ResponseEntity.status(HttpStatus.FOUND).body(student);
        return studentService.getStudentById(id);
    }


    @DeleteMapping("/student/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int id){
        return studentService.delete(id)?ResponseEntity.status(HttpStatus.OK).body("Data deleted!"):ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not deleted!");

    }


    @PutMapping("/student/{id}")
    public ResponseEntity putStudent(@PathVariable("id") int id,@RequestBody Student student){
        try{
            studentService.updateStudent(id,student);
            return ResponseEntity.status(HttpStatus.CREATED).body(student);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Data not edited");
        }
    }


}
