package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Optional<Student> getStudentByFirstname(String firstname){
        return studentRepository.findByFirstname(firstname);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void insertStudent(Student student){
        studentRepository.save(student);
    }
}
