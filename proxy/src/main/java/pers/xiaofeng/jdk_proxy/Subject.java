package pers.xiaofeng.jdk_proxy;

/**
 * @className: pers.xiaofeng.proxy.Subject
 * @description: 需要动态代理的接口
 * @author: xiaofeng
 * @create: 2021-02-04 10:15
 */
public interface Subject {
    public void hello(String name);

    public String bye();
}
