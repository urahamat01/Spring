package com.example.demo.prospring3.security;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();

    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        UserInfo user = securityManager.getLoggedOnUser();

        if (user == null) {
            System.out.println("no use authenticated");
            throw new SecurityException(
                    "you must login before attempting to invoke the method :" + method.getName());
        } else if ("clarence".equals(user.getUserName())) {
            System.out.println("logged in user is clarence - okay !");

        } else {
            System.out.println("Logged in user is " + user.getUserName() + "is not allowed access to method" + method.getName());
        }

    }
}
