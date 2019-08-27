package com.hxj.testconn;


import com.hxj.mapper.TableMapper;
import com.hxj.model.Table;
import com.hxj.page.Page;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class TestConn1 {

    @Test
    public void testConn() throws Exception{

        //1、读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2、创建session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3、打开会话
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);


    }

    @Test
    public void testAddTable()  throws Exception{
        //1、读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2、创建session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3、打开会话
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        //4、添加餐桌
        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);
        int i = tableMapper.addTable(new Table("紫竹林"));
        System.out.println("添加："+i);
        //5、提交
        sqlSession.commit();
    }

    @Test
    public void testAddTables()  throws Exception{
        //1、读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2、创建session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3、打开会话
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        //4、添加餐桌
        List<Table> tables = new ArrayList<>();
        tables.add(new Table("巴山夜雨"));
        tables.add(new Table("紫竹林"));
        tables.add(new Table("南天门"));
        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);
        int i = tableMapper.addTables(tables);
        System.out.println("添加："+i);
        //5、提交
        sqlSession.commit();
    }



}
