package com.itcast.dao;

import com.itcast.domain.User;
import com.itcast.domain.User1;

import java.util.List;

public interface UserDaoByResultMap {
    List<User1> findAll();
    void addUser(User user);
    User1 findById(Long userId);
}
