package com.example.demo.demo1.controller;

import com.example.demo.demo1.pojo.Student;
import com.example.demo.demo1.service.StudentService;
import com.example.demo.demo1.service.impl.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: fjs
 * @create: 2022-01-20 15:21
 **/
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServiceImp service;

    @RequestMapping("/getAllStudent")
    public List<Student> getAllStudent(){
        List<Student> allStudent = service.getAllStudent();
        return allStudent;
    }

    @RequestMapping("/updateStudent")
    public void updateStudent(@RequestBody Student student){
        service.updateStudentById(student);
    }

    @RequestMapping("/insertStudent")
    public void insertStudent(){
        List<Student> list=new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Student student=new Student();
            //student.setId(i);
            student.setName("fjs");
            student.setAge("20");
            student.setSex("男");
            student.setClassname("计科一班");
            list.add(student);
        }
        service.saveBatch(list);

        list.stream().collect(Collectors.toList());
    }
}
