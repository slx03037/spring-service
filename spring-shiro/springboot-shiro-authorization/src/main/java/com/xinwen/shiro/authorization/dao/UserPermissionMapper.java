package com.xinwen.shiro.authorization.dao;


import com.xinwen.shiro.authorization.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserPermissionMapper {
	
	List<Permission> findByUserName(String userName);
}
