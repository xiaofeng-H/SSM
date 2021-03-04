package pers.xiaofeng.service.impl;

import pers.xiaofeng.dao.UserDao;
import pers.xiaofeng.service.UserService;

/**
 * @className: pers.xiaofeng.service.impl.UserServiceImpl
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-04 10:32
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
