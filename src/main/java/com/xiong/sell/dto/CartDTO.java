package com.xiong.sell.dto;

import lombok.Data;

/**
 * @author Xiong YuSong
 * 2019/1/18 14:33
 */
@Data
public class CartDTO {

    /**
     * 商品id.
     */
    private String productId;


    /**
     * 商品数量.
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
