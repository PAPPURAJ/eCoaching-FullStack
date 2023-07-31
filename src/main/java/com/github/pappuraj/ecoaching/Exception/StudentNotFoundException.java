package com.github.pappuraj.ecoaching.Exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String id) {
        super(id);
    }
}
