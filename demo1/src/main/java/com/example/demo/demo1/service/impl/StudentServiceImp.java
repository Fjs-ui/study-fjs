package com.example.demo.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.demo1.aop.ModifyLogToDb;
import com.example.demo.demo1.mapper.StudentMapper;
import com.example.demo.demo1.pojo.Student;
import com.example.demo.demo1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: fjs
 * @create: 2022-01-20 15:19
 **/
@Service
public class StudentServiceImp extends ServiceImpl<StudentMapper,Student> implements StudentService  {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> getAllStudent() {
        List<Student> allStudent = studentMapper.selectList(null);
        return allStudent;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @ModifyLogToDb
    public void updateStudentById(Student student) {
        studentMapper.updateById(student);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertStudent() {

    }
}
