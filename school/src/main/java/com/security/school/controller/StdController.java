package com.security.school.controller;

import com.security.school.entity.Student;
import com.security.school.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/std")
public class StdController {

    @Autowired
    StudentRepo repo;

    @PostMapping("/post")
    public Student savedata(@RequestBody Student std){
        return repo.save(std);
    }
}
