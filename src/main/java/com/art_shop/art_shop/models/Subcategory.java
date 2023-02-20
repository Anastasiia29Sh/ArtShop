package com.art_shop.art_shop.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="category_id")
    private Сategory category;

    @OneToMany (mappedBy="subcategory", fetch=FetchType.EAGER)
    private Collection<Product> products;

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

    public Сategory getCategory() {
        return category;
    }

    public void setCategory(Сategory category) {
        this.category = category;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
