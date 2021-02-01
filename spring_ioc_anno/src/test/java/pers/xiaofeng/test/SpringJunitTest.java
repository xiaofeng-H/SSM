package pers.xiaofeng.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.xiaofeng.config.SpringConfiguration;
import pers.xiaofeng.service.UserService;

import javax.sql.DataSource;

/**
 * @className: pers.xiaofeng.test.SpringJunitTest
 * @description:
 * @author: xiaofeng
 * @create: 2021-02-01 15:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {

    /*Spring集成Junit步骤：
            1、导入spring集成Junit的坐标
            2、使用@Runwith注解替换原来的运行期
            3、使用@ContextConfiguration指定配置文件或配置类
            4、使用@Autowired注入需要测试的对象
            5、创建测试方法进行测试*/

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void test1() throws Exception {
        userService.save();
        System.out.println(dataSource.getConnection());
    }
}
