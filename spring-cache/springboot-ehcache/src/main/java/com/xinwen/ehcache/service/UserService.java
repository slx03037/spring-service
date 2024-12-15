package com.xinwen.ehcache.service;


import com.xinwen.ehcache.domain.User;

public interface UserService {

    User update(User user);


    void deleteBySno(String sno);


    User queryBySno(String sno);
}
