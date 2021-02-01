package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import service.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class Reflect {


    @Test
    private void test1() throws Exception {
        Controller controller = new Controller();
        // 创建属性对象
        Service service = new Service();
        // 获取类对象
        Class<? extends Controller> clazz = controller.getClass();
        // 通过类对象获取属性
        Field userService = clazz.getDeclaredField("userService");
        // 设置属性可获取
        userService.setAccessible(true);
        // 获取属性名
        String name = userService.getName();
        // 拼接方法名
        name = "set" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        // 获取方法名
        Method method = clazz.getMethod(name, Service.class);
        // 通过反射注入对象
        method.invoke(controller, service);

        System.out.println(controller.getUserService());

    }

    @Test
    private void test2() {
        Controller controller = new Controller();
        Class<? extends Controller> clazz = controller.getClass();

        // 获取所有的属性值
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            String name = field.getName();
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation != null) {
                field.setAccessible(true);
                // 获取属性的类型
                Class<?> type = field.getType();
                try {
                    Object o = type.newInstance();
                    field.set(controller, o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(controller.getUserService());
    }
}
