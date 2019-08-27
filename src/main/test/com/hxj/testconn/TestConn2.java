package com.hxj.testconn;


import com.hxj.mapper.TableMapper;
import com.hxj.model.Table;
import com.hxj.page.Page;
import com.hxj.service.TableService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class TestConn2 {

    TableService tableService = new TableService();


    @Test
    public void testAddTable()  throws Exception{
        /*boolean flag = tableService.addTable(new Table("西天"));
        System.out.println(flag);*/
        List<Table> tables = new ArrayList<>();
        tables.add(new Table("巴山夜雨"));
        tables.add(new Table("紫竹林"));
        tables.add(new Table("南天门"));
        boolean flag = tableService.addTable(tables);
        System.out.println(flag);
    }

    @Test
    public void testfind() throws Exception{
        Page<Table> page = new Page<>(1,5);
        HashMap params = new HashMap();
        params.put("tableName","光");
        tableService.findTablesByPage(page,params);
        System.out.println(page);
    }



}
