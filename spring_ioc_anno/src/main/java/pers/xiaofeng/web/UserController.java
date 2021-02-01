package pers.xiaofeng.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaofeng.service.UserService;

/**
 * @Description: spring入门练习
 * @author: xiaofeng
 * @date: 2021/1/30 18:57
 **/
public class UserController {

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 通过id获取Bean
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }
}
