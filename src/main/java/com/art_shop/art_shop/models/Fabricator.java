package com.art_shop.art_shop.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Fabricator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;

//    @ManyToMany
//    @JoinTable(name="product_fabricator",
//            joinColumns=@JoinColumn(name="fabricator_id"),
//            inverseJoinColumns=@JoinColumn(name="product_id"))
//    private List<Product> products;
    @OneToMany (mappedBy="fabricator", fetch=FetchType.EAGER)
    private Collection<Product> products;

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
