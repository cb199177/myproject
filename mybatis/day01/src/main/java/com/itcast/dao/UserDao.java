package com.itcast.dao;

import com.itcast.domain.User;

import java.util.List;
//查询所有
public interface UserDao  {
    List<User> findAll();
    User findById(Long id);
}
