package com.hxj.model;

import java.util.Date;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class Table {

    private int id;
    private String tableName;
    private int tableStatue;
    private Date orderDate;

    public Table() {
    }

    public Table(String tableName) {
        this.tableName = tableName;
    }

    public Table(int id, String tableName) {
        this.id = id;
        this.tableName = tableName;
    }

    public Table(int id, String tableName, int tableStatue, Date orderDate) {
        this.id = id;
        this.tableName = tableName;
        this.tableStatue = tableStatue;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getTableStatue() {
        return tableStatue;
    }

    public void setTableStatue(int tableStatue) {
        this.tableStatue = tableStatue;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", tableName='" + tableName + '\'' +
                ", tableStatue=" + tableStatue +
                ", orderDate=" + orderDate +
                '}';
    }
}
