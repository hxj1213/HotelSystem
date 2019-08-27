package com.hxj.mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public interface BaseMapper<T>{

    public int add(T t);
    public int update(T t);
    public int delete(int id);
    public T findById(int id);
    public List<T> findAll();
    public int findCount(HashMap params);
    public List<T> findByPage(HashMap params);
    public int addList(List<T> list);
    public int deleteList(int[] ids);

}
