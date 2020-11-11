package kenn.shi.project.services.implementation;

import kenn.shi.project.entities.ShopGoods;
import kenn.shi.project.repository.ShopGoodsRepository;
import kenn.shi.project.services.ShopGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopGoodsServiceImpl implements ShopGoodsService {
    @Autowired
    private ShopGoodsRepository shopGoodsRepository;

    @Override
    public ShopGoods addShopGood(ShopGoods shopGood) {
        return shopGoodsRepository.save(shopGood);
    }

    @Override
    public ShopGoods saveShopGood(ShopGoods shopGood) {
        return shopGoodsRepository.save(shopGood);
    }

    @Override
    public List<ShopGoods> getAllShopGoods() {
        return shopGoodsRepository.findAll();
    }

    @Override
    public ShopGoods getShopGood(Long id) {
        return shopGoodsRepository.getOne(id);
    }

    @Override
    public void deleteShopGood(ShopGoods shopGood) {
        shopGoodsRepository.delete(shopGood);
    }

    @Override
    public List<ShopGoods> searchByName(String name) {
        return shopGoodsRepository.findAllByNameLikeOrderByPriceDesc("%"+name+"%");
    }


}
