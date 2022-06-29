package com.mhpsy.mapper;

import com.mhpsy.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Insert("insert into users(name,age) values(#{userName},#{age});")
    int insertUser(@Param("userName") String userName, @Param("age") Integer age);

    @Select("select id as id, name as name, age as age from users where id = #{id}")
    User selectByUserId(@Param("id") Integer id);


}
