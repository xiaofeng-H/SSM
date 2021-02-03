package pers.xiaofeng.proxy.jdk;

/**
 * @className: pers.xiaofeng.proxy.jdk.Target
 * @description: 目标
 * @author: xiaofeng
 * @create: 2021-02-03 23:38
 */
public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running...");
    }
}
