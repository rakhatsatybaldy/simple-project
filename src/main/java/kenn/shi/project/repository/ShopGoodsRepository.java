package kenn.shi.project.repository;

import kenn.shi.project.entities.ShopGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ShopGoodsRepository extends JpaRepository<ShopGoods, Long> {
    List<ShopGoods> findAllByNameLikeOrderByPriceDesc(String name);
}
