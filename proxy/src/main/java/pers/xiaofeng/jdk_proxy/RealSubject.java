package pers.xiaofeng.jdk_proxy;

/**
 * @className: pers.xiaofeng.proxy.RealSubject
 * @description: 被代理的类（实际处理业务的类）
 * @author: xiaofeng
 * @create: 2021-02-04 10:17
 */
public class RealSubject implements Subject {
    @Override
    public void hello(String name) {
        System.out.println("hello " + name);
    }

    @Override
    public String bye() {
        System.out.println("bye");
        return "bye";
    }
}
