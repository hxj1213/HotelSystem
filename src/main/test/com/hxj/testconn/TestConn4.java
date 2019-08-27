package com.hxj.testconn;


import com.hxj.model.Food;
import com.hxj.model.FoodType;
import com.hxj.page.Page;
import com.hxj.service.FoodService;
import com.hxj.service.FoodTypeService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class TestConn4 {

    FoodService foodService = new FoodService();


    @Test
    public void testAddTable()  throws Exception{
        //String foodName, double price, String remark, String img, FoodType foodType
        FoodType foodType = new FoodType("川菜");
        foodService.add(new Food("辣子鸡",68,"好吃不贵，再来一份","",foodType));
    }

    @Test
    public void testAddTables()  throws Exception{
        FoodType foodType1 = new FoodType(8,"川菜");
        FoodType foodType2 = new FoodType(5,"湘菜");
        List<Food> foods = new ArrayList<>();
        foods.add(new Food("麻婆豆腐",18,"好吃不贵","",foodType1));
        foods.add(new Food("糖醋里脊",28,"好吃不贵","",foodType2));
        foods.add(new Food("蚂蚁上树",45,"好吃不贵","",foodType1));
        foods.add(new Food("椰子鸡",28,"好吃不贵","",foodType2));
        foodService.add(foods);
    }

   /*

    @Test
    public void testupdate()  throws Exception{
        foodService.update(new FoodType(3,"西北菜"));
    }

    @Test
    public void testdel()  throws Exception{
        foodService.delete(3);
    }

    @Test
    public void testdels()  throws Exception{
        foodService.delete(new int[]{1,2,4});
    }

    @Test
    public void testFind()  throws Exception{
        List<FoodType> all = foodService.findAll();
        System.out.println(all);
    }

    @Test
    public void testFindById()  throws Exception{
        FoodType all = foodService.findById(5);
        System.out.println(all);
    }

   */

    @Test
    public void testfind() throws Exception{
        Page<Food> page = new Page<>(1,5);
        HashMap params = new HashMap();
        params.put("foodName","辣子鸡");
        foodService.findByPage(page,params);
        System.out.println(page);
    }

}
