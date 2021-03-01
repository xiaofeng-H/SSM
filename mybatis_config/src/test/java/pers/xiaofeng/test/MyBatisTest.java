package pers.xiaofeng.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pers.xiaofeng.domain.User;
import pers.xiaofeng.mapper.UserMapper;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

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
    // typeHandlers标签测试：配置自定义类型处理器
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

    @Test
    // plugins标签测试：配置MyBatis的插件
    public void test3() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 设置分页的相关参数 当前页+每页显示的条数
        PageHelper.startPage(2, 2);

        List<User> userList = userMapper.findAll();

        for (User user : userList) {
            System.out.println(user);

        }

        // 获得与分页相关的参数
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        System.out.println("当前页：" + pageInfo.getPageNum());
        System.out.println("每页显示条数：" + pageInfo.getPageSize());
        System.out.println("总条数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("上一页：" + pageInfo.getPrePage());
        System.out.println("下一页：" + pageInfo.getNextPage());
        System.out.println("是否是第一页：" + pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页：" + pageInfo.isIsLastPage());

        sqlSession.close();
    }
}
