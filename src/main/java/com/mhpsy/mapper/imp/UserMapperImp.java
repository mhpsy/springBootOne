package com.mhpsy.mapper.imp;

import com.mhpsy.entity.User;
import com.mhpsy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapperImp implements UserMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(String userName, Integer age) {
        return userMapper.insertUser(userName,age);
    }

    @Override
    public User selectByUserId(Integer id) {
        return userMapper.selectByUserId(id);
    }
}
