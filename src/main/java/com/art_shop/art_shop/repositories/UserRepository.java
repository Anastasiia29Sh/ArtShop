package com.art_shop.art_shop.repositories;

import com.art_shop.art_shop.models.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.art_shop.art_shop.models.User;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT COUNT(*) FROM аuthorization а WHERE а.login = :login", nativeQuery = true)
    public Integer is_login(@Param("login") String login);

    @Query(value = "SELECT COUNT(*) FROM аuthorization а WHERE а.login = :login AND а.password LIKE :password", nativeQuery = true)
    public Integer is_pass(@Param("login") String login, @Param("password") String password);

    @Query(value = "SELECT COUNT(*) FROM аuthorization а WHERE а.password LIKE :password", nativeQuery = true)
    public Integer is_pass2(@Param("password") String password);

    @Query(value = "SELECT u.first_name FROM user u WHERE u.email = :login", nativeQuery = true)
    public String first_name(@Param("login") String login);

    @Query(value = "SELECT u.id FROM user u WHERE u.email = :login", nativeQuery = true)
    public Long id_accaunt_user(@Param("login") String login);

    @Transactional
    @Modifying
    @Query(value = "CALL add_user(:name1, :name2, :name3, :mail, :day, :tel, :pass);", nativeQuery = true)
    void add_user(@Param("name1") String name1, @Param("name2") String name2, @Param("name3") String name3,
                  @Param("mail") String mail, @Param("day") Date day, @Param("tel") String tel, @Param("pass") String pass);


    @Transactional
    @Modifying
    @Query(value = "CALL update_user(:id, :name1, :name2, :name3, :mail, :day, :tel, :pass);", nativeQuery = true)
    void update_user(@Param("id") Long id, @Param("name1") String name1, @Param("name2") String name2, @Param("name3") String name3,
                  @Param("mail") String mail, @Param("day") Date day, @Param("tel") String tel, @Param("pass") String pass);


    @Query(value = "SELECT title FROM buy_user WHERE id_user = :id ORDER BY time_order, id", nativeQuery = true)
    public List<String> buy_title(@Param("id") Long id);

    @Query(value = "SELECT price FROM buy_user WHERE id_user = :id ORDER BY time_order, id", nativeQuery = true)
    public List<Float> buy_price(@Param("id") Long id);

    @Query(value = "SELECT discounts FROM buy_user WHERE id_user = :id ORDER BY time_order, id", nativeQuery = true)
    public List<Integer> buy_discounts(@Param("id") Long id);

    @Query(value = "SELECT time_order FROM buy_user WHERE id_user = :id ORDER BY time_order, id", nativeQuery = true)
    public List<Date> buy_time_order(@Param("id") Long id);

    @Query(value = "SELECT url_img FROM buy_user WHERE id_user = :id ORDER BY time_order, id", nativeQuery = true)
    public List<String> buy_img(@Param("id") Long id);

    @Query(value = "SELECT id FROM buy_user WHERE id_user = :id ORDER BY time_order, id", nativeQuery = true)
    public List<Long> buy_id(@Param("id") Long id);


}
