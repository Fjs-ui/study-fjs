package com.example.demo.demo1.aop;

import com.example.demo.demo1.mapper.StudentMapper;
import com.example.demo.demo1.pojo.Student;
import com.example.demo.demo1.pojo.StudentLogUpdate;
import com.example.demo.demo1.service.StudentLogService;
import com.example.demo.demo1.service.StudentService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @description:切面获取修改学生记录信息配置
 * @author: fjs
 * @create: 2022-02-09 09:04
 **/
@Slf4j
@Aspect
@Component
public class StudentModifyLogAspect {
    Logger logger= LoggerFactory.getLogger(StudentModifyLogAspect.class);

    @Autowired
    StudentService studentService;

    @Autowired
    StudentLogService service;

    @Autowired
    StudentMapper studentMapper;

    //定义切入点
    @Pointcut("@annotation(com.example.demo.demo1.aop.ModifyLogToDb)")
    public void pointcut(){

    }

    /**
     * 1,通过反射获取已修改内容
     * 2，对获取的内容进行数据处理
     * 3，将格式正确的信息存入数据库
     */

    //配置环绕通知
    @Around("pointcut()")
    @SneakyThrows
    public Object afterAround(ProceedingJoinPoint joinPoint){
        //返回切入点的参数
        Object[] args=joinPoint.getArgs();
        Student dto=(Student) args[0];
        Student old=studentService.getById(dto.getId());
        contrastValueForLog(old,dto);
        return joinPoint.proceed();
    }

    //数据处理
    @SneakyThrows
    private void contrastValueForLog(Student old, Student dto) {
        ArrayList<StudentLogUpdate> list=new ArrayList<>();

        Class clazz=old.getClass();
        Field[] declaredField=clazz.getDeclaredFields();
        for (Field field:declaredField){
            boolean modifyLogForString=field.isAnnotationPresent(ModifyLogForString.class);

            //如果存在该类型
            if (modifyLogForString){
                //PropertyDescriptor读取属性值
                PropertyDescriptor pd=new PropertyDescriptor(field.getName(),clazz);
                Method method=pd.getReadMethod();
                String oldValue=StudentModifyLogAspect.nullStrToBlankStr(String.valueOf(method.invoke(old)));
                String newValue=StudentModifyLogAspect.nullStrToBlankStr(String.valueOf(method.invoke(dto)));

                //判断是否修改
                if (!oldValue.equals(newValue)){
                    //获取修改字段名称
                    ModifyLogForString annotation = field.getAnnotation(ModifyLogForString.class);
                    String fieldValue = annotation.value();
                    addLog(old, dto, list, oldValue, newValue, fieldValue);
                }
            }
        }
        //存储到信息修改表
        if (list!=null){
            for (StudentLogUpdate studentLogUpdate:list){
                service.insert(studentLogUpdate);
            }
        }
    }

       private void addLog(Student old, Student dto, ArrayList<StudentLogUpdate> logList, String oldValue, String newValue, String fieldValue) {
           StudentLogUpdate studentLogUpdate=new StudentLogUpdate();
           studentLogUpdate.setOldValue(oldValue);
           studentLogUpdate.setNewValue(newValue);
           studentLogUpdate.setUpdateColumn(fieldValue);
        logList.add(studentLogUpdate);
    }


    static String nullStrToBlankStr(String str) {
        if ("null".equals(str)) {
            return "";
        }
        return str;
    }


}
