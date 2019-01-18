package com.xiong.sell.service;

import com.xiong.sell.dataobject.ProductInfo;
import com.xiong.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品详细
 *
 * @author Xiong YuSong
 * 2019/1/17 15:24
 */
public interface ProductInfoService {
    /**
     * 查找一件商品信息
     *
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查找所有商品分页显示
     *
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 保存一个商品信息
     *
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     * @param cartDTOList
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
//    ProductInfo onSale(String productId);

    //下架
//    ProductInfo offSale(String productId);
}
