package pers.xiaofeng.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import pers.xiaofeng.proxy.jdk.TargetInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @className: pers.xiaofeng.proxy.jdk.ProxyTest
 * @description: cglib动态代理测试类
 * @author: xiaofeng
 * @create: 2021-02-03 23:42
 */
public class ProxyTest {
    public static void main(String[] args) {
        // 目标对象
        Target target = new Target();

        // 增强对象
        Advice advice = new Advice();

        // 返回值：就是动态生成的代理对象。基于cglib
        // 1、创建增强器（cglib提供）
        Enhancer enhancer = new Enhancer();
        // 2、设置父类（目标）
        enhancer.setSuperclass(Target.class);
        // 3、设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                // 执行前置
                advice.before();
                // 执行目标
                Object invoke = method.invoke(target, args);
                // 执行后置
                advice.afterReturning();

                return null;
            }
        });
        // 4、创建代理对象
        Target proxy = (Target) enhancer.create();

        proxy.save();
    }
}
