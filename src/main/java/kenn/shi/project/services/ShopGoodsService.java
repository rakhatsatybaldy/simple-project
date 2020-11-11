package kenn.shi.project.services;

import kenn.shi.project.entities.ShopGoods;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ShopGoodsService {
    ShopGoods addShopGood(ShopGoods shopGood);
    ShopGoods saveShopGood(ShopGoods shopGood);
    List<ShopGoods> getAllShopGoods();
    ShopGoods getShopGood(Long id);
    void deleteShopGood(ShopGoods shopGood);
    List<ShopGoods> searchByName(String name);
}
