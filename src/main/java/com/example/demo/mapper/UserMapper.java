package com.example.demo.mapper;


import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {


    @Insert("insert into user (name,age,num,create_date) values(#{name},#{age},#{num},#{createDate})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insertUser(User user);



    @Select("select *from user where id=#{id}")
    User get(@Param("id") int id);


}
