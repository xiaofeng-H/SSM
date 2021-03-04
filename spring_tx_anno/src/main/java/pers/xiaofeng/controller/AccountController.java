package pers.xiaofeng.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import pers.xiaofeng.service.AccountService;

/**
 * @className: pers.xiaofeng.controller.AccountController
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-03 14:28
 */
@Controller("accountController")
public class AccountController {

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = app.getBean(AccountService.class);
        accountService.transfer("tom", "lucy", 500);
    }
}
