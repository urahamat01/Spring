package com.example.demo.prospring3.profiling;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;


public class ProfilingInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(invocation.getMethod().getName());
        Object returnValue = invocation.proceed();
        sw.stop();
        dumpInfor(invocation, sw.getTotalTimeMillis());
        return null;
    }

    private void dumpInfor(MethodInvocation invocation, long ms) {

        Method m = invocation.getMethod();
        Object target = invocation.getThis();
        Object[] args = invocation.getArguments();

        System.out.println("Executed method ;" + m.getName());
        System.out.println("On object of type :" + target.getClass().getName());

        System.out.println("With arguments :");

        for (int x = 0; x < args.length; x++) {
            System.out.println(" >" + args[x]);
        }
        System.out.println("\n");
        System.out.println("Took : " + ms + "ms");
    }
}

