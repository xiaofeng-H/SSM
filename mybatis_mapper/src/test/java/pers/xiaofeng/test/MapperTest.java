package pers.xiaofeng.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pers.xiaofeng.domain.User;
import pers.xiaofeng.mapper.UserMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: pers.xiaofeng.test.MapperTest
 * @description:
 * @author: xiaofeng
 * @create: 2021-02-26 15:18
 */
public class MapperTest {
    @Test
    public void test1() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 代理方式对Dao进行实现
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 模拟条件user
        User condition = new User();
        condition.setUid(1);
        //condition.setUsername("晓峰");
        List<User> userList = userMapper.findByCondition(condition);
        System.out.println(userList);

        // 模拟ids的数据
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        List<User> byIds = userMapper.findByIds(ids);
        System.out.println(byIds);
    }

    @Test
    public void test2() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 代理方式对Dao进行实现
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 模拟ids的数据
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<User> byIds = userMapper.findByIds(ids);
        System.out.println(byIds);
    }
}
