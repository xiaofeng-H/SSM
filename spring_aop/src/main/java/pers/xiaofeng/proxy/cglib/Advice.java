package pers.xiaofeng.proxy.cglib;

/**
 * @className: pers.xiaofeng.proxy.jdk.Advice
 * @description: 增强
 * @author: xiaofeng
 * @create: 2021-02-03 23:39
 */
public class Advice {
    public void before() {
        System.out.println("前置增强...");
    }

    public void afterReturning() {
        System.out.println("后置增强...");
    }
}
