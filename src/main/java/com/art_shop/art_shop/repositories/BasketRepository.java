package com.art_shop.art_shop.repositories;

import com.art_shop.art_shop.models.Basket;
import com.art_shop.art_shop.models.ProductJoinSubcategory;
import com.art_shop.art_shop.models.Product;
import com.art_shop.art_shop.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.sql.Date;
import java.util.List;

public interface BasketRepository extends CrudRepository<Basket, Long> {

    @Transactional
    @Modifying
    @Query(value = "call in_basket(:count, :id_product, :id_user);", nativeQuery = true)
    public void in_basket(@Param("count") Integer count, @Param("id_product") Long id_product, @Param("id_user") Long id_user);

    @Query(value =  "SELECT COUNT(*) FROM basket_user b WHERE b.id_user = :id", nativeQuery = true)
    public Integer list_product_basket(@Param("id") Long id);

    @Query(value = "SELECT p.id FROM basket_user bu JOIN basket b ON bu.id_basket = b.id JOIN product p ON b.id_product = p.id WHERE bu.id_user = :id ORDER BY b.id_product", nativeQuery = true)
    public List<Long> product_basket_id(@Param("id") Long id);

    @Query(value = "SELECT p.title FROM basket_user bu JOIN basket b ON bu.id_basket = b.id JOIN product p ON b.id_product = p.id WHERE bu.id_user = :id ORDER BY b.id_product", nativeQuery = true)
    public List<String> product_basket_title(@Param("id") Long id);

    @Query(value = "SELECT p.price FROM basket_user bu JOIN basket b ON bu.id_basket = b.id JOIN product p ON b.id_product = p.id WHERE bu.id_user = :id ORDER BY b.id_product", nativeQuery = true)
    public List<Float> product_basket_price(@Param("id") Long id);

    @Query(value = "SELECT p.url_img FROM basket_user bu JOIN basket b ON bu.id_basket = b.id JOIN product p ON b.id_product = p.id WHERE bu.id_user = :id ORDER BY b.id_product", nativeQuery = true)
    public List<String> product_basket_url_img(@Param("id") Long id);

    @Query(value = "SELECT p.discounts FROM basket_user bu JOIN basket b ON bu.id_basket = b.id JOIN product p ON b.id_product = p.id WHERE bu.id_user = :id ORDER BY b.id_product", nativeQuery = true)
    public List<Integer> product_basket_discounts(@Param("id") Long id);

    @Query(value = "SELECT p.status FROM basket_user bu JOIN basket b ON bu.id_basket = b.id JOIN product p ON b.id_product = p.id WHERE bu.id_user = :id ORDER BY b.id_product", nativeQuery = true)
    public List<String> product_basket_status(@Param("id") Long id);

    @Query(value = "SELECT bu.count FROM basket_user bu JOIN basket b ON bu.id_basket = b.id JOIN product p ON b.id_product = p.id WHERE bu.id_user = :id ORDER BY b.id_product", nativeQuery = true)
    public List<Integer> product_basket_count(@Param("id") Long id);

    @Query(value = "SELECT f.name FROM basket_user bu JOIN basket b ON bu.id_basket = b.id JOIN product p ON b.id_product = p.id JOIN fabricator f ON p.fabricator_id = f.id WHERE bu.id_user = :id ORDER BY b.id_product", nativeQuery = true)
    public List<String> product_basket_fabricator(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "call update_basket(:count, :id_product, :id_user);", nativeQuery = true)
    public void update_basket(@Param("count") Integer count, @Param("id_product") Long id_product, @Param("id_user") Long id_user);



    @Transactional
    @Modifying
    @Query(value = "call del_basket(:id_user, :id_product);", nativeQuery = true)
    void del_basket(@Param("id_user") Long id_user, @Param("id_product") Long id_product);



    @Query(value = "SELECT CURDATE();", nativeQuery = true)
    public Date now_day();


    @Query(value = "SELECT u.first_name from user u where u.id = :id", nativeQuery = true)
    public String name1_user(@Param("id") Long id);

    @Query(value = "SELECT u.second_name from user u where u.id = :id", nativeQuery = true)
    public String name2_user(@Param("id") Long id);

    @Query(value = "SELECT u.third_name from user u where u.id = :id", nativeQuery = true)
    public String name3_user(@Param("id") Long id);

    @Query(value = "SELECT u.email from user u where u.id = :id", nativeQuery = true)
    public String email_user(@Param("id") Long id);

    @Query(value = "SELECT u.tel from user u where u.id = :id", nativeQuery = true)
    public String tel_user(@Param("id") Long id);

    @Query(value = "SELECT u.birthday from user u where u.id = :id", nativeQuery = true)
    public Date birthday_user(@Param("id") Long id);



    @Transactional
    @Modifying
    @Query(value = "call in_order(:id_user, :type_payment, :type_delivery, :comment, :address)", nativeQuery = true)
    public Integer in_order(@Param("id_user") Long id_user, @Param("type_payment") String type_payment, @Param("type_delivery") String type_delivery,
                     @Param("comment") String comment, @Param("address") String address);


    @Query(value = "SELECT MAX(id) FROM `order`", nativeQuery = true)
    public Integer id_order();

    @Transactional
    @Modifying
    @Query(value = "call in_order_product(:id_user, :id_order, :id_product)", nativeQuery = true)
    public void in_order_product(@Param("id_user") Long id_user, @Param("id_order") Integer id_order, @Param("id_product") Long id_product);


    @Query(value = "SELECT all_summa(:id_product, :id_user)", nativeQuery = true)
    public Integer all_summa(@Param("id_product") Long id_product, @Param("id_user") Long id_user);


    @Query(value = "SELECT is_day_user(:id_user)", nativeQuery = true)
    public Integer is_day_user(@Param("id_user") Long id_user);

    @Query(value = "SELECT COUNT(*) FROM `order` o WHERE o.id_user = :id_user AND o.time_order >= SUBDATE(NOW(), INTERVAL 3 MONTH);", nativeQuery = true)
    public Integer count_order(@Param("id_user") Long id_user);



    @Transactional
    @Modifying
    @Query(value = "DELETE FROM basket_user WHERE id_basket IN (SELECT op.id_basket FROM order_product op JOIN basket b ON op.id_basket = b.id WHERE op.id_order = :id_order) AND id_user = :id_user", nativeQuery = true)
    public void ok_order(@Param("id_user") Long id_user, @Param("id_order") Integer id_order);


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM `order` WHERE id = :id_order", nativeQuery = true)
    public void del_order(@Param("id_order") Integer id_order);


}
