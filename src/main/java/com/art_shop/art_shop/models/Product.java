package com.art_shop.art_shop.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    @Column(nullable = false)
    private Float price;
    private String status;
    private String url_img;
    @Column(nullable = false)
    private Date time_add;
    @Column(nullable = false)
    private Integer discounts;

    @ManyToOne (optional=false)
    @JoinColumn (name="subcategory_id")
    private Subcategory subcategory;

    @ManyToOne (optional=false)
    @JoinColumn (name="fabricator_id")
    private Fabricator fabricator;

    public Integer getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Integer discounts) {
        this.discounts = discounts;
    }

    public Fabricator getFabricator() {
        return fabricator;
    }

    public void setFabricator(Fabricator fabricator) {
        this.fabricator = fabricator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public Date getTime_add() {
        return time_add;
    }

    public void setTime_add(Date time_add) {
        this.time_add = time_add;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

}
