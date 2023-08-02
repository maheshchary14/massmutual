package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restapi")
public class StudentRestController {

    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping("/student/{firstname}")
    public Student getStudentByFirstname(@PathVariable String firstname){
        return studentService.getStudentByFirstname(firstname)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}
