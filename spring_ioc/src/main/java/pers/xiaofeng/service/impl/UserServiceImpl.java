package pers.xiaofeng.service.impl;

import lombok.Data;
import pers.xiaofeng.dao.UserDao;
import pers.xiaofeng.service.UserService;

/**
 * @Description: service实现
 * @author: xiaofeng
 * @date: 2021/1/30 18:54
 **/
@Data
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    public void save() {
        userDao.save();
    }
}
