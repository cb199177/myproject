package com.itcast.dao;

import com.itcast.domain.QueryVo;
import com.itcast.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.apache.ibatis.io.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Demo01 {
    //定义测试必须的初始化对象
    private SqlSession sqlSession;
    private InputStream in;
    private UserDao userDao;
    //每次执行test方法都会默认先执行该init方法，所以可以把调用dao方法之前的统一的步骤抽取出来写入里面
    //后面写test就不需再写
    @Before
    public void init()throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }
    //该方法是测试完成之后自动执行，对于增删改操作需要提交事务，可以写在里面，用于释放资源。
    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    //查询所有
    @Test
    public void testFindAll(){
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
    //添加
    @Test
    public void addUser(){
        User user = new User();
        user.setUsername("haha");
        user.setAddress("sgs");
        user.setBirthday(new Date());
        user.setSex("女");
        System.out.println(user);
        userDao.addUser(user);
        System.out.println(user);
    }
    //修改
    @Test
    public void updateUserTest(){
        User user = new User();
        user.setUsername("111");
        user.setId(41);
        user.setAddress("集合被违法");
        System.out.println(user);
        userDao.updateUser(user);
        System.out.println(user);
    }
    //删除
    @Test
    public void deleteUserTest(){
        userDao.deleteUser(41L);
    }
    //通过id查询（id为long）
    @Test
    public void findByIdTest(){
        User user = userDao.findById(41L);
        System.out.println(user);
    }
    //模糊查询(传入参数时给定模糊查询条件)
    @Test
    public void findByNameTest(){
        String username = "%ha%";
        List<User> list = userDao.findByName(username);
        for (User user : list) {
            System.out.println(user);
        }
    }
//    *模糊查询（编译sql时给定模糊条件）
    @Test
    public void findByName2(){
        String username = "ha";
        List<User> list = userDao.findByName2(username);
        for (User user : list) {
            System.out.println(user);
        }
    }
//    查询总记录数
    @Test
    public void findTotalCountTest(){
        int totalCount = userDao.findTotalCount();
        System.out.println(totalCount);
    }
//    根据封装参数对象进行模糊查询
    @Test
    public void findByVoTest(){
        User user = new User();
        user.setSex("%女%");
        QueryVo vo = new QueryVo();
        vo.setUser(user);
        List<User> list = userDao.findByVo(vo);
        for (User user1 : list) {
            System.out.println(user1);
        }
    }
}
