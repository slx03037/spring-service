package com.xinwen.shiro.authorization.dao;


import com.xinwen.shiro.authorization.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
	User findByUserName(@Param("username") String username);
}
