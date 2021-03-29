package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select password from user_data where username = #{username};")
    String findPasswordByUsername(@Param("username") String username);

    @Select("select role from user_data where username = #{username};")
    String findRoleByUsername(@Param("username") String username);

    @Select("select role from role_url where url = #{url};")
    List<String> getRoleByUrl(@Param("url") String url);
}