package com.baizhi.service;

import com.baizhi.dao.FirstDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstServiceImpl implements FirstService {
    private FirstDao firstDao;

    @Override
    public void clear() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("first/spring.xml");
        FirstDao firstDao = (FirstDao) context.getBean("firstDao");
        firstDao.save();
    }

    public void setFirstDao(FirstDao firstDao) {
        this.firstDao = firstDao;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("first/spring.xml");
        FirstService firstService = (FirstService) context.getBean("firstService");
        System.out.println("firstService is invoke");
        firstService.clear();
    }
}
