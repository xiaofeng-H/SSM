package pers.xiaofeng.service.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pers.xiaofeng.dao.UserDao;
import pers.xiaofeng.service.UserService;

/**
 * @Description: service实现
 * @author: xiaofeng
 * @date: 2021/1/30 18:54
 **/
//<bean id="userService" class="pers.xiaofeng.service.impl.UserServiceImpl"></bean>
@Component("userService")
public class UserServiceImpl implements UserService {
    //<property name="userDao" ref="userDao"></property>
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.save();
    }
}
