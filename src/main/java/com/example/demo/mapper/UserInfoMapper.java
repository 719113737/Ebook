package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 从数据库中寻找和用户相关的信息
 */
@Mapper
public interface UserInfoMapper {

    /**
     * 通过用户名寻找密码
     * @param username 用户名
     * @return 返回密码
     */
    @Select("select password from user_data where username = #{username};")
    String findPasswordByUsername(@Param("username") String username);


    /**
     * 通过用户名寻找角色权限
     * @param username 用户名
     * @return 角色权限
     */
    @Select("select role from user_data where username = #{username};")
    String findRoleByUsername(@Param("username") String username);
}