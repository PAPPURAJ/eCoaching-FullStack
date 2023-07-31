package com.github.pappuraj.ecoaching.Exception;

public class StudentAlreadyExist extends RuntimeException{
    public StudentAlreadyExist(String email){
        super(email);
    }

}
