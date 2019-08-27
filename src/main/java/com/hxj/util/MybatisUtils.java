package com.hxj.util;

import com.sun.org.apache.regexp.internal.REUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class MybatisUtils {

    private static SqlSessionFactory factory;

    static {
        try {
            //1、读取配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            //2、创建session工厂
            factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        //3、打开会话
        return factory.openSession();
    }




}
