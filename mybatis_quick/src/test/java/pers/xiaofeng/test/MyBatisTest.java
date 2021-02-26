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
    /*
    * 常用API:SqlSessionFactory build(InputStream inputStream)
    * 通过加载mybatis的核心文件的输入流的形式构建一个SqlSessionFactory对象
    * 其中,Resources工具类,这个类在org.apache.ibatis.io包中.Resources类帮助你从类路径下|文件系统|一个web URL中加载资源文件
    *
    * SqlSessionFactory有多个方法创建SqlSession实例.常用的有如下两个:
    *   openSession():会默认开启一个事务,但事务不会自动提交,也就意味着需要手动提交该事务,更新操作数据才会持久化到数据库中
    *   openSession(boolean autoCommit):参数为是否自动提交,如果设置为true,那么不需要手动提交事务
    *
    * SqlSession实例在MyBatis中是非常强大的一个类.在这里你会看到所有执行语句|提交|回滚事务|获取映射器实例的方法.
    * 执行语句的方法主要有:
    *   <T> T selectOne(String statement, Object parameter)
    *   <E> List<E> selectList(String statement, Object parameter)
    *   int insert(String statement, Object parameter)
    *   int update(String statement, Object parameter)
    *   int delete(String statement, Object parameter)
    * 操作事务的方法主要有:
    *   void commit()
    *   void rollback()
    * */

    // 查询操作
    @Test
    public void test1() throws Exception {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        // 打印数据
        System.out.println(userList);
        // 释放资源
        sqlSession.close();
    }

    // 插入操作
    @Test
    public void test2() throws Exception {
        // 模拟User对象
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("tom");

        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：namespace+id
        sqlSession.insert("userMapper.save", user);

        // mybatis执行更新操作,需要提交事务(默认不提交)
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    // 更新操作
    @Test
    public void test3() throws Exception {
        // 模拟User对象
        User user = new User();
        user.setUid(4);
        user.setUsername("Lucy");
        user.setPassword("lucy");

        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：namespace+id
        sqlSession.update("userMapper.update", user);

        // mybatis执行更新操作,需要提交事务(默认不提交)
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    // 删除操作
    @Test
    public void test4() throws Exception {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：namespace+id
        sqlSession.delete("userMapper.delete", 4);

        // mybatis执行更新操作,需要提交事务(默认不提交)
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }
}
