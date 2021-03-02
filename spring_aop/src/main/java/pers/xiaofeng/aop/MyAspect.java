package pers.xiaofeng.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @className: pers.xiaofeng.aop.MyAspect
 * @description:
 * @author: xiaofeng
 * @create: 2021-03-02 14:56
 */
public class MyAspect {

    public void before() {
        System.out.println("前置增强...");
    }

    public void afterReturning() {
        System.out.println("后置增强...");
    }

    /**
     * @param proceedingJoinPoint 正在执行的连接点==切点
     */
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

    public void after() {
        System.out.println("最终增强...");
    }

}
