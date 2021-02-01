package pers.xiaofeng.factory;

import pers.xiaofeng.dao.UserDao;
import pers.xiaofeng.dao.impl.UserDaoImpl;

/**
 * @Description: 静态工厂构造方法
 * @author: xiaofeng
 * @date: 2021/1/30 18:28
 **/
public class StaticFactory {

    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
