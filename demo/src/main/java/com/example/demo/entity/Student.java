package com.example.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private int id;
    private String firstName;
    private String lastName;

    public Student(int id,String firstName,String lastName){
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(){

    }

    
    public void setId(int id){
        this.id = id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String toString(){
        return "<Student> [id=" + id + ",firstName=" + firstName + ",lastName=" + lastName + "]";
    }
}
