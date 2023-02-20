package com.art_shop.art_shop.controllers;

import com.art_shop.art_shop.models.Checkbox;
import com.art_shop.art_shop.models.ProductJoinSubcategory;
import com.art_shop.art_shop.models.User_infa;
import com.art_shop.art_shop.repositories.BasketRepository;
import com.art_shop.art_shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BasketRepository basketRepository;


    @RequestMapping(value = "/input_user", method=RequestMethod.POST)
    public String user(@RequestParam String login, @RequestParam String password, @RequestParam String path,
                       HttpServletResponse response, RedirectAttributes redirectAttributes, Model model){

        Integer is_login = userRepository.is_login(login);

        String mess = "";
        String active = "false";
        Long id_accaunt_user = Long.valueOf(0);

        if(login == null || login == "" || password == null || password == ""){
            mess = "Пожалуйста, введите все данные";
            active = "true";
        }else {
            if (is_login == 1) {
                Integer is_pass = userRepository.is_pass(login, password);
                if (is_pass == 1) {
                    String name_user = userRepository.first_name(login);
                    id_accaunt_user = userRepository.id_accaunt_user(login);

                    Cookie foo = new Cookie("name_user", name_user);
                    foo.setMaxAge(43200);
                    response.addCookie(foo);

                    Cookie foo2 = new Cookie("id_accaunt_user", Objects.toString(id_accaunt_user));
                    foo2.setMaxAge(43200);
                    response.addCookie(foo2);

                    active = "false";

                } else { mess = "Неверный логин или пароль"; active = "true"; }

            } else { mess = "Неверный логин или пароль"; active = "true"; }
        }


        redirectAttributes.addFlashAttribute("id_accaunt_user", id_accaunt_user);
        redirectAttributes.addFlashAttribute("mess", mess);
        redirectAttributes.addFlashAttribute("active", active);
        return "redirect:" + path;
    }


    @GetMapping("/registration")
    public String greeting(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                           @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "Регистрация");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        Checkbox checkbox = new Checkbox();
        Date d = basketRepository.now_day();
        checkbox.setBirthday(d);

        model.addAttribute("checkbox", checkbox);

        return "registration";
    }


    @RequestMapping(value = "/registration", method=RequestMethod.POST)
    public String processForm(@ModelAttribute(value="checkbox") Checkbox first_name,
                              @ModelAttribute(value="checkbox") Checkbox second_name,
                              @ModelAttribute(value="checkbox") Checkbox third_name,
                              @ModelAttribute(value="checkbox") Checkbox email,
                              @ModelAttribute(value="checkbox") Checkbox tel,
                              @ModelAttribute(value="checkbox") Checkbox birthday,
                              @ModelAttribute(value="checkbox") Checkbox password,
                              @ModelAttribute(value="checkbox") Checkbox password2,
                              Model model,
                              @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                              @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {

        model.addAttribute("title", "Регистрация");

        model.addAttribute("name_user", name_user);
        Long idd = Long.parseLong(id_accaunt_user);

        if(idd != 0){
            int count_product_basket = basketRepository.list_product_basket(idd);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        String name1 = first_name.getFirst_name();
        String name2 = second_name.getSecond_name();
        String name3 = third_name.getThird_name();
        String mail = email.getEmail();
        String tell = tel.getTel();
        Date bir = birthday.getBirthday();
        String pass1 = password.getPassword();
        String pass2 = password2.getPassword2();

        String mess_erroy = "";



        if(name1 == null || name1 == "" || name2 == null || name2 == "" ||
                mail == null || mail == "" || tell == null || tell == "" || pass1 == null || pass1 == "" || pass2 == null || pass2 == ""){
            mess_erroy = "Пожалуйста, введите все данные";
            model.addAttribute("mess_erroy", mess_erroy);
            return "registration";
        }
        if(!pass1.equals(pass2)){
            mess_erroy = "Пароли не совпадают";
            model.addAttribute("mess_erroy", mess_erroy);
            return "registration";
        }
        if(userRepository.is_login(mail) != 0){
            mess_erroy = "Такой email уже существует";
            model.addAttribute("mess_erroy", mess_erroy);
            return "registration";
        }
        if(userRepository.is_pass2(pass1) != 0){
            mess_erroy = "Такой пароль уже существует";
            model.addAttribute("mess_erroy", mess_erroy);
            return "registration";
        }
        if(name3 == null || name3 == ""){
            name3 = "";
        }

        userRepository.add_user(name1, name2, name3, mail, bir, tell, pass1);

        model.addAttribute("mess_erroy", mess_erroy);

        return "registration_ok";
    }


    @GetMapping("/profile")
    public String profile(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                           @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "Мой профиль");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        Checkbox checkbox = new Checkbox();
        Date d = basketRepository.birthday_user(id);
        checkbox.setBirthday(d);

        model.addAttribute("checkbox", checkbox);

        String n1 = basketRepository.name1_user(id);
        String n2 = basketRepository.name2_user(id);
        String n3 = basketRepository.name3_user(id);
        String em = basketRepository.email_user(id);
        String t = basketRepository.tel_user(id);

        model.addAttribute("name_user1", n1);
        model.addAttribute("name_user2", n2);
        model.addAttribute("name_user3", n3);
        model.addAttribute("email_user", em);
        model.addAttribute("tel_user", t);

        return "profile";
    }

//    *****************************************************************


    @RequestMapping(value = "/update_user", method=RequestMethod.POST)
    public String procForm(@ModelAttribute(value="checkbox") Checkbox first_name,
                              @ModelAttribute(value="checkbox") Checkbox second_name,
                              @ModelAttribute(value="checkbox") Checkbox third_name,
                              @ModelAttribute(value="checkbox") Checkbox email,
                              @ModelAttribute(value="checkbox") Checkbox tel,
                              @ModelAttribute(value="checkbox") Checkbox birthday,
                              @ModelAttribute(value="checkbox") Checkbox password,
                              @ModelAttribute(value="checkbox") Checkbox password2,
                              Model model,
                              @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                              @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {

        model.addAttribute("title", "Регистрация");

        model.addAttribute("name_user", name_user);
        Long idd = Long.parseLong(id_accaunt_user);

        if (idd != 0) {
            int count_product_basket = basketRepository.list_product_basket(idd);
            model.addAttribute("count_product_basket", count_product_basket);
        } else {
            model.addAttribute("count_product_basket", 0);
        }

        String name1 = first_name.getFirst_name();
        String name2 = second_name.getSecond_name();
        String name3 = third_name.getThird_name();
        String mail = email.getEmail();
        String tell = tel.getTel();
        Date bir = birthday.getBirthday();
        String pass1 = password.getPassword();
        String pass2 = password2.getPassword2();

        String mess_erroy = "";

        if (name1 == null || name1 == "" || name2 == null || name2 == "" ||
                mail == null || mail == "" || tell == null || tell == "" || pass1 == null || pass1 == "" || pass2 == null || pass2 == "") {
            mess_erroy = "Пожалуйста, введите все данные";
            model.addAttribute("mess_erroy", mess_erroy);
            return "profile";
        }
        if (!pass1.equals(pass2)) {
            mess_erroy = "Пароли не совпадают";
            model.addAttribute("mess_erroy", mess_erroy);
            return "profile";
        }
        if (userRepository.is_login(mail) != 0) {
            mess_erroy = "Такой email уже существует";
            model.addAttribute("mess_erroy", mess_erroy);
            return "profile";
        }
        if (userRepository.is_pass2(pass1) != 0) {
            mess_erroy = "Такой пароль уже существует";
            model.addAttribute("mess_erroy", mess_erroy);
            return "profile";
        }
        if (name3 == null || name3 == "") {
            name3 = "";
        }

        userRepository.update_user(idd, name1, name2, name3, mail, bir, tell, pass1);

        mess_erroy = "Данные успешно обновлены";

        model.addAttribute("mess_erroy", mess_erroy);

        return "profile";

    }


    @GetMapping("/exit")
    public String exit_profile(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                          @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user,
                               HttpServletResponse response) {
        model.addAttribute("title", "ArtShop");

        Cookie foo = new Cookie("name_user", name_user);
        foo.setMaxAge(0);
        response.addCookie(foo);

        Long id = Long.parseLong(id_accaunt_user);

        Cookie foo1 = new Cookie("id_accaunt_user", "id_accaunt_user");
        foo1.setMaxAge(0);
        response.addCookie(foo1);


        model.addAttribute("count_product_basket", 0);

        model.addAttribute("name_user", "hello");

        return "redirect:/";

    }


    @GetMapping("/buy")
    public String buy(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                          @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "Покупки");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        List<String> buy_title = userRepository.buy_title(id);
        List<Float> buy_price = userRepository.buy_price(id);
        List<Integer> buy_discounts = userRepository.buy_discounts(id);
        List<Date> buy_time_order = userRepository.buy_time_order(id);
        List<String> buy_img = userRepository.buy_img(id);
        List<Long> buy_id = userRepository.buy_id(id);

        List<ProductJoinSubcategory> result = new ArrayList<>();
        for (int i = 0; i < buy_title.size(); i++) {
            result.add(new ProductJoinSubcategory(buy_id.get(i), buy_title.get(i), buy_img.get(i), buy_discounts.get(i),
                    buy_price.get(i), buy_time_order.get(i)));
        }
        model.addAttribute("all_res", result);

        return "buy";
    }


}
