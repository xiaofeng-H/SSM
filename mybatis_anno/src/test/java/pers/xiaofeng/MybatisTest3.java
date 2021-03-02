package pers.xiaofeng;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pers.xiaofeng.dao.Order;
import pers.xiaofeng.dao.User;
import pers.xiaofeng.mapper.OrderMapper;
import pers.xiaofeng.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @className: pers.xiaofeng.MybatisTest2
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-01 18:11
 */
public class MybatisTest3 {

    private UserMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void findUser2Order() {
        List<User> all = mapper.findUserAndOrderAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
}
