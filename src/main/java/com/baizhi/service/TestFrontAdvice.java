package com.baizhi.service;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class TestFrontAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("method = [" + method.getName() + "], objects = [" + objects + "], o = [" + o + "]");
    }
}
