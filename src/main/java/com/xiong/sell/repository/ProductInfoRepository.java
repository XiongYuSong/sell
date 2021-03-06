package com.xiong.sell.repository;

import com.xiong.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品详细
 *
 * @author Xiong YuSong
 * 2019/1/17 14:27
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 通过商品上架状态查找商品
     *
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
