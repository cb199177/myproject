package com.itcast.dao;

import com.itcast.domain.User;
import com.itcast.domain.User1;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Demo02 {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private UserDaoByResultMap userDao;
    @Before
    public void init() throws Exception {
        in = org.apache.ibatis.io.Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDaoByResultMap.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    @Test
    public void findAllTest(){
        List<User1> list = userDao.findAll();
        for (User1 user1 : list) {
            System.out.println(user1);
        }
    }
    @Test
    public void addUserTest(){
        User user = new User();
        user.setUsername("boye");
        user.setSex("男");
        user.setAddress("jauhfwkle");
        user.setBirthday(new Date());
        userDao.addUser(user);

    }
    @Test
    public void findByIdTest(){
        User1 user1 = userDao.findById(59L);
        System.out.println(user1);
    }
}
