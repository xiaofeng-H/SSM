package pers.xiaofeng.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pers.xiaofeng.domain.User;
import pers.xiaofeng.mapper.UserMapper;

import java.io.InputStream;
import java.util.Date;

/**
 * @className: pers.xiaofeng.test.MyBatisTest
 * @description:
 * @author: xiaofeng
 * @create: 2021-02-26 17:47
 */
public class MyBatisTest {

    @Test
    public void test1() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 创建user
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("123");
        user.setBirthday(new Date());

        // 执行保存操作
        userMapper.save(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行保存操作
        User user = userMapper.findById(8);
        System.out.println("user中的birthday:" + user.getBirthday());

        sqlSession.commit();
        sqlSession.close();
    }
}
