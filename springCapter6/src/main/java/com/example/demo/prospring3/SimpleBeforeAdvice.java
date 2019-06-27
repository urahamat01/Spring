package com.example.demo.prospring3;

import com.example.demo.MessageWrter;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    public static void main(String[] args) {
        MessageWrter target = new MessageWrter();

        //create the proxy
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(target);

        MessageWrter proxy = (MessageWrter) pf.getProxy();


        //write the message

        proxy.writerMessage();
        ;


    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

    }
}
