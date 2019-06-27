package com.example.demo.prospring3;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {
    public static void main(String[] args) {
        MessageWrter target = new MessageWrter();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(target);

        MessageWrter proxy = (MessageWrter) pf.getProxy();
        proxy.writerMessage();
    }

    @Override
    public void afterReturning(Object returnVlue, Method method, Object[] args, Object target) throws Throwable {

        System.out.println("");
        System.out.println("After method :" + method.getName());


    }
}
