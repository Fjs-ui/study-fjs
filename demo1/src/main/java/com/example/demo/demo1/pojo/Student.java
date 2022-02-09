package com.example.demo.demo1.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.example.demo.demo1.aop.ModifyLogForString;
import lombok.Data;

/**
 * @description:
 * @author: fjs
 * @create: 2022-01-20 15:12
 **/
@Data
public class Student {
    private String id;

    @ModifyLogForString("姓名")
    private String name;

    @ModifyLogForString("年龄")
    private String age;

    private String sex;

    private String classname;
}
