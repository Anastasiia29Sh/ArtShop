package com.art_shop.art_shop.models;

import org.springframework.data.annotation.Reference;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;

@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer count;


    private Long id_product;

//    @OneToMany(fetch=FetchType.EAGER)
//    private Collection<Product> products;


    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Basket(Integer count, Long id_product) {
        this.count = count;
        this.id_product = id_product;
    }
    public Basket(){

    }
}
