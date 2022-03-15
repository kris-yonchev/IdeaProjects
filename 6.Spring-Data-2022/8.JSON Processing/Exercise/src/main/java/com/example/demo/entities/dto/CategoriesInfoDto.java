package com.example.demo.entities.dto;

import com.google.gson.annotations.Expose;


public class CategoriesInfoDto {

    @Expose
    private String category;

    @Expose
    private int productsCount;

    @Expose
    private Double avgPrice;

    @Expose
    private Double totalRevenue;

    public CategoriesInfoDto() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
