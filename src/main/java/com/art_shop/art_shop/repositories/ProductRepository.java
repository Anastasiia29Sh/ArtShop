package com.art_shop.art_shop.repositories;

import com.art_shop.art_shop.models.Product;
import com.art_shop.art_shop.models.ProductJoinSubcategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("SELECT p FROM Product p JOIN p.subcategory s WHERE s.title LIKE 'Подарок художнику'")
    public List<Product> join_present();

    @Query(value = "call novelties", nativeQuery = true)
    public List<Product> join_novelties();

    @Query(value = "SELECT * FROM product p JOIN subcategory s ON p.subcategory_id = s.id WHERE s.title NOT LIKE 'Подарок художнику' and p.discounts!=0", nativeQuery = true)
    public List<Product> join_discounts();

    //    Выборка - Категории
    @Query(value = "SELECT * FROM product p JOIN subcategory s ON p.subcategory_id = s.id JOIN сategory с ON s.category_id = с.id \n" +
            "  WHERE с.title LIKE :name_category AND s.title NOT LIKE 'Подарок художнику'", nativeQuery = true)
    public List<Product> product_category(@Param("name_category") String name_category);

    //    Выборка - Подкатегории
    @Query(value = "SELECT * FROM product p JOIN subcategory s ON p.subcategory_id = s.id\n" +
            "  WHERE s.title LIKE :name_subcategory AND s.title NOT LIKE 'Подарок художнику';", nativeQuery = true)
    public List<Product> product_subcategory(@Param("name_subcategory") String name_subcategory);


    @Query("SELECT p \n" +
            "  from Product p, Subcategory s where p.subcategory = s and p.id = :id")
    public List<Product> info_product(@Param("id") Long id);








}
