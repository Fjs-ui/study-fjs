package com.example.demo.demo1.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.demo.demo1.aop.ModifyLogForString;
import lombok.*;

/**
 * @description:
 * @author: fjs
 * @create: 2022-02-09 09:25
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentLogUpdate {

    @TableId(type = IdType.ASSIGN_UUID)

    private String id;

    private String updateColumn;

    private String oldValue;
    private String newValue;
}
