package com.mhpsy.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

/**
 *
 * @RestController注解跟Controller的区别
 * 如果在类上加上@RestController那么就说明
 * 该类中所有SpringMUVUrl接口映射都是返回json格式
 * @RestController是SpringMVC提供的 SpringMVC本身就有的东西
 *  相当于在类上面加Controller然后每个方法上面加上了@ResponseBody
 *  将数据按照json格式返回
 *
 *  Controller注解是控制层注解SpringMVCURl接口映射
 *  默认的情况下返回值是页面跳转
 *  如果需要返回json格式的情况下需要@ResponseBody
 *
 */

//@EnableAutoConfiguration
//@ComponentScan("com.mhpsy.service")
@RestController
public class HelloWorldService {


    @RequestMapping({"/getuser","getUser"})
    public String getUser(){
        return "json格式的数据";
    }
}
