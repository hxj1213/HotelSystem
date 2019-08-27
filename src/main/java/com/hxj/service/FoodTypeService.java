package com.hxj.service;

import com.hxj.mapper.FoodTypeMapper;
import com.hxj.model.FoodType;
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
public class FoodTypeService {

    SqlSession sqlSession = MybatisUtils.getSqlSession();
    FoodTypeMapper foodTypeMapper = sqlSession.getMapper(FoodTypeMapper.class);

    public boolean add(FoodType foodType){
       int i = -1;
       try{
           i = foodTypeMapper.add(foodType);
           sqlSession.commit();
       }catch (Exception e){
           sqlSession.rollback();
       }finally {
           sqlSession.close();
       }
       return i>0;
    }

    public boolean add(List<FoodType> foodTypes){
        int i = -1;
        try{
            i = foodTypeMapper.addList(foodTypes);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return i>0;
    }

    public boolean update(FoodType foodType){
        int i = -1;
        try{
            i = foodTypeMapper.update(foodType);
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
            i = foodTypeMapper.delete(id);
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
            i = foodTypeMapper.deleteList(ids);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return i>0;
    }

    public List<FoodType> findAll(){
        return foodTypeMapper.findAll();
    }

    public FoodType findById(int id){
        return foodTypeMapper.findById(id);
    }

    /**
     *  分页查询待条件
     * @param page    分页对象
     * @param params  条件集合
     */
    public void findByPage(Page<FoodType> page, HashMap params){
        //查询总记录数
        int count =  foodTypeMapper.findCount(params);
        System.out.println(count);
        page.setTotalRows(count);
        //计算开始下标
        int startIndex = (page.getPageNow()-1)*page.getPageRows();

        //查询集合的时候需要在条件之上再传入以下两个参数
        params.put("startIndex",startIndex);
        params.put("pageRows",page.getPageRows());

        List<FoodType> datas = foodTypeMapper.findByPage(params);
        page.setDatas(datas);

    }



}
