package com.example.demo;

import com.example.demo.demo1.pojo.Student;
import com.example.demo.demo1.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        List<Student> list=new ArrayList<>();
        Student s1=new Student();
        s1.setName("aa");
        list.add(s1);

        Student s2=new Student();
        s1.setName("aaa");
        list.add(s1);


        List<Student> l2=new ArrayList<>();
        list.stream().forEach(t -> {
            Student student=new Student();
            student.setName(t.getName());
            l2.add(student);
        });


        for (int i = 0; i < l2.size(); i++) {
            System.out.println(l2.get(i).toString());
        }
    }

}
