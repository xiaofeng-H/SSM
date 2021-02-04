package pers.xiaofeng.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @className: pers.xiaofeng.proxy.InvocationHandlerImpl
 * @description: InvocationHandler实现类
 * @author: xiaofeng
 * @create: 2021-02-04 10:19
 * <p>
 * 注意：每次生成动态代理类对象时都需要指定一个实现了InvocationHandler接口的调用处理器对象
 */

/*每一个动态代理类都必须要实现InvocationHandler这个接口，并且每个代理类的实例都关联了一个handler，当我们通过代理对象调用一个方法的时候，
这个方法的调用就会被转发为由InvocationHandler这个接口的 invoke 方法来进行调用。我们来看看InvocationHandler这个接口的唯一一个方法 invoke 方法：
Object invoke(Object proxy, Method method, Object[] args) throws Throwable
我们看到这个方法一共接受三个参数，那么这三个参数分别代表如下：
proxy:　　指代JDK动态生成的最终代理对象
method:　指代的是我们所要调用真实对象的某个方法的Method对象
args:　　 指代的是调用真实对象某个方法时接受的参数*/

/*Proxy这个类的作用就是用来动态创建一个代理对象的类，它提供了许多的方法，但是我们用的最多的就是 newProxyInstance 这个方法：
public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,  InvocationHandler h)  throws IllegalArgumentException
这个方法的作用就是得到一个动态的代理对象，其接收三个参数，我们来看看这三个参数所代表的含义：
loader:　　一个ClassLoader对象，定义了由哪个ClassLoader来对生成的代理对象进行加载
interfaces:　　一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上*/

public class InvocationHandlerImpl implements InvocationHandler {

    // 这个就是我们要代理的真实对象，也就是真正执行业务逻辑的类
    private Object subject;

    // 通过构造方法传入这个被代理对象
    public InvocationHandlerImpl(Object subject) {
        this.subject = subject;
    }

    /**
     * 该方法负责集中处理动态代理类上的所有方法调用。 调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行
     *
     * @param proxy  最终生成的代理类实例
     * @param method 被调用的方法对象
     * @param args   调用上面method时传入的参数
     * @return method对应的方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------------动态代理处理开始！！！---------------");

        Object result = null;

        System.out.println("可以在调用实际方法前做一些事情");
        System.out.println("当前调用的方法是" + method.getName());

        // 当代理对象调用真实对象的方法时，其会自动地跳转到代理对象关联的handler对象的invoke方法来进行调用
        result = method.invoke(subject, args);  // 需要指定被代理对象和传入参数

        System.out.println(method.getName() + "方法的返回值是" + result);
        System.out.println("可以在调用实际方法后做一些事情");
        System.out.println("------------动态代理处理结束！！！---------------");

        // 返回method方法执行后的返回值
        return result;
    }
}
