package kenn.shi.project.controllers;

import kenn.shi.project.entities.ShopGoods;
import kenn.shi.project.services.ShopGoodsService;
import kenn.shi.project.services.implementation.ShopGoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopGoodsController {
    @Autowired
    private ShopGoodsService shopGoodsService;

    @GetMapping(value = "/")
    public String index(Model model) {
        List<ShopGoods> allGoods = shopGoodsService.getAllShopGoods();
        model.addAttribute("goods", allGoods);
        return "home";
    }

    @PostMapping(value = "/addgood")
    public String addGood(@RequestParam(name = "name") String name,
                          @RequestParam(name = "description") String description,
                          @RequestParam(name = "price") double price,
                          @RequestParam(name = "amount") int amount) {
        ShopGoods shopGood = new ShopGoods(null, name, description, price, amount);
        shopGoodsService.addShopGood(shopGood);
        return "redirect:/";
    }

    @GetMapping(value = "/details/{id}")
    public String getGood(@PathVariable(name = "id") Long id, Model model) {
        ShopGoods shopGood = shopGoodsService.getShopGood(id);
        if (shopGood != null) {
            model.addAttribute("shopGood", shopGood);
            return "details";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/savegood")
    public String saveGood(@RequestParam(name = "id") Long id,
                           @RequestParam(name = "name") String name,
                           @RequestParam(name = "description") String description,
                           @RequestParam(name = "price") double price,
                           @RequestParam(name = "amount") int amount) {
        ShopGoods shopGood = shopGoodsService.getShopGood(id);
        if (shopGood != null) {
            shopGood.setName(name);
            shopGood.setDescription(description);
            shopGood.setPrice(price);
            shopGood.setAmount(amount);
            shopGoodsService.saveShopGood(shopGood);
        }
        return "redirect:/";
    }

    @PostMapping(value = "/deletegood")
    public String deleteGood(@RequestParam(name = "id")Long id){
        ShopGoods shopGood = shopGoodsService.getShopGood(id);
        if (shopGood!=null){
            shopGoodsService.deleteShopGood(shopGood);
        }

        return "redirect:/";
    }

    @GetMapping(value = "/search")
    public String search(@RequestParam(name = "name")String name , Model model){
        List<ShopGoods> shopGoods = shopGoodsService.searchByName(name);
        model.addAttribute("goods" , shopGoods);
        return "home";

    }
}
