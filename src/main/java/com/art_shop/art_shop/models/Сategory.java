package com.art_shop.art_shop.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Сategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;

    @OneToMany (mappedBy="category", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Subcategory> subcategories;

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

    public Collection<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Collection<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }
}
