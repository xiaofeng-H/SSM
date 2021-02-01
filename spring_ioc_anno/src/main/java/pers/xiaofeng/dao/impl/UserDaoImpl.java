package pers.xiaofeng.dao.impl;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
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
//<bean id="userDao" class="pers.xiaofeng.dao.impl.UserDaoImpl"></bean>
//@Component("userDao") // 使用在类上用于实例化Bean
@Repository("userDao")
@Data
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建...");
    }

    public void save() {
        System.out.println("save running...");
    }
}
