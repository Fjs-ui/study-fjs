package com.example.demo.demo1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.demo1.pojo.StudentLogUpdate;

import java.util.List;

public interface StudentLogService extends IService<StudentLogUpdate> {
    void insert(StudentLogUpdate logUpdate);
}
