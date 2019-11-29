package com.baizhi.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFirst {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("first/spring.xml");
        FirstService firstService = (FirstService) applicationContext.getBean("firstService");
        System.out.println("firstService = " + firstService.getClass());
        firstService.clear();
    }
}
