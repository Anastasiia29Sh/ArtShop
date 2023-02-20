package com.art_shop.art_shop.controllers;

import com.art_shop.art_shop.repositories.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactsController {
    @Autowired
    private BasketRepository basketRepository;

    @GetMapping("/contacts")
    public String greeting(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                           @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "Контакты");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "contacts";
    }
}
