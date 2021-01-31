package pers.xiaofeng.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaofeng.service.UserService;

/**
 * @Description: spring入门练习
 * @author: xiaofeng
 * @date: 2021/1/30 18:57
 **/
public class UserController {

    public static void main(String[] args) {
        /**
         * ApplicationContext：接口类型，代表应用上下文，可以通过其实例获得Spring容器中的Bean对象
         * 实现：
         *    ClassPathXmlApplicationContext：它是从类的根路径下加载配置文件，推荐使用这种（ClassPath Xml ApplicationContext）
         *    FileSystemXmlApplicationContext：它是从磁盘路径上加载配置文件，配置文件可以在磁盘的任意位置
         *    AnnotationConfigApplicationContext：当使用注解配置容器对象时，需要使用此类来创建Spring容器，用它来读取注解
         */
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ApplicationContext app = new FileSystemXmlApplicationContext("E:\\coder\\Java\\ssm\\spring_aop\\src\\main\\resources\\applicationContext.xml");

        /**
         * 其中，当参数的数据类型是字符串时，表示根据Bean的id从容器中获得Bean实例，返回Object，需要强转。
         * 当参数的数据类型是Class类型时，表示根据类型从容器中匹配Bean实例，当容器中相同类型的Bean有多个时，
         * 则此方法会报错
         */
        // 通过id获取Bean
        UserService userService = (UserService) app.getBean("userService");
        userService.save();

        // 通过字节码对象类型获取Bean
        UserService userService1 = app.getBean(UserService.class);
        userService1.save();

        /*// 空指针
        UserService userService = new UserServiceImpl();
        userService.save();*/
    }
}
