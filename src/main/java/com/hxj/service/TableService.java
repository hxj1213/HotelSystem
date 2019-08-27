package com.hxj.service;

import com.hxj.mapper.TableMapper;
import com.hxj.model.Table;
import com.hxj.page.Page;
import com.hxj.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class TableService {

    SqlSession sqlSession = MybatisUtils.getSqlSession();
    TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);

    public boolean addTable(Table table){
        int i = -1;
        try {
            i =tableMapper.addTable(table);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return i>0;
    }

    public boolean addTable(List<Table> tables){
        int i = -1;
        try {
            i =tableMapper.addTables(tables);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return i>0;
    }


    public boolean updateTable(Table table){
        int i = -1;
        try {
            i =tableMapper.updateTable(table);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return i>0;
    }

    public boolean deleteTable(int id){
        int i = -1;
        try {
            i =tableMapper.delTable(id);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return i>0;
    }

    public boolean deleteTable(int[] ids){
        int i = -1;
        try {
            i =tableMapper.delTables(ids);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return i>0;
    }


    public List<Table> findAllTables(){
        return tableMapper.findAllTables();
    }

    public Table findTableById(int id){
        return tableMapper.findTableById(id);
    }

    /**
     *  分页查询待条件
     * @param page    分页对象
     * @param params  条件集合
     */
    public void findTablesByPage(Page<Table> page, HashMap params){
        //查询总记录数
       int count =  tableMapper.findCount(params);
       System.out.println(count);
       page.setTotalRows(count);
       //计算开始下标
        int startIndex = (page.getPageNow()-1)*page.getPageRows();

        //查询集合的时候需要在条件之上再传入以下两个参数
       params.put("startIndex",startIndex);
       params.put("pageRows",page.getPageRows());

       List<Table> tables = tableMapper.findTableByPage(params);
       page.setDatas(tables);

    }

}
