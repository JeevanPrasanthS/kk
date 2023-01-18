package com.security.school.service;


import com.security.school.entity.Student;
import com.security.school.entity.Teacher;
import com.security.school.repository.StudentRepo;
import com.security.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

   static List<Student> studentList;

    @Autowired
    private TeacherRepository repository;

    @Autowired
    StudentRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

 /*  @PostConstruct
    public void loadProductsFromDB() {
        studentList = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> Student.builder()
                        .rollNo(i)
                        .name("product " + i)
                        .standerd(new Random().nextInt(10))
                        .marks(new Random().nextInt(5000)).build()
                ).collect(Collectors.toList());
    }

  */


   /* public static List<Student> loadStudnets(){
        Student s=new Student(121,"Hari",10,560);
        Student s1=new Student(121,"Hari",10,560);
        Student s2=new Student(121,"Hari",10,560);
        Student s3=new Student(121,"Hari",10,560);

        studentList.add(s);
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
    return studentList;


    }*/



    public List<com.security.school.entity.Student> getStudents() {
       return repo.findAll();
    }

    public Student getStudent(int id) {

         return repo.findById(id).stream()
                .filter(product -> product.getRollNo() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("product " + id + " not found"));
    }


    public Teacher addUser(Teacher userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));

        return repository.save(userInfo);
    }


}
