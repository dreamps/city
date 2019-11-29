package com.baizhi.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Date;

public class MyAround implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        try {
            long time = new Date().getTime();
            methodInvocation.proceed();
            long time1 = new Date().getTime();
            System.out.println("执行时间 = " + (time1 - time));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return null;
    }
}
