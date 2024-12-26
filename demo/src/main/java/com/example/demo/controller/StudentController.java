package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestController
public class StudentController {

    // using ResponseEntity class
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"Pradeep","Kumar");
        return ResponseEntity.ok().header("custom-header","Pradeep").body(student);
    }

    @GetMapping("all_students")
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();

        students.add(new Student(1,"Pradeep","kumar"));
        students.add(new Student(2,"P","K"));
        students.add(new Student(3,"Pradeep","Rebbavarapu"));

        return students;
    }


    // Spring boot Rest Api with a Path Variable

    // "http://localhost:8080/students/1"
    @GetMapping("student/{id}")
    public Student studentPathVariable(@PathVariable("id") int id){
        return new Student(id,"Ramesh","Fadatare");
    }
    

    // Spring boot Rest API with Request Params

    // "http://localhost:8080/students/query?id=1&firstName=Ramesh"
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,@RequestParam String firstName){
        return new Student(id,firstName,"Kumar");
    }

    // post request

    // RequestBody converts the json object into java Objects just like how serializers in django does
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student);
        return student;
    }

    // Put request to update

    @PutMapping("students/update/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
        // filter the old student using strudentId
        Student old_student = new Student(studentId,"Pradeep","Kumar");
        old_student.setFirstName(student.getFirstName());
        old_student.setLastName(student.getLastName());
        return old_student;
    }

    



}
