package com.example.demo.demo1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.demo1.pojo.Student;

import java.util.List;

public interface StudentService extends IService<Student> {
    List<Student> getAllStudent();

    void updateStudentById(Student student);

    void insertStudent();
}
