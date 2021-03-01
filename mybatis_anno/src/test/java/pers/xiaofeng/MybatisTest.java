package pers.xiaofeng;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pers.xiaofeng.dao.User;
import pers.xiaofeng.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @className: pers.xiaofeng.MybatisTest
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-01 16:59
 */
public class MybatisTest {
    private UserMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("马超");
        user.setPassword("123");
        mapper.save(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUid(5);
        user.setUsername("Lucy");
        user.setPassword("123");
        mapper.update(user);
    }

    @Test
    public void testDelete() {
        mapper.delete(10);
    }

    @Test
    public void testFindById() {
        User user = mapper.findById(1);
        System.out.println(user);
    }

    @Test
    public void testFindAll() {
        List<User> userList = mapper.findAll();
        System.out.println(userList);
    }
}
