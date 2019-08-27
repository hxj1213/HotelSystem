package com.hxj.model;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class FoodType {
    private int id;
    private String typeName;

    public FoodType() {
    }

    public FoodType(String typeName) {
        this.typeName = typeName;
    }

    public FoodType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "FoodType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
