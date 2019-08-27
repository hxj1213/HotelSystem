package com.hxj.testconn;


import com.hxj.model.FoodType;
import com.hxj.model.Table;
import com.hxj.page.Page;
import com.hxj.service.FoodTypeService;
import com.hxj.service.TableService;
import org.junit.Test;

import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class TestConn3 {

    FoodTypeService foodTypeService = new FoodTypeService();


    @Test
    public void testAddTable()  throws Exception{
        foodTypeService.add(new FoodType("川菜"));
    }

    @Test
    public void testAddTables()  throws Exception{
        List<FoodType> foodTypes = new ArrayList<>();
        foodTypes.add(new FoodType("湘菜"));
        foodTypes.add(new FoodType("东北菜"));
        foodTypes.add(new FoodType("粤菜"));
        foodTypes.add(new FoodType("川菜"));
        foodTypeService.add(foodTypes);
    }

    @Test
    public void testupdate()  throws Exception{
        foodTypeService.update(new FoodType(3,"西北菜"));
    }

    @Test
    public void testdel()  throws Exception{
        foodTypeService.delete(3);
    }

    @Test
    public void testdels()  throws Exception{
        foodTypeService.delete(new int[]{1,2,4});
    }

    @Test
    public void testFind()  throws Exception{
        List<FoodType> all = foodTypeService.findAll();
        System.out.println(all);
    }

    @Test
    public void testFindById()  throws Exception{
        FoodType all = foodTypeService.findById(5);
        System.out.println(all);
    }

    @Test
    public void testfind() throws Exception{
        Page<FoodType> page = new Page<>(1,5);
        HashMap params = new HashMap();
        params.put("typeName","川");
        foodTypeService.findByPage(page,params);
        System.out.println(page);
    }



}
