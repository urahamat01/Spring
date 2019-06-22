package com.example.demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee em = (Employee) context.getBean("employeeBean");
        System.out.println(em.toString());
        context.close();
    }
}
