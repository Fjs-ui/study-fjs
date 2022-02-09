package com.example.demo.demo1.controller;

import org.apache.ibatis.annotations.Mapper;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: fjs
 * @create: 2022-01-21 15:10
 **/
public class CipherTest {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("aa","A");
        map.put("bb","B");

        for (Map.Entry<String, String> map1:map.entrySet()
             ) {
            System.out.println(map1.getKey()+"---"+map1.getValue());
        }


    }
}
