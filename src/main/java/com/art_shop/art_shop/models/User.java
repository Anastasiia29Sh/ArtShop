package com.art_shop.art_shop.models;

import org.thymeleaf.engine.DataDrivenTemplateIterator;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String second_name;
    private String third_name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String tel;
    @Column(nullable = false)
    private Date birthday;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getThird_name() {
        return third_name;
    }

    public void setThird_name(String third_name) {
        this.third_name = third_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
