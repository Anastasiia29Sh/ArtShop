package com.art_shop.art_shop.controllers;

import com.art_shop.art_shop.models.Checkbox;
import com.art_shop.art_shop.models.User;
import com.art_shop.art_shop.repositories.BasketRepository;
import com.art_shop.art_shop.repositories.ProductRepository;
import com.art_shop.art_shop.models.ProductJoinSubcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BasketController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BasketRepository basketRepository;

    @GetMapping("/basket")
    public String greeting(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                           @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {

        model.addAttribute("title", "Корзина");
        model.addAttribute("name_user", name_user);

        System.out.println(Long.parseLong(id_accaunt_user));

        Long id = Long.parseLong(id_accaunt_user);

        if(Long.parseLong(id_accaunt_user) != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);


            List<Long> product_basket_id = basketRepository.product_basket_id(id);
            model.addAttribute("product_basket_id", product_basket_id);

            List<String> product_basket_title = basketRepository.product_basket_title(id);
            model.addAttribute("product_basket_title", product_basket_title);

            List<String> product_basket_status = basketRepository.product_basket_status(id);
            model.addAttribute("product_basket_status", product_basket_status);

            List<String> product_basket_fabricator = basketRepository.product_basket_fabricator(id);
            model.addAttribute("product_basket_fabricator", product_basket_fabricator);

            List<String> product_basket_url_img = basketRepository.product_basket_url_img(id);
            model.addAttribute("product_basket_url_img", product_basket_url_img);

            List<Integer> product_basket_count = basketRepository.product_basket_count(id);
            model.addAttribute("product_basket_count", product_basket_count);

            List<Integer> product_basket_discounts = basketRepository.product_basket_discounts(id);
            model.addAttribute("product_basket_discounts", product_basket_discounts);

            List<Float> product_basket_price = basketRepository.product_basket_price(id);
            model.addAttribute("product_basket_price", product_basket_price);


            List<ProductJoinSubcategory> res = new ArrayList<>();
            for (int i = 0; i < product_basket_title.size(); i++) {
                res.add(new ProductJoinSubcategory(product_basket_id.get(i), product_basket_title.get(i), product_basket_status.get(i), product_basket_fabricator.get(i),
                        product_basket_url_img.get(i), product_basket_count.get(i), product_basket_discounts.get(i), product_basket_price.get(i)));
            }
            model.addAttribute("all", res);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        Checkbox checkbox = new Checkbox();
        Date d = basketRepository.now_day();
        checkbox.setBirthday(d);
        checkbox.setDelivery("pickup");
        checkbox.setPayment("cash");
        model.addAttribute("checkbox", checkbox);

        String name1 = basketRepository.name1_user(id);
        model.addAttribute("name1_user", name1);
        String name2 = basketRepository.name2_user(id);
        model.addAttribute("name2_user", name2);
        String email = basketRepository.email_user(id);
        model.addAttribute("email_user", email);

        return "basket";
    }


    @GetMapping("/basket/{id}")
    public String greeting(@PathVariable(value = "id") long id, Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                           @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "Корзина");
        model.addAttribute("name_user", name_user);

        Long idd = Long.parseLong(id_accaunt_user);

        basketRepository.del_basket(idd, id);

        return "redirect:/basket";
    }



    @RequestMapping(value = "/basket", method=RequestMethod.POST)
    public String processForm(@ModelAttribute(value="checkbox") Checkbox checkbox,
                              @ModelAttribute(value="checkbox") Checkbox count,
                              @ModelAttribute(value="checkbox") Checkbox address,
                              @ModelAttribute(value="checkbox") Checkbox commet,
                              @ModelAttribute(value="checkbox") Checkbox delivery,
                              @ModelAttribute(value="checkbox") Checkbox payment,
                              Model model,
                              @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                              @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {

        model.addAttribute("name_user", name_user);
        Long idd = Long.parseLong(id_accaunt_user);


        String add = address.getAddress();
        String comm = commet.getCommet();
        String deliv = delivery.getDelivery();
        String pay = payment.getPayment();

        List<Long> checkedItems = checkbox.getList_product();

        List<String> list_count = count.getList_count();
        if (list_count.size() != 0) {
            for (String s : list_count) {
                Long id = Long.parseLong(s.substring(0, s.indexOf('_')));
                Integer c = Integer.parseInt(s.substring(s.indexOf('_') + 1));
                basketRepository.update_basket(c, id, idd);
            }
        }

        String mes = "";
        if (checkedItems.size() == 0) {
            mes = "Выберите товары";
        } else {
            if (add == null || add == "") {
                mes = "Пожалуйста, введите адрес";
            }
        }



        if(mes == "") {
            if (deliv.equals("pickup")) deliv = "Самовывоз";
            if (deliv.equals("courier")) deliv = "Курьер";
            if (deliv.equals("post")) deliv = "Почта России";
            if (pay.equals("cash")) pay = "наличные";
            if (pay.equals("no-cash")) pay = "безналичные";

            basketRepository.in_order(idd, pay, deliv, comm, add);
            Integer id_order = basketRepository.id_order();

            Integer all_summa = 0;
            Integer action = 0;

            for (int i = 0; i < checkedItems.size(); i++) {
                basketRepository.in_order_product(idd, id_order, checkedItems.get(i));
                all_summa += basketRepository.all_summa(checkedItems.get(i), idd);
            }
            Integer is_day_user = basketRepository.is_day_user(idd);
            Integer count_order = basketRepository.count_order(idd);
            if(is_day_user == 1) action = 15;
            if(checkedItems.size() > 10) action = 10;
            if(count_order >= 10) action = 10;
            if(is_day_user == 1 && checkedItems.size() > 10) action = 15;
            if(is_day_user == 1 && count_order >= 10) action = 15;
            if(is_day_user == 1 && checkedItems.size() > 10 && count_order >= 10) action = 15;
            if(checkedItems.size() > 10 && count_order >= 10) action = 10;

            all_summa = (all_summa * (100 - action))/100;
            model.addAttribute("all_summa", all_summa);

            System.out.println("Summa = " + all_summa);

            if(idd != 0){
                int count_product_basket = basketRepository.list_product_basket(idd);
                model.addAttribute("count_product_basket", count_product_basket);
            }else{
                model.addAttribute("count_product_basket", 0);
            }
            model.addAttribute("title", "Заказ");
            model.addAttribute("id_order", id_order);
            model.addAttribute("flag", "false");


            return "is_agree_order";


        }else {
            model.addAttribute("mes", mes);
            model.addAttribute("title", "Корзина");

            if (idd != 0) {
                int count_product_basket = basketRepository.list_product_basket(idd);
                model.addAttribute("count_product_basket", count_product_basket);


                List<Long> product_basket_id = basketRepository.product_basket_id(idd);
                model.addAttribute("product_basket_id", product_basket_id);

                List<String> product_basket_title = basketRepository.product_basket_title(idd);
                model.addAttribute("product_basket_title", product_basket_title);

                List<String> product_basket_status = basketRepository.product_basket_status(idd);
                model.addAttribute("product_basket_status", product_basket_status);

                List<String> product_basket_fabricator = basketRepository.product_basket_fabricator(idd);
                model.addAttribute("product_basket_fabricator", product_basket_fabricator);

                List<String> product_basket_url_img = basketRepository.product_basket_url_img(idd);
                model.addAttribute("product_basket_url_img", product_basket_url_img);

                List<Integer> product_basket_count = basketRepository.product_basket_count(idd);
                model.addAttribute("product_basket_count", product_basket_count);

                List<Integer> product_basket_discounts = basketRepository.product_basket_discounts(idd);
                model.addAttribute("product_basket_discounts", product_basket_discounts);

                List<Float> product_basket_price = basketRepository.product_basket_price(idd);
                model.addAttribute("product_basket_price", product_basket_price);


                List<ProductJoinSubcategory> res = new ArrayList<>();
                for (int i = 0; i < product_basket_title.size(); i++) {
                    res.add(new ProductJoinSubcategory(product_basket_id.get(i), product_basket_title.get(i), product_basket_status.get(i), product_basket_fabricator.get(i),
                            product_basket_url_img.get(i), product_basket_count.get(i), product_basket_discounts.get(i), product_basket_price.get(i)));
                }
                model.addAttribute("all", res);
            } else model.addAttribute("count_product_basket", 0);

            String name1 = basketRepository.name1_user(idd);
            model.addAttribute("name1_user", name1);
            String name2 = basketRepository.name2_user(idd);
            model.addAttribute("name2_user", name2);
            String email = basketRepository.email_user(idd);
            model.addAttribute("email_user", email);

            return "basket";
        }

    }


    @GetMapping("/order_ok/{id_order}")
    public String order_ok(@PathVariable(value = "id_order") Integer id_order, Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                           @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "Заказ");
        model.addAttribute("name_user", name_user);
        Long idd = Long.parseLong(id_accaunt_user);
        if(idd != 0){
            int count_product_basket = basketRepository.list_product_basket(idd);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        System.out.println(id_order);

        basketRepository.ok_order(idd, id_order);

        model.addAttribute("flag", "true");

        if(idd != 0){
            int count_product_basket = basketRepository.list_product_basket(idd);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "is_agree_order";
    }






    @GetMapping("/order_no/{id_order}")
    public String order_no(@PathVariable(value = "id_order") Integer id_order, Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                           @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "Заказ");
        model.addAttribute("name_user", name_user);
        Long idd = Long.parseLong(id_accaunt_user);
        if(idd != 0){
            int count_product_basket = basketRepository.list_product_basket(idd);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        basketRepository.del_order(id_order);

        return "redirect:/basket";
    }



}
