package com.mhpsy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class FreemarkerIndexController {
    @RequestMapping("/freemarkerIndex")
    public String freemarkerIndex(Map<String,Object> result){
        result.put("name","mhpsy");
        result.put("sex","0");
        result.put("age","22");
        ArrayList<String> list = new ArrayList<>();
        list.add("mhpsy");
        list.add("qwer");
        list.add("asdf");
        list.add("zxcv");
        result.put("list",list);
        return "freemarkerIndex";
    }
}
