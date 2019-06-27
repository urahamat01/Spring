package com.example.demo.prospring3.crypto;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

        if ((target instanceof KeyGenerator) && ("getKey".equals(method.getName()))) {
            long key = ((long) returnValue);
            if (key == KeyGenerator.WEAK_KEY) {
                throw new SecurityException(
                        "Key Generator generatoed a weak key. Tey again"
                );
            }
        }

    }
}
