package com.hxj.testconn;


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
public class TestConn {

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
        int i = sqlSession.insert("tableMapper.addTable",new Table("软件园食堂"));
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
        int i = sqlSession.insert("tableMapper.addTables",tables);
        System.out.println("添加："+i);
        //5、提交
        sqlSession.commit();
    }

    @Test
    public void testupdateTable()  throws Exception{
        //1、读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2、创建session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3、打开会话
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        //4、添加餐桌
        int i = sqlSession.update("tableMapper.updateTable",new Table(1,"四方街",0,null));
        System.out.println("修改："+i);
        //5、提交
        sqlSession.commit();
    }

    @Test
    public void testdelTable()  throws Exception{
        //1、读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2、创建session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3、打开会话
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        //4、添加餐桌
        int i = sqlSession.delete("tableMapper.delTable",1);
        System.out.println("删除："+i);
        //5、提交
        sqlSession.commit();
    }

    @Test
    public void testdelTables()  throws Exception{
        //1、读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2、创建session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3、打开会话
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        //4、添加餐桌
        int i = sqlSession.delete("tableMapper.delTables",new int[]{10,11});
        System.out.println("删除："+i);
        //5、提交
        sqlSession.commit();
    }


    @Test
    public void testfindTables()  throws Exception{
        //1、读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2、创建session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3、打开会话
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        //4、查询餐桌
        List<Table> tables= sqlSession.selectList("tableMapper.findAllTables");
        System.out.println(tables);
    }

    @Test
    public void testfindById()  throws Exception{
        //1、读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2、创建session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3、打开会话
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        //4、查询餐桌
        Table table= sqlSession.selectOne("tableMapper.findTableById",2);
        System.out.println(table);
    }

    @Test
    public void testfindByPage()  throws Exception{
        //1、读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2、创建session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3、打开会话
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);

        Page<Table> page = new Page<>(1,5);
        int startIndex = (page.getPageNow()-1)*page.getPageRows();

        //4、查询餐桌
        HashMap params = new HashMap();
//        params.put("tableName","光");
        params.put("tableStatue",0);
        params.put("startTime",new Date());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        params.put("endTime",simpleDateFormat.parse("2019-08-27 09:34:20"));


        int count = sqlSession.selectOne("tableMapper.findCount",params);
        System.out.println("总记录数："+count);

        page.setTotalRows(count);

        params.put("startIndex",startIndex);
        params.put("pageRows",page.getPageRows());

        List<Table> tables= sqlSession.selectList("tableMapper.findTableByPage",params);
        System.out.println(tables);

        page.setDatas(tables);


        System.out.println(page);
    }


}
