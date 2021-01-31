package pers.xiaofeng.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaofeng.dao.UserDao;

/**
 * @Description: Spring入门练习
 * @author: xiaofeng
 * @date: 2021/1/30 16:48
 **/
public class UserDaoDemo {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
    }
}
