package pers.xiaofeng.dao.impl;

import lombok.Data;
import pers.xiaofeng.dao.UserDao;
import pers.xiaofeng.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Description: Spring入门练习
 * @author: xiaofeng
 * @date: 2021/1/30 16:40
 **/
@Data
public class UserDaoImpl implements UserDao {

    private List<String> stringList;
    private Map<String, User> userMap;
    private Properties properties;

    private String userName;
    private int age;

    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建...");
    }

    public void init() {
        System.out.println("初始化方法...");
    }

    public void destroy() {
        System.out.println("销毁方法...");
    }

    public void save() {
        System.out.println("userName=" + userName + "; age=" + age);
        System.out.println(stringList);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println("save running...");
    }
}
