package com.xiong.sell.enums;

import lombok.Getter;

/**
 * 商品状态
 *
 * @author Xiong YuSong
 * 2019/1/17 15:39
 */
@Getter
public enum ProductStatusEnum {
    /**
     * 表示上架商品
     */
    UP(0, "在架"),
    /**
     * 表示下架商品
     */
    DOWN(1, "下架");


    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
