package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping("/")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student()); // Create an empty User object to bind form data
        return "index"; // Return the name of the HTML file (without .html extension)
    }
    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute("student") Student student) {
        // Process the form data and perform any necessary actions
        // For simplicity, let's just print the user data to the console
        System.out.println("Student Registration Data:");
        System.out.println("id: " + student.getId());
        System.out.println("First Name: " + student.getFirstname());
        System.out.println("Last Name: " + student.getLastname());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Password: " + student.getPassword());

        studentService.insertStudent(student);

        return "redirect:/success"; // Redirect to the success page after form submission
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success"; // Return the name of the success page (without .html extension)
    }

}
