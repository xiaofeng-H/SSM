package pers.xiaofeng.anno;

/**
 * @className: pers.xiaofeng.proxy.jdk.Target
 * @description: 目标
 * @author: xiaofeng
 * @create: 2021-02-03 23:38
 */

import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface {
    public void save() {
        //int a = 5 / 0;
        System.out.println("save running...");
    }
}
