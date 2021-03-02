package pers.xiaofeng.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.xiaofeng.aop.TargetInterface;

/**
 * @className: pers.xiaofeng.test.AopTest
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-02 15:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopTest {

    @Autowired
    private TargetInterface target;

    @Test
    public void test1() {
        target.save();
    }

}
