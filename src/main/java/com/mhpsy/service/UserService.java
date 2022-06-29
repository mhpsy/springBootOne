package com.mhpsy.service;


import com.mhpsy.entity.User;
import com.mhpsy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/insertUser")
    public String insert(String userName, Integer age) {
        int update = jdbcTemplate.update("insert into users(name,age) values(?,?)", userName, age);
        return update > 0 ? "success" : "";
    }

    /**
     * 使用mybatis查询
     *
     * @param id
     * @return
     */
    @RequestMapping({"/FindById", "/findbyid"})
    public User useMybatisFindById(Integer id) {
        return userMapper.selectByUserId(id);
    }

    @RequestMapping({"/insertUser", "/insertuser"})
    public String useMybatisInsertUser(String name, Integer age) {
        int i = userMapper.insertUser(name, age);
        return i > 0 ? "success" : "no";
    }

}
