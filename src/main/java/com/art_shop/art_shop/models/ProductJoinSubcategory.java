package com.art_shop.art_shop.models;

import java.sql.Date;

public class ProductJoinSubcategory {
    private Long id;
    private String title_product;
    private String description;
    private Float price;
    private String url_img;
    private String status;
    private String title_category;
    private Integer discounts;
    private Integer count;
    private String fabricator_name;
    private Date time_order;

    public Date getTime_order() {
        return time_order;
    }

    public void setTime_order(Date time_order) {
        this.time_order = time_order;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Integer discounts) {
        this.discounts = discounts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle_product() {
        return title_product;
    }

    public void setTitle_product(String title_product) {
        this.title_product = title_product;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFabricator_name() {
        return fabricator_name;
    }

    public void setFabricator_name(String fabricator_name) {
        this.fabricator_name = fabricator_name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle_category() {
        return title_category;
    }

    public void setTitle_category(String title_category) {
        this.title_category = title_category;
    }

//    public ProductJoinSubcategory(Long id, String title_product, String description, Float price, String url_img, String status, Integer discounts, String title_category) {
//        this.id = id;
//        this.title_product = title_product;
//        this.description = description;
//        this.price = price;
//        this.url_img = url_img;
//        this.status = status;
//        this.discounts = discounts;
//        this.title_category = title_category;
//    }
    public ProductJoinSubcategory(Long id, String title_product, String status, String fabricator_name, String url_img, Integer count, Integer discounts, Float price) {
        this.id = id;
        this.title_product = title_product;
        this.status = status;
        this.fabricator_name = fabricator_name;
        this.url_img = url_img;
        this.count = count;
        this.discounts = discounts;
        this.price = price;
    }

    public ProductJoinSubcategory(Long id, String title_product, String url_img, Integer discounts, Float price, Date time_order) {
        this.id = id;
        this.title_product = title_product;
        this.url_img = url_img;
        this.discounts = discounts;
        this.price = price;
        this.time_order = time_order;
    }

    public ProductJoinSubcategory() {
    }
}
