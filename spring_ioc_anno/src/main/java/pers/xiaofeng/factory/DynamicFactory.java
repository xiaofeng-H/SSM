package pers.xiaofeng.factory;

import pers.xiaofeng.dao.UserDao;
import pers.xiaofeng.dao.impl.UserDaoImpl;

/**
 * @Description: 实例化工厂
 * @author: xiaofeng
 * @date: 2021/1/30 18:35
 **/
public class DynamicFactory {

    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
