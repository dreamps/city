package com.baizhi.dao;

public class FirstDaoImpl implements FirstDao {
    @Override
    public void save() {
        System.out.println("FirstDao is invoke..........");
    }

    /*public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("first/spring.xml");
        FirstDao firstDao = (FirstDao) context.getBean("firstDao");
        System.out.println("1111111111111");
        firstDao.save();
    }*/

}
