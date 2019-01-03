package com.itcast.dao;



import com.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class Mybaties01 {
    private InputStream in;
    private SqlSession sqlSession;

    @Before
    public void init()throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建sqlsessionfactory工厂对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(in);
        //3.使用工厂对象创建sqlsession对象
        sqlSession = sessionFactory.openSession();
    }
    @After
    public void destory() throws Exception{
        sqlSession.close();
        in.close();
    }
    @Test
    public void findByIdTest() throws Exception{
        //4.sqlsession对象创建接口代理对象
        init();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5.使用代理对象执行方法
        User user= userDao.findById(45L);
        System.out.println(user);
        //6.释放资源
        destory();
    }
}
