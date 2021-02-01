package pers.xiaofeng.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.xiaofeng.config.SpringConfiguration;
import pers.xiaofeng.service.UserService;

/**
 * @Description: spring入门练习
 * @author: xiaofeng
 * @date: 2021/1/30 18:57
 **/
public class UserController {

    public static void main(String[] args) {
        // xml配置
        //ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 注解
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 通过id获取Bean
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }
}
