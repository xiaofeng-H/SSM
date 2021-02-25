package pers.xiaofeng.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pers.xiaofeng.domain.User;

import java.io.InputStream;
import java.util.List;

/**
 * @className: pers.xiaofeng.test.MyBatis
 * @description: MyBatis测试
 * @author: xiaofeng
 * @create: 2021-02-25 18:17
 */
public class MyBatisTest {

    @Test
    public void test1() throws Exception{
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：namespace + id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        // 打印数据
        System.out.println(userList);
        // 释放资源
        sqlSession.close();
    }
}
