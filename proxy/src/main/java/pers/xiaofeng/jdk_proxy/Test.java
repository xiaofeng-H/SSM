package pers.xiaofeng.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @className: pers.xiaofeng.proxy.Test
 * @description: 测试类
 * @author: xiaofeng
 * @create: 2021-02-04 10:35
 */
public class Test {
    /*
    首先解释一下JDK动态代理的大致流程，JDK主要会做以下工作：
            1. 获取 RealSubject上的所有接口列表；
            2. 确定要生成的代理类的类名；
            3. 根据需要实现的接口信息，在代码中动态创建该Proxy类的字节码；
            4. 将对应的字节码转换为对应的class 对象；
            5. 创建InvocationHandler 实例handler，用来处理Proxy所有方法调用；
            6. Proxy 的class对象 以创建的handler对象为参数，实例化一个proxy对象
            */

    public static void main(String[] args) {
        // 被代理的对象
        Subject realSubject = new RealSubject();

        // 通过InvocationHandlerImpl的构造器生成一个InvocationHandler对象，需要传入被代理对象作为参数
        InvocationHandler handler = new InvocationHandlerImpl(realSubject);

        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class[] interfaces = realSubject.getClass().getInterfaces();

        /*首先我们解释一下为什么我们这里可以将其转化为Subject类型的对象？原因就是在newProxyInstance这个方法的第二个参数上，
        我们给这个代理对象提供了一组什么接口，那么我这个代理对象就会实现了这组接口，这个时候我们当然可以将这个代理对象
        强制类型转化为这组接口中的任意一个，因为这里的接口是Subject类型，所以就可以将其转化为Subject类型了。
        同时我们需要明白，通过 Proxy.newProxyInstance 创建的代理对象是在jvm运行时动态生成的一个对象，而在运行是动态生成的一个对象，
        命名方式都是这样的形式，以$开头，proxy为中，最后一个数字表示对象的标号。*/

        // 需要指定类装载器、一组接口及调用处理器生成动态代理类实例
        Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);

        System.out.println("动态代理对象的类型：" + subject.getClass().getName());

        /*我们看到，在真正通过代理对象来调用真实对象的方法的时候，我们可以在该方法前后添加自己的一些操作。当我通过代理对象来调用方法的时候，
        其实际就是委托由其关联到的 handler 对象的invoke方法中来调用，并不是自己来真实调用，而是通过代理的方式来调用的。
        这就是我们的java动态代理机制。通过这种方式，被代理的对象(RealSubject)可以在运行时动态改变，需要控制的接口(Subject接口)可以在运行时改变，
        控制的方式(DynamicSubject类)也可以动态改变，从而实现了非常灵活的动态代理关系。*/

        subject.hello("xiaofeng");
        subject.bye();
    }

}

