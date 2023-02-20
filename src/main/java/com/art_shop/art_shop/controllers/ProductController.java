package com.art_shop.art_shop.controllers;

import com.art_shop.art_shop.models.Basket;
import com.art_shop.art_shop.models.Product;
import com.art_shop.art_shop.models.ProductJoinSubcategory;
import com.art_shop.art_shop.repositories.BasketRepository;
import com.art_shop.art_shop.repositories.ProductRepository;
import com.art_shop.art_shop.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BasketRepository basketRepository;

    @GetMapping("/product/{id}")
    public String greeting(@PathVariable(value = "id") long id, Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                           @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "ArtShop");
        List<Product> res = productRepository.info_product(id);
        model.addAttribute("info_product", res);
        model.addAttribute("name_user", name_user);
        Long idd = Long.parseLong(id_accaunt_user);

        if(idd != 0){
            int count_product_basket = basketRepository.list_product_basket(idd);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "product";
    }
    @GetMapping("/{id}")
    public String basket(@PathVariable(value = "id") long id, Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                         @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "ArtShop");
        model.addAttribute("id_product", id);
        model.addAttribute("name_user", name_user);
        Long idd = Long.parseLong(id_accaunt_user);

        if(idd != 0){
            int count_product_basket = basketRepository.list_product_basket(idd);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        basketRepository.in_basket(1, id, idd);

        return "redirect:/#" + id;
    }

    @GetMapping("list_product/{id}/{name_str}")
    public String basket1(@PathVariable(value = "id") long id,
                          @PathVariable(value = "name_str") String name_str, Model model,
                          @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                          @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "ArtShop");
        model.addAttribute("id_product", id);
        model.addAttribute("name_user", name_user);
        Long idd = Long.parseLong(id_accaunt_user);

        if(idd != 0){
            int count_product_basket = basketRepository.list_product_basket(idd);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        basketRepository.in_basket(1, id, idd);

        return "redirect:/" + name_str + "#" + id;
    }

    @GetMapping("product/list_product/{id}")
    public String basket3(@PathVariable(value = "id") long id, Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                          @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "ArtShop");
        model.addAttribute("id_product", id);
        model.addAttribute("name_user", name_user);
        Long idd = Long.parseLong(id_accaunt_user);

        if(idd != 0){
            int count_product_basket = basketRepository.list_product_basket(idd);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        basketRepository.in_basket(1, id, idd);

        return "redirect:/product/" + id;
    }
}
