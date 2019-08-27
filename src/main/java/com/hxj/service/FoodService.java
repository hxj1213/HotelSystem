package com.hxj.service;

import com.hxj.mapper.FoodMapper;
import com.hxj.model.Food;
import com.hxj.page.Page;
import com.hxj.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class FoodService {

    SqlSession sqlSession = MybatisUtils.getSqlSession();
    FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);

    public boolean add(Food food){
        int i = -1;
        try{
            i = foodMapper.add(food);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return i>0;
    }

    public boolean add(List<Food> foods){
        int i = -1;
        try{
            i = foodMapper.addList(foods);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return i>0;
    }

    public boolean update(Food food){
        int i = -1;
        try{
            i = foodMapper.update(food);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return i>0;
    }

    public boolean delete(int id){
        int i = -1;
        try{
            i = foodMapper.delete(id);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return i>0;
    }

    public boolean delete(int[] ids){
        int i = -1;
        try{
            i = foodMapper.deleteList(ids);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return i>0;
    }

    public List<Food> findAll(){
        return foodMapper.findAll();
    }

    public Food findById(int id){
        return foodMapper.findById(id);
    }

    /**
     *  分页查询待条件
     * @param page    分页对象
     * @param params  条件集合
     */
    public void findByPage(Page<Food> page, HashMap params){
        //查询总记录数
        int count =  foodMapper.findCount(params);
        System.out.println(count);
        page.setTotalRows(count);
        //计算开始下标
        int startIndex = (page.getPageNow()-1)*page.getPageRows();

        //查询集合的时候需要在条件之上再传入以下两个参数
        params.put("startIndex",startIndex);
        params.put("pageRows",page.getPageRows());

        List<Food> datas = foodMapper.findByPage(params);
        System.out.println(datas);
        page.setDatas(datas);

    }

}
