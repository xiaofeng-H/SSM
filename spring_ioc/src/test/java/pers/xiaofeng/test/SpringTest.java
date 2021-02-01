package pers.xiaofeng.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaofeng.dao.UserDao;

/**
 * @Description: Spring测试
 * @author: xiaofeng
 * @date: 2021/1/30 17:44
 **/
public class SpringTest {

    @Test
    // 测试scope属性
    public void test1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
        System.out.println(userDao2);
    }

    @Test
    // 测试init-method和destroy-method方法
    public void test2(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        System.out.println(userDao);
        // 告诉容器我要关闭了，容器才有时间反应过来说我要执行销毁方法，不然容器来不及执行销毁方法就已经被销毁了
        app.close();
    }

    @Test
    // 测试静态工厂构造方法
    public void test3(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        System.out.println(userDao);
    }
}
