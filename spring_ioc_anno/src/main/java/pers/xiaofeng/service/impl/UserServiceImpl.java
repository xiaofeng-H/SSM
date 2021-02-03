package pers.xiaofeng.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pers.xiaofeng.dao.UserDao;
import pers.xiaofeng.service.UserService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @Description: service实现
 * @author: xiaofeng
 * @date: 2021/1/30 18:54
 **/
//<bean id="userService" class="pers.xiaofeng.service.impl.UserServiceImpl"></bean>
//@Component("userService")
@Service("userService")
@Scope("singleton")
//@Scope("prototype")
public class UserServiceImpl implements UserService {

    //<property name="userDao" ref="userDao"></property>
    //@Autowired // 按照数据类型从Spring容器中进行匹配的（使用在字段上用于根据类型依赖注入）
    //@Qualifier("userDao") // 是按照id值从容器中进行匹配的，但是注意此处@Qualifier要结合@Autowired一起使用（根据名称进行依赖注入）
    @Resource(name = "userDao") // @Resource相当于@Autowired和@Qualifier（按照名称注入）
    private UserDao userDao;

    @Value("${jdbc.driver}") // 类似于xml配置中从外部加载properties文件获取变量值
    private String driver;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    // 使用注解时，set方法可以不写，set方法主要用于xml配置文件反射创建bean
/*    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct
    public void init() {
        System.out.println("Service对象的初始化方法");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Service对象的销毁方法");
    }
}
