package com.art_shop.art_shop.models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Checkbox {
    private List<Long> list_product = new ArrayList<>();
    private List<String> list_count = new ArrayList<>();
    private String first_name;
    private String second_name;
    private String third_name;
    private String password;
    private String password2;

    public String getThird_name() {
        return third_name;
    }

    public void setThird_name(String third_name) {
        this.third_name = third_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    private String email;
    private String address;

    private Date birthday;
    private String tel;
    private String commet;
    private String delivery;
    private String payment;

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getCommet() {
        return commet;
    }

    public void setCommet(String commet) {
        this.commet = commet;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public List<Long> getList_product() {
        return list_product;
    }

    public void setList_product(List<Long> list_product) {
        this.list_product = list_product;
    }

    public List<String> getList_count() {
        return list_count;
    }

    public void setList_count(List<String> list_count) {
        this.list_count = list_count;
    }
}
