package com.example.demo.demo1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.demo1.pojo.StudentLogUpdate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentLogMapper extends BaseMapper<StudentLogUpdate> {

}
