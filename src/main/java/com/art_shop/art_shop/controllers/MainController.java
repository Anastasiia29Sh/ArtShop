package com.art_shop.art_shop.controllers;

import com.art_shop.art_shop.models.Product;
import com.art_shop.art_shop.models.Subcategory;
import com.art_shop.art_shop.repositories.BasketRepository;
import com.art_shop.art_shop.repositories.ProductRepository;
import com.art_shop.art_shop.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.art_shop.art_shop.models.ProductJoinSubcategory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.expression.Lists;

import java.util.Collection;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SubcategoryRepository subcategoryRepository;
    @Autowired
    private BasketRepository basketRepository;

    @GetMapping("/")
    public String greeting(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                           @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "ArtShop");

        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        List<Product> product_present = productRepository.join_present();
        model.addAttribute("products_present", product_present);

        List<Product> product_novelties = productRepository.join_novelties();
        model.addAttribute("products_novelties", product_novelties);

        List<Product> product_discounts = productRepository.join_discounts();
        model.addAttribute("products_discounts", product_discounts);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "main";
    }

    @GetMapping("/paints")
    public String paints(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                         @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????");
        model.addAttribute("title_catalog", "");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_category = "????????????";
        List<Product> product = productRepository.product_category(name_category);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/paper")
    public String paper(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                        @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????");
        model.addAttribute("title_catalog", "");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_category = "????????????";
        List<Product> product = productRepository.product_category(name_category);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/graphic")
    public String graphic(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                          @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????????");
        model.addAttribute("title_catalog", "");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_category = "??????????????";
        List<Product> product = productRepository.product_category(name_category);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/easels")
    public String easels(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                         @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????????????");
        model.addAttribute("title_catalog", "");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_category = "??????????????????";
        List<Product> product = productRepository.product_category(name_category);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/canvases")
    public String canvases(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                           @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "???????????? ?? ??????????");
        model.addAttribute("title_catalog", "");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_category = "???????????? ?? ??????????";
        List<Product> product = productRepository.product_category(name_category);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/brushes")
    public String brushes(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                          @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????");
        model.addAttribute("title_catalog", "");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_category = "??????????";
        List<Product> product = productRepository.product_category(name_category);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/modeling")
    public String modeling(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                           @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????");
        model.addAttribute("title_catalog", "");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_category = "??????????";
        List<Product> product = productRepository.product_category(name_category);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/stationery")
    public String stationery(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                             @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????????????");
        model.addAttribute("title_catalog", "");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_category = "????????????????????";
        List<Product> product = productRepository.product_category(name_category);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }

    @GetMapping("/watercolor_paints")
    public String watercolor_paints(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                    @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????");
        model.addAttribute("title_catalog", "???????????? ??????????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "???????????? ??????????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/acrylic_paints")
    public String acrylic_paints(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                 @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????");
        model.addAttribute("title_catalog", "???????????? ??????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "???????????? ??????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/gouache_paints")
    public String gouache_paints(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                 @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????");
        model.addAttribute("title_catalog", "???????????? ????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "???????????? ????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/oil_paints")
    public String oil_paints(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                             @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????");
        model.addAttribute("title_catalog", "???????????? ????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "???????????? ????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/brushes_watercolor_gouache")
    public String brushes_watercolor_gouache(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                             @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????");
        model.addAttribute("title_catalog", "?????????? ?????? ???????????????? ?? ??????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "?????????? ?????? ???????????????? ?? ??????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/oil_brushes")
    public String oil_brushes(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                              @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????");
        model.addAttribute("title_catalog", "?????????? ?????? ????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "?????????? ?????? ????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/brush_cases")
    public String brush_cases(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                              @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????");
        model.addAttribute("title_catalog", "???????????? ?????? ????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "???????????? ?????? ????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/universal_brushes")
    public String universal_brushes(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                    @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????");
        model.addAttribute("title_catalog", "?????????? ??????????????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "?????????? ??????????????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/watercolor_paper")
    public String watercolor_paper(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                   @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????");
        model.addAttribute("title_catalog", "???????????? ?????? ????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "???????????? ?????? ????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/paper_acrylic_oil")
    public String paper_acrylic_oil(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                    @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????");
        model.addAttribute("title_catalog", "???????????? ?????? ???????????? ?? ??????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "???????????? ?????? ???????????? ?? ??????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/paper_pastel_charcoal")
    public String paper_pastel_charcoal(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                        @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????");
        model.addAttribute("title_catalog", "???????????? ?????? ??????????????, ????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "???????????? ?????? ??????????????, ????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/graphics_paper")
    public String graphics_paper(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                 @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????");
        model.addAttribute("title_catalog", "???????????? ?????? ??????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "???????????? ?????? ??????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/drawing_paper")
    public String drawing_paper(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????");
        model.addAttribute("title_catalog", "???????????? ??????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "???????????? ??????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/pencils_rods")
    public String pencils_rods(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                               @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????????");
        model.addAttribute("title_catalog", "?????????????????? ?? ??????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "?????????????????? ?? ??????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/markers")
    public String markers(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                          @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????????");
        model.addAttribute("title_catalog", "?????????????? ?? ????????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "?????????????? ?? ????????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/pastel_sepia")
    public String pastel_sepia(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                               @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????????");
        model.addAttribute("title_catalog", "??????????????, ??????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "??????????????, ??????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/feathers_pens")
    public String feathers_pens(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????????");
        model.addAttribute("title_catalog", "??????????, ??????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "??????????, ??????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/ink")
    public String ink(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                      @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????????");
        model.addAttribute("title_catalog", "???????? ?? ??????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "???????? ?? ??????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/easelss")
    public String easelss(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                          @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????????????");
        model.addAttribute("title_catalog", "??????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "??????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/sketchbooks")
    public String sketchbooks(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                              @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????????????");
        model.addAttribute("title_catalog", "????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/tablets")
    public String tablets(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                          @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????????????");
        model.addAttribute("title_catalog", "????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/primed_cardboard")
    public String primed_cardboard(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                   @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "???????????? ?? ??????????");
        model.addAttribute("title_catalog", "???????????? ????????????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "???????????? ????????????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/canvas_unprimed")
    public String canvas_unprimed(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                  @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "???????????? ?? ??????????");
        model.addAttribute("title_catalog", "?????????? ????????????????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "?????????? ????????????????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/binding_cardboard")
    public String binding_cardboard(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                    @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "???????????? ?? ??????????");
        model.addAttribute("title_catalog", "???????????? ??????????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "???????????? ??????????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/gypsum_clay")
    public String gypsum_clay(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                              @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????");
        model.addAttribute("title_catalog", "???????? ?? ??????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "???????? ?? ??????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/plasticine_sculptural")
    public String plasticine_sculptural(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                        @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????");
        model.addAttribute("title_catalog", "?????????????????? ????????????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "?????????????????? ????????????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/sculptural_tools")
    public String sculptural_tools(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                   @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????");
        model.addAttribute("title_catalog", "?????????????????????? ????????????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "?????????????????????? ????????????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/notebooks")
    public String notebooks(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                            @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????????????");
        model.addAttribute("title_catalog", "???????????????? ?? ??????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "???????????????? ?? ??????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/glue")
    public String glue(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                       @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????????????");
        model.addAttribute("title_catalog", "????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/buttons_clips")
    public String buttons_clips(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????????????");
        model.addAttribute("title_catalog", "????????????, ??????????????, ???????????? ?????? ??????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "????????????, ??????????????, ???????????? ?????? ??????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/rulers")
    public String rulers(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                         @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????????????");
        model.addAttribute("title_catalog", "??????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "??????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/erasers")
    public String erasers(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                          @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????????????");
        model.addAttribute("title_catalog", "??????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "??????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/colour_pencils")
    public String colour_pencils(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                 @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????????????");
        model.addAttribute("title_catalog", "?????????????? ??????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "?????????????? ??????????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/compasses_scissors")
    public String compasses_scissors(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                     @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????????????");
        model.addAttribute("title_catalog", "??????????????, ??????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        String name_subcategory = "??????????????, ??????????????";
        List<Product> product = productRepository.product_subcategory(name_subcategory);
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/gift_artist")
    public String gift_artist(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                              @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "?????????????? ??????????????????");
        model.addAttribute("title_catalog", "?????????????? ??????????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        List<Product> product = productRepository.join_present();
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/novelties_product")
    public String novelties_product(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                    @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "??????????????");
        model.addAttribute("title_catalog", "??????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        List<Product> product = productRepository.join_novelties();
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }
    @GetMapping("/discounts_product")
    public String discounts_product(Model model, @CookieValue(value = "name_user", defaultValue = "hello") String name_user,
                                    @CookieValue(value = "id_accaunt_user", defaultValue = "0") String id_accaunt_user) {
        model.addAttribute("title", "????????????");
        model.addAttribute("title_catalog", "????????????");
        model.addAttribute("name_user", name_user);
        Long id = Long.parseLong(id_accaunt_user);

        List<Product> product = productRepository.join_discounts();
        model.addAttribute("products", product);

        if(id != 0){
            int count_product_basket = basketRepository.list_product_basket(id);
            model.addAttribute("count_product_basket", count_product_basket);
        }else{
            model.addAttribute("count_product_basket", 0);
        }

        return "list_product";
    }

}
