package com.example.demo;

import org.springframework.aop.framework.ProxyFactory;

public class HellowWorldAOPExample {
    public static void main(String[] args) {

        MessageWrter target1 = new MessageWrter();


        //create the proxy
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new MessageDecorator());
        pf.setTarget(target1);

        MessageWrter proxy = (MessageWrter) pf.getProxy();

        // write the messages target .writeMessage();
        target1.writerMessage();
        System.out.println("");
        proxy.writerMessage();

    }
}
