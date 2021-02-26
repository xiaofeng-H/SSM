package pers.xiaofeng.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pers.xiaofeng.dao.UserMapper;
import pers.xiaofeng.domain.User;

import java.io.InputStream;
import java.util.List;

/**
 * @className: pers.xiaofeng.service.ServiceDemo
 * @description:
 * @author: xiaofeng
 * @create: 2021-02-26 14:28
 */
public class ServiceDemo {
    public static void main(String[] args) throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 代理方式对Dao进行实现
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll();
        System.out.println(userList);

        User user = userMapper.findById(1);
        System.out.println(user);
    }
}
