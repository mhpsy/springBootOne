package com.mhpsy.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class getMember {

//    @Value("${mhpsy.nameA}")
//    private String name;
//
//    @Value("${mhpsy.ageA}")
//    private int age;


    @RequestMapping({"/getMember","/getmember"})
    public String getMember(){
        return "index";
    }


}
