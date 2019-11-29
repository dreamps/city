package com.baizhi.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;


public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static final ThreadLocal<SqlSession> t = new ThreadLocal<SqlSession>();

    static {
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = t.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            t.set(sqlSession);
        }
        return sqlSession;
    }


    public static void close() {
        SqlSession sqlSession = t.get();
        if (sqlSession != null) {
            sqlSession.close();
            t.remove();
        }
    }

    public static void commit() {
        getSqlSession().commit();
        close();
    }

    public static void rollback() {
        getSqlSession().rollback();
        close();
    }
}
