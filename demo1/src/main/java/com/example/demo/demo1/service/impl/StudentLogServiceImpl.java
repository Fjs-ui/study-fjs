package com.example.demo.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.demo1.mapper.StudentLogMapper;
import com.example.demo.demo1.mapper.StudentMapper;
import com.example.demo.demo1.pojo.StudentLogUpdate;
import com.example.demo.demo1.service.StudentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @description:
 * @author: fjs
 * @create: 2022-02-09 10:36
 **/
@Service
public class StudentLogServiceImpl extends ServiceImpl<StudentLogMapper,StudentLogUpdate> implements StudentLogService {

    @Autowired
    StudentLogMapper mapper;


    @Override
    public void insert(StudentLogUpdate logUpdate) {
        mapper.insert(logUpdate);
    }

}
