package com.xinwen.shiro.authorization.dao;


import com.xinwen.shiro.authorization.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {
	
	List<Role> findByUserName(String userName);
}
