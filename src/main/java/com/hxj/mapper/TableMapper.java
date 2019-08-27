package com.hxj.mapper;

import com.hxj.model.Table;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public interface TableMapper {

    public int addTable(Table table);
    public int addTables(List<Table> tables);
    public int updateTable(Table table);
    public int delTable(int id);
    public int delTables(int[] ids);
    public List<Table> findAllTables();
    public Table findTableById(int id);
    public int findCount(HashMap params);
    public List<Table> findTableByPage(HashMap params);

}
