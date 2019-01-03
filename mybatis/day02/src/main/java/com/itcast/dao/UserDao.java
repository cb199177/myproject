package com.itcast.dao;

import com.itcast.domain.QueryVo;
import com.itcast.domain.User;

import java.util.List;

public interface UserDao {
    //查询所有
    List<User> findAll();
    //增加
    void addUser(User user);
    //修改用户
    void updateUser(User user);
    //根据id删除
    void deleteUser(Long id);
    //根据id查询
    User findById(Long id);
//    根据参数模糊查询
    List<User> findByName(String username);
//    根据xml配置模糊查询
    List<User> findByName2(String username);
//    总记录数查询
    int findTotalCount();
//   根据封装参数的对象查询
    List<User> findByVo(QueryVo vo);
}
