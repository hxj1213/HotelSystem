package com.hxj.model;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class Food {

    private int id;
    private String foodName;
    private double price;
    private String remark;
    private String img;
    private FoodType foodType;//foodType.getId()

    public Food() {
    }

    public Food(String foodName, double price, String remark, String img, FoodType foodType) {
        this.foodName = foodName;
        this.price = price;
        this.remark = remark;
        this.img = img;
        this.foodType = foodType;
    }

    public Food(int id, String foodName, double price, String remark, String img, FoodType foodType) {
        this.id = id;
        this.foodName = foodName;
        this.price = price;
        this.remark = remark;
        this.img = img;
        this.foodType = foodType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", price=" + price +
                ", remark='" + remark + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
