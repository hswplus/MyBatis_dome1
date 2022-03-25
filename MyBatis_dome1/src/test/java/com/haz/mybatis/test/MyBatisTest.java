package com.haz.mybatis.test;

import com.haz.mybatis.mapper.UserMapper;
import com.haz.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: HAZ
 * @date: 2022/3/19
 * @Description:
 */

public class MyBatisTest {
    /**
     * 测试插入
     * sqlSession默认不自动提交事务，如需自动提交事务
     * 可以使用sqlSessionFactory.openSession(true);
     * @throws IOException
     */
    @Test
    public void testMyBatis() throws IOException {
        User user = new User(null,"haz","123456",18,"1","1273@qq.com");
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取sqlSessionFactoryBuilder的工厂对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 获取MyBatis操作数据库的一个会话对象SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取mapper接口对象的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 测试功能
        int result = userMapper.insertUser(user);
//        sqlSession.commit();
        System.out.println("result:"+result);
    }

    /**
     * 测试修改
     * @throws IOException
     */
    @Test
    public void testUpdateUser() throws IOException {
        User user = new User(11,"李四");
        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //通过代理模式创建UserMapper接口的代理实现类对象?
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.updateUser(user);
        System.out.println("result:"+result);
    }

    /**
     * 测试查询和删除操作
     * @throws IOException
     */
    @Test
    public void CURD() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 根据id删除对应的用户
//        mapper.deleteUser(10);
        // 根据id查询对应的用户
//        User user = mapper.getUserById(11);
//        System.out.println(user);
        // 查询所有用户信息
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }
}
