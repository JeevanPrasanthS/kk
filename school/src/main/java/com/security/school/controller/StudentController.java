package com.security.school.controller;


import com.security.school.entity.Student;
import com.security.school.entity.Teacher;
import com.security.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/new")
    public Teacher addNewUser(@RequestBody Teacher teacher){
        return service.addUser(teacher);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Student> getAllTheProducts() {
        return service.getStudents();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Student getProductById(@PathVariable int id) {
        return service.getStudent(id);
    }



}
