package pers.xiaofeng.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @className: pers.xiaofeng.aop.MyAspect
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-02 14:56
 */
@Component("myAspect")
@Aspect // 标注当前MyAspect是一个切面类
public class MyAspect {

    // 通知的配置语法：@通知注解("切点表达式")

    /*
     * 切点表达式的抽取
     * 抽取方式：是在切面内定义方法，在该方法上使用@Pointcut注解定义切点表达式，然后再在增强注解中进行引用
     * */

    // 定义切点表达式
    @Pointcut("execution(* pers.xiaofeng.anno.*.*(..))")
    public void pointcut() {

    }

    // 配置前置通知
    //@Before("execution(* pers.xiaofeng.anno.*.*(..))")
    public void before() {
        System.out.println("前置增强...");
    }

    public void afterReturning() {
        System.out.println("后置增强...");
    }

    /**
     * @param proceedingJoinPoint 正在执行的连接点==切点
     */
    @Around("MyAspect.pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前增强...");
        // 切点方法
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕后增强...");
        return proceed;
    }

    public void afterThrowing() {
        System.out.println("异常抛出增强...");
    }

    @After("execution(* pers.xiaofeng.anno.*.*(..))")
    public void after() {
        System.out.println("最终增强...");
    }

}
